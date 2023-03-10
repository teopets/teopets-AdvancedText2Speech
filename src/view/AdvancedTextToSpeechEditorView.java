// MARIOS IAKOVIDIS AM 4063
// THEOFILOS GEORGIOS PETSIOS AM 4158

package view;


import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

import commands.CommandsFactory;
import model.Document;

// Graphic User Interface
public class AdvancedTextToSpeechEditorView extends JFrame implements ActionListener
{
	
	private static final long serialVersionUID = -1451371297023174241L;

	private JTextArea textArea;
	
	private JFrame frame;
	
	private CommandsFactory commandsFactory = new CommandsFactory();
	
	// Create window
	public AdvancedTextToSpeechEditorView()
	{
		frame = new JFrame("Advanced Text To Speech App");
		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			MetalLookAndFeel.setCurrentTheme(new OceanTheme());
		}catch(Exception e)
		{
			e.printStackTrace();
			System.exit(1);
		}
		
		textArea = new JTextArea();
		Font font = new Font("SansSerif",Font.PLAIN,14);
		textArea.setFont(font);
		JScrollPane pane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		
		// Set menus
		JMenuBar menubar = new JMenuBar();
		JMenu menu1 = new JMenu("Documents");
		JMenu menu2 = new JMenu("Text to Speech");
		JMenu menu3 = new JMenu("Recording");
		JMenu menu4 = new JMenu("About");
		
		JMenu menu11 = new JMenu("Open Document");
		menu11.setIcon(new ImageIcon("icons\\openicon.png"));
		
		JMenuItem item12 = new JMenuItem("Edit Document");
		item12.setIcon(new ImageIcon("icons\\editicon.png"));
		
		JMenu menu13 = new JMenu("Save Document As");
		menu13.setIcon(new ImageIcon("icons\\saveicon.png"));
		
		JMenuItem item111 = new JMenuItem("Open Simple Word Document");
		JMenuItem item112 = new JMenuItem("Open Atbash Word Document");
		JMenuItem item113 = new JMenuItem("Open Rot13 Word Document");
		JMenuItem item114 = new JMenuItem("Open Simple Excel Document");
		JMenuItem item115 = new JMenuItem("Open Atbash Excel Document");
		JMenuItem item116 = new JMenuItem("Open Rot13 Excel Document");
		
		item111.setIcon(new ImageIcon("icons\\wordicon.png"));
		item112.setIcon(new ImageIcon("icons\\wordicon.png"));
		item113.setIcon(new ImageIcon("icons\\wordicon.png"));
		item114.setIcon(new ImageIcon("icons\\excelicon.png"));
		item115.setIcon(new ImageIcon("icons\\excelicon.png"));
		item116.setIcon(new ImageIcon("icons\\excelicon.png"));
		
		JMenuItem item131 = new JMenuItem("Save Simple Word Document");
		JMenuItem item132 = new JMenuItem("Save Atbash Word Document");
		JMenuItem item133 = new JMenuItem("Save Rot13 Word Document");
		JMenuItem item134 = new JMenuItem("Save Simple Excel Document");
		JMenuItem item135 = new JMenuItem("Save Atbash Excel Document");
		JMenuItem item136 = new JMenuItem("Save Rot13 Excel Document");
		
		item131.setIcon(new ImageIcon("icons\\wordicon.png"));
		item132.setIcon(new ImageIcon("icons\\wordicon.png"));
		item133.setIcon(new ImageIcon("icons\\wordicon.png"));
		item134.setIcon(new ImageIcon("icons\\excelicon.png"));
		item135.setIcon(new ImageIcon("icons\\excelicon.png"));
		item136.setIcon(new ImageIcon("icons\\excelicon.png"));
		
		// Bind buttons to ActionListener
		item111.addActionListener(this);
		item112.addActionListener(this);
		item113.addActionListener(this);
		item114.addActionListener(this);
		item115.addActionListener(this);
		item116.addActionListener(this);
		item12.addActionListener(this);
		item131.addActionListener(this);
		item132.addActionListener(this);
		item133.addActionListener(this);
		item134.addActionListener(this);
		item135.addActionListener(this);
		item136.addActionListener(this);
		
		// Add button to menus
		menu11.add(item111);
		menu11.add(item112);
		menu11.add(item113);
		menu11.add(item114);
		menu11.add(item115);
		menu11.add(item116);
		menu13.add(item131);
		menu13.add(item132);
		menu13.add(item133);
		menu13.add(item134);
		menu13.add(item135);
		menu13.add(item136);
		menu1.add(menu11);
		menu1.add(item12);
		menu1.add(menu13);
		
