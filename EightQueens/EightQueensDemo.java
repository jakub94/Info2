package EightQueens;
import java.util.Random;


public class EightQueensDemo
{

	public static void main(String[] args)
	{
		printNQueensSolution(0, new ChessBoard(8));
	}

	private static void addRandomQueens(int count, ChessBoard chessBoard)
	{
		int size = chessBoard.getSize();
		Random rand = new Random();
		int i = 0;

		for(i = 0; i < count; i++)
		{
			int r1 = rand.nextInt(size);
			int r2 = rand.nextInt(size);
			System.out.println("r1 " + r1 + "  r2 " + r2 );
			try
			{
				chessBoard.addChessPiece(new Queen(r1, r2));

			}
			catch(IllegalStateException e)
			{
				i--;					
			}
		}
	}

	private static boolean isAnyPieceThreateningAnother(ChessBoard board)
	{
		for(ChessPiece piece: board.getChessPieces())
		{
			if(piece.isThreateningAnyone(board))
				return true;
		}
		return false; 
	}

	private static void printNQueensSolution(int row, ChessBoard board)
	{
		int boardSize = board.getSize();

		for(int x = 0; x < boardSize; x++)
		{
			Queen q = new Queen(row, x);
			board.addChessPiece(q);

			if(q.isThreateningAnyone(board))
				board.removeChessPiece(q);
			else
			{
				if(row == (boardSize -1))
				{
					//board.printBoardState();
					board.printBoard();
					board.removeChessPiece(q);
					return;
				}
				
				printNQueensSolution(row + 1, board);
				board.removeChessPiece(q);
			}
		}
	}

}