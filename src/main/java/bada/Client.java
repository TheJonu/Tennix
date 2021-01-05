package bada;

import java.sql.Timestamp;

public class Client extends bada.Person {
    private int client_id;

    public Client(){}

    public Client(String first_name, String last_name, Timestamp registration_date, int client_id){
        super(first_name, last_name, registration_date);
        this.client_id = client_id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    @Override
    public String toString() {
        return "bada.Client [" +
                "client_id=" + client_id +
                "first_name=" + this.getFirst_name() +
                "last_name=" + this.getLast_name() +
                "registration_date" + this.getRegistration_date()+
                ']';
    }
}
