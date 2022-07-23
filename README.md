# CarParkingSystem

1.	There is parking slot available in Shree-Mall with 3 floors;
    Each floor has 4 sections and each section can maximum park 20 cars.
2.  You need  to design one application which will maintain all car details in such way when a car owner arrives to collect his car.
    Your application should provide details including where it is located.

3.	Create class CarDetails which will have field’s owerName, carModel, carNO, ownerMobileNo, ownerAddress with setter and getter methods
    (carNo can not be null)
4.	Class Token that contains the information about the floor, section and parking number.
5.	Create class ParkingSystem which will have method’s
    1.	Token addNewCar(CarDetails obj) throws NoParkingAvailableException: To add a car to the parking
    2.	removeCar(CarDetails) throws InvalidParkingException : To remove a car from parking
    3.	removeCar(Token) throws InvalidParkingException : To remove a car from Parking
    4.	Token getParkedCarLocation(CarDetails obj) : To access the car location

6.	Write the test cases to test the application.