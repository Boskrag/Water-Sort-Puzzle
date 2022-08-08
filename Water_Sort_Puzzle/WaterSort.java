import java.util.Scanner;
import java.util.Random;
import java.util.*;
class WaterSort
 {
	Character top = null;
	// create constants for colors
	static Character red= new Character('r');
	static Character blue = new Character('b');
	static Character yellow= new Character('g');
	// Bottles declaration
	
	
	public static void showAll( StackAsMyArrayList bottles[])
	{
		for (int i = 0; i<=4; i++)
		 {
			 System.out.println("Bottle "+ i+ ": " + bottles[i]);
		 }
	}
	
	public static boolean Solved(StackAsMyArrayList bottles[])
	{
		int counter = 0;
		for (int i = 0; i < bottles.length; i++)
		{	
			if(bottles[i].checkStackUniform() == true)
			{
				counter ++;
			}
		}
		if(counter == 4)
		{
			return true;
		}
		return false;
	}
 
	
    public static void main(String args[])
    {
		 int moves = 0;// number of moves to mix the water
		 int source = 0; // number of bottle to pour FROM
		 int target = 0; // number of bottle to pour TO
		 int max = 4; // total number of items allowed per bottle
		 Random randomNum = new Random();
		 // Bottles declaration
		 StackAsMyArrayList bottles[] = new StackAsMyArrayList[5];
		 //You can do this with a for also
		 bottles[0] = new StackAsMyArrayList<Character>();
		 bottles[1] = new StackAsMyArrayList<Character>();
		 bottles[2] = new StackAsMyArrayList<Character>();
		 bottles[3] = new StackAsMyArrayList<Character>();
		 bottles[4] = new StackAsMyArrayList<Character>();
		 
		 //////STRATEGY #1
		 while (moves<4) // 4 moves per 3 colors = 12 moves required
        {
          // get source bottle
          target = randomNum.nextInt(max+1);
          while (bottles[target].getStackSize() == 4)// target is full
             {
               target = randomNum.nextInt(max);
             }
          bottles[target].push(blue);
		  target = randomNum.nextInt(max+1);
		  while (bottles[target].getStackSize() == 4)// target is full
             {
               target = randomNum.nextInt(max);
             }
          bottles[target].push(red);
		  target = randomNum.nextInt(max+1);
		  while (bottles[target].getStackSize() == 4)// target is full
             {
               target = randomNum.nextInt(max);
             }
          bottles[target].push(yellow);
          // increment valid moves
          moves++;
        }
		
		while(!Solved(bottles))
		{
			showAll(bottles);
			
			System.out.println(" ");
			
			Scanner bottleSource = new Scanner(System.in);
			System.out.println("Enter bottle source number: ");
			int bSource = bottleSource.nextInt();
			
			Scanner bottleTarget = new Scanner(System.in);
			System.out.println("Enter bottle target number: ");
			int bTarget = bottleTarget.nextInt();
			
			if(bSource < 0 || bSource > 4)
			{
				System.out.println("Source out of range");
			}
			
			else if(bTarget < 0 || bTarget > 4)
			{
				System.out.println("Target out of range");
			}
			
			else if(bottles[bSource].getStackSize() == 0)
			{
				System.out.println("The bottle is empty: ");
			}
			
			else if(bottles[bSource].peek()!= bottles[bTarget].peek())
			{
				System.out.println("Colours not matching: ");
			}
			
			else if(bottles[bTarget].getStackSize() == 4)
			{
				System.out.println("Target is full: ");
			}
			else 
			{
				bottles[bTarget].push(bottles[bSource].pop());
			}
		
		}
		
		System.out.println("Congratulations! You solved the puzzle! ");

	}
}