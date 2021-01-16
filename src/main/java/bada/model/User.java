package bada.model;

import java.sql.Date;

public class User {

    protected String login;
    protected String password;
    protected Date regDate;

    public User(){
        this.regDate = new Date(System.currentTimeMillis());
    }

    public User(String login, String password){
        this.login = login;
        this.password = password;
        this.regDate = new Date(System.currentTimeMillis());
    }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Date getRegDate() {
        return regDate;
    }
    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
}
