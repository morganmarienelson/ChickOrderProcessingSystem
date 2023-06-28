import java.util.Arrays;

public class CustomerOrderQueue {
    //creates an array of CustomerOrderObjects
    public CustomerOrderObject[] customerOrders;
    public int lastIndex = -1;

    //initializes queue to 50 for 50 records
    public CustomerOrderQueue(){
        customerOrders = new CustomerOrderObject[50];
    }

    //gets first record in queue
    public CustomerOrderObject getFirst() throws Exception {
       //checks to see if queue is empty
        if(isEmpty()){
            throw new Exception("Queue is empty");
        } else {
            //returns first record in queue
            return customerOrders[0];
        }
    }

    //adds a record to the end of a queue
    public void addLast(CustomerOrderObject record){
        //will increase the size of the queue by 2 if there is only one space left for a record
        if(customerOrders.length-lastIndex < 2){
            doubleQueueSize();
        }
        //increments last index since record is added
        lastIndex++;
        //adds record to the index space
        customerOrders[lastIndex] = record;
    }

    //removes the first record of the queue
    public void removeFirst() throws Exception{
        if (isEmpty()){
            throw new Exception("Queue is empty");
        } else {
            //removes first record in queue
            customerOrders[0] = null;
            //loops through every index in queue
            for (int i =0; i < size(); i++){
                //places order at its index-1
                customerOrders[i] = customerOrders[i+1];
                //clears the index space that record was at
                customerOrders[i + 1] = null;
            }
            //decrements last index since record was removed
            lastIndex--;
        }
    }

    //checks to see if queue is empty
    public boolean isEmpty(){
        return lastIndex < 0;
    }

    //returns size of queue
    public int size(){
        return lastIndex + 1;
    }

    //increases the size of the queue by 2 if needed
    public void doubleQueueSize(){
        customerOrders   = Arrays.copyOf(customerOrders, customerOrders .length*2);
    }

}
