package bada;


import java.util.List;

public class Court {
    private int id;
    private String name;
    private String address;
    private String image;
    private int openingHour;
    private int closingHour;

    private Booking[][] timetable;


    public Court(){

    }

    public Court(int id, String name, String address, String image, int openingHour, int closingHour){
        this.id = id;
        this.name = name;
        this.address = address;
        this.image = image;
        this.openingHour = openingHour;
        this.closingHour = closingHour;
    }
    
    public Court(int id, String name, String address, int openingHour, int closingHour){
        this.id = id;
        this.name = name;
        this.address = address;
        this.image = id+".jpg";
        this.openingHour = openingHour;
        this.closingHour = closingHour;
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
    public String getOpeningHours(){
        return "" + openingHour + ":00 - " + closingHour + ":00";
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
    
    public void setImage(String image) {
    	this.image = image;
    }
    
    public String getImage() {
    	return image;
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
                ", image='" + image +
                ", opening_hour=" + openingHour +
                ", closing_hour=" + closingHour +
                ']';
    }
}

