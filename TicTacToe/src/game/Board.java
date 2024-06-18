package game;

public class Board {
	private char board[][];
	private int boardsize=3;
	private char p1symbol,p2symbol;
	private int count;
	public final static int Player1_wins=1;
	public final static int Player2_wins=2;
	public final static int DRAW=3;
	public final static int INCOMPLETE=4;
	public final static int INVALID=5;
	
	
	public Board(char p1symbol,char p2symbol) {
		board =new char[boardsize][boardsize];
		for(int i=0;i< boardsize;i++) {
			for(int j=0;j<boardsize;j++) {
				board[i][j]=' ';
			}
		}
		this.p1symbol=p1symbol;
		this.p2symbol=p2symbol;
		
	}
	public int move(char symbol,int x,int y) {
		
		if(x<0 || x>=boardsize || y<0 || y>boardsize || board[x][y]!=' ') {
			return INVALID;
		}
		
		board[x][y]=symbol;
		count++;
		//check row
		if(board[x][0]==board[x][1] && board[x][0]==board[x][2]) {
			return symbol == p1symbol ? Player1_wins : Player2_wins;		
		}
		//check column
		if(board[0][y]==board[1][y] && board[0][y]==board[2][y]) {
			return symbol == p1symbol ? Player1_wins : Player2_wins;		
		}
		//diagonal 1
		if(board[0][0]!=0 && board[0][0]==board[1][1] && board[0][0]==board[2][2]) {
			return symbol == p1symbol ? Player1_wins : Player2_wins;		
		}
		//diagonal 2
		if(board[0][0]!=0 &&  board[0][2]==board[1][1] && board[0][2]==board[2][0]) {
			return symbol == p1symbol ? Player1_wins : Player2_wins;		
		}
		
		if(count==boardsize * boardsize ) {
			return DRAW;
		}
		return INCOMPLETE;
		
	}
	
	public void print() {
		for(int i=0;i< boardsize;i++) {
			for(int j=0;j<boardsize;j++) {
				System.out.print("| " +board[i][j] + " |");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("----------------");
	}
	

}

