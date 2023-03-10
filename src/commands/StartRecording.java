// MARIOS IAKOVIDIS AM 4063
// THEOFILOS GEORGIOS AM 4158

package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.ReplayManager;

// Command that starts a recording session
public class StartRecording implements ActionListener
{
	private ReplayManager replayManager = ReplayManager.getInstance();

	public void actionPerformed(ActionEvent e) 
	{
		this.replayManager.startRecording();
	}
}
