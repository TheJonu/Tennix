package bada;

public class Court {
    private int court_ID;
    private String name;
    private String address;
    private int opening_hour;
    private int closing_hour;

    public Court(){
    }

    public Court(int court_ID, String name, String address, int opening_hour, int closing_hour){
        this.court_ID = court_ID;
        this.name = name;
        this.address = address;
        this.opening_hour = opening_hour;
        this.closing_hour = closing_hour;
    }

    public int getCourt_ID() {
        return court_ID;
    }

    public void setCourt_ID(int court_ID) {
        this.court_ID = court_ID;
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


    public int getOpening_hour() {
        return opening_hour;
    }

    public void setOpening_hour(int opening_hour) {
        this.opening_hour = opening_hour;
    }

    public int getClosing_hour() {
        return closing_hour;
    }

    public void setClosing_hour(int closing_hour) {
        this.closing_hour = closing_hour;
    }

    @Override
    public String toString() {
        return "bada.Court [" +
                "court_ID=" + court_ID +
                ", name='" + name +
                ", address='" + address +
                ", opening_hour=" + opening_hour +
                ", closing_hour=" + closing_hour +
                ']';
    }
}

