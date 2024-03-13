import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String manufacturerName = bufferedReader.readLine();

        boolean isLongTermWarranty = Integer.parseInt(bufferedReader.readLine().trim()) != 0;

        int minWarranty = Integer.parseInt(bufferedReader.readLine().trim());

        boolean isGas = Integer.parseInt(bufferedReader.readLine().trim()) != 0;

        boolean isDryer = Integer.parseInt(bufferedReader.readLine().trim()) != 0;

        // Create object of type Manufacturer using the constructor with two parameters. Pass manufacturerName and isLongTermWarranty as arguments
        Manufacturer manufacturer = new Manufacturer(manufacturerName, isLongTermWarranty);

        // Create object of type ElectricDevice using the constructor with 2 parameters. Pass manufacturer and minWarranty as arguments: ElectricDevice electricDevice = new ElectricDevice(manufacturer, minWarranty);
        ElectricDevice electricDevice = new ElectricDevice(manufacturer, minWarranty);

        // Print on the console the warranty of the the object electricDevice, by calling warranty() method
        System.out.println(electricDevice.getWarranty());

        // Assign the electricDevice a new object of type Cooker using the constructor with 3 parameters. Pass manufacturer, price and minWarranty as arguments: electricDevice = new Cooker(manufacturer, minWarranty, isGas);
        electricDevice = new Cooker(manufacturer, minWarranty, isGas);

        // Print on the console the warranty of the object electricDevice, by calling warranty() method
        System.out.println(electricDevice.getWarranty());

        // Assign the electricDevice a new object of type WashingMachine using the constructor with 3 parameters. Pass manufacturer, price and minWarranty as arguments: electricDevice = new WashingMachine(manufacturer, minWarranty, isDryer);
        electricDevice = new WashingMachine(manufacturer, minWarranty, isDryer);

        // Print on the console the warranty of the the object electricDevice, by calling warranty() method
        System.out.println(electricDevice.getWarranty());

        bufferedReader.close();
    }
}
