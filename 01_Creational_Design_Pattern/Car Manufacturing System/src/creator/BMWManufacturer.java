package creator;

import product.BMW;
import product.Car;

public class BMWManufacturer extends CarManufacturer {
    @Override
    public Car createCar()  {
        return new BMW();
    }
}
