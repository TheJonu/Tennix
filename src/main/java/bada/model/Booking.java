package bada.model;

public class Booking {

    private int id;
    private int day;
    private int hour;
    private int courtId;
    private int clientId;

    private String courtName;

    public Booking(){

    }

    public Booking(int day, int hour, int courtId, int clientId){
        this.day = day;
        this.hour = hour;
        this.courtId = courtId;
        this.clientId = clientId;
    }

    // get the day's name
    public String getDayName(){
        switch(day){
            case 0: return "Monday";
            case 1: return "Tuesday";
            case 2: return "Wednesday";
            case 3: return "Thursday";
            case 4: return "Friday";
            default: return "";
        }
    }

    public String getCourtName() { return courtName; }
    public void setCourtName(String value) { courtName = value; }

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

    public int getCourtId() { return courtId; }
    public void setCourtId(int courtId) {
        this.courtId = courtId;
    }

    public int getClientId() {
        return clientId;
    }
    public void setClientId(int clientId) { this.clientId = clientId; }

    /*
    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", hour=" + hour +
                ", court=" + courtId +
                ", client=" + clientId +
                //", employee=" + employeeId +
                '}';
    }
     */
}
