import delivery.*;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String materialName = bufferedReader.readLine();
        boolean isFragile = Integer.parseInt(bufferedReader.readLine().trim()) != 0;
        boolean toClientsAddress = Integer.parseInt(bufferedReader.readLine().trim()) != 0;
        double minPrice = Double.parseDouble(bufferedReader.readLine().trim());
        double weight = Double.parseDouble(bufferedReader.readLine().trim());
        double pricePerKg = Double.parseDouble(bufferedReader.readLine().trim());
        double additionalPrice = Double.parseDouble(bufferedReader.readLine().trim());

        // Use the set method to give the value additionalPrice to the additional price when the shipment has to be delivered to the client's address.
        DeliverableItem.setExtraPrice(additionalPrice);

        // Create an object of type Material using the constructor with two parameters. Pass materialName and isFragile as arguments.
        Material material = new Material(materialName, isFragile);

        // Create a reference of type Deliverable.
        Deliverable item;

        // Use the reference of type Deliverable to create an object of type Document. Use toClientsAddress and minPrice to the constructor of the Document.
        item = new Document(toClientsAddress, minPrice);

        // Print on the console the result of calling the deliveryPrice() method: the method that has to return the total shipping price for the delivery.
        System.out.println(item.deliveryPrice());

        // Use the reference of type Deliverable to create an object of type WeightedItem. Use weight and pricePerKg to pass them to the constructor of the WeightedItem.
        item = new WeightedItem(toClientsAddress, material, weight, pricePerKg);

        // Print on the console the result of calling the deliveryPrice() method: the method that has to return the total shipping price for the delivery.
        System.out.println(item.deliveryPrice());

        bufferedReader.close();
    }
}
