package bada;

public class Booking {

    private int id;
    private int hour;
    private Court court;
    private Client client;
    private Employee employee;

    public Booking(){

    }

    public Booking(int id, int hour, Court court, Client client, Employee employee) {
        this.id = id;
        this.hour = hour;
        this.court = court;
        this.client = client;
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public Court getCourt() {
        return court;
    }

    public void setCourt(Court court) {
        this.court = court;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", hour=" + hour +
                ", court=" + court +
                ", client=" + client +
                ", employee=" + employee +
                '}';
    }
}
