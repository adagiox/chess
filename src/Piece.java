abstract public class Piece
{
    public final static int PIECE_WHITE = 0;
    public final static int PIECE_BLACK = 1;
    public final static int PIECE_TYPE_PAWN = 0;
    public final static int PIECE_TYPE_ROOK = 1;
    public final static int PIECE_TYPE_KNIGHT = 2;
    public final static int PIECE_TYPE_BISHOP = 3;
    public final static int PIECE_TYPE_QUEEN = 4;
    public final static int PIECE_TYPE_KING = 5;

    int type;
    Tile currentTile;
    int ownedBy;
}
