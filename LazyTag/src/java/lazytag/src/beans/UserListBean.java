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
    private int pageSize = 5;
    private double numberOfRecords;
    private int numberOfPages;
    private List<Integer> pages;
    private String sortParam;
    private String sortOrder;

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getSortParam() {
        return sortParam;
    }

    public void setSortParam(String sortParam) {
        this.sortParam = sortParam;
    }

    public List<Integer> getPages() {
        return pages;
    }

    public void setPages(List<Integer> pages) {
        this.pages = pages;
    }
    private Integer currentPage;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public double getNumberOfRecords() {
        return numberOfRecords;
    }

    public void setNumberOfRecords(int numberOfRecords) {
        this.numberOfRecords = numberOfRecords;
    }


    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

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



                if(sortParam == null){
                    sortParam = "user_id";
                }
                if(sortOrder == null){
                    sortOrder = "ASC";
                }

                if(currentPage == null){
                    currentPage = 1;
                }

                String currPage = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("currentPage");

                if (currPage != null) {
                    currentPage = new Integer(currPage);
                }

                System.out.println("currentPage: " + currentPage);

                
                numberOfRecords = userService.searchUserCount(roleId, firstName, lastName, email, login);
                System.out.println("numberOfRecords: " + numberOfRecords);
                if(numberOfRecords > 0){
                    System.out.println(Math.ceil((double)(numberOfRecords / pageSize)) + " "
                            + (double)(numberOfRecords / pageSize));
                    numberOfPages =  (int) Math.ceil((double)(numberOfRecords / pageSize)) ;

                }
                else{
                    numberOfPages = 0;
                }

                pages = new ArrayList<Integer>();
                for(int i=0;i<numberOfPages ; i++ ){
                    pages.add(i+1);
                }

                System.out.println("numberOfPages: " + numberOfPages);

                int startRecord = (currentPage-1) * pageSize;


                List<User> users = userService.searchUser(roleId, firstName, lastName, email, login, sortParam, sortOrder, startRecord, pageSize);
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
     * Sign out from the system
     * @return
     */
    public String logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        session.invalidate();
        return "login";
    }

    public String changeSorting() {
        String sort = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("sortParam");

        if (sort != null) {
            if (sortParam.equalsIgnoreCase(sort)) {
                if (sortOrder.equalsIgnoreCase("ASC")) {
                    sortOrder = "DESC";
                } else {
                    sortOrder = "ASC";
                }
            } else {
                sortParam = sort;
                sortOrder = "ASC";
            }
        }
        currentPage = 1;
        searchUser();
        return null;
    }

    public String search(){
        sortParam = "user_id";
        currentPage = 1;
        sortOrder = "ASC";
        searchUser();
        return null;
    }

    public String getFirstPage(){
        currentPage = 1;
        searchUser();
        return null;
    }

    public String getPrevPage(){
        currentPage = currentPage - 1;
        searchUser();
        return null;
    }

    public String getNextPage() {
        currentPage = currentPage + 1;
        searchUser();
        return null;
    }

    public String getLastPage() {
        currentPage = numberOfPages;
        searchUser();
        return null;
    }


}
