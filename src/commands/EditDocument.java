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

// Command that edits the contents of the Document
public class EditDocument implements ActionListener,Prototype
{
	private Document document;
	
	private ReplayManager replayManager = ReplayManager.getInstance();
	
	private ArrayList<String> newContents = new ArrayList<String>();
	
	private JFrame frame;
	
	private JTextArea textArea;
	
	public EditDocument(JFrame frame, JTextArea textArea) 
	{
		this.frame = frame;
		this.textArea = textArea;
	}

	public void setDocument(Document document)
	{
		this.document = document;
	}
	
	public void setNewContents(ArrayList<String> newContents)
	{
		this.newContents = newContents;
	}
	
	// Get a deep copy of the object
	public EditDocument getClone() 
	{
		Document cloneDocument = this.document.getClone();
		EditDocument cloneEditDocument = new EditDocument(this.frame,this.textArea);
		cloneEditDocument.setDocument(cloneDocument);
		return cloneEditDocument;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(this.document == null)
		{
			return;
		}
		if(this.replayManager.isActiveRecording())
		{
			EditDocument cloneEditDocument = this.getClone();
			this.replayManager.addStoredCommands(cloneEditDocument);
		}
		String text = this.textArea.getText();
		String[] paragraphSheet = text.split("\r");
		for(int i = 0;i < paragraphSheet.length;i++)
		{
			this.newContents.add(paragraphSheet[i]);
		}
		this.document.edit(newContents);
	}
}
