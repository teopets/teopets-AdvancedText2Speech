// MARIOS IAKOVIDIS AM 4063
// THEOFILOS GEORGIOS PETSIOS AM 4158

package output;

import java.util.ArrayList;
import java.util.HashMap;


// Create Rot13 Document and write it to File
public class WriterRot13Decorator extends WriterDecorator 
{
	private HashMap<Character,Character> encoder = new HashMap<Character,Character>();
	
	private void initializeEncoder()
	{
		this.encoder.put('a', 'n');
		this.encoder.put('b', 'o');
		this.encoder.put('c', 'p');
		this.encoder.put('d', 'q');
		this.encoder.put('e', 'r');
		this.encoder.put('f', 's');
		this.encoder.put('g', 't');
		this.encoder.put('h', 'u');
		this.encoder.put('i', 'v');
		this.encoder.put('j', 'w');
		this.encoder.put('k', 'x');
		this.encoder.put('l', 'y');
		this.encoder.put('m', 'z');
		this.encoder.put('n', 'a');
		this.encoder.put('o', 'b');
		this.encoder.put('p', 'c');
		this.encoder.put('q', 'd');
		this.encoder.put('r', 'e');
		this.encoder.put('s', 'f');
		this.encoder.put('t', 'g');
		this.encoder.put('u', 'h');
		this.encoder.put('v', 'i');
		this.encoder.put('w', 'j');
		this.encoder.put('x', 'k');
		this.encoder.put('y', 'l');
		this.encoder.put('z', 'm');
		this.encoder.put('A', 'N');
		this.encoder.put('B', 'O');
		this.encoder.put('C', 'P');
		this.encoder.put('D', 'Q');
		this.encoder.put('E', 'R');
		this.encoder.put('F', 'S');
		this.encoder.put('G', 'T');
		this.encoder.put('H', 'U');
		this.encoder.put('I', 'V');
		this.encoder.put('J', 'W');
		this.encoder.put('K', 'X');
		this.encoder.put('L', 'Y');
		this.encoder.put('M', 'Z');
		this.encoder.put('N', 'A');
		this.encoder.put('O', 'B');
		this.encoder.put('P', 'C');
		this.encoder.put('Q', 'D');
		this.encoder.put('R', 'E');
		this.encoder.put('S', 'F');
		this.encoder.put('T', 'G');
		this.encoder.put('U', 'H');
		this.encoder.put('V', 'I');
		this.encoder.put('W', 'J');
		this.encoder.put('X', 'K');
		this.encoder.put('Y', 'L');
		this.encoder.put('Z', 'M');
		this.encoder.put(' ', ' ');
		this.encoder.put('0', '0');
		this.encoder.put('1', '1');
		this.encoder.put('2', '2');
		this.encoder.put('3', '3');
		this.encoder.put('4', '4');
		this.encoder.put('5', '5');
		this.encoder.put('6', '6');
		this.encoder.put('7', '7');
		this.encoder.put('8', '8');
		this.encoder.put('9', '9');
		this.encoder.put('!', '!');
		this.encoder.put('@', '@');
		this.encoder.put('#', '#');
		this.encoder.put('$', '$');
		this.encoder.put('%', '%');
		this.encoder.put('^', '^');
		this.encoder.put('&', '&');
		this.encoder.put('*', '*');
		this.encoder.put('(', '(');
		this.encoder.put(')', ')');
		this.encoder.put('-', '-');
		this.encoder.put('+', '+');
		this.encoder.put('_', '_');
		this.encoder.put('=', '=');
		this.encoder.put('[', '[');
		this.encoder.put('{', '{');
		this.encoder.put(']', ']');
		this.encoder.put('}', '}');
		this.encoder.put(';', ';');
		this.encoder.put(':', ':');
		this.encoder.put('?', '?');
		this.encoder.put('/', '/');
		this.encoder.put('<', '<');
		this.encoder.put('>', '>');
		this.encoder.put('.', '.');
		this.encoder.put(',', ',');
		this.encoder.put('\\', '\\');
		this.encoder.put('|', '|');
		this.encoder.put('"', '"');
		this.encoder.put('\n','\n');
		this.encoder.put('\t','\t');
		
	}
	public WriterRot13Decorator(DocumentWriter documentWriter) 
	{
		super(documentWriter);
	}

	public void write(ArrayList<String> contents) 
	{
		ArrayList<String> encodedContents = new ArrayList<String>();
		this.initializeEncoder();
		for(String s: contents)
		{
			String encodedLine = "";
			for(int i = 0;i < s.length();i++)
			{
				char letter = s.charAt(i);
				char encodedLetter = encoder.get(letter);
				encodedLine += encodedLetter;
			}
			encodedContents.add(encodedLine);
		}
		documentWriter.write(encodedContents);
	}	
}
