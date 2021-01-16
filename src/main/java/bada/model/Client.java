package bada.model;

import java.sql.Date;

public class Client extends User {

    protected int id;
    protected String name;

    public Client(){
        super();
    }

    public Client(String name, String login, String password){
        super(login, password);
        this.name = name;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
