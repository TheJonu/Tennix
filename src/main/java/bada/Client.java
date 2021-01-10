package bada;

import java.sql.Timestamp;

public class Client extends bada.Person {
    private int id;

    public Client(){}

    public Client(String first_name, String last_name, Timestamp registration_date, int id){
        super(first_name, last_name, registration_date);
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "bada.Client [" +
                "client_id=" + id +
                "first_name=" + this.getFirstName() +
                "last_name=" + this.getLastName() +
                "registration_date" + this.getRegistrationDate()+
                ']';
    }
}
