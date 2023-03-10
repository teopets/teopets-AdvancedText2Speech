// MARIOS IAKOVIDIS AM 4063
// THEOFILOS GEORGIOS PETSIOS AM 4158

package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Document;
import model.Prototype;
import model.ReplayManager;


// Command that transforms text to audio
public class DocumentToSpeech implements ActionListener,Prototype
{
	private Document document;
	
	private ReplayManager replayManager = ReplayManager.getInstance();

	public void setDocument(Document document)
	{
		this.document = document;
	}
	
	public void setReplayManager(ReplayManager replayManager)
	{
		this.replayManager = replayManager;
	}
	
	// Get a deep copy of the object
	public DocumentToSpeech getClone() 
	{
		Document cloneDocument = this.document.getClone();
		DocumentToSpeech cloneDocumentToSpeech = new DocumentToSpeech();
		cloneDocumentToSpeech.setDocument(cloneDocument);
		return cloneDocumentToSpeech;
	}

	public void actionPerformed(ActionEvent e) 
	{
		if(this.document == null)
		{
			return;
		}
		if(this.replayManager.isActiveRecording())
		{
			DocumentToSpeech cloneDocumentToSpeech = this.getClone();
			this.replayManager.addStoredCommands(cloneDocumentToSpeech);
		}
		this.document.play();
	}
}