		JMenuItem item21 = new JMenuItem("Document To Speech");
		JMenuItem item22 = new JMenuItem("Part Of Document To Speech");
		JMenuItem item23 = new JMenuItem("Tune Audio Parameters");
		
		item21.setIcon(new ImageIcon("icons\\playicon.png"));
		item22.setIcon(new ImageIcon("icons\\playicon.png"));
		item23.setIcon(new ImageIcon("icons\\tuneicon.png"));
		
		item21.addActionListener(this);
		item22.addActionListener(this);
		item23.addActionListener(this);
		
		menu2.add(item21);
		menu2.add(item22);
		menu2.add(item23);
		
		JMenuItem item31 = new JMenuItem("Start Recording");
		JMenuItem item32 = new JMenuItem("End Recording");
		JMenuItem item33 = new JMenuItem("Replay");
		
		item31.setIcon(new ImageIcon("icons\\starticon.png"));
		item32.setIcon(new ImageIcon("icons\\stopicon.png"));
		item33.setIcon(new ImageIcon("icons\\replayicon.png"));
		
		item31.addActionListener(this);
		item32.addActionListener(this);
		item33.addActionListener(this);
		
		menu3.add(item31);
		menu3.add(item32);
		menu3.add(item33);
		
		JMenuItem item41 = new JMenuItem("Help");
		
		item41.setIcon(new ImageIcon("icons\\helpicon.png"));
		
		menu4.add(item41);
		
		item41.addActionListener(this);
		
		menubar.add(menu1);
		menubar.add(menu2);
		menubar.add(menu3);
		menubar.add(menu4);
		
