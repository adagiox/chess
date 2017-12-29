import java.util.Collection;
import java.util.List;

public class Editor
{
	Game game;

	public Editor(Game game)
	{
		this.game = game;
	}

	public String getEditState()
	{
		return game.getBoardState();
	}
}
