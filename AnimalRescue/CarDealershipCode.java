import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CarDealershipCode
{

	public static void main(String[] args)
	{
		
		displayProgramSummary();
		String fileName = "cars1.txt";
		try
		{
			System.out.println("\nTesting file: " + fileName);
			Dealership dealership = new Dealership("CS Dealership", 6);
			dealershipSetUp(fileName, dealership);
			dealership.displayCars();
			System.out.println("\nMost Expensive Car:");
			dealership.displayMostExpensiveCar();
			String outputFileName = dealership.getDealershipName() + ".txt";
			dealership.writeCarsToFile(outputFileName);
		} catch (FileNotFoundException exception)
		{
			System.out.println("Error: Unable to find file " + fileName);
		}
		System.out.println("\nEnd of program");
	}
	public static void dealershipSetUp(String fileName, Dealership newDealership) throws FileNotFoundException
	{
		File inputFile = new File(fileName);
		Scanner fileScanner = new Scanner(inputFile);
		while (fileScanner.hasNext())
		{
			String make = fileScanner.next();
			String model = fileScanner.next();
			double price = fileScanner.nextDouble();
			Car car = new Car(make, model, price);
			newDealership.addCar(car);
		}
		fileScanner.close();
	}
	public static void displayProgramSummary()
	{
		System.out.println("**************************************");
		System.out.println("Dealership and Car Analysis");
		System.out.println("**************************************");
		System.out.println("Reads car data from a file");
		System.out.println("Displays all cars");
		System.out.println("Finds most expensive car");
		System.out.println();
	
	
	}//End of main
}//End of TestDealership


class Car
{
	private String make;
	private String model;
	private double price;
	
	
	public Car(String make, String model, double price)
	{
		
		this.make = make;
		this.model = model;
		this.price = price;
		
	}
	
	public String getMake()
	{
		
		return make;
	}//End of getMake
	
	public String getmodel()
	{
		
		return model;
	}//
	
	public double getPrice()
	{
		
		return price;
		
	}//End of get Price
	
	
	
	public void displayCarDetails()
	{
		
		System.out.println(" Make: " + make + " Model: " + model + " Price: " + price);
		
	}//End of Display car Details
	
	
}//End of Car class


class Dealership
{
	
	//Making private variables that should not be changed (For right now)
	private String name;
	private Car[] cars;
	private int numberOfCars;
	private int maxNumberOfCars;
	
	//Creating the Dealership class to store the array for the object/Cars
	Dealership(String name, int maxNumberOfCars)
	{
		this.name = name;
		this.maxNumberOfCars = maxNumberOfCars;
		//Setting a random number for now as the array size
		cars = new Car[maxNumberOfCars];
		
		//Giving the numberOfCars a initial variable.
		numberOfCars = 0;
	}
	 String getDealershipName()
	{
		
	return name;
		
	}//End of getDealerShipName

	 void addCar(Car newCar)
	{
		if (numberOfCars < cars.length)
		{
			
		cars[numberOfCars] = newCar;
		numberOfCars++;
			
		}
		
		//Code for adding a car
	}//End of addCar
	 
	 public void displayMostExpensiveCar()
	 {
		Car mostExpensiveCar = cars[0];
		 for (int i = 1; i < cars.length; i++)
		 {
			 
			 if (mostExpensiveCar.getPrice() < cars[i].getPrice())
			 {
				 mostExpensiveCar = cars[i];
			 }//End of If
		 }//End Of for loop
		mostExpensiveCar.displayCarDetails();
	 }//End Of displayMostExpensiveCar
	
	 void displayCars()
	 {
		 
		 for (int i = 1; i < numberOfCars; i++)
		 {
			 
			 cars[i].displayCarDetails();
			 
		 }//End Of For
	 }//End Of DisplayCars
	 
	  void writeCarsToFile(String outputFileName) throws FileNotFoundException
	 {
			File outputFile = new File(outputFileName);
			PrintWriter fileWriter = new PrintWriter(outputFile);
			fileWriter.println("write information");
			fileWriter.close();
			System.out.println("Data written to file: " + outputFile.getAbsolutePath());
		}//End of writeCarsToFile

}//End of Dealership
