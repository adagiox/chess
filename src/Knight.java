import java.util.ArrayList;

public class Knight extends Piece
{
	public final static int value = 3;

	public Knight(int owner, Tile tile)
	{
		ownedBy = owner;
		currentTile = tile;
		type = PIECE_TYPE_KNIGHT;
		validMoves = new ArrayList<>();
	}
}
