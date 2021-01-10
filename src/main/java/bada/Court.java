package bada;

public class Court {
    private int id;
    private String name;
    private String address;
    private int openingHour;
    private int closingHour;
    private boolean[][] windows = new boolean[24][5];

    public Court(){
        this.windows[1][1] = true;
    }

    public Court(int id, String name, String address, int openingHour, int closingHour){
        this.id = id;
        this.name = name;
        this.address = address;
        this.openingHour = openingHour;
        this.closingHour = closingHour;
        this.windows[1][1] = true;
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

    public boolean[][] getWindows() {
        return windows;
    }

    public void setWindows(boolean[][] windows) {
        this.windows = windows;
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

