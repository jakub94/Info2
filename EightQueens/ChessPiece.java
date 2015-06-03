package EightQueens;

public abstract class ChessPiece
{
	protected int row;
	protected int col; 
	protected String position; 
	protected String name;
	protected char symbol;
	protected boolean color; //0 = white / 1 = black
	
	public ChessPiece(int row, int col)
	{
		this.row = row;
		this.col = col;
		setPositionString();
	}
	
	public abstract boolean isThreateningAnyone(ChessBoard chessboard);
	
	private void setPositionString()
	{
		this.position = "" + (char)(65 + row) + (col + 1);	
	}
	
	public void setPosition(int row, int col) 
	{
		this.row = row;
		this.col = col; 
		
		setPositionString();
	}

	public int getRow()
	{
		return row;
	}

	public int getCol()
	{
		return col;
	}

	public String getPositionString()
	{
		return position;
	}
	public char getSymbol()
	{
		return symbol;
	}
	
}