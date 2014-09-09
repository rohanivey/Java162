/**
*
*  This class is the service class for a lottery client. Five numbers are generated randomly upon creation from 1 through 50.
*  Several functions exist to allow generating numbers, comparing numbers to an input string and an overriding of the toString
*  to print the Lottery's object array as a user friendly string.
*
*  @author Charles Ivey
*
*/

import java.util.Random;
import java.util.Arrays;
import java.lang.StringBuilder;

public class Lottery
{
   /**
   * Creation of the array lotteryNumbers; five numbers; integer
   */
   private int[] lotteryNumbers = new int[5];
   
   /**
   *  Creation of the random number object
   */
   Random randNum = new Random();
   
   /**
   * Constructor of the Lottery class. Automatically generates new random numbers and sorts them.
   */
   public Lottery(){
      this.GenerateNumbers();
      this.sortNumbers();
      //Arrays.sort(lotteryNumbers);

   }   
   
   /**
   *  This is the method called upon creation of the class. It simply scans through the available values in an array and assigns them a random number
   *  from 1 through 50;
   */
   public void GenerateNumbers()
   {
      for(int i = 0; i < lotteryNumbers.length; i++)
      {
         lotteryNumbers[i] = randNum.nextInt(50)+1;   
      }
   }
   
   /**
   *  Very straightforward method, sorting the lottery numbers using java.util.Arrays;
   */
   public void sortNumbers()
   {
      Arrays.sort(lotteryNumbers);
   }
   
  
   /**
   *  This method returns an integer and compares the input of a passed array
   *  @param compareInput An array to be compared to the random lottery numbers in the lottery object
   *  @return Returns the number of positive comparisons between the passed array and the lottery's array
   *  @throws No exception
   */
   public int Compare(int[] compareInput)
   {
      //Integer to keep the number of hits
      int positiveCompares = 0;
      //Second array to check if a value has already been counted. A 2d array would have been better for this, but I don't think that's the point of this exercise
      int[] usedYet = {0,0,0,0,0};
      //Scanning through the lotteryNumbers
      for(int i = 0; i < lotteryNumbers.length; i++)
      {  
         //Scanning through the user input
         for(int j = 0; j < compareInput.length; j++)
         {
            //If the lottery number is equal to the user input number and it hasn't been counted yet, add one to the positiveCompares tally and mark it as used.
            if(lotteryNumbers[i] == compareInput[j] && usedYet[i] == 0)
            {
            positiveCompares++;
            usedYet[i] = 1;
            }//end if
         }//end for(j)
      }// end for(i)
      
      return positiveCompares;
   }//end Compare()
   
   /**
   *  This method overrides the toString for this object, effectively printing out the lottery numbers array in a readable format
   */
   public String toString()
   {  
      StringBuilder stringNumbers = new StringBuilder();
      
      stringNumbers.append("The winning lottery numbers were:");
      
      for(int i = 0; i < lotteryNumbers.length-1; i++)
      {
         // I could replace the below with a switch/case but this works well enough for all intents and purposes.
         stringNumbers.append(" " + lotteryNumbers[i] + ",");
      }
      stringNumbers.append(" and " + lotteryNumbers[lotteryNumbers.length-1] + ".");
      return stringNumbers.toString();

   }
/* 
//Test main for the class itself if one would like to see it work without the client
public static void main(String args[])
{
   Lottery lottery = new Lottery();
   for(int i = 0; i < lottery.lotteryNumbers.length; i++){System.out.println(lottery.lotteryNumbers[i]);}
   System.out.println(lottery);
} 
*/

}



