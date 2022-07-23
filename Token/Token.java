package Token;

public class Token {
    String floor;
    String section;
    int parkingNumber;

    public Token(String floor, String section, int parkingNumber) {
        this.floor = floor;
        this.section = section;
        this.parkingNumber = parkingNumber;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public int getParkingNumber() {
        return parkingNumber;
    }

    public void setParkingNumber(int parkingNumber) {
        this.parkingNumber = parkingNumber;
    }
}
