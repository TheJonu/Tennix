package bada;

public class Court {
    private int id;
    private String name;
    private String address;
    private int openingHour;
    private int closingHour;

    public Court(){
    }

    public Court(int id, String name, String address, int openingHour, int closingHour){
        this.id = id;
        this.name = name;
        this.address = address;
        this.openingHour = openingHour;
        this.closingHour = closingHour;
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

