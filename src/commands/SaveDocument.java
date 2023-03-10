// MARIOS IAKOVIDIS AM 4063
// THEOFILOS GEORGIOS PETSIOS AM 4158

package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import model.Document;
import model.Prototype;
import model.ReplayManager;

// Command that saves the contents of GUI to a Document
public class SaveDocument implements ActionListener,Prototype
{
	private Document document;
	
	private ReplayManager replayManager = ReplayManager.getInstance();
	
	private JFrame frame;
	
	private JTextArea textArea;
	
	public SaveDocument(JFrame frame, JTextArea textArea) 
	{
		this.frame = frame;
		this.textArea = textArea;
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
	public SaveDocument getClone() 
	{
		Document cloneDocument = this.document.getClone();
		SaveDocument cloneSaveDocument = new SaveDocument(this.frame,this.textArea);
		cloneSaveDocument.setDocument(cloneDocument);
		return cloneSaveDocument;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		ArrayList<String> contents = new ArrayList<String>();
		String text = textArea.getText();
		String[] paragraphSheet = text.split("\r");
		for(int i = 0;i < paragraphSheet.length;i++)
		{
			contents.add(paragraphSheet[i]);
		}
		if(this.document == null)
		{
			return;
		}
		if(this.replayManager.isActiveRecording())
		{
			SaveDocument cloneSaveDocument = this.getClone();
			this.replayManager.addStoredCommands(cloneSaveDocument);
		}
		this.document.setContents(contents);
		this.document.save();
	}
}
