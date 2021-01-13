package bada;

import java.sql.Date;
import java.sql.Timestamp;

public class Client extends bada.Person {

    private int id;
    private String login;



    public Client(){}

    public Client(String first_name, String last_name, Timestamp registration_date, int id){
        super(first_name, last_name, registration_date);
        this.id = id;
    }

    public String getFullName() { return firstName + " " + lastName; }

    public String getRegistrationDateString(){
        Date date = new Date(registrationDate.getTime());
        return date.toString();
    }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

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
