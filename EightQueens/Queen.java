package EightQueens;
import java.awt.Point;


public class Queen extends ChessPiece
{

	public Queen(int row, int col)
	{
		super(row, col);
		this.symbol = 'Q';
		this.name = "Queen";
	}

	@Override
	public boolean isThreateningAnyone(ChessBoard chessboard)
	{
		return (threatDiagonal(chessboard) || threatHorizontal(chessboard) || threatVertical(chessboard) );
	}

	private boolean threatHorizontal(ChessBoard chessboard)
	{
		for(int i = 0; i < chessboard.getSize(); i++)
		{
			if(i != col)
			{
				if(chessboard.isFieldOccupied(row, i) == true)
					return true; 
			}
		}	
		return false; 
	}

	private boolean threatVertical(ChessBoard chessboard)
	{
		for(int i = 0; i < chessboard.getSize(); i++)
		{
			if(i != row)
			{
				if(chessboard.isFieldOccupied(i, col) == true)
					return true;
			}
		}	
		return false; 
	}

	private boolean threatDiagonal(ChessBoard chessboard)
	{
		return (threatLeftDiagonal(chessboard) || threatRightDiagonal(chessboard));
	}

	private boolean threatLeftDiagonal(ChessBoard chessboard)
	{
		Point p = getLeftCornerPointN(chessboard);		
		int y = p.y; //col
		int x = p.x; //row 


		for(; x < chessboard.getSize() && y < chessboard.getSize() ; x++, y++)
		{
			if( !(row==x && col == y) )
			{
				if(chessboard.isFieldOccupied(x, y) == true)
					return true;
			}
		}
		
		return false;
	}

	private boolean threatRightDiagonal(ChessBoard chessboard)
	{
		Point p = getRightCornerPointN(chessboard);		
		int y = p.y; //col; 
		int x = p.x; //row; 

		for(; x < chessboard.getSize() && y > 0 ; x++, y--)
		{	
			if( !(row==x && col == y) )
			{
				if(chessboard.isFieldOccupied(x, y) == true)
					return true;
			}
		}
		return false;
	}

	public  Point getLeftCornerPointN(ChessBoard chessboard)
	{
		int a = Math.min((row), (col));
		return new Point(row - a, col - a);
	}
	
	public Point getRightCornerPointN(ChessBoard chessboard)
	{
		int a = Math.min((row), (chessboard.getSize() - (col + 1)));
		return new Point(row - a, col + a);
	}
	
	public Point getRightCornerPoint(ChessBoard chessboard)
	{
		int x = col;
		int y = row;

		for(; x < chessboard.getSize()-1; x++)
		{
			if(y == 0)
				break;

			y--;

		}

		return new Point(x,y);
	}

	public  Point getLeftCornerPoint(ChessBoard chessboard)
	{
		int x = col;
		int y = row;

		for(; x > 0; x--)
		{
			if(y == 0)
				break;

			y--;

		}
		return new Point(x,y);
	}
}
