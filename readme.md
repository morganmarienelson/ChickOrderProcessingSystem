# Programming Languages Midterm 2
## Chick Order Processing System

### Implementation Details
#### ChickInventoryStack Class
This class was created to manage the stack implementation for the shipment records. 
It contains the push(), pop(), peek(), getRecord(), size(), isEmpty(), and doubleStackSize() methods.
In this program, the peek() and doubleStackSize() methods are not used with the given input.txt.
However, I created these methods to make sure that the stack implementation included the
basic stack methods (peek()) and to make sure that it would still work with different input sizes.

#### CustomerOrderObject Class
This class was utilized to save the number of chicks and the customer names for each
order. It has get and set methods for both variables.

#### CustomerOrderQueue Class
This class holds all the queue implementation details for
customer orders. It includes the getFirst(), addLast(), removeFirst(), isEmpty(), size(), and doubleQueueSize() methods.
The doubleQueueSize() method is not needed for the given input.txt, but
I included it to allow for other possible inputs.

#### OrderOutputRecord Record
This record defines all the summary information necessary for each completed order.

#### OutputClass
The output class formats and prints the information for each completed order in a table format.
It includes the total summary information for all shipments and orders.

#### ProcessOrderClass
This class is called when the first order in the queue can be completed by the current chick inventory.
It completes the order by going through shipments in the chick inventory stack and taking out the desired
number of chicks. Once the order is complete, it adds the completed order
information into the output list.

#### ReadInputFile Class
This class goes through the input.txt line by line and adds each record
to its corresponding stack or queue. It also updates the cost of the chicks based
on the current day. It checks to see if the current shipment is enough to fulfill
the first order in the queue. If so, it calls the ProcessOrderClass.

#### ShipmentObject Class
This class is used to set and get the number of chicks, price per chick, and days the chicks are in the warehouse
for each shipment record.

### Correctness
This program should fulfill all the requirements and run correctly
according to my knowledge

### Additional Notes
This program is currently retrieving the file from a file path
on my computer. However, this path can be commented out. Right above it, there
is a commented out user prompt to enter the users desired file path. Once uncommented,
a user can enter a file path to any input.txt file.
