import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.LinkedList;
public class OutputClass {
    public void formatOutput(LinkedList<OrderOutputRecord> output) {
        //Summary variables
        int totalNumberOfSales = 0;
        int totalChicksSold = 0;
        double grossSalesTotal= 0;
        double avgPriceOfEachChickSold;
        int totalDaysInWarehouse = 0;
        double avgDaysChickInWarehouse;

        //Makes doubles only show two decimal places
        DecimalFormat toTheNearestTenth = new DecimalFormat("0.00");
        //Formats table heading, left aligned, with n chars for each output
        System.out.format("%-30s %20s %20s %20s", "Customer Name", "# of Chicks Purchased", "Avg Price/Chick", "Total Amount\n");
        //goes through all the records in output to print them out in table format
        for (OrderOutputRecord record : output) {
            System.out.format("%-30s %20s %20s %20s", record.customerName(), record.numChicksPurchased(), toTheNearestTenth.format(Math.round(record.avgPricePerChick()*100)/100.0), toTheNearestTenth.format(record.totalAmtSpent()) + "\n");
            //calculates summary variables based on info in each record
            totalChicksSold += record.numChicksPurchased();
            totalNumberOfSales++;
            grossSalesTotal += record.totalAmtSpent();;
            totalDaysInWarehouse += record.sumOfDayInWarehousePerChick();
        }
        //calculates averages for summary information
        avgDaysChickInWarehouse = (double) totalDaysInWarehouse/totalChicksSold;
        avgPriceOfEachChickSold = grossSalesTotal/totalChicksSold;
        //Summary information display
        System.out.println();
        System.out.println("Summary Statistics:");
        System.out.println("Total Number of Completed Sales: " + totalNumberOfSales);
        System.out.println("Total Number of Chicks Sold: " + totalChicksSold);
        System.out.println("Average Price of Each Chick Sold: " + toTheNearestTenth.format(avgPriceOfEachChickSold));
        System.out.println("Average Number of Days a Sold Chick Stayed in the Warehouse: " + toTheNearestTenth.format(avgDaysChickInWarehouse));
        System.out.println("Gross Sales Total: " + toTheNearestTenth.format(grossSalesTotal));
    }
}
