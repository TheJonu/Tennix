package bada;


import java.util.List;

public class Court {
    private int id;
    private String name;
    private String address;
    private int openingHour;
    private int closingHour;

    private Booking[][] timetable = new Booking[24][5];


    public Court(){

    }

    public Court(int id, String name, String address, int openingHour, int closingHour){
        this.id = id;
        this.name = name;
        this.address = address;
        this.openingHour = openingHour;
        this.closingHour = closingHour;
    }




    // set the timetable according to existing bookings
    public void refreshTimetable(List<Booking> bookings){
        clearTimetable();
        for(int i=0; i<bookings.size(); i++){
             Booking booking = bookings.get(i);
             this.timetable[booking.getHour()][booking.getDay()] = booking;
        }
    }

    // clear the timetable
    private void clearTimetable(){
        for(int i=0; i<24; i++){
            for(int j=0; j<5; j++){
                timetable[i][j] = null;
            }
        }
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getOpeningHour() {
        return openingHour;
    }

    public void setOpeningHour(int openingHour) {
        this.openingHour = openingHour;
    }

    public int getClosingHour() {
        return closingHour;
    }

    public void setClosingHour(int closingHour) {
        this.closingHour = closingHour;
    }

    public Booking[][] getTimetable() { return timetable; }

    public void setTimetable(Booking[][] bookings) { this.timetable = bookings; }

    @Override
    public String toString() {
        return "bada.Court [" +
                "ID=" + id +
                ", name='" + name +
                ", address='" + address +
                ", opening_hour=" + openingHour +
                ", closing_hour=" + closingHour +
                ']';
    }
}

