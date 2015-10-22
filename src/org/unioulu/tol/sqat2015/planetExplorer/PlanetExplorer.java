package org.unioulu.tol.sqat2015.planetExplorer;

// Before submitting write your ID and finish time here. Your ID is written on project description sheets.
// ID:
// Finish time:
public class PlanetExplorer {
	int[][] PlanetSurfaceArray;
	int Rotation = 0;
	int SizeX;
	int SizeY;
	public PlanetExplorer(int x, int y, String obstacles){
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use:
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  //A 100x100 grid with two obstacles at coordinates (5,5) and (7,8) 
	 */
		SizeX = x;
		SizeY = y;
		PlanetSurfaceArray = new int[x][y];
		String[] tokens = obstacles.split("/");
		boolean IsX = true;
		for (String t : tokens)
		{
			  System.out.println(t);
			  String[] tokens2 = t.split(",");
			  int tempX = 0;
			  int tempY = 0;
			  
			  
				for (String t2 : tokens2)
				{
					
					boolean isRun = false;
					if(IsX == true)
					{
						  System.out.println("X:"+t2);
						  IsX = false;
						  isRun = true;
						  tempX = Integer.parseInt(t2);
					}
					if(IsX == false && isRun == false)
					{
						  System.out.println("Y:"+t2);
						  IsX = true;
						  tempY = Integer.parseInt(t2);
					}
					if(IsX == true && isRun == false)
					{					
						PlanetSurfaceArray[tempX][tempY] = 1;
					}
				}
				PlanetSurfaceArray[0][0] = 2;
				
		}		
	}
	
	public int[][] getPlanetSurfaceArray()
	{
		return PlanetSurfaceArray;
	}
	
	public void RotateAntiClockWise()
	{
		if(Rotation == 0)
		{
			Rotation = 3;		
		}
		else if(Rotation == 1)
		{
			Rotation--;		
		}
		else if(Rotation == 2)
		{
			Rotation--;		
		}
		else if(Rotation == 3)
		{
			Rotation--;		
		}	
	}
	public void RotateClockWise()
	{
		if(Rotation == 3)
		{
			Rotation = 0;		
		}
		else if(Rotation == 0)
		{
			Rotation++;		
		}
		else if(Rotation == 1)
		{
			Rotation++;		
		}
		else if(Rotation == 2)
		{
			Rotation++;		
		}	
	}
	
	public int[] GetExplorerLocation()
	{
		for(int x = 0; x < SizeX; x++)
		{
			for(int y = 0; y < SizeY; y++)
			{
				if(PlanetSurfaceArray[x][y] == 2)
				{
					return new int[] {x, y};
				}
			}
		}
		return new int[] {0, 0};	
	}
	
	public boolean CheckCollision(int CoordX, int CoordY)
	{
		
		if(PlanetSurfaceArray[CoordX][CoordY] == 1)
		{
			return true;
		}
		return false;
	}
	
