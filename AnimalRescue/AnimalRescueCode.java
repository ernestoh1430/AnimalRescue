import java.util.Scanner;

/**
 * 
 */
public class AnimalRescueCode
{
 public static void main(String[] args)
	{
	 //Input the Scanner Class
	 Scanner Input = new Scanner(System.in);
	 
	 //Calling method displayProgramOverview
	 displayProgramOverview();
	 //Getting the total Amount of Animals currently in the shelter
	 int numberOfAnimals = getValidNumberOfAnimals(Input);
	Input.nextLine();
	 //Creating Arrays
	 String[] animalNames = new String[numberOfAnimals];
	 double[] animalWeights = new double[numberOfAnimals];
	 double[] animalsDailyFood = new double[numberOfAnimals];
	 double[] animalsWeeklyFood = new double[numberOfAnimals];
	 //Call Method Validating Animal Data
	 validateAnimalData(animalNames, animalWeights, animalsDailyFood, numberOfAnimals, Input);
	 String[] animalsWeightClass = new String[numberOfAnimals];
	 calculateWeeklyFoodEach(animalsDailyFood, animalsWeeklyFood, numberOfAnimals);
	 //Call Method determineAnimalWeightClass
	 determineAnimalWeightClass(animalWeights, numberOfAnimals, animalsWeightClass);
	 //Call Void Method displayAllAnimalsSummary
	 displayAllAnimalsSummary(animalNames, animalWeights, animalsWeightClass, animalsDailyFood, animalsWeeklyFood, numberOfAnimals);
	 //Call Method totalWeekglyFood
	 totalWeeklyFoodAmount(animalsWeeklyFood, numberOfAnimals);
	 //Initializing average Daily Food
	 double averageDailyFood = 0.0;
	 //Call Method calculateAverageDailyFood
	 calculateAverageDailyFood(animalsDailyFood, averageDailyFood, numberOfAnimals);
	 //Call Method displayGreaterOrEqualDailyFood
	 displayGreaterOrEqualDailyFood(animalsDailyFood, averageDailyFood, numberOfAnimals, animalNames);
	 
		}//End Of Main
 public static void displayProgramOverview()
 {
	 System.out.println("This program is being created for an Animal Rescue center who wants to store animal data on all the animals they have.\n"
	 		+ " The program will first get input from the user asking for the number of animals.\n"
	 		+ " After this the program will ask the User to put in all the information needed to track and display all the rescue center needs.\n"
	 		+ " The information needed by the program are the names of each animal, the daily food of each animal, and the weight of each animal.\n"
	 		+ " In the end the program is gonna display all the results for each animal.\r\n");
 }//End of displayProgramOverview
 
 
 public static int getValidNumberOfAnimals(Scanner Input) 
 {//Start of ValidateNumberOfAnimals
	
	System.out.println("Enter the amount of animals currently in the Animal Shelter: ");
	int numberOfAnimals = Input.nextInt(); 
	//While Loop to get a positive number
	while (numberOfAnimals <= 0)
	{
		System.out.println("This Number is Invalid\n Please enter the Number of animals Currently In the Shelter:");
		numberOfAnimals = Input.nextInt();
	}

	 return numberOfAnimals;
 	}//End of getValidNumberOfAnimals
 
 public static void validateAnimalData(String[] animalNames, double[] animalWeights, double[] animalsDailyFood, int numberOfAnimals, Scanner Input)
 {
	 
	 for (int i = 0; i < numberOfAnimals; i++ )
	 {
		 
		 System.out.print("What is the "+ (i + 1) + " Animals Name");
		 animalNames[i] = Input.nextLine();
	 
		 System.out.print("What is His or Her Weight in Pounds?");
		 animalWeights[i] = Input.nextDouble();
		//While Loop to get a positive number
		 while (animalWeights[i] <= 0)
		 {
				System.out.print("This Number is Invalid\n Please enter the Weight of the animal in LBS:");
				 animalWeights[i] = Input.nextDouble();
		 }
		 
		 System.out.println("What is His or Her daily food consumption in Cups?");
		 animalsDailyFood[i] = Input.nextDouble();
		//While Loop to get a positive number
		 while (animalsDailyFood[i] <= 0)
		 {
				System.out.println("This Number is Invalid\n Please enter the Daily Fod Consumption of the animal in Cups:");
				 animalsDailyFood[i] = Input.nextDouble();
		 }
		 Input.nextLine();
	 }//End Of For Loop
	
 }//End of getAnimalData
 
