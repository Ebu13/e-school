package Persons;

/**
 * This class represents a manager.
 */
public class Manager {
    private String userName;
    private String pass;

    /**
     * Constructs a Manager object with the specified username and password.
     *
     * @param userName the username of the manager
     * @param pass     the password of the manager
     */
    public Manager(String userName, String pass) {
        this.userName = userName;
        this.pass = pass;
    }

    /**
     * Retrieves the username of the manager.
     *
     * @return the username
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the username of the manager.
     *
     * @param userName the username to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Retrieves the password of the manager.
     *
     * @return the password
     */
    public String getPass() {
        return pass;
    }

    /**
     * Sets the password of the manager.
     *
     * @param pass the password to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }
}