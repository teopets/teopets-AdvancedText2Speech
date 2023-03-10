// MARIOS IAKOVIDIS AM 4063
// THEOFILOS GEORGIOS PETSIOS AM 4158
package model;

import java.util.ArrayList;
import input.DocumentReader;
import input.DocumentReaderFactory;
import output.DocumentWriter;
import output.DocumentWriterFactory;

// Class that represents a Document
public class Document implements Prototype
{
	private ArrayList<String> contents = new ArrayList<String>();
	
	private ArrayList<String> lineContents = new ArrayList<String>();
	
	private TTSFacade audioManager = new TTSFacade();
	
	private String format;
	
	private String encoding;
	
	private String fileName;
	
	public Document(String format,String encoding,String fileName)
	{
		this.format = format;
		this.encoding = encoding;
		this.fileName = fileName;
	}
	
	public ArrayList<String> getContents()
	{
		ArrayList<String> retArray = this.contents;
		return retArray;
	}
	
	public ArrayList<String> getLineContents()
	{
		ArrayList<String> retArray = this.lineContents;
		return retArray;
	}
	
	public TTSFacade getAudioManager() {
		return audioManager;
	}

	public void setAudioManager(TTSFacade audioManager) {
		this.audioManager = audioManager;
	}

	public void setContents(ArrayList<String> contents) 
	{
		this.contents = contents;
	}

	public void setLineContents(ArrayList<String> lineContents) 
	{
		this.lineContents = lineContents;
	}
	
	// Get deep copy of the object
	public Document getClone() 
	{
		ArrayList<String> cloneContents = this.contents;
		ArrayList<String> cloneLineContents = this.lineContents;
		TTSFacade cloneAudioManager = this.audioManager;
		Document cloneDocument = new Document(this.format,this.encoding,this.fileName);
		cloneDocument.setContents(cloneContents);
		cloneDocument.setLineContents(cloneLineContents);
		cloneDocument.setAudioManager(cloneAudioManager);
		return cloneDocument;
	}
	
	// Private method to split edited contents to lines
	private ArrayList<String> convertToLines()
	{
		ArrayList<String> retArray = new ArrayList<String>();
		if(this.format.equals("Word"))
		{
			for(String paragraph: this.contents)
			{
				String[] lines = paragraph.split("\n");
				for(String s:lines)
				{	
					retArray.add(s);
				}
			}
		}else if(this.format.equals("Excel"))
		{
			for(String sheet: this.contents)
			{
				String[] lines = sheet.split(" \n");
				for(String s:lines)
				{
					retArray.add(s);
				}
			}
		}
		return retArray;
	}
	
	// Open document and extract its contents
	public void open()
	{
		this.contents.clear();
		this.lineContents.clear();
		ArrayList<String> readContents = new ArrayList<String>();
		DocumentReaderFactory documentReaderFactory = new DocumentReaderFactory();
		DocumentReader documentReader = documentReaderFactory.createReader(this.format, this.encoding, this.fileName);
		readContents = documentReader.read();
		if(this.format.equals("Word"))
		{
			for(String s: readContents)
			{	
				
				String str = s.replaceAll("(.{150})", "$1\n");
				this.contents.add(str + '\n');
				String[] lines = str.split("\n");
				for(int i = 0;i< lines.length;i++)
				{
					this.lineContents.add(lines[i]);
				}
			}
		}else if(this.format.equals("Excel"))
		{
			for(String s: readContents)
			{
				this.contents.add(s);
				String[] lines = s.split("\n");
				for(int i = 0;i< lines.length;i++)
				{
					this.lineContents.add(lines[i]);
				}
			}
		}
	}
	
	// Edit document's contents
	public void edit(ArrayList<String> newContents)
	{
		this.contents = newContents;
		this.lineContents = this.convertToLines();
	}
	
	// Save document's contents
	public void save()
	{
		DocumentWriterFactory documentWriterFactory = new DocumentWriterFactory();
		DocumentWriter documentWriter = documentWriterFactory.createWriter(this.format, this.encoding, this.fileName);
		documentWriter.write(this.contents);
	}
	
	// Convert contents to audio
	public void play()
	{
		for(String s: this.contents)
		{
			this.audioManager.play(s);
		}
	}
	
	// Convert certain contents to audio
	public void playLines(int startLine,int endLine)
	{
		for(int i = startLine;i<endLine;i++)
		{
			this.audioManager.play(this.lineContents.get(i));
		}
	}
	
	// Set audio Parameters
	public void tuneAudioParamenters(float volume,float pitch, float rate)
	{
		this.audioManager.tuneAudioParameters(volume, pitch, rate);
	}
}
