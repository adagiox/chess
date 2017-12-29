import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece
{
	public final static int value = 5;

	public Rook(int owner, Tile tile)
	{
		ownedBy = owner;
		currentTile = tile;
		type = PIECE_TYPE_ROOK;
		validMoves = new ArrayList<>();
	}

	public List<Move> getValidMoves()
	{
		return null;
	}
}
