// MARIOS IAKOVIDIS AM 4063
// THEOFILOS GEORGIOS PETSIOS AM 4158

package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import org.junit.jupiter.api.Test;

import commands.EditDocument;
import commands.OpenDocument;
import commands.SaveDocument;
import model.Document;

// Save Document Test Case
public class SaveDocumentTest {

	private JFrame frame;
	
	private JTextArea textArea1 = new JTextArea();
	
	private JTextArea textArea2 = new JTextArea();
	
	private JTextArea textArea3 = new JTextArea();
	
	private Document document;
	
	private OpenDocument openDocument = new OpenDocument(frame,textArea1);
	
	private EditDocument editDocument;
	
	private SaveDocument saveDocument;
	
	private ActionEvent e = null;
	
	private ArrayList<String> wordContents = new ArrayList<String>();
	
	private ArrayList<String> excelContents = new ArrayList<String>();
	
	private ArrayList<String> testWordContents;
	
	private ArrayList<String> testWordContentsAtbash;
	
	private ArrayList<String> testWordContentsRot13;
	
	private ArrayList<String> testExcelContents;
	
	private ArrayList<String> testExcelContentsAtbash;
	
	private ArrayList<String> testExcelContentsRot13;
	
	private String wordContentsParagraph1 = "This is the first paragraph";
	
	private String wordContentsParagraph2 = "This is the second paragraph";
	
	private String excelContentsSheet1 = "Name Year Grades \nMary 4 7";
	
	private String excelContentsSheet2 = "Name Year Grades \nJohn 3 5";
	
	@Test
	void testSimpleWordDocument()
	{
		wordContents.add(wordContentsParagraph1);
		wordContents.add(wordContentsParagraph2);
		
		document = new Document("Word","None","documents\\TestSimple_WordDocumentSave.docx");
		editDocument = new EditDocument(frame,textArea2);
		editDocument.setDocument(document);
		editDocument.setNewContents(wordContents);
		editDocument.actionPerformed(e);
		
		textArea3.setText("This is the first paragraph\rThis is the second paragraph");
		saveDocument = new SaveDocument(frame,textArea3);
		saveDocument.setDocument(document);
		saveDocument.actionPerformed(e);
		
		openDocument = new OpenDocument(frame,textArea1);
		openDocument.setDocument(document);
		openDocument.actionPerformed(e);
		
		testWordContents = document.getContents();
		for(int i=0; i<testWordContents.size();i++)
		{
			assertEquals(wordContents.get(i),testWordContents.get(i).trim());
		}
	}
	
	@Test
	void testAtbashWordDocument()
	{
		wordContents.add(wordContentsParagraph1);
		wordContents.add(wordContentsParagraph2);
		
		document = new Document("Word","Atbash","documents\\TestAtbash_WordDocumentSave.docx");
		editDocument = new EditDocument(frame,textArea2);
		editDocument.setDocument(document);
		editDocument.setNewContents(wordContents);
		editDocument.actionPerformed(e);
		
		textArea3.setText("This is the first paragraph\rThis is the second paragraph");
		saveDocument = new SaveDocument(frame,textArea3);
		saveDocument.setDocument(document);
		saveDocument.actionPerformed(e);
		
		openDocument = new OpenDocument(frame,textArea1);
		openDocument.setDocument(document);
		openDocument.actionPerformed(e);
		
		testWordContentsAtbash = document.getContents();
		for(int i=0; i<testWordContentsAtbash.size();i++)
		{
			assertEquals(wordContents.get(i),testWordContentsAtbash.get(i).trim());
		}
	}
	
