/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lazytag.src.beans;

import lazytag.src.entity.User;
import lazytag.src.model.UserModel;
import lazytag.src.resources.MessageProvider;
import lazytag.src.service.UserService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.apache.myfaces.custom.datascroller.HtmlDataScroller;

/**
 *
 * @author Priya
 */
@ManagedBean
@RequestScoped
public class UserListBean {

    private List userList;
    @EJB
    private UserService userService;
    private String login;
    private String firstName;
    private String lastName;
    private String email;
    private boolean displaySearch;

    public boolean isDisplaySearch() {
        return displaySearch;
    }

    public void setDisplaySearch(boolean displaySearch) {
        this.displaySearch = displaySearch;
    }

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

    public List<UserModel> getUserList() {
        return userList;
    }

    public void setUserList(List<UserModel> userList) {
        this.userList = userList;
    }

    /** Creates a new instance of UserListBean */
    public UserListBean() {
    }

    /**
     * Search user, this method is called when the form is loaded
     * @return
     */
    @PostConstruct
    public String searchUser() {
        FacesContext context = FacesContext.getCurrentInstance();
        List<UserModel> userModelList = new ArrayList<UserModel>();
        User sessionUser = (User) context.getExternalContext().getSessionMap().get("user");
        if (null == sessionUser) {
            HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
            session.invalidate();
            return "login";
        } else {
            int roleId = new Integer(sessionUser.getRoleId());
            if (sessionUser != null && roleId == new Integer(new MessageProvider().getValue("admin")).intValue()) {
                displaySearch = true;
                context = FacesContext.getCurrentInstance();
                HtmlDataScroller data = (HtmlDataScroller) context.getViewRoot().findComponent("searchuser:scroller");
                data.getUIData().setFirst(0);


//                HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
//                firstName = (String) session.getAttribute("firstName");
//                lastName = (String) session.getAttribute("lastName");
//                email = (String) session.getAttribute("email");
//                login = (String) session.getAttribute("login");

                List<User> users = userService.searchUser(roleId, firstName, lastName, email, login);
                System.out.println("Here in search users: " + users.size() + " ");
                for (User user : users) {
                    UserModel userModel = new UserModel(user.getUserId(), user.getLogin(),
                            user.getPassword(), user.getFirstName(), user.getLastName(), user.getEmail());
                    userModelList.add(userModel);
                }
            } else {
                displaySearch = false;
                UserModel userModel = new UserModel(sessionUser.getUserId(), sessionUser.getLogin(),
                        sessionUser.getPassword(), sessionUser.getFirstName(), sessionUser.getLastName(), sessionUser.getEmail());
                userModelList.add(userModel);
            }
            this.setUserList(userModelList);
            return null;
        }
    }

    /**
     * Search user as per input criteria. This method is called when Search button is clicked.
     * @return
     */
//    public void search() {
//        FacesContext context = FacesContext.getCurrentInstance();
//        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
//        session.setAttribute("firstName", this.getFirstName());
//        session.setAttribute("lastName", this.getLastName());
//        session.setAttribute("email", this.getEmail());
//        session.setAttribute("login", this.getLogin());
//    }

    /**
     * Sign out from the system
     * @return
     */
    public String logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        session.invalidate();
        return "login";
    }
}
