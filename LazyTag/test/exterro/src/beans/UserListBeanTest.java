/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exterro.src.beans;

import lazytag.src.beans.UserListBean;
import lazytag.src.model.UserModel;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Priya
 */
public class UserListBeanTest {

    public UserListBeanTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of isDisplaySearch method, of class UserListBean.
     */
    @Test
    public void testIsDisplaySearch() {
        System.out.println("isDisplaySearch");
        UserListBean instance = new UserListBean();
        instance.setDisplaySearch(false);
        boolean expResult = false;
        boolean result = instance.isDisplaySearch();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDisplaySearch method, of class UserListBean.
     */
    @Test
    public void testSetDisplaySearch() {
        System.out.println("setDisplaySearch");
        boolean displaySearch = false;
        UserListBean instance = new UserListBean();
        instance.setDisplaySearch(displaySearch);
    }

    /**
     * Test of getEmail method, of class UserListBean.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        UserListBean instance = new UserListBean();
        instance.setEmail("");
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmail method, of class UserListBean.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        UserListBean instance = new UserListBean();
        instance.setEmail(email);
    }

    /**
     * Test of getFirstName method, of class UserListBean.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        UserListBean instance = new UserListBean();
        instance.setFirstName("");
        String expResult = "";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFirstName method, of class UserListBean.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String firstName = "";
        UserListBean instance = new UserListBean();
        instance.setFirstName(firstName);
    }

    /**
     * Test of getLastName method, of class UserListBean.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        UserListBean instance = new UserListBean();
        instance.setLastName("");
        String expResult = "";
        String result = instance.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLastName method, of class UserListBean.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String lastName = "";
        UserListBean instance = new UserListBean();
        instance.setLastName(lastName);
    }

    /**
     * Test of getLogin method, of class UserListBean.
     */
    @Test
    public void testGetLogin() {
        System.out.println("getLogin");
        UserListBean instance = new UserListBean();
        instance.setLogin("");
        String expResult = "";
        String result = instance.getLogin();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLogin method, of class UserListBean.
     */
    @Test
    public void testSetLogin() {
        System.out.println("setLogin");
        String login = "";
        UserListBean instance = new UserListBean();
        instance.setLogin(login);
    }

    /**
     * Test of getUserList method, of class UserListBean.
     */
    @Test
    public void testGetUserList() {
        System.out.println("getUserList");
        UserListBean instance = new UserListBean();
        instance.setUserList(new ArrayList<UserModel>());
        List expResult = new ArrayList<UserModel>();
        List result = instance.getUserList();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUserList method, of class UserListBean.
     */
    @Test
    public void testSetUserList() {
        System.out.println("setUserList");
        List<UserModel> userList = null;
        UserListBean instance = new UserListBean();
        instance.setUserList(userList);
    }

    /**
     * Test of searchUser method, of class UserListBean.
     */
    @Test(expected=NullPointerException.class)
    public void testSearchUser() {
        System.out.println("searchUser");
        UserListBean instance = new UserListBean();
        String result = instance.searchUser();
    }

    /**
     * Test of search method, of class UserListBean.
     */
//    @Test(expected=NullPointerException.class)
//    public void testSearch() {
//        System.out.println("search");
//        UserListBean instance = new UserListBean();
//        String result = instance.search();
//    }

    /**
     * Test of logout method, of class UserListBean.
     */
    @Test(expected=NullPointerException.class)
    public void testLogout() {
        System.out.println("logout");
        UserListBean instance = new UserListBean();
        String result = instance.logout();
    }

}