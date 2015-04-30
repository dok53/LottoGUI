package myLotto;


import acm.program.*;


import java.util.ArrayList;
import java.util.Random;




public class Lotto extends ConsoleProgram {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int drawnBalls;
	private int lastNumber;
	private int numOfRows;
	
	
	public void run()
	{
		print("Enter the number of balls in the drum : ");
		lastNumber = readInt();
		print("Enter the number of balls to be drawn : ");
		drawnBalls = readInt();
		print("Enter the number of rows you want : ");
		numOfRows = readInt();
		drawBalls();
		extraBalls();
		
	}
	
	/**
	 * @return the firstNumber
	 */
	public int getFirstNumber() 
	{
		return drawnBalls;
	}
	
	/**
	 * @return drawnBalls Returns the drawn balls
	 */
	private int drawBalls()
	{
		for (int k = 0; k < numOfRows; k++)
		{
			print("The balls chosen are : ");
			ArrayList<Integer> templist = new ArrayList<Integer>();
			for (int i = 0; i < drawnBalls; i++)
			{
				//print("" + Generator.nextInt(lastNumber) + " ");
				int j = Generator.nextInt(lastNumber);
				if (!templist.contains(j + 1))
				{
					templist.add(j + 1);
				}
				else
				{
					templist.add(j + 2);
				}
				print (templist.get(i) + " ");
			}
			print ("\n");
		}
			print ("\n");
			return drawnBalls;
		
	}
	
	private void extraBalls()
	{
		print("Do you want to draw any more balls (y/n)? : ");
		String choice = readLine();
		if (choice.equalsIgnoreCase("Y"))
		{
			print("Enter the number of balls in the drum : ");
			int extraBalls = readInt();
			print("Enter the number of balls to be drawn : ");
			int ballsGenerated = readInt();
			for (int k = 0; k < numOfRows; k++)
			{
				print("The extra balls are : ");
				ArrayList<Integer> templist2 = new ArrayList<Integer>();
				for (int i = 0; i < ballsGenerated; i ++)
				{
					int j = Generator.nextInt(extraBalls);
					if (templist2.contains(j + 1))
					{
						templist2.add(j + 2);
					}
					templist2.add(j + 1);
					print(templist2.get(i) + " ");
				}
				print ("\n");
			}
		}
		else
		{
			print("Goodluck with your numbers, press E to exit : ");
			String pick = readLine();
			if (pick.equalsIgnoreCase("e"))
			{
				System.exit(5000);
			}
		}
	}

	/**
	 * @param firstNumber the firstNumber to set
	 */
	public void setFirstNumber(int drawnBalls) 
	{
		this.drawnBalls = drawnBalls;
	}

	/**
	 * @return the lastNumber
	 */
	public int getLastNumber() 
	{
		return lastNumber;
	}

	/**
	 * @param lastNumber the lastNumber to set
	 */
	public void setLastNumber(int lastNumber) 
	{
		this.lastNumber = lastNumber;
	}
	
	Random Generator = new Random();
	


}
