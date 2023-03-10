// MARIOS IAKOVIDIS AM 4063
// THEOFILOS GEORGIOS PETSIOS AM 4158

package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.Document;
import model.FakeTTSFacade;
import model.Prototype;
import model.ReplayManager;

// Command to be used for testing purposes that implements FakeTTS commands
public class FakeTTS implements ActionListener,Prototype
{
	private Document document;
	
	private ReplayManager replayManager;
	
	private FakeTTSFacade facade;
	
	public FakeTTSFacade getFacade() 
	{
		return facade;
	}
	
	public void setFacade(FakeTTSFacade facade) 
	{
		this.facade = facade;
	}

	public void setDocument(Document document)
	{
		this.document = document;
	}
	
	public void setReplayManager(ReplayManager replayManager)
	{
		this.replayManager = replayManager;
	}
	
	// Get deep copy of the object
	public FakeTTS getClone() 
	{
		Document cloneDocument = this.document.getClone();
		FakeTTS cloneFakeTTS = new FakeTTS();
		cloneFakeTTS.setDocument(cloneDocument);
		cloneFakeTTS.setReplayManager(replayManager);
		cloneFakeTTS.setFacade(facade);
		return cloneFakeTTS;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		ArrayList<String> contents = this.document.getContents();
		if(this.replayManager.isActiveRecording())
		{
			FakeTTS cloneFakeTTS = this.getClone();
			this.replayManager.addStoredCommands(cloneFakeTTS);
		}
		for(String s: contents)
		{
			this.facade.play(s);
		}
	}

	
}