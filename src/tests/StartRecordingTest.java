// MARIOS IAKOVIDIS AM 4063
// THEOFILOS GEORGIOS PETSIOS AM 4158
package tests;

import static org.junit.jupiter.api.Assertions.*;
import java.awt.event.ActionEvent;
import org.junit.jupiter.api.Test;
import commands.StartRecording;
import model.ReplayManager;

// Start Recording Test Case
class StartRecordingTest 
{
	private ReplayManager replayManager;
	
	private StartRecording startRecording;

	private ActionEvent e = null;
	
	@Test
	void test() 
	{
		replayManager = ReplayManager.getInstance();
		startRecording = new StartRecording();
		startRecording.actionPerformed(e);
		
		boolean testRecordingStatus = this.replayManager.isActiveRecording();
		assertTrue(testRecordingStatus);
	}

}
