import java.util.LinkedList;

public class ProcessOrderClass {
    public void processCurrentOrders(ChickInventoryStack chickInventory, CustomerOrderObject currentOrder, LinkedList<OrderOutputRecord> output, CustomerOrderQueue customerOrders) throws Exception {
        //holds amounts for each split order
        double costOfOrder;
        double pricePerChick;
        int chicksPurchased;

        //Output Variables
        double avgPricePerChick;
        int finalChicksPurchased = 0;
        double finalCost = 0;
        int sumofDaysChicksInWarehouse = 0;

        //checks to see if the customer order is not complete yet
        while (currentOrder != null) {
            //sets current shipment to the last order in the stack and removes it
            ShipmentObject currentShipment = chickInventory.pop();
            //checks to see if the order can be completed by the current shipment
            if (currentOrder.getNumChicks() <= currentShipment.getNumChicks()) {
                //all chicks in order are bought
                chicksPurchased = currentOrder.getNumChicks();
                //calculates total chicks purchased
                finalChicksPurchased = finalChicksPurchased + chicksPurchased;
                //sets the price per chick for current shipment
                pricePerChick = currentShipment.getPricePerChick();
                //calculates the total cost for this shipment
                costOfOrder = (chicksPurchased) * (pricePerChick);
                //calculates total cost of entire order
                finalCost = costOfOrder + finalCost;
                //calculates average price per chick
                avgPricePerChick = finalCost / finalChicksPurchased;
                //calculates total amount of days chicks were in warehouse per chick
                sumofDaysChicksInWarehouse += (currentShipment.getDaysInWarehouse()*(chicksPurchased));
                //creates a new orderComplete record with all output information
                OrderOutputRecord orderComplete = new OrderOutputRecord(currentOrder.getCustomerName(), finalChicksPurchased, avgPricePerChick, finalCost, sumofDaysChicksInWarehouse);
                //adds orderComplete record to output list
                output.add(orderComplete);
                //checks to see if chicks are remaining in shipment
                if (currentOrder.getNumChicks() < currentShipment.getNumChicks()) {
                    //updates the amount of remaining chicks in shipment
                    currentShipment.setNumChicks(currentShipment.getNumChicks() - chicksPurchased);
                    //adds the updated shipment information to end of list
                    chickInventory.push(currentShipment);
                }
                //sets current order to null to show it is complete
                currentOrder = null;
            }
            //order will take all chicks available in last shipment
            else {
                //order will buy all the chicks in current shipment
                chicksPurchased = currentShipment.getNumChicks();
                //calculates total chicks purchased in entire order
                finalChicksPurchased = chicksPurchased + finalChicksPurchased;
                //sets the price per chick for current shipment
                pricePerChick = currentShipment.getPricePerChick();
                //calculates the total cost of current shipment
                costOfOrder = (chicksPurchased) * (pricePerChick);
                //calculates total cost spent so far in order process
                finalCost = costOfOrder + finalCost;
                //calculates total amount of days chicks were in warehouse per chick
                sumofDaysChicksInWarehouse += (currentShipment.getDaysInWarehouse()*(chicksPurchased));
                //updates number of chicks left for order
                currentOrder.setNumChicks(currentOrder.getNumChicks() - chicksPurchased);
            }
        }
    }
}
