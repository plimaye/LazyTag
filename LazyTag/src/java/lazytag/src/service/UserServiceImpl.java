/*
    Copyright© 2011 Priya Limaye, Nandini Mahendran

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.

    Contact: plimaye@pdx.edu, mnandini@pdx.edu */
package lazytag.src.service;

import lazytag.src.entity.User;
import lazytag.src.model.UserModel;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Interface implementation
 * @author Priya
 */
@Stateless
public class UserServiceImpl implements UserService {

    @PersistenceContext(name = "ExterroPU")
    private EntityManager em;

    public void setEm(EntityManager em) {
        this.em = em;
    }

    /**
     * Create new Account
     * @param user
     * @return
     */
    @Override
    public boolean registerUser(UserModel user) {
        System.out.println("Register User: " + user.getFirstName());

        Query query = em.createNativeQuery("INSERT INTO user (login, password ,firstName"
                + ",lastName,email)  VALUES(?,?,?,?,?)");
        query.setParameter(1, user.getLogin());
        query.setParameter(2, user.getPassword());
        query.setParameter(3, user.getFirstName());
        query.setParameter(4, user.getLastName());
        query.setParameter(5, user.getEmail());
        query.executeUpdate();
        return true;
    }

    /**
     * Search user as per input criteria
     * @param roleId
     * @param firstName
     * @param lastName
     * @param email
     * @param login
     * @return
     */
    @Override
    public List<User> searchUser(int roleId, String firstName, String lastName, String email, String login, String sortParam, String sortOrder, 
            int rowCount, int rowOffset) {
        String query = "SELECT * FROM user WHERE role_id < ? ";

        if (firstName != null && !firstName.trim().equals("")) {
            query += "AND firstName LIKE '" + firstName.replaceAll("'", "''") + "%'";
        }
        if (lastName != null && !lastName.trim().equals("")) {
            query += "AND lastName LIKE '" + lastName.replaceAll("'", "''") + "%'";
        }
        if (email != null && !email.trim().equals("")) {
            query += "AND email LIKE '" + email.replaceAll("'", "''") + "%'";
        }
        if (login != null && !login.trim().equals("")) {
            query += "AND login LIKE '" + login.replaceAll("'", "''") + "%'";
        }

        if (sortParam != null && !sortParam.trim().equals("")
                && sortOrder != null && !sortOrder.trim().equals("")) {
            query += "ORDER BY " + sortParam + " " + sortOrder + "";
        }

        query += " LIMIT " + rowCount + ", " + rowOffset + "";

        System.out.println("search query: " + query);

        List<User> users = new ArrayList<User>();
        users = em.createNativeQuery(query, User.class).setParameter(1, roleId).getResultList();
        return users;
    }

    /**
     * Authenticate user
     * @param loginId
     * @param password
     * @return
     */
    @Override
    public User autheticate(String loginId, String password) {
        List<User> users = new ArrayList<User>();
        users = em.createNamedQuery("User.findByLoginPassword").
                setParameter("login", loginId).
                setParameter("password", password).getResultList();
        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }
    }

    /**
     * Check if entered login id already exists in the system
     * @param loginId
     * @return
     */
    @Override
    public boolean validateLogin(String loginId) {
        List<User> users = new ArrayList<User>();
        users = em.createNamedQuery("User.findByLogin").
                setParameter("login", loginId).getResultList();
        if (users != null && users.size() > 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public int searchUserCount(int roleId, String firstName, String lastName, String email, String login) {
        Long count;

        String query = "SELECT COUNT(1) FROM user WHERE role_id < ? ";

        if (firstName != null && !firstName.trim().equals("")) {
            query += "AND firstName LIKE '" + firstName.replaceAll("'", "''") + "%'";
        }
        if (lastName != null && !lastName.trim().equals("")) {
            query += "AND lastName LIKE '" + lastName.replaceAll("'", "''") + "%'";
        }
        if (email != null && !email.trim().equals("")) {
            query += "AND email LIKE '" + email.replaceAll("'", "''") + "%'";
        }
        if (login != null && !login.trim().equals("")) {
            query += "AND login LIKE '" + login.replaceAll("'", "''") + "%'";
        }
        count = (Long) em.createNativeQuery(query).setParameter(1, roleId).getSingleResult();
        return count.intValue();
    }


}
