package creator;

import builder.*;

public class PCBuilderCreator {
    public PCBuilder createBuilder(String location) throws Exception {
        switch (location) {
            case "1":
                return new T1Builder(); // Core i5
            case "2":
                return new T2Builder(); // Core i7
            case "3":
                return new T3Builder(); // Core i9
            case "4":
                return new T4Builder(); // Gaming PC
            default:
                throw new Exception("Unknown option");
        }
    }
}
