// MARIOS IAKOVIDIS AM 4063
// THEOFILOS-GEORGIOS PETSIOS AM 4158
package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import org.junit.jupiter.api.Test;

import commands.EditDocument;
import commands.EndRecording;
import commands.FakeTTS;
import commands.OpenDocument;
import commands.Replay;
import commands.StartRecording;
import model.Document;
import model.FakeTTSFacade;
import model.ReplayManager;

// Replay Test Case
class ReplayTest 
{
	private Document document;
	
	private ReplayManager replayManager;
	
	private FakeTTSFacade facade = new FakeTTSFacade();
	
	private FakeTTS fakeTTS;
	
	private OpenDocument openDocument;
	
	private EditDocument editDocument;
	
	private Replay replay;
	
	private StartRecording startRecording;
	
	private EndRecording endRecording;
	
	private ActionEvent e = null;
	
	private JFrame frame;
	
	private JTextArea textArea1 = new JTextArea();
	
	private JTextArea textArea2 = new JTextArea();
	
	private String contents = "Name Year Grades \nMary 4 7 \nBill 2 3 \nAlex 5 10 \nJennifer 3 6 \nJohn 1 2 \nAnna 8 3 \n Test Excel Document  Name Year Grades \nMary 4 7 \nBill 2 3 \nAlex 5 10 \nJennifer 3 6 \nJohn 1 2 \nAnna 8 3 \n Test Excel Document";
	
	@Test
	void test() 
	{
		ArrayList<String> editContents = new ArrayList<String>();
		editContents.add("Test Excel Document");
		document = new Document("Excel","Atbash","documents\\TestAtbash_ExcelDocument.xlsx");
		replayManager = ReplayManager.getInstance();
		
		startRecording = new StartRecording();
		startRecording.actionPerformed(e);
		
		openDocument = new OpenDocument(frame,textArea1);
		openDocument.setDocument(document);
		openDocument.actionPerformed(e);
		
		fakeTTS = new FakeTTS();
		fakeTTS.setDocument(document);
		fakeTTS.setReplayManager(replayManager);
		fakeTTS.setFacade(facade);
		fakeTTS.actionPerformed(e);
		
		editDocument = new EditDocument(frame,textArea2);
		editDocument.setDocument(document);
		editDocument.setNewContents(editContents);
		editDocument.actionPerformed(e);
		
		fakeTTS = new FakeTTS();
		fakeTTS.setDocument(document);
		fakeTTS.setReplayManager(replayManager);
		fakeTTS.setFacade(facade);
		fakeTTS.actionPerformed(e);
		
		endRecording = new EndRecording();
		endRecording.actionPerformed(e);
		
		replay = new Replay();
		replay.actionPerformed(e);
		
		String testPlayedContents = facade.getPlayedContents();
		assertEquals(contents,testPlayedContents.trim());
	}

}
