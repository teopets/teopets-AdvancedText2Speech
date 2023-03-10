// MARIOS IAKOVIDIS AM 4063
// THEOFILOS GEORGIOS AM 4158


package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import org.junit.jupiter.api.Test;
import commands.DocumentToSpeechLines;
import commands.OpenDocument;
import model.Document;
import model.FakeTTSFacade;

// Document To Speech Lines Test Case
class DocumentToSpeechLinesTest 
{
	private Document document;
	
	private DocumentToSpeechLines documentToSpeechLines;
	
	private OpenDocument openDocument;
	
	private FakeTTSFacade fakeTTS = new FakeTTSFacade();
	
	private String contents = "Mary 4 7  Bill 2 3  Alex 5 10  Jennifer 3 6  John 1 2  Anna 8 3";
	
	private String testContents;
	
	private int startLine = 1;
	
	private int endLine = 7;

	private ActionEvent e = null;
	
	private JFrame frame;
	
	private JTextArea textArea = new JTextArea();
	
	@Test
	void test() 
	{
		ArrayList<String> retArray = new ArrayList<String>();
		document = new Document("Excel","Rot13","documents\\TestRot13_ExcelDocument.xlsx");
		openDocument = new OpenDocument(frame,textArea);
		openDocument.setDocument(document);
		openDocument.actionPerformed(e);
		
		documentToSpeechLines = new DocumentToSpeechLines();
		documentToSpeechLines.setDocument(document);
		
		retArray = document.getLineContents();
		for(int i = startLine;i<endLine;i++)
		{
			fakeTTS.play(retArray.get(i));
		}
		testContents = fakeTTS.getPlayedContents();
		assertEquals(contents,testContents.trim());
	}

}

