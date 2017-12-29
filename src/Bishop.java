import java.util.ArrayList;
import java.util.List;

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

	public List<Move> getValidMoves()
	{
		return null;
	}
}
