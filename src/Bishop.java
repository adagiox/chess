import java.util.ArrayList;

public class Bishop extends Piece
{
	public final static int value = 3;

	public Bishop(int owner, Tile tile)
	{
		ownedBy = owner;
		currentTile = tile;
		type = PIECE_TYPE_BISHOP;
		validMoves = new ArrayList<>();
	}
}
