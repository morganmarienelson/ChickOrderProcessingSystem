import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class ReadInputFileClass {
    public LinkedList<OrderOutputRecord> processRecords(File file, LinkedList<OrderOutputRecord> output) throws Exception {
        CustomerOrderQueue customerOrders = new CustomerOrderQueue();
        ChickInventoryStack chickInventory = new ChickInventoryStack();
        //holds the string for the line read in file
        String fileLine;
        //holds the day since last event
        int currentDay;
        //hold record information
        int numChicks;
        double pricePerChick;

        //Creates a scanner to read file
        Scanner scanner = new Scanner(file);

        //creates instance of ProcessOrderClass for later use
        ProcessOrderClass processOrder = new ProcessOrderClass();

        //Loops through input file while next line exists
        while (scanner.hasNextLine()) {
            //sets fileLine to next record in file
            fileLine = scanner.nextLine();
            //splits record by commas and to store 4 inputs in an array
            String[] recordArray = fileLine.split("[,]", 0);
            //sets the current day to the record's day since last event
            currentDay = Integer.parseInt(recordArray[3].replaceAll("\\s", ""));
            //checks to make sure stack is not empty
            if (!chickInventory.isEmpty()){
                for(int i=0;i<chickInventory.size();i++){
                    //variable to hold shipment record
                    ShipmentObject record;
                    //gets shipment record at index
                    record = chickInventory.getRecord(i);
                    //changes the price of record based on currentDay
                    record.setPricePerChick(record.getPricePerChick() + (.1) * currentDay);
                    //updates the time chicks have been in warehouse
                    record.setDaysInWarehouse(record.getDaysInWarehouse() + currentDay);
                }
            }
            //checks to see if record in array is a shipment
            if (recordArray[0].contains("S")) {
                //creates a new shipment object
                ShipmentObject shipmentRecord = new ShipmentObject();
                //sets the number of chicks in shipment
                numChicks = Integer.parseInt(recordArray[1].replaceAll("\\s", ""));
                //sets the price per chick
                pricePerChick = Double.parseDouble(recordArray[2].replaceAll("\\s", ""));
                //stores info into shipment record
                shipmentRecord.setNumChicks(numChicks);
                shipmentRecord.setPricePerChick(pricePerChick);
                //adds shipment record to stack
                chickInventory.push(shipmentRecord);
                //checks to see if record is an order
            } else if (recordArray[0].contains("O")) {
                //creates new order object
                CustomerOrderObject customerOrder = new CustomerOrderObject();
                //sets number of chicks
                numChicks = Integer.parseInt(recordArray[2].replaceAll("\\s", ""));
                //adds record information to customer order object
                customerOrder.setCustomerName(recordArray[1]);
                customerOrder.setNumChicks(numChicks);
                //adds order to queue
                customerOrders.addLast(customerOrder);
            } else {
                throw new Exception("Invalid input");
            }
            //loops through stack and queue as long as both are not empty
            while (!chickInventory.isEmpty() && !customerOrders.isEmpty()){
                //sets customer order to first order in queue
                CustomerOrderObject customerOrder = customerOrders.getFirst();
                //sets all the chicks in inventory = 0
                int totalChicksInInventory = 0;
                //calculates total number of  chicks in inventory
                for(int i=0;i<chickInventory.size();i++){
                    //gets the shipment record at index i
                    ShipmentObject record = chickInventory.getRecord(i);
                    //adds number of chicks in shipment to total inventory variable
                    totalChicksInInventory += record.getNumChicks();
                }
                //checks to see if there are enough chicks in inventory for current order
                if (totalChicksInInventory >= customerOrder.getNumChicks()){
                    //if there is enough chicks, order is processed
                    processOrder.processCurrentOrders(chickInventory, customerOrder, output, customerOrders);
                    //order is removed from queue since it is complete
                    customerOrders.removeFirst();
                } else {
                    //breaks out of the while loop and processes next file line
                    break;
                }
            }
        }
        return output;
    }
}