	@Test
	void testRot13WordDocument()
	{
		wordContents.add(wordContentsParagraph1);
		wordContents.add(wordContentsParagraph2);
		
		document = new Document("Word","Rot13","documents\\TestRot13_WordDocumentSave.docx");
		editDocument = new EditDocument(frame,textArea2);
		editDocument.setDocument(document);
		editDocument.setNewContents(wordContents);
		editDocument.actionPerformed(e);
		
		textArea3.setText("This is the first paragraph\rThis is the second paragraph");
		saveDocument = new SaveDocument(frame,textArea3);
		saveDocument.setDocument(document);
		saveDocument.actionPerformed(e);
		
		openDocument = new OpenDocument(frame,textArea1);
		openDocument.setDocument(document);
		openDocument.actionPerformed(e);
		
		testWordContentsRot13 = document.getContents();
		for(int i=0; i<testWordContentsRot13.size();i++)
		{
			assertEquals(wordContents.get(i),testWordContentsRot13.get(i).trim());
		}
	}
	
	@Test
	void testSimpleExcelDocument()
	{
		excelContents.add(excelContentsSheet1);
		excelContents.add(excelContentsSheet2);
		
		document = new Document("Excel","None","documents\\TestSimple_ExcelDocumentSave.xlsx");
		editDocument = new EditDocument(frame,textArea2);
		editDocument.setDocument(document);
		editDocument.setNewContents(excelContents);
		editDocument.actionPerformed(e);
		
		textArea3.setText("Name Year Grades \nMary 4 7\n\rName Year Grades \nJohn 3 5");
		saveDocument = new SaveDocument(frame,textArea3);
		saveDocument.setDocument(document);
		saveDocument.actionPerformed(e);
		
		openDocument = new OpenDocument(frame,textArea1);
		openDocument.setDocument(document);
		openDocument.actionPerformed(e);
		
		testExcelContents = document.getContents();
		for(int i=0; i<testExcelContents.size();i++)
		{
			assertEquals(excelContents.get(i).trim(),testExcelContents.get(i).trim());
		}
	}
	
	@Test
	void testAtbashExcelDocument()
	{
		excelContents.add(excelContentsSheet1);
		excelContents.add(excelContentsSheet2);
		
		document = new Document("Excel","Atbash","documents\\TestAtbash_ExcelDocumentSave.xlsx");
		editDocument = new EditDocument(frame,textArea2);
		editDocument.setDocument(document);
		editDocument.setNewContents(excelContents);
		editDocument.actionPerformed(e);
		
		textArea3.setText("Name Year Grades \nMary 4 7\n\rName Year Grades \nJohn 3 5");
		saveDocument = new SaveDocument(frame,textArea3);
		saveDocument.setDocument(document);
		saveDocument.actionPerformed(e);
		
		openDocument = new OpenDocument(frame,textArea1);
		openDocument.setDocument(document);
		openDocument.actionPerformed(e);
		
		testExcelContentsAtbash = document.getContents();
		for(int i=0; i<testExcelContentsAtbash.size();i++)
		{
			assertEquals(excelContents.get(i).trim(),testExcelContentsAtbash.get(i).trim());
		}
	}
	
	@Test
	void testRot13ExcelDocument()
	{
		excelContents.add(excelContentsSheet1);
		excelContents.add(excelContentsSheet2);
		
		document = new Document("Excel","Rot13","documents\\TestRot13_ExcelDocumentSave.xlsx");
		editDocument = new EditDocument(frame,textArea2);
		editDocument.setDocument(document);
		editDocument.setNewContents(excelContents);
		editDocument.actionPerformed(e);
		
		textArea3.setText("Name Year Grades \nMary 4 7\n\rName Year Grades \nJohn 3 5");
		saveDocument = new SaveDocument(frame,textArea3);
		saveDocument.setDocument(document);
		saveDocument.actionPerformed(e);
		
		openDocument = new OpenDocument(frame,textArea1);
		openDocument.setDocument(document);
		openDocument.actionPerformed(e);
		
		testExcelContentsRot13 = document.getContents();
		for(int i=0; i<testExcelContentsRot13.size();i++)
		{
			assertEquals(excelContents.get(i).trim(),testExcelContentsRot13.get(i).trim());
		}
	}
}
