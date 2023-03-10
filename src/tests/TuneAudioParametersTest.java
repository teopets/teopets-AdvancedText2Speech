// MARIOS IAKOVIDIS AM 4063
// THEOFILOS GEORGIOS AM 4158

package tests;

import static org.junit.jupiter.api.Assertions.*;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import org.junit.jupiter.api.Test;
import commands.OpenDocument;
import commands.TuneAudioParameters;
import model.Document;
import model.FakeTTSFacade;

// Tune Audio Parameters Test Case
class TuneAudioParametersTest 
{
	private Document document;
	
	private OpenDocument openDocument;
	
	private TuneAudioParameters tuneAudioParameters;
	
	private float volume = 5;
			
	private float pitch = 100;
	
	private float rate = 150;
	
	private float testVolume;
	
	private float testPitch;

	private float testRate;
	
	private ActionEvent e = null;
	
	private FakeTTSFacade fakeTTS = new FakeTTSFacade();
	
	private JFrame frame;
	
	private JTextArea textArea = new JTextArea();
	
	@Test
	void test() 
	{ 
		// Open Document
		document = new Document("Word","Rot13","documents\\TestRot13_WordDocument.docx");
		openDocument = new OpenDocument(frame,textArea);
		openDocument.setDocument(document);
		openDocument.actionPerformed(e);
		
		// Tune Audio Parameters
		tuneAudioParameters = new TuneAudioParameters();
		tuneAudioParameters.setDocument(document);
		tuneAudioParameters.setVolume(volume);
		tuneAudioParameters.setPitch(pitch);
		tuneAudioParameters.setRate(rate);
		
		// Edit Tune Audio Parameters in FakeTTS
		fakeTTS.tuneAudioParameters(this.volume,this.pitch,this.rate);
		testVolume = fakeTTS.getPlayedVolume();
		testPitch = fakeTTS.getPlayedPitch();
		testRate = fakeTTS.getPlayedRate();
		
		assertEquals(volume,testVolume);
		assertEquals(pitch,testPitch);
		assertEquals(rate,testRate);
	}

}
