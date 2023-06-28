import java.util.Arrays;

public class ChickInventoryStack {
    //creates an array of ShipmentObjects
    public ShipmentObject[] chickInventory;
   //starts as -1 to signify stack is empty
    public int lastIndex = -1;

    //initializes stack to 50 for 50 records
    public ChickInventoryStack(){
        chickInventory = new ShipmentObject[50];
    }

    //adds a record to the end of stack
    public void push(ShipmentObject record){
        //will increase the size of the stack there is only one space left for a record
        if(chickInventory.length-lastIndex < 2){
            doubleStackSize();
        }
        //increments lastIndex since record being added
        lastIndex++;
        //adds the record to the index space
        chickInventory[lastIndex] = record;
    }

    //removes and returns the last record in the list
    public ShipmentObject pop() throws Exception{
        //will save the popped record
        ShipmentObject recordPopped;
        //checks to see if stack is empty
        if (isEmpty()){
            throw new Exception("Stack is empty");
        } else {
            //saves last record in variable
            recordPopped = chickInventory[lastIndex];
            //changes that records location to empty
            chickInventory[lastIndex] = null;
            //decrements last index since element is removed
            lastIndex--;
            //returns popped record
            return recordPopped;
        }
    }

    //gets last shipment in the stack
    //NOTE: not used but is a stack implementation just in case
    public ShipmentObject peek() throws Exception {
        //checks if stack is empty
        if(isEmpty()){
            //throws an exception if the stack is empty
            throw new Exception("Stack is empty");
        } else {
            //returns last record in stack
            return chickInventory[lastIndex];
        }
    }

    //gets shipment record according to given index
    public ShipmentObject getRecord(int index) throws Exception {
        //checks to make sure a record exists at specific index
        if(index <= lastIndex){
            //returns record at given index
            return chickInventory[index];
        } else {
            //throws an exception if the index is not associated with a record
            throw new Exception("A record does not exist at this index");
        }
    }

    //returns size of stack
    public int size(){
        return lastIndex + 1;
    }

    //checks to see if stack is empty
    public boolean isEmpty(){
        return lastIndex < 0;
    }

    //increases the size of the stack by 2 if needed
    public void doubleStackSize(){
        chickInventory = Arrays.copyOf(chickInventory, chickInventory.length*2);
    }

}
