/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lazytag.src.beans;

import lazytag.src.service.UserService;
import lazytag.src.service.UserServiceImpl;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
public class LoginBeanTest {

    public LoginBeanTest() {
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
     * Test of setLoginId method, of class LoginBean.
     */
    @Test
    public void testSetLoginId() {
        String loginId = "admin";
        LoginBean instance = new LoginBean();
        instance.setLoginId(loginId);
    }

    /**
     * Test of getLoginId method, of class LoginBean.
     */
    @Test
    public void testGetLoginId() {
        System.out.println("getLoginId");
        LoginBean instance = new LoginBean();
        instance.setLoginId("");
        String result = instance.getLoginId();
        assertNotNull(result);
    }

    /**
     * Test of setPassword method, of class LoginBean.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "admin";
        LoginBean instance = new LoginBean();
        instance.setPassword(password);
    }

    /**
     * Test of getPassword method, of class LoginBean.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        LoginBean instance = new LoginBean();
        instance.setPassword("");
        String result = instance.getPassword();
        assertNotNull(result);
    }

    /**
     * Test of authenticate method, of class LoginBean.
     */
    @Test
    public void testAuthenticate() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExterroPU");
        EntityManager em = emf.createEntityManager();

        System.out.println("authenticate");
        LoginBean instance = new LoginBean();
        UserService userService = new UserServiceImpl();
        instance.setLoginId("admin");
        instance.setPassword("admin");
        instance.setUserService(userService);
        String result = instance.authenticate();
        assertEquals("searchusers", result);
    }
}
