//creates an output record with all the needed properties for each order
public record OrderOutputRecord(
        String customerName,
        int numChicksPurchased,
        double avgPricePerChick,
        double totalAmtSpent,
        int sumOfDayInWarehousePerChick

) {
}
