import java.util.ArrayList;
import java.util.List;

public class King extends Piece
{

	public King(int owner, Tile tile)
	{
		ownedBy = owner;
		currentTile = tile;
		type = PIECE_TYPE_KING;
		validMoves = new ArrayList<>();
	}

	public List<Move> getValidMoves()
	{
		return null;
	}
}
