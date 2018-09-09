import ou.*;

/**
* Class FrogDanceCoordinator
*
* Objects of the FrogDanceCoordinator class allow showing
* dance sequences involving Frog objects.
*
* @author M250 Course Team
* @version 1.2
*/

public class FrogDanceCoordinator
{
   /**
    * instance variables
    */  
   private int numOfFrogsDancing;
   private int numOfDanceMoves;

   private Frog frog1;
   private Frog frog2;
   private Frog frog3;

   private String danceMove1;
   private String danceMove2;
   private String danceMove3;
 
   /**
    * Constructor for objects of class FrogDanceCoordinator.
    */
   public FrogDanceCoordinator (Frog aFrog1, Frog aFrog2, Frog aFrog3)
   {
      super();
      this.frog1 = aFrog1;
      this.frog2 = aFrog2;
      this.frog3 = aFrog3;
      this.numOfFrogsDancing = 0;
      this.numOfDanceMoves = 0;     
   }
 
   /* instance methods */ 
   
   /**
    * Prompts the user to select which, if any, of the three Frog
    * objects referenced by the instance variables are to perform
    * a dance.
    */
   public void selectDancingFrogs()
   {
      this.numOfFrogsDancing = 0;
      
      this.frog1.setColour(OUColour.GREEN);
      this.frog2.setColour(OUColour.GREEN);
      this.frog3.setColour(OUColour.GREEN);
     
      if (OUDialog.confirm("Would you like the first frog to dance?") == true)
      {
          this.frog1.setColour(OUColour.RED);
          this.frog1.setPosition(1);
          this.numOfFrogsDancing++;
      }
      if (OUDialog.confirm("Would you like the second frog to dance?") == true)
      {
         this.frog2.setColour(OUColour.RED);
         this.frog2.setPosition(1);
         this.numOfFrogsDancing++;
      }
      if (OUDialog.confirm("Would you like the third frog to dance?") == true)
      {
         this.frog3.setColour(OUColour.RED);
         this.frog3.setPosition(1);
         this.numOfFrogsDancing++;
      }
   }

   /**
    * Returns true if the argument is in the range 1 to 3 (inclusive),
    * otherwise false.
    */
   public boolean isValidNumOfMoves(int aNumber)
   {
      return ((aNumber >= 1) && (aNumber <= 3));
   }  

   /**
    * Prompts the user for a number of dance moves
    * in the range 1 to 3 inclusive, and returns this number.
    */
   public int promptForNumOfMoves()
   {
      int moves = 0;       
 
      try
      {
         moves = Integer.parseInt(OUDialog.request("Please enter the number of dance moves to be performed - between 1 and 3 (inclusive)"));
      }
      catch (NumberFormatException anException)
      {
         moves = 0;
      }

      return moves;
   }

   /**
    * Repeatedly prompts the user for a number of moves, until they enter
    * a valid input representing a number in the range 1 to 3 inclusive, and
    * then returns this number.
    */   
   public int getNumOfMoves()
   {
      int moves = this.promptForNumOfMoves();
     
      while (!this.isValidNumOfMoves(moves))
      {
         OUDialog.alert("That is not a valid number of dance moves.");
         moves = this.promptForNumOfMoves();   
      }
     
      return moves;
   }
  
   /**
    * Returns true if the argument is either "flip" or "slide",
    * otherwise false.
    */
   public boolean isValidMove(String aMoveType)
   {
      return ((aMoveType.equals("flip")) || (aMoveType.equals("slide")));
   }
 
    /**
    * Prompts the user to enter the the name of a dance move which must be either "flip" or "slide".
    */   
    public String promptForDanceMove()
    {
      String danceMove = OUDialog.request("Please enter type of dance move - flip or slide");

      while (!this.isValidMove(danceMove))
      {
         OUDialog.alert("This is not a valid type of move");
         danceMove = OUDialog.request
         ("Please enter type of dance move - \"flip\" or \"slide\"");
      }
      return danceMove;
   }

   /**
    * 'Flip' a frog depending on its position
    */       
   private void flip(Frog aFrog)
   {
      aFrog.jump();
      if (aFrog.getPosition() == 1)
      {
         aFrog.setPosition(11);
      }
      else
      {
         aFrog.setPosition(1);
      }
      aFrog.jump();
   }   

   /**
    * 'Slide' a frog depending on its position
    */       
   private void slide(Frog aFrog)
   {
      if (aFrog.getPosition() == 1)
      {
         while (aFrog.getPosition() < 11)
         {
            aFrog.setPosition(aFrog.getPosition() + 1);
         }
         aFrog.jump();
      }
      else
      {
         while (aFrog.getPosition() > 1)
         {
            aFrog.setPosition(aFrog.getPosition() - 1);
         }
         aFrog.jump();
      }
   }   
 
   /**
    * 'Flip' all frogs that have been set for dancing
    */   
   private void flipDancingFrogs()
   {
      if (this.frog1.getColour().equals(OUColour.RED))
      {
         this.flip(this.frog1);
      }
      if (this.frog2.getColour().equals(OUColour.RED))
      {
         this.flip(this.frog2);
      }
      if (this.frog3.getColour().equals(OUColour.RED))
      {
         this.flip(this.frog3);
      }
   }   
 
   /**
    * 'Slide' all frogs that have been set for dancing
    */       
   private void slideDancingFrogs()
   {
      if (this.frog1.getColour().equals(OUColour.RED))
      {
         this.slide(this.frog1);
      }
      if (this.frog2.getColour().equals(OUColour.RED))
      {
         this.slide(this.frog2);
      }
      if (this.frog3.getColour().equals(OUColour.RED))
      {
         this.slide(this.frog3);
      }
   }
  
   /**
    * Method to create a dance for all frogs that have been
    * selected to dance. The method takes no arguments and returns
    * no value.
    */
   public void createDance()
   {
      if (numOfFrogsDancing == 0)
      {
         return;
      }
      else
      {
         this.numOfDanceMoves = getNumOfMoves();
        
         this.danceMove1 = promptForDanceMove();
        
         if (numOfDanceMoves > 1)
         {
            this.danceMove2 = promptForDanceMove();
         }
         if (numOfDanceMoves > 2)
         {
            this.danceMove3 = promptForDanceMove();
         }
      }
   }
  
   /**
    * Method to set up a dance which first chooses the
    * number of frogs dancing, and then creates the dance
    * for all frogs selected. This method takes no arguments
    * and returns no value.
    */
   public void setUpDance()
   {
      selectDancingFrogs();
     
      createDance();
   }
  
   /**
    * Method which gets the number of frogs to perform
    * the dance which has been created. This method takes no 
    * arguments and returns no value.
    */
   public void performDance()
   {
      if (this.numOfFrogsDancing == 0)
      {
         return;
      }

      if (danceMove1.equals("flip"))
      {
         flipDancingFrogs();
      }
      else if(danceMove1.equals("slide"))
      {
         slideDancingFrogs();
      }
     
      if (this.numOfDanceMoves > 1)
      {
         if (this.danceMove2.equals("flip"))
         {
            flipDancingFrogs();
         }
         else if(this.danceMove2.equals("slide"))
         {
            slideDancingFrogs();
         }
      }
  
      if (this.numOfDanceMoves > 2)
      {
         if (this.danceMove3.equals("flip"))
         {
            flipDancingFrogs();
         }
         else if(this.danceMove3.equals("slide"))
         {
            slideDancingFrogs();
         }
       }
   }
}