/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exterro.src.model;

import lazytag.src.model.UserModel;
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
public class UserModelTest {

    public UserModelTest() {
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
     * Test of getEmail method, of class UserModel.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        UserModel instance = new UserModel();
        instance.setEmail("");
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmail method, of class UserModel.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        UserModel instance = new UserModel();
        instance.setEmail(email);
    }

    /**
     * Test of getFirstName method, of class UserModel.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        UserModel instance = new UserModel();
        instance.setFirstName("");
        String expResult = "";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFirstName method, of class UserModel.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String firstName = "";
        UserModel instance = new UserModel();
        instance.setFirstName(firstName);
    }

    /**
     * Test of getLastName method, of class UserModel.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        UserModel instance = new UserModel();
        instance.setLastName("");
        String expResult = "";
        String result = instance.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLastName method, of class UserModel.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String lastName = "";
        UserModel instance = new UserModel();
        instance.setLastName(lastName);
    }

    /**
     * Test of getLogin method, of class UserModel.
     */
    @Test
    public void testGetLogin() {
        System.out.println("getLogin");
        UserModel instance = new UserModel();
        instance.setLogin("");
        String expResult = "";
        String result = instance.getLogin();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLogin method, of class UserModel.
     */
    @Test
    public void testSetLogin() {
        System.out.println("setLogin");
        String login = "";
        UserModel instance = new UserModel();
        instance.setLogin(login);
    }

    /**
     * Test of getPassword method, of class UserModel.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        UserModel instance = new UserModel();
        instance.setPassword("");
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPassword method, of class UserModel.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        UserModel instance = new UserModel();
        instance.setPassword(password);
    }

    /**
     * Test of getUserId method, of class UserModel.
     */
    @Test
    public void testGetUserId() {
        System.out.println("getUserId");
        UserModel instance = new UserModel();
        instance.setUserId(0);
        int expResult = 0;
        int result = instance.getUserId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUserId method, of class UserModel.
     */
    @Test
    public void testSetUserId() {
        System.out.println("setUserId");
        int userId = 0;
        UserModel instance = new UserModel();
        instance.setUserId(userId);
    }
}
