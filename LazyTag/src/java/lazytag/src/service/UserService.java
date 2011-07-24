/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lazytag.src.service;

import lazytag.src.entity.User;
import lazytag.src.model.UserModel;
import java.util.List;
import javax.ejb.Local;

/**
 * Local EJB interface
 * @author Priya
 */
@Local
public interface UserService {
    public boolean registerUser(UserModel user);
    public List<User> searchUser(int roleId,String firstName, String lastName, String email, String login);
    public User autheticate(String loginId, String password);
    public boolean validateLogin(String loginId);
}
