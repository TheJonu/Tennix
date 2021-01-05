package bada;

import java.sql.Timestamp;

public class Person {
    private String first_name;
    private String last_name;
    private Timestamp registration_date;

    public Person(){
    }

    public Person(String first_name, String last_name, Timestamp registration_date){
        this.first_name = first_name;
        this.last_name = last_name;
        this.registration_date = registration_date;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Timestamp getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Timestamp registration_date) {
        this.registration_date = registration_date;
    }
}
