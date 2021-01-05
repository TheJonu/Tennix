package bada;

import java.sql.Timestamp;

public class Employee extends bada.Person {
    private int employee_id;
    private float salaray;

    public Employee(){}

    public Employee(String first_name, String last_name, Timestamp registration_date, int employee_id, float salaray){
        super(first_name, last_name, registration_date);
        this.employee_id = employee_id;
        this.salaray = salaray;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public float getSalaray() {
        return salaray;
    }

    public void setSalaray(float salaray) {
        this.salaray = salaray;
    }

    @Override
    public String toString() {
        return "bada.Employee [" +
                "client_id=" + employee_id +
                "first_name=" + this.getFirst_name() +
                "last_name=" + this.getLast_name() +
                "registration_date" + this.getRegistration_date()+
                "salary=" + salaray +
                ']';
    }
}
