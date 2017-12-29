import java.util.ArrayList;
import java.util.List;

public class Game
{
	public final static char BLANK_TILE = ' ';

	public final static char WHITE_PAWN = 'P';
	public final static char WHITE_ROOK = 'R';
	public final static char WHITE_KNIGHT = 'K';
	public final static char WHITE_BISHOP = 'B';
	public final static char WHITE_KING = '*';
	public final static char WHITE_QUEEN = 'Q';

	public final static char BLACK_PAWN = 'p';
	public final static char BLACK_ROOK = 'r';
	public final static char BLACK_KNIGHT = 'k';
	public final static char BLACK_BISHOP = 'b';
	public final static char BLACK_KING = '#';
	public final static char BLACK_QUEEN = 'q';

	Tile[][] board;
	List<Piece> activeWhite;
	List<Piece> activeBlack;
	List<Piece> capturedWhite;
	List<Piece> capturedBlack;
	List<Move> moveHistory;
	Gui gui;

	public Game()
	{
		gui = new Gui();
		board = new Tile[8][8];
		activeWhite = new ArrayList<>();
		activeBlack = new ArrayList<>();
		capturedWhite = new ArrayList<>();
		capturedBlack = new ArrayList<>();
		moveHistory = new ArrayList<>();
		setBoard();
		initBoardPieces();
		printBoard();
		System.out.println(getBoardState());
	}

	//@TODO: Create board state, ability to import or edit a board state

	public void setBoard()
	{
		for (int rank = 8; rank >= 1; rank--)
		{
			for (char file = 'A'; file < 73; file++)
				board[rank - 1][(int)file - 65] = new Tile(rank, file);
		}
	}

	public String getBoardState()
	{
		StringBuilder state = new StringBuilder();
		for (Tile[] t : board)
		{
			for (Tile i : t)
			{
				if (i.currentPiece == null)
					state.append(Game.BLANK_TILE);
				else if (i.currentPiece.ownedBy == Piece.PIECE_WHITE)
				{
					if (i.currentPiece.type == Piece.PIECE_TYPE_PAWN)
						state.append(Game.WHITE_PAWN);
					else if (i.currentPiece.type == Piece.PIECE_TYPE_ROOK)
						state.append(Game.WHITE_ROOK);
					else if (i.currentPiece.type == Piece.PIECE_TYPE_KNIGHT)
						state.append(Game.WHITE_KNIGHT);
					else if (i.currentPiece.type == Piece.PIECE_TYPE_BISHOP)
						state.append(Game.WHITE_BISHOP);
					else if (i.currentPiece.type == Piece.PIECE_TYPE_KING)
						state.append(Game.WHITE_KING);
					else if (i.currentPiece.type == Piece.PIECE_TYPE_QUEEN)
						state.append(Game.WHITE_QUEEN);
				}
				else
				{
					if (i.currentPiece.type == Piece.PIECE_TYPE_PAWN)
						state.append(Game.BLACK_PAWN);
					else if (i.currentPiece.type == Piece.PIECE_TYPE_ROOK)
						state.append(Game.BLACK_ROOK);
					else if (i.currentPiece.type == Piece.PIECE_TYPE_KNIGHT)
						state.append(Game.BLACK_KNIGHT);
					else if (i.currentPiece.type == Piece.PIECE_TYPE_BISHOP)
						state.append(Game.BLACK_BISHOP);
					else if (i.currentPiece.type == Piece.PIECE_TYPE_KING)
						state.append(Game.BLACK_KING);
					else if (i.currentPiece.type == Piece.PIECE_TYPE_QUEEN)
						state.append(Game.BLACK_QUEEN);
				}
			}
		}
		return state.toString();
	}

	public Tile[][] loadBoardState(String state)
	{
		return parseState(state);
	}

