package bada;

import java.sql.Timestamp;

public class Person {
    private String firstName;
    private String lastName;
    private Timestamp registrationDate;

    public Person(){
    }

    public Person(String firstName, String lastName, Timestamp registrationDate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.registrationDate = registrationDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Timestamp getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Timestamp registrationDate) {
        this.registrationDate = registrationDate;
    }
}
