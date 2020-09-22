/**	
 * RadixSort.java
 * Project 0
 * 
 * This file includes a program for Sorting an unsorted list of Address in ascending order based on the ZipCodes given.
 * I have used RadixSort for the purpose of sorting the ZipCode and have used:
 * MailAddressInterface interface - provided by professor - to use the methods
 * Project0Helper class - provided by professor - to test the proper functioning of the sort
 * ConcreteMailAddress - self-created - to implement the MailAddressInterface method
 * 
 * User can input a filename to input the file, the file gets sorted and user can input a filename for output
 *  
 * Sanskar Lamsal
 * EECS 2500 - Linear Data Structure in Java
 * Dr. Gerald R. Heuring
 */

//importing all important essential libraries
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Class RadixSort has the main method, RadixSorting Method and PrintWriter method.
 * These method read unsorted data, process on the data and output the sorted information respectively
*/
public class RadixSort {
	
	/**
	 * RadixSorting method takes in myList(the list of the objects as a parameter
	 * It then accesses ZipCodeDigit to give out the current digit that we are working with and sort them into the RadixSort array bin
	 * The array is then cleared out filling the partial sorted objects according to the ZipCode inside myList
	 * The same process is repeated for all the digits in the ZipCode and finally everything gets sorted according to ZipCode
	 * */
	public static void RadixSorting(MailAddressInterface[] myList) {
		for(int a=5; a>=1; a--) {
			MailAddressInterface RadixSort[][] = new ConcreteMailAddress[10000][10];
			int i = 0;
			while (myList[i] != null) {				
				int column = myList[i].getZipCodeDigit(a);
				int row = 0;
				for(row=0; row<10000; row++) {
					if(RadixSort[row][column]==null) {
						break;
					}
				}
				RadixSort[row][column] = myList[i];
				i++;
			}
		Arrays.fill(myList, null);
		
		int position = 0;
		for(int column=0;column<10;column++) {
			for(int row=0; row<10000; row++) {
				if (RadixSort[row][column] != null) {
					myList[position] = RadixSort[row][column];
					position++;
					}
				}
			}
		}
	}

	/**
	 * PrintWriter takes in filename: output file name and myList: the array of sorted objects as a parameter
	 * It then loops through all the objects in the array from index 0 and prints them into a file name specified by the user
	 * It goes through all the values and act as output for the program
	 */
	public static void PrintWriter(String filename, MailAddressInterface[] myList){
		try {
			FileWriter newWriter = new FileWriter(filename);
			int i=0;
			while (myList[i] != null) {				
				newWriter.write(myList[i].getName()+"\n");
				newWriter.write(myList[i].getAddressLine1()+"\n");
				newWriter.write(myList[i].getAddressLine2()+"\n");
				newWriter.write(myList[i].getCity()+"\n");
				newWriter.write(myList[i].getState()+"\n");
				newWriter.write(myList[i].getZipCode()+"\n");
				i++;
		}			
		newWriter.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Main method is the starting point of the program
	 * It is the method that creates myList array of objects
	 * The method then prompts a user for InputFileName and OutputFileName which will be then used to access input/create output file
	 * The method goes through each line of the input line one by line and groups 6 lines into an object of:
	 * 		1. Name
	 *  	2. Address1
	 *  	3. Address2
	 * 		4. City
	 *  	5. State
	 *  	6. ZipCode
	 *  The method then calls the RadixSort method to sort the objects and also calls the methods from helper class
	 *  the methods from helper class are responsible for checking the time taken and if we have all the Zip code in our program
	 *  It then finally calls the PrintWriter method
	 * */
	public static void main(String[] args) {
		
		MailAddressInterface myList[] = new ConcreteMailAddress[10000];
		Project0Helper helper = new Project0Helper();
		
		Scanner inScanner = new Scanner(System.in);
		System.out.print("Input File > ");
		String inputFileName = inScanner.nextLine();
		System.out.print("Output File> ");
		String outputFileName = inScanner.nextLine();
		inScanner.close();
		
		Scanner myscanner;
		try {
			myscanner = new Scanner(new File(inputFileName) );
			
			try {
				for (int i= 0; i < 10000; i++) {
					String name = myscanner.nextLine();
					String address1 = myscanner.nextLine();
					String address2 = myscanner.nextLine();
					String city = myscanner.nextLine();
					String state = myscanner.nextLine();
					int zip = myscanner.nextInt();
					myscanner.nextLine();  
					myList[i] = new ConcreteMailAddress(name, address1, address2, city, state, zip);
				}
			} catch(NoSuchElementException e) {
				//This marks the end of the input file
			}

			helper.checkStartingOrder(myList);
			RadixSorting(myList);
			helper.checkFinalOrder(myList);
			PrintWriter(outputFileName,myList);
			myscanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}
}	
