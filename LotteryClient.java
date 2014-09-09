/**
*  The following program is a clientside program to run Lottery.class
*
*
*
*
* @author Charles Ivey
*/

//Import my scanner for later use
import java.util.Scanner;

//Name the client
public class LotteryClient
{
   //Begin main
   public static void main(String args[])
   {
      //Creating a lottery object
      Lottery lottery = new Lottery();
      //Create a variable for the while loop used five lines below
      boolean doContinue = true;
      //Do a short introduction
      Intro();
      //The while loop here allows for the user to continue checking number arrays until they are satisfied
      while(doContinue)
      {
      /**
      *  The following is a method to run the entirety of the Lottery calculations/input/display.
      *
      */
      wholeProgramCycle(lottery);
      //This is checked at the end with the checkContinue method to see if the user needs to exit the above while loop and close the program.
      doContinue = checkContinue();
      }//end while(doContinue)
   }//End main  


   //This is a basic introduction method
   public static void Intro()
   {
   System.out.println("Thank you for choosing Lot-o-Tech for your lottery needs!");
   }//End Intro();
   
   /**This is the bulk of the program. It does everything
   *@param inputLottery The lottery object to be passed from main
   */
   public static void wholeProgramCycle(Lottery inputLottery)
   {
   //Defining a user input array here
   int[] userArray = new int[5];
   System.out.println("Enter your lottery ticket consisting of five numbers below.\n");
   //Calling on inputNumbers and assigning that to userArray
   userArray = inputNumbers();
   //Comparing the userArray to the lottery numbers and returning it to the integer positiveHits
   int positiveHits = inputLottery.Compare(userArray);
   //Passing positive hits to the printResults() method to print out the user's sucessful guesses
   printResults(positiveHits);
   }//End wholeProgramCycle()
   
   /**This method asks for and returns the user's guess array
   *  @return The user's array of guessed numbers
   *
   */
   public static int[] inputNumbers()
   {
      //Creating a temporary array
      int[] tempArray = new int[5];
      //Creating a string for the switch statement below
      String numberName = "";
      //Creating a scanner
      Scanner scan = new Scanner(System.in);      
      //Going through the possible numbers the user will have to guess with so I can output the proper word for a number
      //For example, the initial number input would be the "first" number, the next would be the "second".
      //The string numberName is used in the println below the for loop
      for(int i = 0; i < tempArray.length; i++)
      {
         switch(i)
         {
            case 0:
            numberName = "first";
            break;
         
            case 1:
            numberName = "second";
            break;
         
            case 2:
            numberName = "third";
            break;
            
            case 3:
            numberName = "fourth";
            break;
            
            case 4:
            numberName = "fifth";
            break;
         } //end switch(i)
       System.out.println("Please input your " + numberName + " number.\n");
       //Assigning the numbers in the temp array to the user's input
       tempArray[i] = scan.nextInt();  
      }// end for(i)
      return tempArray;   
   }// end inputNumbers
   
   /**
   * @param inputResults The results from comparing the user's input vs the lottery numbers
   */
   public static void printResults(int inputResults)
   {
      //This switch statement will check against the integer value for correct guesses and output the proper statement.
      switch(inputResults)
      {
         case 0:
         System.out.println("You got no matches :(");
         break;
         
         case 1:
         System.out.println("You got one match; Better than nothing!");
         break;         
         
         case 2:
         System.out.println("Two matches, way to go!");
         break;         
         
         case 3:
         System.out.println("Three matches? Statically lucky!");
         break;         
         
         case 4:
         System.out.println("Four matches? You must be cheating...");
         break;         
         
         case 5:
         //Having some fun with a statistical improbability. Try and catching the InterruptedExceptions caused by each Thread.sleep(). I didn't want to throw an interrupted
         //exception for the entire method.
         System.out.println("FIVE MATCHES?! I don't know how to handle this.");
         System.out.println("Seriously, do you know how lucky that is?");
         try{
         Thread.sleep(2000);
         } catch(InterruptedException e){}
         System.out.println("I'm a computer and I don't think I could do that well.");
         try{
         Thread.sleep(2000);
         } catch(InterruptedException e){}
         System.out.println("I need a minute. I gotta think this over.");
         try{
         Thread.sleep(2000);
         } catch(InterruptedException e){}
         //Exits the program
         System.exit(0);
         break;         
         
         
      }
   
   }
   /**
   *  This method will check if the user needs to continue
   *  @return The boolean true/false answer if the user has more guesses/tickets to input.
   *
   */
   public static boolean checkContinue(){
   //The checked boolean is to determine whether the y/n has been sucessfully answered properly
   boolean checked = false;
   boolean returnAnswer = false;
   //While the question hasn't been fully answered, keep asking the question.
   while(!checked){   
      System.out.println("Do you have another lottery ticket to check?");
      //New scanner
      Scanner scan = new Scanner(System.in);
      String answer = scan.nextLine();
      //Format the answer to lower case
      answer = answer.toLowerCase();
      //What is the first letter of the answer? This allows removal of multiple case statements for the switch below as many common answers are reduced to a single response
      //For example, No, no, nope, NO, N, and NO WAY all return as the character 'n'
      char answerChar = answer.charAt(0);
      //Switch statement to check if the player wants to input more tickets
      switch(answerChar)
         {
         case 'y':
         checked = true;  
         returnAnswer = true;   
         break;
         case 'n':
         checked = true;        
         returnAnswer = false;
         System.out.println("Thank you for playing Lot-O-Tech! Please come again!");
         break;
         default:
         System.out.println("I'm sorry, I only understand Yes or No.\n\n");
         break;
         }
   }
   return returnAnswer;
   }

}//end LotteryClient