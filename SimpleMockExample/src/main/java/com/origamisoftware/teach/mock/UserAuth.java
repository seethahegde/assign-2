package com.origamisoftware.teach.mock;

/**
 * Created by seetha on 1/31/15.
 */
public class UserAuth {
    String UserName;
    String Password;

    /* Constructor for the UserAuth class
     * @param name    Username
     * @param pwd Password
     *
     */
    public UserAuth(String name, String pwd) {
        this.UserName = name;
        this.Password = pwd;
    }
    /**
     *Checks if the username and password provided to access the service is valid
     *
     *
     * @return a boolean value
     * */
    public boolean isValidCredential() {
        String expectedUserName="abc";
        String expectedPassword="asdf";

        if ( UserName.equals(expectedUserName) && Password.equals(expectedPassword) ) {
            return true;
        } else {
            return false;
        }
    }
}
