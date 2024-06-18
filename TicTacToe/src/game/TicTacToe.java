package game;

import java.util.Scanner;

public class TicTacToe {
		private Player player1,player2;
		private Board board;
		
		public static void main(String[] args) {
			TicTacToe t=new TicTacToe();
			t.startgame();
			}
		
		public void startgame() {
			//player intput
			Scanner s =new Scanner (System.in);
			player1 =takePlayerinput(1);
			player2 =takePlayerinput(2);
			while(player1.getSymbol()!=player1.getSymbol()) {
				System.out.println("Symbol already picked, plese pick another symbol");
				char sy=s.next().charAt(0);
				player2.setSymbol(sy);
				
			}
			//create board
			board =new Board(player1.getSymbol(),player2.getSymbol());
			
			//start game
			boolean p1turn=true;
			int status=Board.INCOMPLETE;
			while(status==Board.INCOMPLETE || status==Board.INVALID) {
				if(p1turn==true) {
					System.out.println("Player1 - " + player1.getName() + "'s turn");
					System.out.println("Enter x: ");
					int x=s.nextInt();
					System.out.println("Enter y: ");
					int y=s.nextInt();
					status= board.move(player1.getSymbol(),x,y);
					if(status!=Board.INVALID) 
					{
						p1turn=false;
						board.print();
					}
					else
					{
						System.out.println("Invalid move! try again");
					}
				}
				else
				{
					System.out.println("Player2 - " + player2.getName() + "'s turn");
					System.out.println("Enter x: ");
					int x=s.nextInt();
					System.out.println("Enter y: ");
					int y=s.nextInt();
					 status= board.move(player2.getSymbol(),x,y);
					if(status!=Board.INVALID) {
						p1turn=true;
						board.print();;	
					}	
					else
					{
						System.out.println("Invalid move! try again");
					}
					
				}
			}
			if(status== Board.Player1_wins) {
				System.out.println("Player1 - " + player1.getName() +  " Wins");
			}
			else if(status== Board.Player2_wins) {
				System.out.println("Player2 - " + player2.getName() +  " Wins");
			}
			else {
				System.out.println("DRAW");
			}
		}
		
		private Player takePlayerinput(int num) {
			Scanner s=new Scanner(System.in);
			System.out.println("Enter player" + num + "name: ");
			String name=s.nextLine();
			System.out.println("Enter player" + num + "symbol: ");
			char symbol=s.next().charAt(0);
			Player p=new Player(name,symbol);
			return p;		
		}
		
}