	public void Move(int MovementDirection)
	{
		int[] tempLocationArray = new int[2];
		if(MovementDirection == 1)
		{
			if(Rotation == 0) //North
			{
				tempLocationArray = GetExplorerLocation();
				int tempX = tempLocationArray[0];
				int tempY = tempLocationArray[1];
				PlanetSurfaceArray[tempX][tempY] = 0;
				tempY++;
				if(tempY < SizeY)
				{
					boolean IsColliding = CheckCollision(tempX,tempY);
					if(IsColliding == false)
						PlanetSurfaceArray[tempX][tempY] = 2;
					else
						PlanetSurfaceArray[tempX][tempY-1] = 2;
				}
				if(tempY >= SizeY)
				{
					boolean IsColliding = CheckCollision(tempX,tempY);
					if(IsColliding == false)
						PlanetSurfaceArray[tempX][0] = 2;
					else
						PlanetSurfaceArray[tempX][tempY-1] = 2;				
				}			
			}
			if(Rotation == 1) //East
			{
				tempLocationArray = GetExplorerLocation();
				int tempX = tempLocationArray[0];
				int tempY = tempLocationArray[1];
				PlanetSurfaceArray[tempX][tempY] = 0;
				tempX++;
				if(tempX < SizeX)
				{
					boolean IsColliding = CheckCollision(tempX,tempY);
					if(IsColliding == false)
						PlanetSurfaceArray[tempX][tempY] = 2;
					else
						PlanetSurfaceArray[tempX-1][tempY] = 2;
				}
				if(tempX >= SizeX)
				{
					boolean IsColliding = CheckCollision(tempX,tempY);
					if(IsColliding == false)
						PlanetSurfaceArray[0][tempY] = 2;
					else
						PlanetSurfaceArray[tempX-1][tempY] = 2;				
				}		
			}
			if(Rotation == 2) //South
			{
				tempLocationArray = GetExplorerLocation();
				int tempX = tempLocationArray[0];
				int tempY = tempLocationArray[1];
				PlanetSurfaceArray[tempX][tempY] = 0;
				tempY--;
				
				if(tempY >= 0)
				{
					boolean IsColliding = CheckCollision(tempX,tempY);
					if(IsColliding == false)
						PlanetSurfaceArray[tempX][tempY] = 2;
					else
						PlanetSurfaceArray[tempX][tempY-1] = 2;
				}
				if(tempY < 0)
				{
					boolean IsColliding = CheckCollision(tempX,tempY);
					if(IsColliding == false)
						PlanetSurfaceArray[tempX][SizeY-1] = 2;
					else
						PlanetSurfaceArray[tempX][tempY-1] = 2;				
				}		
			}
			if(Rotation == 3) //west
			{
				tempLocationArray = GetExplorerLocation();
				int tempX = tempLocationArray[0];
				int tempY = tempLocationArray[1];
				System.out.println("Rotation == 3");
				PlanetSurfaceArray[tempX][tempY] = 0;
				System.out.println("PlanetSurfaceArray[tempX][tempY] = 0");
				tempX--;
				
				if(tempX >= 0)
				{
					
					boolean IsColliding = CheckCollision(tempX,tempY);
					if(IsColliding == false)
					{
						System.out.println("PlanetSurfaceArray[tempX][tempY] = 2");
						PlanetSurfaceArray[tempX][tempY] = 2;
					}
					else
						PlanetSurfaceArray[tempX+1][tempY] = 2;
				}
				if(tempX < 0)
				{
					System.out.println("CheckCollision(tempX,tempY)");
					boolean IsColliding = CheckCollision(SizeX-1,tempY);
					if(IsColliding == false)
					{
						System.out.println("PlanetSurfaceArray[SizeX-1][tempY] = 2");
						PlanetSurfaceArray[SizeX-1][tempY] = 2;
					}
					else
						PlanetSurfaceArray[tempX+1][tempY] = 2;				
				}	
			}
		}
	}
	public String executeCommand(String command){
		
		char[] commandArray = command.toCharArray();
		
		for(int x = 0; x < commandArray.length; x++)
		{
			if(commandArray[x] == 'l')
			{
				RotateAntiClockWise();
			}
			if(commandArray[x] == 'r')
			{
				RotateClockWise();
			}
			if(commandArray[x] == 'f')
			{
				Move(1);
			}
			if(commandArray[x] == 'b')
			{
				Move(-1);
			}
		}
		
		/* The command string is composed of "f" (forward), "b" (backward), "l" (left) and "r" (right)
		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.
		 
		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 */
		int[] tempExplorerLocation = GetExplorerLocation();
		
		String Srotation = "F";
		if(Rotation == 0)
		{
			Srotation = "N";
		}
		if(Rotation == 1)
		{
			Srotation = "E";
		}
		if(Rotation == 2)
		{
			Srotation = "S";
		}
		if(Rotation == 3)
		{
			Srotation = "W";
		}
		
		
		String Results = tempExplorerLocation[0] + ","+tempExplorerLocation[1] + "," + Srotation;
		//String Test = "Test";
		return Results;
	}
	
	
}
