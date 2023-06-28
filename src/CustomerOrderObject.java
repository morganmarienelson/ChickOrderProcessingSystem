
//gets and sets the number of chicks and the customer name for all order records
public class CustomerOrderObject {
    int numChicks;
    String customerName;

    public void setNumChicks(int numberOfChicks){
        numChicks = numberOfChicks;
    }

    public int getNumChicks(){
        return numChicks;
    }

    public void setCustomerName(String orderCustomerName){
        customerName = orderCustomerName;
    }

    public String getCustomerName(){
        return customerName;
    }
}
