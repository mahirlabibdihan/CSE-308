package creator;

import product.Car;
import product.Tesla;

public class TeslaManufacturer extends CarManufacturer {

    @Override
    public Car createCar() {
        return new Tesla();
    }
}
