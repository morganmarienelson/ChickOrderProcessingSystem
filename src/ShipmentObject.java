
//gets and sets the number of chicks, price per chick, and the days chicks are in warehouse for all shipment records
public class ShipmentObject {
    int numChicks;
    double pricePerChick;
    int daysInWarehouse;

    public void setNumChicks(int numberOfChicks){
         numChicks = numberOfChicks;
    }

    public int getNumChicks(){
      return numChicks;
    }

    public void setPricePerChick(double shipPricePerChick){
        pricePerChick = shipPricePerChick;
    }

    public double getPricePerChick(){
        return pricePerChick;
    }

    public void setDaysInWarehouse(int daysPast){
        daysInWarehouse = daysPast;
    }

    public int getDaysInWarehouse(){
        return daysInWarehouse;
    }
}
