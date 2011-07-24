/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exterro.src.beans;

import lazytag.src.beans.UserBean;
import lazytag.src.service.UserService;
import lazytag.src.service.UserServiceImpl;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
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
public class UserBeanTest {

    public UserBeanTest() {
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
     * Test of getUserService method, of class UserBean.
     */
    @Test
    public void testGetUserService() {
        System.out.println("getUserService");
        UserBean instance = new UserBean();
        instance.setUserService(new UserServiceImpl());
        UserService result = instance.getUserService();
        assertNotNull(result);
    }

    /**
     * Test of setUserService method, of class UserBean.
     */
    @Test
    public void testSetUserService() {
        System.out.println("setUserService");
        UserService userService = new UserServiceImpl();
        UserBean instance = new UserBean();
        instance.setUserService(userService);
    }

    /**
     * Test of getEmail method, of class UserBean.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        UserBean instance = new UserBean();
        instance.setEmail("");
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmail method, of class UserBean.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        UserBean instance = new UserBean();
        instance.setEmail(email);
    }

    /**
     * Test of getFirstName method, of class UserBean.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        UserBean instance = new UserBean();
        instance.setFirstName("");
        String expResult = "";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFirstName method, of class UserBean.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String firstName = "";
        UserBean instance = new UserBean();
        instance.setFirstName(firstName);
    }

    /**
     * Test of getLastName method, of class UserBean.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        UserBean instance = new UserBean();
        instance.setLastName("");
        String expResult = "";
        String result = instance.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLastName method, of class UserBean.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String lastName = "";
        UserBean instance = new UserBean();
        instance.setLastName(lastName);
    }

    /**
     * Test of getLogin method, of class UserBean.
     */
    @Test
    public void testGetLogin() {
        System.out.println("getLogin");
        UserBean instance = new UserBean();
        instance.setLogin("");
        String result = instance.getLogin();
        assertEquals(result,"");
    }

    /**
     * Test of setLogin method, of class UserBean.
     */
    @Test
    public void testSetLogin() {
        System.out.println("setLogin");
        String login = "";
        UserBean instance = new UserBean();
        instance.setLogin(login);
    }

    /**
     * Test of getPassword method, of class UserBean.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        UserBean instance = new UserBean();
        instance.setPassword("");
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPassword method, of class UserBean.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        UserBean instance = new UserBean();
        instance.setPassword(password);
    }

    /**
     * Test of getUserId method, of class UserBean.
     */
    @Test
    public void testGetUserId() {
        System.out.println("getUserId");
        UserBean instance = new UserBean();
        instance.setUserId(0);
        int expResult = 0;
        int result = instance.getUserId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUserId method, of class UserBean.
     */
    @Test
    public void testSetUserId() {
        System.out.println("setUserId");
        int userId = 0;
        UserBean instance = new UserBean();
        instance.setUserId(userId);
    }

    /**
     * Test of resetForm method, of class UserBean.
     */
    @Test
    public void testResetForm() {
        System.out.println("resetForm");
        UserBean instance = new UserBean();
        instance.setPassword("abc");
        instance.resetForm();
        assertEquals(instance.getPassword(), "");
    }

}