	public Tile[][] parseState(String state)
	{
		Tile[][] newBoard = new Tile[8][8];
		int j = 0;
		for (int i = 0; i < state.length(); i++)
		{
			if (state.charAt(i) == WHITE_PAWN)
				newBoard[i][j].currentPiece = newPiece(Piece.PIECE_TYPE_PAWN, Piece.PIECE_WHITE, newBoard[i][j]);
			else if (state.charAt(i) == WHITE_ROOK)
				newBoard[i][j].currentPiece = newPiece(Piece.PIECE_TYPE_ROOK, Piece.PIECE_WHITE, newBoard[i][j]);
			else if (state.charAt(i) == WHITE_KNIGHT)
				newBoard[i][j].currentPiece = newPiece(Piece.PIECE_TYPE_KNIGHT, Piece.PIECE_WHITE, newBoard[i][j]);
			else if (state.charAt(i) == WHITE_BISHOP)
				newBoard[i][j].currentPiece = newPiece(Piece.PIECE_TYPE_BISHOP, Piece.PIECE_WHITE, newBoard[i][j]);
			else if (state.charAt(i) == WHITE_KING)
				newBoard[i][j].currentPiece = newPiece(Piece.PIECE_TYPE_KING, Piece.PIECE_WHITE, newBoard[i][j]);
			else if (state.charAt(i) == WHITE_QUEEN)
				newBoard[i][j].currentPiece = newPiece(Piece.PIECE_TYPE_QUEEN, Piece.PIECE_WHITE, newBoard[i][j]);
			else if (state.charAt(i) == BLACK_PAWN)
				newBoard[i][j].currentPiece = newPiece(Piece.PIECE_TYPE_PAWN, Piece.PIECE_BLACK, newBoard[i][j]);
			else if (state.charAt(i) == BLACK_ROOK)
				newBoard[i][j].currentPiece = newPiece(Piece.PIECE_TYPE_ROOK, Piece.PIECE_BLACK, newBoard[i][j]);
			else if (state.charAt(i) == BLACK_KNIGHT)
				newBoard[i][j].currentPiece = newPiece(Piece.PIECE_TYPE_KNIGHT, Piece.PIECE_BLACK, newBoard[i][j]);
			else if (state.charAt(i) == BLACK_BISHOP)
				newBoard[i][j].currentPiece = newPiece(Piece.PIECE_TYPE_BISHOP, Piece.PIECE_BLACK, newBoard[i][j]);
			else if (state.charAt(i) == BLACK_KING)
				newBoard[i][j].currentPiece = newPiece(Piece.PIECE_TYPE_KING, Piece.PIECE_BLACK, newBoard[i][j]);
			else if (state.charAt(i) == BLACK_QUEEN)
				newBoard[i][j].currentPiece = newPiece(Piece.PIECE_TYPE_QUEEN, Piece.PIECE_BLACK, newBoard[i][j]);
			if (j < 8)
				j++;
			else
				j = 0;
		}
		return newBoard;
	}

	public void initBoardPieces()
	{
		//Black Pieces
		board[6][0].currentPiece = newPiece(Piece.PIECE_TYPE_PAWN, Piece.PIECE_BLACK, board[6][0]);
		board[6][1].currentPiece = newPiece(Piece.PIECE_TYPE_PAWN, Piece.PIECE_BLACK, board[6][1]);
		board[6][2].currentPiece = newPiece(Piece.PIECE_TYPE_PAWN, Piece.PIECE_BLACK, board[6][2]);
		board[6][3].currentPiece = newPiece(Piece.PIECE_TYPE_PAWN, Piece.PIECE_BLACK, board[6][3]);
		board[6][4].currentPiece = newPiece(Piece.PIECE_TYPE_PAWN, Piece.PIECE_BLACK, board[6][4]);
		board[6][5].currentPiece = newPiece(Piece.PIECE_TYPE_PAWN, Piece.PIECE_BLACK, board[6][5]);
		board[6][6].currentPiece = newPiece(Piece.PIECE_TYPE_PAWN, Piece.PIECE_BLACK, board[6][6]);
		board[6][7].currentPiece = newPiece(Piece.PIECE_TYPE_PAWN, Piece.PIECE_BLACK, board[6][7]);

		board[7][0].currentPiece = newPiece(Piece.PIECE_TYPE_ROOK, Piece.PIECE_BLACK, board[7][0]);
		board[7][1].currentPiece = newPiece(Piece.PIECE_TYPE_KNIGHT, Piece.PIECE_BLACK, board[7][1]);
		board[7][2].currentPiece = newPiece(Piece.PIECE_TYPE_BISHOP, Piece.PIECE_BLACK, board[7][2]);
		board[7][3].currentPiece = newPiece(Piece.PIECE_TYPE_QUEEN, Piece.PIECE_BLACK, board[7][3]);
		board[7][4].currentPiece = newPiece(Piece.PIECE_TYPE_KING, Piece.PIECE_BLACK, board[7][4]);
		board[7][5].currentPiece = newPiece(Piece.PIECE_TYPE_BISHOP, Piece.PIECE_BLACK, board[7][5]);
		board[7][6].currentPiece = newPiece(Piece.PIECE_TYPE_KNIGHT, Piece.PIECE_BLACK, board[7][6]);
		board[7][7].currentPiece = newPiece(Piece.PIECE_TYPE_ROOK, Piece.PIECE_BLACK, board[7][7]);

		//White Pieces
		board[1][0].currentPiece = newPiece(Piece.PIECE_TYPE_PAWN, Piece.PIECE_WHITE, board[1][0]);
		board[1][1].currentPiece = newPiece(Piece.PIECE_TYPE_PAWN, Piece.PIECE_WHITE, board[1][1]);
		board[1][2].currentPiece = newPiece(Piece.PIECE_TYPE_PAWN, Piece.PIECE_WHITE, board[1][2]);
		board[1][3].currentPiece = newPiece(Piece.PIECE_TYPE_PAWN, Piece.PIECE_WHITE, board[1][3]);
		board[1][4].currentPiece = newPiece(Piece.PIECE_TYPE_PAWN, Piece.PIECE_WHITE, board[1][4]);
		board[1][5].currentPiece = newPiece(Piece.PIECE_TYPE_PAWN, Piece.PIECE_WHITE, board[1][5]);
		board[1][6].currentPiece = newPiece(Piece.PIECE_TYPE_PAWN, Piece.PIECE_WHITE, board[1][6]);
		board[1][7].currentPiece = newPiece(Piece.PIECE_TYPE_PAWN, Piece.PIECE_WHITE, board[1][7]);

		board[0][0].currentPiece = newPiece(Piece.PIECE_TYPE_ROOK, Piece.PIECE_WHITE, board[0][0]);
		board[0][1].currentPiece = newPiece(Piece.PIECE_TYPE_KNIGHT, Piece.PIECE_WHITE, board[0][1]);
		board[0][2].currentPiece = newPiece(Piece.PIECE_TYPE_BISHOP, Piece.PIECE_WHITE, board[0][2]);
		board[0][3].currentPiece = newPiece(Piece.PIECE_TYPE_QUEEN, Piece.PIECE_WHITE, board[0][3]);
		board[0][4].currentPiece = newPiece(Piece.PIECE_TYPE_KING, Piece.PIECE_WHITE, board[0][4]);
		board[0][5].currentPiece = newPiece(Piece.PIECE_TYPE_BISHOP, Piece.PIECE_WHITE, board[0][5]);
		board[0][6].currentPiece = newPiece(Piece.PIECE_TYPE_KNIGHT, Piece.PIECE_WHITE, board[0][6]);
		board[0][7].currentPiece = newPiece(Piece.PIECE_TYPE_ROOK, Piece.PIECE_WHITE, board[0][7]);
	}

