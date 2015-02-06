package com.origamisoftware.teach.mock;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by seetha on 2/1/15.
 */
public class UserAuthTest {
    UserAuth userObj, altUserObj;
    String username = "abc";
    String passwd = "asdf";
    //Initialization of test data
    @Before
    public void setup() {
        userObj = new UserAuth(username, passwd);
        altUserObj = new UserAuth(username, passwd.concat("test"));
    }
    @Test
    public void testPositiveUserCredentials() {
        assertTrue("Checking username and password", userObj.isValidCredential());
    }
    @Test
    public void testNegativeUserCredentials() {
        assertFalse("Checking Wrong username and password", altUserObj.isValidCredential());
    }
}
