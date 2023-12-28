// Student: Kris Meehan
// Professor: Professor Soule
// Class: CSC103
// File: Queen.java 

/******************************************************************************
* @author Kris Meehan
* This class is for a Queen object;
* A Queen object contains a row and a column value. There are two constructors,
* a no argument constructor which sets the row and column to 0, and one requiring 
* values to be passed in for the row and column. There are accessor methods to 
* obtain the row and column of the current Queen, a toString method to return a
* formatted string of the current location, and a method to determine whether there
* is a conflict between the two Queens.
* 
* @note
*    Assistance building methods from "Data Structures & Other Objects Using JAVA"
*    by Michael Main

******************************************************************************/
public class Queen implements Cloneable
{
   // Invariant of the UnboundedInt class:
   //   1. The row of the Queen.
   //   2. The Column of the Queen.
   private int row;
   private int column;
      
   /**
   * Initialize a Queen object default coordinates (0, 0).
   * @param - none
   * @postcondition
   *   The row and column of the Queen are set to zero.   
   **/
   public Queen()
   {
      row = 0;
      column = 0;   
   }    
   /**
   * Initialize a Queen object with the passed in coordinates.
   * @param r
   *   The row location of the Queen 
   * @param c
   *   The column location of the Queen
   * @postcondition
   *   The row and column of the Queen have been set.   
   **/
   public Queen(int r, int c)
   {
      row = r;
      column = c;   
   }
   /**
   * Get the row of the current Queen.
   * @param - none 
   * @postcondition
   *   The int value of the row is returned.
   * @return
   *   The row of the Queen.
   **/
   public int getRow()
   {
      return row;   
   }
   /**
   * Get the column of the current Queen.
   * @param - none 
   * @postcondition
   *   The int value of the column is returned.
   * @return
   *   The column of the Queen.
   **/
   public int getColumn()
   {
      return column;   
   }
   /**
   * Return a string containing the row and column of the current Queen.
   * @param - none 
   * @postcondition
   *   The location of the Queen has been returned in a formatted string. 
   * @return
   *   a string containing the location of the Queen.
   **/
   public String toString()
   {
      String location = new String("");
      location = "(row = " + row + ", column = " + column + ")";
      
      return location;
   }
   /**
   * Return a boolean true or false based on whether there is a conflict
   * between the current Queen and the passed in Queen.
   * @param test
   *   The Queen being tested for a conflict. 
   * @postcondition
   *   If a conflict was found true is returned, false if no conflict. 
   * @return
   *   a boolean to tell whether there is a conflict between the Queens.
   **/
   public boolean conflict(Queen test)
   {
      if ((row == test.getRow()) || column == test.getColumn())
         return true;
      else if((row + test.getColumn()) == (column + test.getRow()))
         return true;
      else if((row == test.getColumn()) && (column == test.getRow()))
         return true;
      else if((row + column) == (test.getRow() + test.getColumn()))
         return true;
      else
         return false;
   }  
}