	public void printBoard()
	{
		for (Tile[] r : board)
		{
			for (Tile t : r)
			{
				if (t.currentPiece != null)
				{
					if (t.currentPiece.ownedBy == Piece.PIECE_WHITE)
					{
						if (t.currentPiece.type == Piece.PIECE_TYPE_PAWN)
							System.out.print('\u2659');
						else if (t.currentPiece.type == Piece.PIECE_TYPE_ROOK)
							System.out.print('\u2656');
						else if (t.currentPiece.type == Piece.PIECE_TYPE_KNIGHT)
							System.out.print('\u2658');
						else if (t.currentPiece.type == Piece.PIECE_TYPE_BISHOP)
							System.out.print('\u2657');
						else if (t.currentPiece.type == Piece.PIECE_TYPE_QUEEN)
							System.out.print('\u2655');
						else if (t.currentPiece.type == Piece.PIECE_TYPE_KING)
							System.out.print('\u2654');
					}
					else if (t.currentPiece.ownedBy == Piece.PIECE_BLACK)
					{
						if (t.currentPiece.type == Piece.PIECE_TYPE_PAWN)
							System.out.print('\u265F');
						else if (t.currentPiece.type == Piece.PIECE_TYPE_ROOK)
							System.out.print('\u265C');
						else if (t.currentPiece.type == Piece.PIECE_TYPE_KNIGHT)
							System.out.print('\u265E');
						else if (t.currentPiece.type == Piece.PIECE_TYPE_BISHOP)
							System.out.print('\u265D');
						else if (t.currentPiece.type == Piece.PIECE_TYPE_QUEEN)
							System.out.print('\u265B');
						else if (t.currentPiece.type == Piece.PIECE_TYPE_KING)
							System.out.print('\u265A');
					}
				}
				System.out.print("\t");
			}
			System.out.println();
		}
	}

	public Piece newPiece(int type, int owner, Tile tile)
	{
		Piece piece = null;
		if (type == Piece.PIECE_TYPE_PAWN)
			piece = new Pawn(owner, tile);
		else if (type == Piece.PIECE_TYPE_ROOK)
			piece = new Rook(owner, tile);
		else if (type == Piece.PIECE_TYPE_KNIGHT)
			piece = new Knight(owner, tile);
		else if (type == Piece.PIECE_TYPE_BISHOP)
			piece = new Bishop(owner, tile);
		else if (type == Piece.PIECE_TYPE_QUEEN)
			piece = new Queen(owner, tile);
		else if (type == Piece.PIECE_TYPE_KING)
			piece = new King(owner, tile);
		if (piece != null)
		{
			if (piece.ownedBy == Piece.PIECE_WHITE)
				activeWhite.add(piece);
			else
				activeBlack.add(piece);
		}
		return piece;
	}

	public void resetGame()
	{
		setBoard();
	}
}
