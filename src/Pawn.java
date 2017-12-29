import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece
{
	public final static int value = 1;

	public Pawn(int owner, Tile tile)
	{
		ownedBy = owner;
		currentTile = tile;
		type = PIECE_TYPE_PAWN;
		validMoves = new ArrayList<>();
	}

	public List<Move> getValidMoves()
	{
		return null;
	}
}
