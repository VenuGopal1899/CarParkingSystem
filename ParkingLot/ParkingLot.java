package ParkingLot;

import CarDetails.*;
import Token.Token;

public class ParkingLot {
    public CarDetails car;
    public Token token;
    public boolean is_available;

    public ParkingLot(CarDetails car, Token token, boolean is_available) {
        this.car = car;
        this.token = token;
        this.is_available = is_available;
    }

    public CarDetails getCarDetails() {
        return car;
    }

    public void setCarDetails(CarDetails car) {
        this.car = car;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(CarDetails car) {
        this.car = car;
    }

    public boolean getIsAvailable() {
        return is_available;
    }

    public void setIsAvailable(Boolean is_available) {
        this.is_available = is_available;
    }
}
