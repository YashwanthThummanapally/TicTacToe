package com.ox.gameApplication;

import java.util.Scanner;
import com.ox.exceptions.*;

public class TicTacToeApplication 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		char matrix[] = {'1','2','3','4','5','6','7','8','9'};
		
		System.out.println("Enter 1st player name :");
		String player1 = sc.nextLine();
		
		System.out.println("Enter 2nd player name :");
		String player2 = sc.nextLine();
		
		boolean perfectMove;
		int positionsFilled=0;
		int choice;
		
		while(true)
		{
			perfectMove = false;
		
			System.out.println();
			for(int i=0; i<matrix.length; i++)
			{
				System.out.print(matrix[i]+"   ");
				if((i+1)%3==0)
				{
					System.out.println();
				}
			}
			
			if(positionsFilled%2==0) // player 1
			{
				System.out.println(player1+" : Enter a position to insert 'X'");
				
				try
				{
					choice = Integer.parseInt(sc.nextLine());
					
					if(choice>=1 && choice<=9)
					{					
						if(matrix[choice-1]=='X')
						{
							throw new AlreadyPlacedException("You already inserted 'X' in this position");
						}
						else if(matrix[choice-1]=='O')
						{
							throw new OpponentPositionException("Opponent already inserted 'O' in this position");
						}
						else
						{
							perfectMove = true;
							matrix[choice-1] = 'X';
						}
					}
					else
					{
						throw new InvalidPositionException("Enter valid position between 1 and 9");
					}
				}
				catch(NumberFormatException e)
				{
					System.out.println("Error : Only positive integers are allowed here");
				}
				catch(AlreadyPlacedException e)
				{
					System.out.println("Error : "+e.getMessage());
				}
				catch(OpponentPositionException e)
				{
					System.out.println("Error : "+e.getMessage());
				}
				catch(InvalidPositionException e)
				{
					System.out.println("Error : "+e.getMessage());
				}
			}
			else // player 2
			{
				System.out.println(player2+" : Enter a position to insert 'O'");
				
				try
				{
					choice = Integer.parseInt(sc.nextLine());
					
					if(choice>=1 && choice<=9)
					{
						if(matrix[choice-1]=='O')
						{
							throw new AlreadyPlacedException("You already inserted 'O' in this position");
						}
						else if(matrix[choice-1]=='X')
						{
							throw new OpponentPositionException("Opponent already inserted 'X' in this position");
						}
						else
						{
							perfectMove = true;
							matrix[choice-1] = 'O';
						}
					}
					else
					{
						throw new InvalidPositionException("Enter valid position between 1 and 9");
					}
				}
				catch(NumberFormatException e)
				{
					System.out.println("Error : Only positive integers are allowed here");
				}
				catch(InvalidPositionException e)
				{
					System.out.println("Error : "+e.getMessage());
				}
				catch(AlreadyPlacedException e)
				{
					System.out.println("Error : "+e.getMessage());
				}
				catch(OpponentPositionException e)
				{
					System.out.println("Error : "+e.getMessage());
				}
			}
			
			if(perfectMove)
			{
				++positionsFilled;
				
				if(positionsFilled>3)
				{
					if(matrix[0]==matrix[1] && matrix[1]==matrix[2])
					{
						if(matrix[0]=='X')
						{
							System.out.println(player1+" won the match");
						}
						else
						{
							System.out.println(player2+" won the match");
						}
						break;
					}
					else if(matrix[3]==matrix[4] && matrix[4]==matrix[5])
					{
						if(matrix[3]=='X')
						{
							System.out.println(player1+" won the match");
						}
						else
						{
							System.out.println(player2+" won the match");
						}
						break;
					}
					else if(matrix[6]==matrix[7] && matrix[7]==matrix[8])
					{
						if(matrix[6]=='X')
						{
							System.out.println(player1+" won the match");
						}
						else
						{
							System.out.println(player2+"won the match");
						}
						break;
					}
					else if(matrix[0]==matrix[3] && matrix[3]==matrix[6])
					{
						if(matrix[0]=='X')
						{
							System.out.println(player1+" won the match");
						}
						else
						{
							System.out.println(player2+" won the match");
						}
						break;
					}
					else if(matrix[1]==matrix[4] && matrix[4]==matrix[7])
					{
						if(matrix[1]=='O')
						{
							System.out.println(player2+" won the match");
						}
						else
						{
							System.out.println(player1+" won the match");
						}
						break;
					}
					else if(matrix[2]==matrix[5] && matrix[5]==matrix[8])
					{
						if(matrix[2]=='O')
						{
							System.out.println(player2+" won the match");
						}
						else
						{
							System.out.println(player1+" won the match");
						}
						break;
					}
					else if(matrix[0]==matrix[4] && matrix[4]==matrix[8])
					{
						if(matrix[0]=='O')
						{
							System.out.println(player2+" won the match");
						}
						else
						{
							System.out.println(player1+" won the match");
						}
						break;
					}
					else if(matrix[2]==matrix[4] && matrix[4]==matrix[6])
					{
						if(matrix[2]=='O')
						{
							System.out.println(player2+" won the match");
						}
						else
						{
							System.out.println(player1+" won the match");
						}
						break;
					}
					else
					{
						if(positionsFilled==9)
						{
							System.out.println("Match drawn");
							break;
						}
					}
				}
			}
		}
		sc.close();
	}
}