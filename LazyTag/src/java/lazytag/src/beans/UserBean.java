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

    Contact: plimaye@pdx.edu, mnandini@pdx.edu
*/

package lazytag.src.beans;

import lazytag.src.model.UserModel;
import lazytag.src.resources.MessageProvider;
import lazytag.src.service.UserService;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Nandini
 */
public class UserBean {

    @EJB
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    private int userId;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Create new account
     * @return
     */
    public String registerUser() {
        FacesContext context = FacesContext.getCurrentInstance();
        boolean result = false;
        UserModel user = new UserModel(login, password, firstName, lastName, email);
        result = userService.registerUser(user);
        FacesMessage message = new FacesMessage(new MessageProvider().getValue("usercreated"));
        message.setSeverity(FacesMessage.SEVERITY_INFO);
        context.addMessage(null, message);
        resetForm();
        return null;
    }

    /**
     * Validate loginId to check if it already exists in the system
     * @param facesContext
     * @param component
     * @param newValue
     * @throws ValidatorException
     */
    public void validateLogin(FacesContext facesContext, UIComponent component, Object newValue) throws ValidatorException {
        String loginId = newValue.toString();
        boolean result = userService.validateLogin(loginId);
        if (!result) {
            FacesMessage message = new FacesMessage(new MessageProvider().getValue("login_not_avail"));
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            facesContext.addMessage(component.getClientId(), message);
            throw new ValidatorException(message);
        }
    }

    /**
     * Reset form to blank
     */
    public void resetForm() {
        this.setLogin("");
        this.setFirstName("");
        this.setLastName("");
        this.setEmail("");
        this.setPassword("");
    }
}

