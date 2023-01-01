import creator.BMWManufacturer;
import creator.CarManufacturer;
import creator.TeslaManufacturer;
import creator.ToyotaManufacturer;
import product.Car;

public class CarManufacturingSystem {
    String location;
    public CarManufacturingSystem(String location){
        this.location = location;
    }
    private String getCarDetails(Car car) {
        String details = "\n";
        details += "Company: " + car.getCompany() + "\n";
        details += "Color: " + car.getColor() + "\n";
        details += "Manufacturing country: " + car.getManufacturer() + "\n";
        details += "Engine: " + car.getEngine() + "\n";
        details += "Drive train system: " + car.getDriveTrainSystem() + " wheels" + "\n";
        return details;
    }
    private CarManufacturer getManufacturer(String location) throws Exception {
        switch (location) {
            case "US":
                return new TeslaManufacturer();
            case "Asia":
                return new ToyotaManufacturer();
            case "Europe":
                return new BMWManufacturer();
            default:
                throw new Exception("Unknown option");
        }
    }

    public void run() {
        try {
            CarManufacturer man = getManufacturer(location);
            Car car = man.orderCar();
            System.out.println(getCarDetails(car));
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}