// MARIOS IAKOVIDIS AM 4063
// THEOFILOS GEORGIOS PETSIOS AM 4158 

package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.ReplayManager;

// Command that replays the recorded commands
public class Replay implements ActionListener
{
	private ReplayManager replayManager = ReplayManager.getInstance();

	public void actionPerformed(ActionEvent e) 
	{
		this.replayManager.replay();
	}
}
