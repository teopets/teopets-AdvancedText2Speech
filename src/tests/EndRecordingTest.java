// MARIOS IAKOVIDIS AM 4063
// THEOFILOS GEORGIOS PETSIOS AM 4158

package tests;

import static org.junit.jupiter.api.Assertions.*;
import java.awt.event.ActionEvent;
import org.junit.jupiter.api.Test;
import commands.EndRecording;
import commands.StartRecording;
import model.ReplayManager;

// End Recording Test Case
class EndRecordingTest 
{
	private ReplayManager replayManager;
	
	private StartRecording startRecording;
	
	private EndRecording endRecording;

	private ActionEvent e = null;

	
	@Test
	void test() 
	{
		replayManager = ReplayManager.getInstance();
		
		startRecording = new StartRecording();
		startRecording.actionPerformed(e);
		
		endRecording = new EndRecording();
		endRecording.actionPerformed(e);
		
		boolean testRecordingStatus = this.replayManager.isActiveRecording();
		assertFalse(testRecordingStatus);
	}
}
