public class Queen extends Piece
{
	public final static int value = 9;

	public Queen(int owner, Tile tile)
	{
		ownedBy = owner;
		currentTile = tile;
		type = PIECE_TYPE_QUEEN;
	}
}
