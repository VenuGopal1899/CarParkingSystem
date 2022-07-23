package ParkingSystem;

import java.util.*;
import CarDetails.CarDetails;
import Token.Token;
import ParkingLot.ParkingLot;

public class ParkingSystem {
    public ArrayList<ParkingLot> parkingLotList;

    public ParkingSystem() {
        this.parkingLotList = new ArrayList<ParkingLot>();
        for(int f=1; f <= 3; f++){
            for(int s=1; s<=4; s++){
                for(int pNo=1; pNo<=20; pNo++){
                    String floorId = "F" + f;
                    String sectionId = "S" + s;
                    Token token = new Token(floorId, sectionId, pNo);
                    ParkingLot parkingLot = new ParkingLot(null, token, true);
                    this.parkingLotList.add(parkingLot);
                }
            }
        }
    }

    public boolean isMatchingCarInfo(CarDetails car1, CarDetails car2){
        if(!car1.getOwnerName().equals(car2.getOwnerName())) return false;
        if(!car1.getCarModel().equals(car2.getCarModel())) return false;
        if(!car1.getCarNo().equals(car2.getCarNo())) return false;
        if(car1.getOwnerMobileNo() != car2.getOwnerMobileNo()) return false;
        if(!car1.getOwnerAddress().equals(car2.getOwnerAddress())) return false;

        return true;
    }

    public boolean isMatchingTokenInfo(Token t1, Token t2){
        if(!t1.getFloor().equals(t2.getFloor())) return false;
        if(!t1.getSection().equals(t2.getSection())) return false;
        if(t1.getParkingNumber() != t2.getParkingNumber()) return false;
        return true;
    }

    public ArrayList<ParkingLot> getParkingLotList(){
        return this.parkingLotList;
    }

    public ArrayList<ParkingLot> getAvailableParkingLotList() throws NoParkingAvailableException{
        ArrayList<ParkingLot> response = new ArrayList<ParkingLot>();
        for(int i=0; i < this.parkingLotList.size(); i++){
            ParkingLot p = this.parkingLotList.get(i);
            if(p.getIsAvailable()){
                response.add(p);
            }
        }
        if(response.size() > 0) return response;
        throw new NoParkingAvailableException("Parking space not available.");
    }

    public CarDetails removeCar(CarDetails car) throws InvalidParkingException{
        for(int i=0; i < this.parkingLotList.size(); i++){
            ParkingLot p = this.parkingLotList.get(i);
            CarDetails c = p.getCarDetails();
            if(c != null && isMatchingCarInfo(c, car)){
                p.setCarDetails(null);
                p.setIsAvailable(true);
                return c;
            }
        }
        throw new InvalidParkingException("Parking lot not found for given car info.");
    }

    public CarDetails removeCar(Token token) throws InvalidParkingException {
        for(int i=0; i < this.parkingLotList.size(); i++){
            ParkingLot p = this.parkingLotList.get(i);
            CarDetails car = p.getCarDetails();
            Token t = p.getToken();
            if(car != null && isMatchingTokenInfo(t, token)){
                p.setCarDetails(null);
                p.setIsAvailable(true);
                return car;
            }
        }
        throw new InvalidParkingException("Parking lot not found for given token info.");
    }

    public Token addNewCar(CarDetails car) throws NoParkingAvailableException {
        for(int i=0; i < this.parkingLotList.size(); i++){
            ParkingLot p = this.parkingLotList.get(i);
            if(p.getIsAvailable() == true){
                p.setCarDetails(car);
                p.setIsAvailable(false);
                return p.getToken();
            }
        }
        throw new NoParkingAvailableException("Parking space not available.");
    }

    public Token getParkedCarLocation(CarDetails car) throws InvalidParkingException {
        for(int i=0; i < this.parkingLotList.size(); i++){
            ParkingLot p = this.parkingLotList.get(i);
            CarDetails c = p.getCarDetails();
            if(c != null && isMatchingCarInfo(c, car)){
                return p.getToken();
            }
        }
        throw new InvalidParkingException("Parking lot not found for given car info.");
    }
}