 public static void calculateWeeklyFoodEach(double[] animalsDailyFood, double[] animalsWeeklyFood, int numberOfAnimals)
 {
	 
	 for (int i = 0; i < numberOfAnimals; i++ )
	 {
		animalsWeeklyFood[i] = animalsDailyFood[i] * 7;
	 	}//End Of for loop
 	}//End Of calculateWeeklyFoodEach
 
 public static void determineAnimalWeightClass(double[] animalWeights, int numberOfAnimals, String[] animalsWeightClass)
 {
	 //For Loop for the amount of animals and will give each a weight Class
	 for (int i = 0; i < numberOfAnimals; i++ )
	 {
		 //If else statement to switch the Weight class
		 if (animalWeights[i] < 20)
		 {
			animalsWeightClass[i] = "Small";
		 }
		 else if (animalWeights[i] < 50)
		 {
			 animalsWeightClass[i] = "Medium";
		 }
		 else if (animalWeights[i] < 100)
		 {
			 animalsWeightClass[i] = "Large";
		 }
		 else
		 {
			 animalsWeightClass[i] = "Extra-Large";
		 }
		 
	 }//End of For loop
 }//End of determineingAnimalWeightClass
 
 public static void displayAllAnimalsSummary(String[] animalNames, double[] animalWeights, String[] animalsWeightClass, double[] animalsDailyFood, double[] animalsWeeklyFood, int numberOfAnimals)
 {
	//For Loop for the amount of animals to print out every animals summary
	 for (int i = 0; i < numberOfAnimals; i++ )
	 {
		 System.out.print("\n" + animalNames[i] + " Is " + animalWeights[i] + " lbs, and in the " + animalsWeightClass[i] + " Weight Class" +"They eat " + animalsDailyFood[i] + "Cups Per Day, and " + animalsWeeklyFood[i] + "Cups Per Week\n"); 
	 }//End Of for loop
 }//End of DisplayAllAnimalsSummary
 
 public static void totalWeeklyFoodAmount(double[] animalsWeeklyFood, int numberOfAnimals)
 {
	 
	 double totalWeeklyFood = 0.0;
	 for (int i = 0; i < numberOfAnimals; i++ )
	 {
		 
		 totalWeeklyFood = totalWeeklyFood + animalsWeeklyFood[i];
	 }//End of For Loop
	 System.out.println("The total Weekly Food for all the animals combined is: " + totalWeeklyFood);
 }//End of totalWeeklyFoodAmount
 public static  double calculateAverageDailyFood(double[] animalsDailyFood, double averageDailyFood, int numberOfAnimals)
 {
	 double totalDailyFood = 0.0;
	 for (int i = 0; i < numberOfAnimals; i++ )
	 {
		 totalDailyFood = totalDailyFood + animalsDailyFood[i];
	 }//End Of For Loop
	 averageDailyFood = (totalDailyFood/7);
	 return averageDailyFood;
 }//End of calculateAverageDailyFood
 
 public static void displayGreaterOrEqualDailyFood(double[] animalsDailyFood, double averageDailyFood, int numberOfAnimals, String[] animalNames)
 {
	 for (int i = 0; i < numberOfAnimals; i++ )
	 {
		 
		 if (animalsDailyFood[i] >= averageDailyFood);
		 {
			 System.out.println(animalNames[i] + "Consumes more cups per day then the daily average.\n");
		 }//End If
	 }//End of for loop
 }//End of DisplayGreaterOrEqualDailyFood
 
 
}//End Of Public Class
