package ParkingSystem;

public class NoParkingAvailableException  extends Exception{
    public NoParkingAvailableException (String str){
        super(str);
    }
}
