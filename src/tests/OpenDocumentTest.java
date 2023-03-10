// MARIOS IAKOVIDIS AM 40633
// THEOFILOS GEORGIOS AM 4158

package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import commands.OpenDocument;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import model.Document;

// Open Document Test case
class OpenDocumentTest {
	
	private Document document;
	
	private OpenDocument openDocument;
	
	private ActionEvent e = null;
	
	private String wordContents = "Apache POI, a project run by the Apache Software Foundation, and previously a sub-project of the Jakarta Project, provides pure Java libraries for reading and writing files in Microsoft Office formats, such as Word, PowerPoint, and Excel. The name was originally an acronym for \"Poor Obfuscation Implementation\", referring humorously to the fact that the file formats seemed to be deliberately obfuscated, but poorly, since they were successfully reverse engineered. This explanation - and those of the similar names for the various sub-projects - were removed from the official web pages in order to better market the tools to businesses who would not consider such humor appropriate. The original authors (Andrew C. Oliver and Marc Johnson) also noted the existence of the Hawaiian poi dish, made of mashed taro root, which had similarly derogatory connotations.";
	
	private String excelContents = "Name Year Grades \nMary 4 7 \nBill 2 3 \nAlex 5 10 \nJennifer 3 6 \nJohn 1 2 \nAnna 8 3"; 
	
	private String testWordContents = "";
	
	private String testExcelContents = "";
	
	private JFrame frame;
	
	private JTextArea textArea = new JTextArea();
	
	@Test
	void testSimpleWordDocument()
	{
		document = new Document("Word","None","documents\\TestSimple_WordDocument.docx");
		openDocument = new OpenDocument(this.frame,this.textArea);
		openDocument.setDocument(document);
		openDocument.actionPerformed(e);
		ArrayList<String> fileContents = document.getContents();
		for(String s: fileContents)
		{
			for(int i = 0;i<s.length();i++)
			{
				testWordContents += s.charAt(i);
			}
		}
		assertEquals(wordContents.replaceAll("(.{150})","$1\n"),testWordContents.trim());
	}
	
	@Test
	void testAtbashWordDocument() 
	{
		document = new Document("Word","Atbash","documents\\TestAtbash_WordDocument.docx");
		openDocument = new OpenDocument(this.frame,this.textArea);
		openDocument.setDocument(document);
		openDocument.actionPerformed(e);
		ArrayList<String> fileContents = document.getContents();
		for(String s: fileContents)
		{
			testWordContents += s;
		}
		assertEquals(wordContents.replaceAll("(.{150})","$1\n"),testWordContents.trim());
	}
	
	@Test
	void testRot13WordDocument()
	{
		document = new Document("Word","Rot13","documents\\TestRot13_WordDocument.docx");
		openDocument = new OpenDocument(this.frame,this.textArea);
		openDocument.setDocument(document);
		openDocument.actionPerformed(e);
		ArrayList<String> fileContents = document.getContents();
		for(String s: fileContents)
		{
			testWordContents += s;
		}
		assertEquals(wordContents.replaceAll("(.{150})","$1\n"),testWordContents.trim());
	}
	
	@Test
	void testSimpleExcelDocument()
	{
		document = new Document("Excel","None","documents\\TestSimple_ExcelDocument.xlsx");
		openDocument = new OpenDocument(this.frame,this.textArea);
		openDocument.setDocument(document);
		openDocument.actionPerformed(e);
		ArrayList<String> fileContents = document.getContents();
		for(String s: fileContents)
		{
			testExcelContents += s;
		}
		assertEquals(excelContents,testExcelContents.trim());
	}
	
	@Test
	void testAtbashExcelDocument()
	{
		document = new Document("Excel","Atbash","documents\\TestAtbash_ExcelDocument.xlsx");
		openDocument = new OpenDocument(this.frame,this.textArea);
		openDocument.setDocument(document);
		openDocument.actionPerformed(e);
		ArrayList<String> fileContents = document.getContents();
		for(String s: fileContents)
		{
			testExcelContents += s;
		}
		assertEquals(excelContents,testExcelContents.trim());
	}
	
	@Test
	void testRot13ExcelDocument()
	{
		document = new Document("Excel","Rot13","documents\\TestRot13_ExcelDocument.xlsx");
		openDocument = new OpenDocument(this.frame,this.textArea);
		openDocument.setDocument(document);
		openDocument.actionPerformed(e);
		ArrayList<String> fileContents = document.getContents();
		for(String s: fileContents)
		{
			testExcelContents += s;
		}
		assertEquals(excelContents,testExcelContents.trim());
	}

}
