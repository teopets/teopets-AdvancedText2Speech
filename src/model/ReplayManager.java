// MARIOS IAKOVIDIS AM 4063
// THEOFILOS GEORGIOS PETSIOS AM 4158

package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// Implementation of Replay Manager
public class ReplayManager 
{
	private ArrayList<ActionListener> storedCommands = new ArrayList<ActionListener>();
	
	private static ReplayManager instance = null;
	
	private boolean recordingStatus = false;
	
	private ActionEvent e = null;
	
	private ReplayManager() {}
	
	public static ReplayManager getInstance()
	{
		if(instance == null)
		{
			instance = new ReplayManager();
		}
		return instance;
	}
	
	// Check if a recording session is enabled
	public boolean isActiveRecording()
	{
		return this.recordingStatus;
	}
	
	// Begin a recording session
	public void startRecording()
	{
		this.storedCommands.clear();
		this.recordingStatus = true;
	}
	
	// End a recording session
	public void endRecording()
	{
		this.recordingStatus = false;
	}
	
	// Replay saved commands
	public void replay()
	{
		if(this.recordingStatus == false)
		{
			for(ActionListener command: storedCommands)
			{
				command.actionPerformed(e);
			}
		}else{
			System.out.println("Cannot replay if recording is active.");
		}
	}
	
	// Store commands to be replayed
	public void addStoredCommands(ActionListener command)
	{
		this.storedCommands.add(command);
	}
}
