import java.util.ArrayList;
import java.util.Scanner;

import CarDetails.CarDetails;
import ParkingLot.ParkingLot;
import ParkingSystem.InvalidParkingException;
import ParkingSystem.NoParkingAvailableException;
import ParkingSystem.ParkingSystem;
import Token.Token;

class Main {
    public static void printCarDetails(CarDetails car){
        System.out.println("Name: " + car.getOwnerName() + " Contact No: " + car.getOwnerMobileNo() + " Residence: " + car.getOwnerAddress());
        System.out.println("Car No: " + car.getCarNo() + " Car Model: " + car.getCarModel() + "\n");
    }

    public static void printTokenDetails(Token token){
        System.out.println("\nFloor: " + token.getFloor() + " Section: " + token.getSection() + " Parking No: " + token.getParkingNumber() + "\n");
    }

    public static void printParkingLotDetails(ParkingLot p){
        CarDetails car = p.getCarDetails();
        Token token = p.getToken();
        Boolean isAvailable = p.getIsAvailable();
        if(car != null) printCarDetails(car);
        printTokenDetails(token);
        System.out.println("Available : " + isAvailable + "\n");
    }

    public static void main(String[] args){
        System.out.println("Welcome to Shree-Mall. \n");
        boolean exitMall = false;
        Scanner sc = new Scanner(System.in);
        ParkingSystem p = new ParkingSystem();

        while(!exitMall){
            System.out.println("\n1. I would like to park my car.");
            System.out.println("2. I would like to retrive my car. I have a token with me.");
            System.out.println("3. I would like to retrive my car. I don't have token with me.");
            System.out.println("4. Show me info of all available parking lots.");
            System.out.println("5. Show me info of all parking lots.");
            System.out.println("6. Exit \n");


            System.out.print("Select your option : ");
            int option = sc.nextInt();

            switch(option){
                case 1:
                    System.out.print("\nPlease enter below information.\n");
                    try {
                        System.out.print("Name : ");
                        String ownerName = sc.next();
                        System.out.print("Car Model : ");
                        String carModel = sc.next();
                        System.out.print("Car No : ");
                        String carNo = sc.next();;
                        System.out.print("Contact No : ");
                        int ownerMobileNo = sc.nextInt();
                        System.out.print("Residence : ");
                        String ownerAddress = sc.next();

                        CarDetails car = new CarDetails(ownerName, carModel, carNo, ownerMobileNo, ownerAddress);
                        System.out.println();
                        printCarDetails(car);
                        Token token = p.addNewCar(car);
                        printTokenDetails(token);
                    } catch (NoParkingAvailableException e) {
                        System.out.println("\n\n NoParkingAvailableException : " + e);
                    }
                    break;
                case 2:
                    System.out.println("\nPlease enter below information.\n");
                    try {
                        System.out.print("Floor : ");
                        String floor = sc.next();
                        System.out.print("Section : ");
                        String section = sc.next();
                        System.out.print("Parking No : ");
                        int parkingNumber = sc.nextInt();

                        Token token = new Token(floor, section, parkingNumber);
                        CarDetails removedCar = p.removeCar(token);
                        System.out.println("Removed car details : \n");
                        printCarDetails(removedCar);
                    } catch (InvalidParkingException e) {
                        System.out.println("\n\n InvalidParkingException : " + e);
                    }
                    break;
                case 3:
                    System.out.println("\nPlease enter below information.\n");
                    try {
                        System.out.print("Name : ");
                        String ownerName = sc.next();
                        System.out.print("Car Model : ");
                        String carModel = sc.next();
                        System.out.print("Car No : ");
                        String carNo = sc.next();;
                        System.out.print("Contact No : ");
                        int ownerMobileNo = sc.nextInt();
                        System.out.print("Residence : ");
                        String ownerAddress = sc.next();

                        CarDetails car = new CarDetails(ownerName, carModel, carNo, ownerMobileNo, ownerAddress);
                        CarDetails removedCar = p.removeCar(car);
                        System.out.println("Removed car details : \n");
                        printCarDetails(removedCar);
                    } catch (InvalidParkingException e) {
                        System.out.println("\n\n InvalidParkingException : " + e);
                    }
                    break;
                case 4:
                    try {
                        ArrayList<ParkingLot> parkingLotsList = new ArrayList<>();
                        parkingLotsList = p.getAvailableParkingLotList();
                        System.out.println("\nBelow is the list of available parking lots.\n");
                        for(int i=0; i<parkingLotsList.size(); i++){
                            printParkingLotDetails(parkingLotsList.get(i));
                        }
                    } catch (NoParkingAvailableException e) {
                        System.out.println("\n\n NoParkingAvailableException : " + e);
                    }
                    break;
                case 5:
                    ArrayList<ParkingLot> parkingLotsList = new ArrayList<>();
                    parkingLotsList = p.getParkingLotList();
                    System.out.println("\nBelow is the list of parking lots.\n");
                    for(int i=0; i<parkingLotsList.size(); i++){
                        printParkingLotDetails(parkingLotsList.get(i));
                    }
                    break;
                case 6:
                    exitMall = true;
                    break;
            }
        }

        sc.close();
        System.out.println("\n Thank you. Visit again. \n");
    }
}