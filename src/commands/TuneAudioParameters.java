// MARIOS IAKOVIDIS AM 4063
// THEOFILOS GEORGIOS PETSIOS AM 4158 

package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Document;
import model.Prototype;
import model.ReplayManager;

// Command that sets different audio parameters
public class TuneAudioParameters implements ActionListener,Prototype
{
	private Document document;
	
	private ReplayManager replayManager = ReplayManager.getInstance();
	
	private float volume;
	
	private float pitch;
	
	private float rate;
	
	public void setDocument(Document document)
	{
		this.document = document;
	}

	public void setReplayManager(ReplayManager replayManager)
	{
		this.replayManager = replayManager;
	}
	
	public void setVolume(float volume) {
		this.volume = volume;
	}

	public void setPitch(float pitch) {
		this.pitch = pitch;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	// Get deep copy of the object
	public TuneAudioParameters getClone() 
	{
		Document cloneDocument = this.document.getClone();
		TuneAudioParameters cloneTuneAudioParameters = new TuneAudioParameters();
		cloneTuneAudioParameters.setVolume(this.volume);
		cloneTuneAudioParameters.setRate(this.rate);
		cloneTuneAudioParameters.setPitch(this.pitch);
		cloneTuneAudioParameters.setDocument(cloneDocument);
		return cloneTuneAudioParameters;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(this.document == null)
		{
			return;
		}
		if(this.replayManager.isActiveRecording())
		{
			TuneAudioParameters cloneTuneAudioParameters = this.getClone();
			this.replayManager.addStoredCommands(cloneTuneAudioParameters);
		}
		this.document.tuneAudioParamenters(this.volume, this.pitch, this.rate);
	}
}
