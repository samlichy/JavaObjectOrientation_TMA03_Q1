import ou.*;
/**
 * The abstract class Amphibian forms the basis of all amphibians.
 *
 * @author M250 Module Team
 * @version 1.0
 */
public abstract class Amphibian extends OUAnimatedObject
{

   /* instance variables */
   private OUColour colour;
   private int position;

   /**
    * Constructor for objects of the abstract class Amphibian.
    */
   public Amphibian(OUColour aColour, int aPosition)
   {
      super();
      this.colour = aColour;
      this.position = aPosition;
   }

   /* instance methods */    

   /** 
    * Moves the receiver to the left.
    */ 
   public abstract void left(); 

   /** 
    * Moves the receiver to the right.
    */
   public abstract void right();

   /**
    * Resets the receiver to its "home" position.
    */
   public abstract void home();

   /**
    * Returns the position of the receiver.
    */
   public int getPosition()
   {
      return this.position;
   }

   /**
    * Sets the position of the receiver to the value of the argument aPosition.
    */
   public void setPosition (int aPosition)
   {
      this.position = aPosition;
      this.update("position");
   }

   /**
    * Sets the colour of the receiver to the argument's colour.
    */
   public void sameColourAs(Amphibian anAmphibian)
   {
      this.setColour(anAmphibian.getColour());
   }

   /**
    * Returns the colour of the receiver.
    */
   public OUColour getColour()
   {
      return this.colour;
   }

   /**
    * Sets the colour of the receiver to the value of the argument aColour.
    */
   public void setColour(OUColour aColour)
   {
      this.colour = aColour;
      this.update("colour");
   }

   /**
    * Sets the colour of the receiver to brown.
    */
   public void brown()
   {
      this.setColour(OUColour.BROWN);
   }

   /**
    * Sets the colour of the receiver to green.
    */
   public void green()
   {
      this.setColour(OUColour.GREEN);
   }

   /**
    * Causes user interface to emit a sound.
    */
   public void croak()
   {
      this.performAction("croak");
   }

   /**
    * Returns a string representation of the receiver.
    */
   @Override
   public String toString()
   {
      return "An instance of class " + this.getClass().getName() 
      + ": position " + this.getPosition() 
      + ", colour " + this.getColour();
   }
}
