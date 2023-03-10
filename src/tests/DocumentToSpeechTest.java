// MARIOS IAKOVIDIS AM 4063
// THEOFILOS GEORGIOS PETSIOS AM 4158

package tests;

import static org.junit.jupiter.api.Assertions.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import org.junit.jupiter.api.Test;
import commands.DocumentToSpeech;
import commands.OpenDocument;
import model.Document;
import model.FakeTTSFacade;

// Document to Speech Test Case
class DocumentToSpeechTest {

	private Document document;
	
	private DocumentToSpeech documentToSpeech;
	
	private OpenDocument openDocument;
	
	private FakeTTSFacade fakeTTS = new FakeTTSFacade();
	
	private String contents = "Apache POI, a project run by the Apache Software Foundation, and previously a sub-project of the Jakarta Project, provides pure Java libraries for reading and writing files in Microsoft Office formats, such as Word, PowerPoint, and Excel. The name was originally an acronym for \"Poor Obfuscation Implementation\", referring humorously to the fact that the file formats seemed to be deliberately obfuscated, but poorly, since they were successfully reverse engineered. This explanation - and those of the similar names for the various sub-projects - were removed from the official web pages in order to better market the tools to businesses who would not consider such humor appropriate. The original authors (Andrew C. Oliver and Marc Johnson) also noted the existence of the Hawaiian poi dish, made of mashed taro root, which had similarly derogatory connotations.";
	
	private String testContents;

	private ActionEvent e = null;
	
	private JFrame frame;
	
	private JTextArea textArea = new JTextArea();
	
	@Test
	void test() 
	{
		ArrayList<String> retArray = new ArrayList<String>();
		document = new Document("Word","Atbash","documents\\TestAtbash_WordDocument.docx");
		openDocument = new OpenDocument(frame,textArea);
		openDocument.setDocument(document);
		openDocument.actionPerformed(e);
		
		documentToSpeech = new DocumentToSpeech();
		documentToSpeech.setDocument(document);
		
		retArray = document.getContents();
		for(String s:retArray)
		{
			fakeTTS.play(s);
		}
		testContents = fakeTTS.getPlayedContents();
		assertEquals(contents.replaceAll("(.{150})", "$1\n"),testContents.trim());
	}

}
