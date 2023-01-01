import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.print("Enter continental location(US/Asia/Europe): ");
            Scanner sc = new Scanner(System.in);
            String location = sc.nextLine();
            CarManufacturingSystem cms = new CarManufacturingSystem(location);
            cms.run();
        }
    }
}