		frame.setJMenuBar(menubar);
		frame.add(pane);
		frame.setSize(1024,720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	// What happens when a button is pressed
	public void actionPerformed(ActionEvent e)
	{
		Document newDocument;
		String command = e.getActionCommand();
		if(command.equals("Open Simple Word Document"))
		{
			JFileChooser fileChooser = new JFileChooser("c:");
			FileNameExtensionFilter filter = new FileNameExtensionFilter("MS Word Documents","docx");
			fileChooser.setFileFilter(filter);
			int r = fileChooser.showOpenDialog(null);
			if(r == JFileChooser.APPROVE_OPTION)
			{
				String fileName = fileChooser.getSelectedFile().getAbsolutePath();
				newDocument = new Document("Word","None",fileName);
				commandsFactory.setDocument(newDocument);
			}else if(r == JFileChooser.CANCEL_OPTION)
			{
				return;
			}
			ActionListener openDocument = commandsFactory.createCommand("Open Document",frame,textArea);
			openDocument.actionPerformed(e);
		}else if(command.equals("Open Atbash Word Document"))
		{
			JFileChooser fileChooser = new JFileChooser("c:");
			FileNameExtensionFilter filter = new FileNameExtensionFilter("MS Word Documents","docx");
			fileChooser.setFileFilter(filter);
			int r = fileChooser.showOpenDialog(null);
			if(r == JFileChooser.APPROVE_OPTION)
			{
				String fileName = fileChooser.getSelectedFile().getAbsolutePath();
				newDocument = new Document("Word","Atbash",fileName);
				commandsFactory.setDocument(newDocument);
			}else if(r == JFileChooser.CANCEL_OPTION)
			{
				return;
			}
			ActionListener openDocument = commandsFactory.createCommand("Open Document",frame,textArea);
			openDocument.actionPerformed(e);
		}else if(command.equals("Open Rot13 Word Document"))
		{
			JFileChooser fileChooser = new JFileChooser("c:");
			FileNameExtensionFilter filter = new FileNameExtensionFilter("MS Word Documents","docx");
			fileChooser.setFileFilter(filter);
			int r = fileChooser.showOpenDialog(null);
			if(r == JFileChooser.APPROVE_OPTION)
			{
				String fileName = fileChooser.getSelectedFile().getAbsolutePath();
				newDocument = new Document("Word","Rot13",fileName);
				commandsFactory.setDocument(newDocument);
			}else if(r == JFileChooser.CANCEL_OPTION)
			{
				return;
			}
			ActionListener openDocument = commandsFactory.createCommand("Open Document",frame,textArea);
			openDocument.actionPerformed(e);
		}else if(command.equals("Open Simple Excel Document"))
		{
			JFileChooser fileChooser = new JFileChooser("c:");
			FileNameExtensionFilter filter = new FileNameExtensionFilter("MS Excel Documents","xlsx");
			fileChooser.setFileFilter(filter);
			int r = fileChooser.showOpenDialog(null);
			if(r == JFileChooser.APPROVE_OPTION)
			{
				String fileName = fileChooser.getSelectedFile().getAbsolutePath();
				newDocument = new Document("Excel","None",fileName);
				commandsFactory.setDocument(newDocument);
			}else if(r == JFileChooser.CANCEL_OPTION)
			{
				return;
			}
			ActionListener openDocument = commandsFactory.createCommand("Open Document",frame,textArea);
			openDocument.actionPerformed(e);
		}else if(command.equals("Open Atbash Excel Document"))
		{
			JFileChooser fileChooser = new JFileChooser("c:");
			FileNameExtensionFilter filter = new FileNameExtensionFilter("MS Excel Documents","xlsx");
			fileChooser.setFileFilter(filter);
			int r = fileChooser.showOpenDialog(null);
			if(r == JFileChooser.APPROVE_OPTION)
			{
				String fileName = fileChooser.getSelectedFile().getAbsolutePath();
				newDocument = new Document("Excel","Atbash",fileName);
				commandsFactory.setDocument(newDocument);
			}else if(r == JFileChooser.CANCEL_OPTION)
			{
				return;
			}
			ActionListener openDocument = commandsFactory.createCommand("Open Document",frame,textArea);
			openDocument.actionPerformed(e);
		}else if(command.equals("Open Rot13 Excel Document"))
		{
			JFileChooser fileChooser = new JFileChooser("c:");
			FileNameExtensionFilter filter = new FileNameExtensionFilter("MS Excel Documents","xlsx");
			fileChooser.setFileFilter(filter);
			int r = fileChooser.showOpenDialog(null);
			if(r == JFileChooser.APPROVE_OPTION)
			{
				String fileName = fileChooser.getSelectedFile().getAbsolutePath();
				newDocument = new Document("Excel","Rot13",fileName);
				commandsFactory.setDocument(newDocument);
			}else if(r == JFileChooser.CANCEL_OPTION)
			{
				return;
			}
			ActionListener openDocument = commandsFactory.createCommand("Open Document",frame,textArea);
			openDocument.actionPerformed(e);
		}else if(command.equals("Edit Document"))
		{
			ActionListener editDocument = commandsFactory.createCommand("Edit Document",frame,textArea);
			editDocument.actionPerformed(e);
		}else if(command.equals("Save Simple Word Document"))
		{
			JFileChooser fileChooser = new JFileChooser("c:");
			FileNameExtensionFilter filter = new FileNameExtensionFilter("MS Word Documents","docx");
			fileChooser.setFileFilter(filter);
			int r = fileChooser.showSaveDialog(null);
			if(r == JFileChooser.APPROVE_OPTION)
			{
				String fileName = fileChooser.getSelectedFile().getAbsolutePath();
				newDocument = new Document("Word","None",fileName);
				commandsFactory.setDocument(newDocument);
			}else if(r == JFileChooser.CANCEL_OPTION)
			{
				return;
			}
			ActionListener saveDocument = commandsFactory.createCommand("Save Document",frame,textArea);
			saveDocument.actionPerformed(e);
		}else if(command.equals("Save Atbash Word Document"))
		{
			JFileChooser fileChooser = new JFileChooser("c:");
			FileNameExtensionFilter filter = new FileNameExtensionFilter("MS Word Documents","docx");
			fileChooser.setFileFilter(filter);
			int r = fileChooser.showSaveDialog(null);
			if(r == JFileChooser.APPROVE_OPTION)
			{
				String fileName = fileChooser.getSelectedFile().getAbsolutePath();
				newDocument = new Document("Word","Atbash",fileName);
				commandsFactory.setDocument(newDocument);
			}else if(r == JFileChooser.CANCEL_OPTION)
			{
				return;
			}
			ActionListener saveDocument = commandsFactory.createCommand("Save Document",frame,textArea);
			saveDocument.actionPerformed(e);
		}else if(command.equals("Save Rot13 Word Document"))
		{
			JFileChooser fileChooser = new JFileChooser("c:");
			FileNameExtensionFilter filter = new FileNameExtensionFilter("MS Word Documents","docx");
			fileChooser.setFileFilter(filter);
			int r = fileChooser.showSaveDialog(null);
			if(r == JFileChooser.APPROVE_OPTION)
			{
				String fileName = fileChooser.getSelectedFile().getAbsolutePath();
				newDocument = new Document("Word","Rot13",fileName);
				commandsFactory.setDocument(newDocument);
			}else if(r == JFileChooser.CANCEL_OPTION)
			{
				return;
			}
			ActionListener saveDocument = commandsFactory.createCommand("Save Document",frame,textArea);
			saveDocument.actionPerformed(e);
		}else if(command.equals("Save Simple Excel Document"))
		{
			JFileChooser fileChooser = new JFileChooser("c:");
			FileNameExtensionFilter filter = new FileNameExtensionFilter("MS Excel Documents","xlsx");
			fileChooser.setFileFilter(filter);
			int r = fileChooser.showSaveDialog(null);
			if(r == JFileChooser.APPROVE_OPTION)
			{
				String fileName = fileChooser.getSelectedFile().getAbsolutePath();
				newDocument = new Document("Excel","None",fileName);
				commandsFactory.setDocument(newDocument);
			}else if(r == JFileChooser.CANCEL_OPTION)
			{
				return;
			}
			ActionListener saveDocument = commandsFactory.createCommand("Save Document",frame,textArea);
			saveDocument.actionPerformed(e);
		}else if(command.equals("Save Atbash Excel Document"))
		{
			JFileChooser fileChooser = new JFileChooser("c:");
			FileNameExtensionFilter filter = new FileNameExtensionFilter("MS Excel Documents","xlsx");
			fileChooser.setFileFilter(filter);
			int r = fileChooser.showSaveDialog(null);
			if(r == JFileChooser.APPROVE_OPTION)
			{
				String fileName = fileChooser.getSelectedFile().getAbsolutePath();
				newDocument = new Document("Excel","Atbash",fileName);
				commandsFactory.setDocument(newDocument);
			}else if(r == JFileChooser.CANCEL_OPTION)
			{
				return;
			}
			ActionListener saveDocument = commandsFactory.createCommand("Save Document",frame,textArea);
			saveDocument.actionPerformed(e);
		}else if(command.equals("Save Rot13 Excel Document"))
		{
			JFileChooser fileChooser = new JFileChooser("c:");
			FileNameExtensionFilter filter = new FileNameExtensionFilter("MS Excel Documents","xlsx");
			fileChooser.setFileFilter(filter);
			int r = fileChooser.showOpenDialog(null);
			if(r == JFileChooser.APPROVE_OPTION)
			{
				String fileName = fileChooser.getSelectedFile().getAbsolutePath();
				newDocument = new Document("Excel","Rot13",fileName);
				commandsFactory.setDocument(newDocument);
			}else if(r == JFileChooser.CANCEL_OPTION)
			{
				return;
			}
			ActionListener saveDocument = commandsFactory.createCommand("Save Document",frame,textArea);
			saveDocument.actionPerformed(e);
		}else if(command.equals("Document To Speech"))
		{
			ActionListener documentToSpeech = commandsFactory.createCommand("Document To Speech", frame, textArea);
			documentToSpeech.actionPerformed(e);
		}else if(command.equals("Part Of Document To Speech"))
		{
			JFrame f= new JFrame();  
		    JDialog d = new JDialog(f , "Lines To Listen", true);
		    JTextField fieldStart = new JTextField(5);
		    JLabel startLabel = new JLabel("Start Line:");
		    JTextField fieldEnd = new JTextField(5);
		    JLabel endLabel = new JLabel("End Line:");
		    startLabel.setLabelFor(fieldStart);
		    endLabel.setLabelFor(fieldEnd);
		    JButton b = new JButton("OK");
		    b.addActionListener(new ActionListener() { 
		    		public void actionPerformed(ActionEvent event) {
		    			if(fieldStart.getText().equals("")|| fieldEnd.getText().equals(""))
		    			{
		    				return;
		    			}
		    			int startLine = Integer.parseInt(fieldStart.getText());
		    			int endLine = Integer.parseInt(fieldEnd.getText());
		    			commandsFactory.setStartLine(startLine);
		    			commandsFactory.setEndLine(endLine);
		    			ActionListener documentToSpeechLines = commandsFactory.createCommand("Document To Speech Lines",frame,textArea);
		    			d.setVisible(false);
		    			documentToSpeechLines.actionPerformed(e);
		    		}
		    });
	        d.setLayout( new FlowLayout() );  
	        d.add(startLabel);
	        d.add(fieldStart);
	        d.add(endLabel);
	        d.add(fieldEnd);
	        d.add(b);
	        d.setSize(120,120);
	        d.setLocationRelativeTo(f);
	        d.setResizable(false);
	        d.setVisible(true);  
		}else if(command.equals("Tune Audio Parameters"))
		{
			JFrame f= new JFrame();  
		    JDialog d = new JDialog(f , "Tune Parameters", true);
		    JTextField fieldVolume = new JTextField(15);
		    JLabel volumeLabel = new JLabel("Volume");
		    JTextField fieldPitch = new JTextField(15);
		    JLabel pitchLabel = new JLabel("Pitch");
		    JTextField fieldRate = new JTextField(15);
		    JLabel rateLabel = new JLabel("Rate");
		    
		    fieldVolume.setText("3");
		    fieldPitch.setText("150");
		    fieldRate.setText("150");
		    
		    volumeLabel.setLabelFor(fieldVolume);
		    pitchLabel.setLabelFor(fieldPitch);
		    rateLabel.setLabelFor(fieldRate);
		    JButton b = new JButton("OK");
		    b.addActionListener(new ActionListener() { 
		    		public void actionPerformed(ActionEvent event) {
		    			if(fieldVolume.getText().equals("")|| fieldPitch.getText().equals("") || fieldRate.getText().equals(""))
		    			{
		    				return;
		    			}
		    			int volume = Integer.parseInt(fieldVolume.getText());
		    			int pitch = Integer.parseInt(fieldPitch.getText());
		    			int rate = Integer.parseInt(fieldRate.getText());
		    			commandsFactory.setVolume(volume);
		    			commandsFactory.setPitch(pitch);
		    			commandsFactory.setRate(rate);
		    			ActionListener tuneAudioParameters = commandsFactory.createCommand("Tune Audio Parameters",frame,textArea);
		    			tuneAudioParameters.actionPerformed(e);
		    			d.setVisible(false);
		    		}
		    });
	        d.setLayout( new FlowLayout() );  
	        d.add(volumeLabel);
	        d.add(fieldVolume);
	        d.add(pitchLabel);
	        d.add(fieldPitch);
	        d.add(rateLabel);
	        d.add(fieldRate);
	        d.add(b);
	        d.setSize(180,200);
	        d.setLocationRelativeTo(f);
	        d.setResizable(false);
	        d.setVisible(true);  
		}else if(command.equals("Start Recording"))
		{
			ActionListener startRecording = commandsFactory.createCommand("Start Recording", frame, textArea);
			startRecording.actionPerformed(e);
		}else if(command.equals("Replay"))
		{
			ActionListener replay = commandsFactory.createCommand("Replay", frame, textArea);
			replay.actionPerformed(e);
		}else if(command.equals("End Recording"))
		{
			ActionListener endRecording = commandsFactory.createCommand("End Recording", frame, textArea);
			endRecording.actionPerformed(e);
		}else if(command.equals("Help"))
		{
			JFrame f = new JFrame("Help");
			JTextArea textArea = new JTextArea();
			Font font = new Font("SansSerif",Font.PLAIN,14);
			textArea.setFont(font);
			textArea.setText("Ã’’ 803 Software Engineering\nComputer Science and Engineering, Univeristy of Ioannina\nSpring 2021\n\nMarios Iakovidis AM 4063\nTheofilos-Georgios Petsios AM 4158\n\n"
					+ "Open Document: Open a Word/Excel Document that is either encoded with Atbash/Rot13 or not.\n"
					+ "Edit Document: Edit the contents of an opened document without changing the Document file.\n"
					+ "Save Document As: Save the contents of an opened document to a file that the user selects.\n"
					+ "Document To Speech: Converts the full contents of an opened document to audio.\n"
					+ "Part Of Document To Speech: The user selects a part of the contents of an opened document to be converted to audio.\n"
					+ "Tune Audio Parameters: Set the audio's volume,pitch and rate.\n"
					+ "Start Recording: Begin a recording session of the executed commands.\n"
					+ "End Recording: End a recording session of the executed commands.\n"
					+ "Replay: Replay the recorded session.\n");
			textArea.setEditable(false);
			f.add(textArea);
			f.setSize(800,400);
			f.setLocationRelativeTo(frame);
			f.setResizable(false);
			f.setVisible(true);
		}
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		AdvancedTextToSpeechEditorView editor = new AdvancedTextToSpeechEditorView();
	}
}
