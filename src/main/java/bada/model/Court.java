package bada.model;


import java.util.List;

public class Court {

    private int id;
    private String name;
    private String address;
    private int openingHour;
    private int closingHour;
    private String photo;

    private Booking[][] timetable;


    public Court(){

    }

    public Court(String name, String address, int openingHour, int closingHour, String photo){
        this.name = name;
        this.address = address;
        this.openingHour = openingHour;
        this.closingHour = closingHour;
        this.photo = photo;
    }


    // set the timetable according to existing bookings
    public void refreshTimetable(List<Booking> bookings){
        int hoursCount = closingHour-openingHour;
        timetable = new Booking[hoursCount][5];
        for(int i=0; i<bookings.size(); i++){
             Booking booking = bookings.get(i);
             this.timetable[booking.getHour()-openingHour][booking.getDay()] = booking;
        }
    }

    // get opening hours string
    public String getOpeningHours(){ return "" + openingHour + ":00 - " + closingHour + ":00"; }

    // get path to image
    public String getImageSrc() { return photo; }


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public int getOpeningHour() { return openingHour; }
    public void setOpeningHour(int openingHour) { this.openingHour = openingHour; }

    public int getClosingHour() { return closingHour; }
    public void setClosingHour(int closingHour) { this.closingHour = closingHour; }

    public String getPhoto() { return photo; }
    public void setPhoto(String photo) { this.photo = photo; }

    public Booking[][] getTimetable() { return timetable; }
    public void setTimetable(Booking[][] bookings) { this.timetable = bookings; }

}

