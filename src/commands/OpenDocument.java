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

// Command that opens a Document
public class OpenDocument implements ActionListener,Prototype
{
	private Document document;
	
	private ReplayManager replayManager = ReplayManager.getInstance();
	
	private JFrame frame;
	
	private JTextArea textArea;

	
	public OpenDocument(JFrame frame,JTextArea textArea)
	{
		this.frame = frame;
		this.textArea = textArea;
	}
	
	public void setDocument(Document document)
	{
		this.document = document;
	}
	
	// Get deep copy of the object
	public OpenDocument getClone() 
	{
		Document cloneDocument = this.document.getClone();
		OpenDocument cloneOpenDocument = new OpenDocument(this.frame,this.textArea);
		cloneOpenDocument.setDocument(cloneDocument);
		return cloneOpenDocument;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(this.replayManager.isActiveRecording())
		{
			OpenDocument cloneOpenDocument = this.getClone();
			this.replayManager.addStoredCommands(cloneOpenDocument);
		}
		this.document.open();
		ArrayList<String> contents = this.document.getContents();
		this.textArea.setText("");
		for(String s: contents)
		{
			this.textArea.append(s + "\r");
		}
	}
}
