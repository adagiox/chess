public class Game
{
	Tile[][] board;
	Gui gui;

	public Game()
	{
		//gui = new Gui();
		board = new Tile[8][8];
		setBoard();

	}

	public void setBoard()
	{
		for (int rank = 8; rank >= 1; rank--)
		{
			for (char file = 'A'; file < 73; file++)
			{
				board[rank - 1][(int)file - 65] = new Tile(rank, file);
				System.out.print(file + "," + rank + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public void resetGame()
	{
		setBoard();
	}
}
