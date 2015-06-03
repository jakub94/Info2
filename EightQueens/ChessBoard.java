package EightQueens;

import java.util.ArrayList;


public class ChessBoard 
{
	// row, col
	private boolean[][] board;
	private final int size; 
	private ArrayList<ChessPiece> chessPieces; 

	public ChessBoard(int size)
	{
		this.board = new boolean[size][size];
		this.size = size;
		this.chessPieces = new ArrayList<ChessPiece>(); 
	}

	public int getSize()
	{	
		return size;
	}

	public boolean isFieldOccupied(int row, int col)
	{
		checkRowColBounds(row, col);
		return board[row][col]; 
	}

	public ArrayList<ChessPiece> getChessPieces()
	{
		return chessPieces;
	}

	public void addChessPiece(ChessPiece chessPiece) throws IllegalStateException
	{

		if(board[chessPiece.getRow()][chessPiece.getCol()] == false)
		{
			chessPieces.add(chessPiece); 
			board[chessPiece.getRow()][chessPiece.getCol()] = true;
		}
		else
			throw new IllegalStateException();
	}

	public void removeChessPiece(ChessPiece chessPiece)
	{
		chessPieces.remove(chessPiece); 
		board[chessPiece.getRow()][chessPiece.getCol()] = false;
	}
	
	public ChessPiece getChessPiece(int row, int col)
	{
		for(ChessPiece chessPiece : chessPieces)
		{
			if(chessPiece.getRow() == row && chessPiece.getCol() == col)
				return chessPiece;
		}	
		return null;
	}

	public void printBoard()
	{
		String tmp = "";
		for(ChessPiece chesspiece : chessPieces)
			tmp += chesspiece.getSymbol() + "-" + chesspiece.getPositionString() + " ";
		
		System.out.println(tmp);
	}

	public void reset()
	{
		this.board = new boolean[size][size];
		this.chessPieces = new ArrayList<ChessPiece>(); 
	}

	public void printBoardState()
	{
		String tmp = "**";
		for(int i = 0; i < size; i++)
		{
			System.out.print(" " + i);
			tmp += "**";
		}
		System.out.println("\n" + tmp);
		for (int i = 0; i < size; i++)
		{
			String rowState ="|";
			for(int j = 0; j < size; j++)
			{
				ChessPiece chessPiece = getChessPiece(i,j);
				if(chessPiece == null)
					rowState += "O "; 
				else
					rowState += chessPiece.getSymbol() + " ";
			}
			System.out.println(rowState + "|" + i);
			
		}
		System.out.println(tmp);
		
	}

	private void checkRowColBounds(int row, int col)
	{
		if (col < 0 || col >= size)
			throw new IllegalArgumentException("col: " + col);  

		if (row < 0 || row >= size)
			throw new IllegalArgumentException("row: " + row);
	}
}