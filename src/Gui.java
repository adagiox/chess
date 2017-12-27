import javax.swing.*;

public class Gui
{
	JFrame frame;

	public Gui()
	{
		SwingUtilities.invokeLater(new Runnable() {
			public void run()
			{
				frame = new JFrame("Chess");
				frame.setSize(640, 480);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});

	}
}
