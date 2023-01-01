package creator;

import product.Car;


// CarManufacturer is the client of factory method createCar()
public abstract class CarManufacturer {
    protected abstract Car createCar(); // Factory method
    public Car orderCar() {
        return createCar();
    }
}
