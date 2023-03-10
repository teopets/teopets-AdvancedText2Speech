// MARIOS IAKOVIDIS AM 4063
// THEOFILOS GEORGIOS PETSIOS AM 4158

package commands;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import model.Document;

// Class that creates ActionListener objects 
public class CommandsFactory 
{
	private Document document;
	
	private int startLine;
	
	private int endLine;
	
	private int volume;
	
	private int pitch;
	
	private int rate;
	
	public void setVolume(int volume) 
	{
		this.volume = volume;
	}

	public void setPitch(int pitch) 
	{
		this.pitch = pitch;
	}

	public void setRate(int rate) 
	{
		this.rate = rate;
	}

	public void setDocument(Document document)
	{
		this.document = document;
	}
	
	public void setStartLine(int startLine) 
	{
		this.startLine = startLine;
	}
	
	public void setEndLine(int endLine) 
	{
		this.endLine = endLine;
	}
	
	// Create an ActionListener and return it
	public ActionListener createCommand(String command, JFrame frame, JTextArea textArea)
	{
		if(command.equals("Open Document"))
		{
			OpenDocument openDocument = new OpenDocument(frame,textArea);
			openDocument.setDocument(this.document);
			return openDocument;
		}else if(command.equals("Edit Document"))
		{
			EditDocument editDocument = new EditDocument(frame,textArea);
			editDocument.setDocument(this.document);
			return editDocument;
		}else if(command.equals("Save Document"))
		{
			SaveDocument saveDocument = new SaveDocument(frame,textArea);
			saveDocument.setDocument(this.document);
			return saveDocument;
		}else if(command.equals("Document To Speech"))
		{
			DocumentToSpeech documentToSpeech = new DocumentToSpeech();
			documentToSpeech.setDocument(document);
			return documentToSpeech;
		}else if(command.equals("Document To Speech Lines"))
		{
			DocumentToSpeechLines documentToSpeechLines = new DocumentToSpeechLines();
			documentToSpeechLines.setDocument(document);
			documentToSpeechLines.setStartLine(startLine);
			documentToSpeechLines.setEndLine(endLine);
			return documentToSpeechLines;
		}else if(command.equals("Tune Audio Parameters"))
		{
			TuneAudioParameters tuneAudioParameters = new TuneAudioParameters();
			tuneAudioParameters.setVolume(volume);
			tuneAudioParameters.setPitch(pitch);
			tuneAudioParameters.setRate(rate);
			tuneAudioParameters.setDocument(document);
			return tuneAudioParameters;
		}else if(command.equals("Start Recording"))
		{
			StartRecording startRecording = new StartRecording();
			return startRecording;
		}else if(command.equals("Replay"))
		{
			Replay replay = new Replay();
			return replay;
		}else if(command.equals("End Recording"))
		{
			EndRecording endRecording = new EndRecording();
			return endRecording;
		}else{
			return null;
		}
	}
}
