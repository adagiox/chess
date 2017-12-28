import java.util.LinkedList;
import java.util.Queue;

public class GameManager
{
	Game currentGame;
	Queue<Move> moveQueue;

	public GameManager(Game game)
	{
		currentGame = game;
		moveQueue = new LinkedList<>();
	}

	// get the events for a turn
	//    one players move and update any ui elements accordingly
	// @TODO: create a UI manager for ui updates
	public boolean getEvents(int turn)
	{
		return true;
	}

	public boolean processEvents()
	{
		return true;
	}
}
