/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lazytag.src.beans;

import lazytag.src.entity.User;
import lazytag.src.resources.MessageProvider;
import lazytag.src.service.UserService;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Priya
 */
@ManagedBean
@RequestScoped
public class LoginBean {
    private String loginId;
    private String password;

    @EJB
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /** Creates a new instance of LoginBean */
    public LoginBean() {
    }

    /**
     * Authenticate User
     * @return
     */
    public String authenticate(){
        FacesContext context = FacesContext.getCurrentInstance();
        User user = null;
        user = userService.autheticate(loginId, password);
        if(user!=null){
              HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
              session.setAttribute("user", user);
              return "searchusers";
        }else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    new MessageProvider().getValue("loginid_invalid"),"");
            context.addMessage(null, message);
            return null;
        }
    }

}
