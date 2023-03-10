// MARIOS IAKOVIDIS AM 4063
// THEOFILOS GEORGIOS PETSIOS AM 4158

package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import org.junit.jupiter.api.Test;

import commands.EditDocument;
import commands.OpenDocument;
import model.Document;

// Edit Document Test Case
class EditDocumentTest 
{
	private Document document;
	
	private OpenDocument openDocument;
	
	private EditDocument editDocument;
	
	private ActionEvent e = null;
	
	private String newWordContents = "This is document's edited edition";
	
	private String newExcelContents = "Name Year Grades \nMary 4 7";
	
	private String testNewWordContents = "";
	
	private String testNewExcelContents = "";
	
	private JFrame frame;
	
	private JTextArea textArea1 = new JTextArea();
	
	private JTextArea textArea2 = new JTextArea();
	
	@Test
	void testSimpleWordDocument() 
	{
		ArrayList<String> newContents = new ArrayList<String>();
		newContents.add(newWordContents);
		document = new Document("Word","None","documents\\TestSimple_WordDocument.docx");
		
		// Open a document
		openDocument = new OpenDocument(frame,textArea1);
		openDocument.setDocument(document);
		openDocument.actionPerformed(e);
		
		// Edit a document
		editDocument = new EditDocument(frame,textArea2);
		editDocument.setDocument(document);
		editDocument.setNewContents(newContents);
		editDocument.actionPerformed(e);
		
		ArrayList<String> fileContents = document.getContents();
		for(String s:fileContents)
		{
			for(int i = 0;i<s.length();i++)
			{
				testNewWordContents += s.charAt(i);
			}
			
		}
		assertEquals(newWordContents,testNewWordContents.trim());
	}
	
	@Test
	void testAtbashWordDocument() 
	{
		ArrayList<String> newContents = new ArrayList<String>();
		newContents.add(newWordContents);
		document = new Document("Word","Atbash","documents\\TestAtbash_WordDocument.docx");
		openDocument = new OpenDocument(frame,textArea1);
		openDocument.setDocument(document);
		openDocument.actionPerformed(e);
		
		editDocument = new EditDocument(frame,textArea2);
		editDocument.setDocument(document);
		editDocument.setNewContents(newContents);
		editDocument.actionPerformed(e);
		
		ArrayList<String> fileContents = document.getContents();
		for(String s:fileContents)
		{
			for(int i = 0;i<s.length();i++)
			{
				testNewWordContents += s.charAt(i);
			}
			
		}
		assertEquals(newWordContents,testNewWordContents.trim());
	}
	
	@Test
	void testRot13WordDocument() 
	{
		ArrayList<String> newContents = new ArrayList<String>();
		newContents.add(newWordContents);
		document = new Document("Word","Rot13","documents\\TestRot13_WordDocument.docx");
		openDocument = new OpenDocument(frame,textArea1);
		openDocument.setDocument(document);
		openDocument.actionPerformed(e);
		
		editDocument = new EditDocument(frame,textArea2);
		editDocument.setDocument(document);
		editDocument.setNewContents(newContents);
		editDocument.actionPerformed(e);
		
		ArrayList<String> fileContents = document.getContents();
		for(String s:fileContents)
		{
			for(int i = 0;i<s.length();i++)
			{
				testNewWordContents += s.charAt(i);
			}
			
		}
		assertEquals(newWordContents,testNewWordContents.trim());
	}
	
	@Test
	void testSimpleExcelDocument() 
	{
		ArrayList<String> newContents = new ArrayList<String>();
		newContents.add(newExcelContents);
		document = new Document("Excel","None","documents\\TestSimple_ExcelDocument.xlsx");
		openDocument = new OpenDocument(frame,textArea1);
		openDocument.setDocument(document);
		openDocument.actionPerformed(e);
		
		editDocument = new EditDocument(frame,textArea2);
		editDocument.setDocument(document);
		editDocument.setNewContents(newContents);
		editDocument.actionPerformed(e);
		
		ArrayList<String> fileContents = document.getContents();
		for(String s:fileContents)
		{
			for(int i = 0;i<s.length();i++)
			{
				testNewExcelContents += s.charAt(i);
			}
			
		}
		assertEquals(newExcelContents,testNewExcelContents.trim());
	}
	
	@Test
	void testAtbashExcelDocument() 
	{
		ArrayList<String> newContents = new ArrayList<String>();
		newContents.add(newExcelContents);
		document = new Document("Excel","Atbash","documents\\TestAtbash_ExcelDocument.xlsx");
		openDocument = new OpenDocument(frame,textArea1);
		openDocument.setDocument(document);
		openDocument.actionPerformed(e);
		
		editDocument = new EditDocument(frame,textArea2);
		editDocument.setDocument(document);
		editDocument.setNewContents(newContents);
		editDocument.actionPerformed(e);
		
		ArrayList<String> fileContents = document.getContents();
		for(String s:fileContents)
		{
			for(int i = 0;i<s.length();i++)
			{
				testNewExcelContents += s.charAt(i);
			}
			
		}
		assertEquals(newExcelContents,testNewExcelContents.trim());
	}
	
	@Test
	void testRot13ExcelDocument() 
	{
		ArrayList<String> newContents = new ArrayList<String>();
		newContents.add(newExcelContents);
		document = new Document("Excel","Rot13","documents\\TestRot13_ExcelDocument.xlsx");
		openDocument = new OpenDocument(frame,textArea1);
		openDocument.setDocument(document);
		openDocument.actionPerformed(e);
		
		editDocument = new EditDocument(frame,textArea2);
		editDocument.setDocument(document);
		editDocument.setNewContents(newContents);
		editDocument.actionPerformed(e);
		
		ArrayList<String> fileContents = document.getContents();
		for(String s:fileContents)
		{
			for(int i = 0;i<s.length();i++)
			{
				testNewExcelContents += s.charAt(i);
			}
			
		}
		assertEquals(newExcelContents,testNewExcelContents.trim());
	}
}
