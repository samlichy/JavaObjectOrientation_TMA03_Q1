import ou.*;
/**
 * The class Frog defines an amphibian with the characteristics of a frog.
 *
 * @author M250 Module Team
 * @version 2.0
 */

public class Frog extends Amphibian
{
   /**
    * Constructor for objects of class Frog which initialises colour to green
    * and position to 1.
    */  
   public Frog()
   {
      super(OUColour.GREEN, 1);
   }

   /* instance methods */    

   /**
    * Resets the receiver to its "home" position of 1.
    */
   @Override
   public void home()
   {
      this.setPosition(1);
   }

   /**
    * Decrements the position of the receiver by 1.
    */
   @Override
   public void left()
   {
      this.setPosition(this.getPosition() - 1);
   }

   /**
    * Increments the position of the receiver by 1.
    */
   @Override
   public void right()
   {
      this.setPosition(this.getPosition() + 1);
   }

   /**
    * Causes a change in an appropriate observing user interface.
    * Icon representing the receiver performs a jump animation
    */
   public void jump()
   {
      this.performAction("jump");
   }
}
