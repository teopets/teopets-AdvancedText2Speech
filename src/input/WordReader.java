// MARIOS IAKOVIDIS AM 4063
// THEOFILOS GEORGIOS PETSIOS AM 4158

package input;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

// class for reading .docx files
public class WordReader implements DocumentReader
{
	private String fileName;
	
	// constructor
	public WordReader(String fileName)
	{
		this.fileName = fileName;
	}
	
	// read contents of .docx file
	public ArrayList<String> read()
	{
		ArrayList<String> retArray = new ArrayList<String>();
		String fileData;
		try
		{
			// initialize streams
			File file = new File(fileName);
			FileInputStream fis = new FileInputStream(file.getAbsolutePath());
			XWPFDocument document = new XWPFDocument(fis);
			// get the document's paragraphs
			List<XWPFParagraph> paragraphs = document.getParagraphs();
			// get paragraph's contents and add them to the ArrayList 
			for(int i = 0;i<paragraphs.size();i++)
			{
				fileData = paragraphs.get(i).getParagraphText();
				retArray.add(fileData);
			}
			// close streams
			document.close();
			fis.close();
		}catch(Exception exception)
		{
			exception.printStackTrace();
			return null;
		}
		
		return retArray;
	}	
}
