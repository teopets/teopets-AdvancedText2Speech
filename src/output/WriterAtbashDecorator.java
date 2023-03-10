// MARIOS IAKOVIDIS AM 4063
// THEOFILOS GEORGIOS PETSIOS AM 4158

package output;

import java.util.ArrayList;
import java.util.HashMap;

// Create Atbash Document and write it to File
public class WriterAtbashDecorator extends WriterDecorator 
{
	private HashMap<Character,Character> encoder = new HashMap<Character,Character>();
	
	// initialize HashMap for AtBash decoding
	private void initializeEncoder()
	{
		this.encoder.put('a', 'z');
		this.encoder.put('b', 'y');
		this.encoder.put('c', 'x');
		this.encoder.put('d', 'w');
		this.encoder.put('e', 'v');
		this.encoder.put('f', 'u');
		this.encoder.put('g', 't');
		this.encoder.put('h', 's');
		this.encoder.put('i', 'r');
		this.encoder.put('j', 'q');
		this.encoder.put('k', 'p');
		this.encoder.put('l', 'o');
		this.encoder.put('m', 'n');
		this.encoder.put('n', 'm');
		this.encoder.put('o', 'l');
		this.encoder.put('p', 'k');
		this.encoder.put('q', 'j');
		this.encoder.put('r', 'i');
		this.encoder.put('s', 'h');
		this.encoder.put('t', 'g');
		this.encoder.put('u', 'f');
		this.encoder.put('v', 'e');
		this.encoder.put('w', 'd');
		this.encoder.put('x', 'c');
		this.encoder.put('y', 'b');
		this.encoder.put('z', 'a');
		this.encoder.put('A', 'Z');
		this.encoder.put('B', 'Y');
		this.encoder.put('C', 'X');
		this.encoder.put('D', 'W');
		this.encoder.put('E', 'V');
		this.encoder.put('F', 'U');
		this.encoder.put('G', 'T');
		this.encoder.put('H', 'S');
		this.encoder.put('I', 'R');
		this.encoder.put('J', 'Q');
		this.encoder.put('K', 'P');
		this.encoder.put('L', 'O');
		this.encoder.put('M', 'N');
		this.encoder.put('N', 'M');
		this.encoder.put('O', 'L');
		this.encoder.put('P', 'K');
		this.encoder.put('Q', 'J');
		this.encoder.put('R', 'I');
		this.encoder.put('S', 'H');
		this.encoder.put('T', 'G');
		this.encoder.put('U', 'F');
		this.encoder.put('V', 'E');
		this.encoder.put('W', 'D');
		this.encoder.put('X', 'C');
		this.encoder.put('Y', 'B');
		this.encoder.put('Z', 'A');
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
		this.encoder.put('\n', '\n');
		this.encoder.put('\t', '\t');
	}
	
	public WriterAtbashDecorator(DocumentWriter documentWriter) 
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
