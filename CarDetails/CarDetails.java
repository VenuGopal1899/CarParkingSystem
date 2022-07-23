package CarDetails;

public class CarDetails {
    public String ownerName;
    public String carModel;
    public String carNo;
    public int ownerMobileNo;
    public String ownerAddress;


    public CarDetails(String ownerName, String carModel, String carNo, int ownerMobileNo, String ownerAddress) {
        this.ownerName = ownerName;
        this.carModel = carModel;
        this.carNo = carNo;
        this.ownerMobileNo = ownerMobileNo;
        this.ownerAddress = ownerAddress;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNO) {
        this.carNo = carNO;
    }

    public int getOwnerMobileNo() {
        return ownerMobileNo;
    }

    public void setOwnerMobileNo(int ownerMobileNo) {
        this.ownerMobileNo = ownerMobileNo;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }
}