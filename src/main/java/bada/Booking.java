package bada;

public class Booking {

    private int id;
    private int day;
    private int hour;
    private int courtId;
    private int clientId;
    private Integer employeeId; // nullable


    public Booking(){

    }

    public Booking(int id, int hour, int courtId, int clientId, Integer employeeId) {
        this.id = id;
        this.hour = hour;
        this.courtId = courtId;
        this.clientId = clientId;
        this.employeeId = employeeId;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDay() { return day; }

    public void setDay(int day) { this.day = day; }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getCourtId() {
        return courtId;
    }

    public void setCourtId(int courtId) {
        this.courtId = courtId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) { this.clientId = clientId; }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) { this.employeeId = employeeId; }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", hour=" + hour +
                ", court=" + courtId +
                ", client=" + clientId +
                ", employee=" + employeeId +
                '}';
    }
}
