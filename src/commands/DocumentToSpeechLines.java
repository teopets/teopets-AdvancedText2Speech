// MARIOS IAKOVIDIS AM 4063
// THEOFILOS GEORGIOS PETSIOS AM 4158

package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.Document;
import model.Prototype;
import model.ReplayManager;

// Class that transforms certain parts of the text to audio
public class DocumentToSpeechLines implements ActionListener,Prototype
{
	private Document document;
	
	private ReplayManager replayManager = ReplayManager.getInstance();
	
	private int startLine;
	
	private int endLine;
	
	public void setDocument(Document document)
	{
		this.document = document;
	}
	
	public void setReplayManager(ReplayManager replayManager)
	{
		this.replayManager = replayManager;
	}

	public void setStartLine(int startLine) 
	{
		this.startLine = startLine;
	}

	public void setEndLine(int endLine) 
	{
		this.endLine = endLine;
	}
	
	// Get a deep copy of the object
	public DocumentToSpeechLines getClone() 
	{
		Document cloneDocument = this.document.getClone();
		DocumentToSpeechLines cloneDocumentToSpeechLines = new DocumentToSpeechLines();
		cloneDocumentToSpeechLines.setDocument(cloneDocument);
		cloneDocumentToSpeechLines.setStartLine(this.startLine);
		cloneDocumentToSpeechLines.setEndLine(this.endLine);
		cloneDocumentToSpeechLines.setReplayManager(this.replayManager);
		return cloneDocumentToSpeechLines; 
	}

	public void actionPerformed(ActionEvent e) 
	{
		ArrayList<String> lineContents = this.document.getLineContents();
		if(this.document == null)
		{
			return;
		}
		if(this.replayManager.isActiveRecording())
		{
			DocumentToSpeechLines cloneDocumentToSpeechLines = this.getClone();
			this.replayManager.addStoredCommands(cloneDocumentToSpeechLines);
		}
		if(startLine > lineContents.size() || endLine > lineContents.size())
		{
			return ;
		}
		this.document.playLines(startLine - 1, endLine - 1);
	}
}
