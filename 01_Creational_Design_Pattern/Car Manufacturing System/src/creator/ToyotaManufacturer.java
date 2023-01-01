package creator;

import product.Car;
import product.Toyota;

public class ToyotaManufacturer extends CarManufacturer {
    @Override
    public Car createCar() {
        return new Toyota();
    }
}
