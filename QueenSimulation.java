// Student: Kris Meehan
// Professor: Professor Soule
// Class: CSC103
// FILE: QueenSimulation.java

// This program solves the N-Queens problem with a board size input by
// the user. The N-Queens problem calculates each individual solutions where
// N Queens can fit on an NxN chess board without any of them threatening
// each other. This program calculates and prints each solution and the
// total number of solutions

import java.util.Scanner;

public class QueenSimulation
{
   private static Scanner kb = new Scanner(System.in);   
      
   public static void main(String[ ] args)
   {
      // variables used to test UnboundedInt class      
      LinkedStack solution = new LinkedStack();
      Queen q1 = new Queen();
      Queen q2 = new Queen();
      Queen popped = new Queen();
      int size;
      int row = 1;
      int column = 1;
      int solutions = 0;
      boolean conflict;  
      boolean done = false;
      
      System.out.println("This program solves the N-Queens problem for an NxN board.");
      System.out.println("Input the size of the board to solve: ");
      size = kb.nextInt();        
      
      // loop through until final column of first row is popped
      while(!done)
      {
         // while there isn't a solution...
         while(solution.size() < size)
         {
            conflict = false;
            q1 = new Queen(row, column);
            
            // check queen with each queen in solution for a conflict
            for(int i = 0; (i < solution.size()) && (conflict == false); i++)
            {                         
               q2 = (Queen)solution.itemAt(i);           
               
               conflict = q2.conflict(q1);           
            }
            // push queen if there is no conflict
            if (conflict == false)
            {
               solution.push(q1);
               row++;
               column = 1;
            }
            else
               column++;
            // continue to pop until column is within the board   
            while (column > size && !done)
            {
               popped = (Queen)solution.pop();
               column = popped.getColumn() + 1;
               row = popped.getRow();
               
               // if last column of first row is popped, end program
               if ((row == 1) && (column-1 == size))               
                  done = true; 
                             
            }  
         }
                       
         if ((solution.size() == size) && !done)
         {
            solutions += 1;
            printSolution(solution, solutions);
            popped = (Queen)solution.pop();
            
            // pop again if column is at the end of the row. Increment column
            if(popped.getColumn() == size)
            {
               popped = (Queen)solution.pop();         
               column = popped.getColumn() + 1;
            }
            // Increment column
            else
               column = popped.getColumn() + 1; 
            row = popped.getRow();            
         }              
      }
      // prints total number of solutions   
      System.out.println("The number of solutions for (N = " + size + ") is " + solutions);
   
   }
   // this method prints the current solution 
   public static void printSolution(LinkedStack stack, int number)
   {
      System.out.print("Solution #" + number + ": " + stack.itemAt(stack.size()-1).toString());
             
      for (int k = stack.size()-2; k >= 0; k--)
         System.out.print(", " + stack.itemAt(k).toString()); 
      System.out.println();
   }
} 
