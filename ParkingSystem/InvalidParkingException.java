package ParkingSystem;

public class InvalidParkingException extends Exception {
    public InvalidParkingException (String str){
        super(str);
    }
}