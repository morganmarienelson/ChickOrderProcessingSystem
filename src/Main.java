import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Exception {
        //Stores the output after processing
        LinkedList<OrderOutputRecord> output = new LinkedList<>();

       //asks user for input file path
//        Scanner getInputFile = new Scanner(System.in);
//        System.out.println("Enter input file path: ");
//
//        //saves user given path
//        String inputFilePath = getInputFile.nextLine();

        //File path on my computer
        String inputFilePath = "/Users/morgannelson/Desktop/ School/PL Midterm 2/Input File.txt";

        //Creates a file instance
        File file = new File(inputFilePath);

        //calls ReadInputFile class and sends file to class for processing
        ReadInputFileClass processFile = new ReadInputFileClass();
        //stores output values in output variable
        output =  processFile.processRecords(file, output);

        //calls OutputClass to get/print summary information
        OutputClass format = new OutputClass();
        format.formatOutput(output);
    }
}