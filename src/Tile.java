public class Tile
{
    public final static int TILE_COLOR_WHITE = 0;
    public final static int TILE_COLOR_BLACK = 1;
    int rank;
    char file;
    int color;
    Piece currentPiece;

    public Tile(int rank, char file)
    {
        this.rank = rank;
        this.file = file;
        if (((int)file + rank) % 2 == 0)
            color = TILE_COLOR_BLACK;
        else
            color = TILE_COLOR_WHITE;
    }
}
