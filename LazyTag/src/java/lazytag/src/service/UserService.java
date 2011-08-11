/**
 * Copyright© 2011 Priya Limaye, Nandini Mahendran

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

    Contact: plimaye@pdx.edu, mnandini@pdx.edu
 */

package lazytag.src.service;

import lazytag.src.entity.User;
import lazytag.src.model.UserModel;
import java.util.List;
import javax.ejb.Local;

/**
 * Local EJB interface
 * @author Nandini
 */
@Local
public interface UserService {
    public boolean registerUser(UserModel user);
    public List<User> searchUser(int roleId, String firstName, String lastName, String email, String login, String sortParam, String sortOrder,
            int rowCount, int rowOffset);
    public User autheticate(String loginId, String password);
    public boolean validateLogin(String loginId);
    public int searchUserCount(int roleId,String firstName, String lastName, String email, String login);
}
