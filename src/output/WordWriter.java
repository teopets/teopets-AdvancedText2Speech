// MARIOS IAKOVIDIS AM 4063
// THEOFILOS GEORGIOS PETSIOS AM 4158

package output;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

// Write a Word document
public class WordWriter implements DocumentWriter 
{
	private String fileName;
	
	// constructor
	public WordWriter(String fileName)
	{
		this.fileName = fileName;
	}
	
	// write document contents in .docx file
	public void write(ArrayList<String> contents) 
	{
		try
		{
			File file = new File(fileName);
			FileOutputStream fos = new FileOutputStream(file.getAbsolutePath()); 
			XWPFDocument document = new XWPFDocument();
			for(String s:contents)
			{
				XWPFParagraph paragraph = document.createParagraph();
				XWPFRun run = paragraph.createRun();
				run.setText(s);
			}
			document.write(fos);
			document.close();
			fos.close();
		}catch(Exception exception)
		{
			exception.printStackTrace();
		}
	}
}
