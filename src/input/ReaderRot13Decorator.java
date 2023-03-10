// MARIOS IAKOVDIS AM 4063
// THEOFILOS GEORGIOS PETSIOS AM 4158

package input;

import java.util.ArrayList;
import java.util.HashMap;

// Read document and perform Rot13 decoding 
public class ReaderRot13Decorator extends ReaderDecorator
{

	private HashMap<Character,Character> decoder = new HashMap<Character,Character>();
	
	private void initializeDecoder()
	{
		this.decoder.put('a', 'n');
		this.decoder.put('b', 'o');
		this.decoder.put('c', 'p');
		this.decoder.put('d', 'q');
		this.decoder.put('e', 'r');
		this.decoder.put('f', 's');
		this.decoder.put('g', 't');
		this.decoder.put('h', 'u');
		this.decoder.put('i', 'v');
		this.decoder.put('j', 'w');
		this.decoder.put('k', 'x');
		this.decoder.put('l', 'y');
		this.decoder.put('m', 'z');
		this.decoder.put('n', 'a');
		this.decoder.put('o', 'b');
		this.decoder.put('p', 'c');
		this.decoder.put('q', 'd');
		this.decoder.put('r', 'e');
		this.decoder.put('s', 'f');
		this.decoder.put('t', 'g');
		this.decoder.put('u', 'h');
		this.decoder.put('v', 'i');
		this.decoder.put('w', 'j');
		this.decoder.put('x', 'k');
		this.decoder.put('y', 'l');
		this.decoder.put('z', 'm');
		this.decoder.put('A', 'N');
		this.decoder.put('B', 'O');
		this.decoder.put('C', 'P');
		this.decoder.put('D', 'Q');
		this.decoder.put('E', 'R');
		this.decoder.put('F', 'S');
		this.decoder.put('G', 'T');
		this.decoder.put('H', 'U');
		this.decoder.put('I', 'V');
		this.decoder.put('J', 'W');
		this.decoder.put('K', 'X');
		this.decoder.put('L', 'Y');
		this.decoder.put('M', 'Z');
		this.decoder.put('N', 'A');
		this.decoder.put('O', 'B');
		this.decoder.put('P', 'C');
		this.decoder.put('Q', 'D');
		this.decoder.put('R', 'E');
		this.decoder.put('S', 'F');
		this.decoder.put('T', 'G');
		this.decoder.put('U', 'H');
		this.decoder.put('V', 'I');
		this.decoder.put('W', 'J');
		this.decoder.put('X', 'K');
		this.decoder.put('Y', 'L');
		this.decoder.put('Z', 'M');
		this.decoder.put(' ', ' ');
		this.decoder.put('0', '0');
		this.decoder.put('1', '1');
		this.decoder.put('2', '2');
		this.decoder.put('3', '3');
		this.decoder.put('4', '4');
		this.decoder.put('5', '5');
		this.decoder.put('6', '6');
		this.decoder.put('7', '7');
		this.decoder.put('8', '8');
		this.decoder.put('9', '9');
		this.decoder.put('!', '!');
		this.decoder.put('@', '@');
		this.decoder.put('#', '#');
		this.decoder.put('$', '$');
		this.decoder.put('%', '%');
		this.decoder.put('^', '^');
		this.decoder.put('&', '&');
		this.decoder.put('*', '*');
		this.decoder.put('(', '(');
		this.decoder.put(')', ')');
		this.decoder.put('-', '-');
		this.decoder.put('+', '+');
		this.decoder.put('_', '_');
		this.decoder.put('=', '=');
		this.decoder.put('[', '[');
		this.decoder.put('{', '{');
		this.decoder.put(']', ']');
		this.decoder.put('}', '}');
		this.decoder.put(';', ';');
		this.decoder.put(':', ':');
		this.decoder.put('?', '?');
		this.decoder.put('/', '/');
		this.decoder.put('<', '<');
		this.decoder.put('>', '>');
		this.decoder.put('.', '.');
		this.decoder.put(',', ',');
		this.decoder.put('\\', '\\');
		this.decoder.put('|', '|');
		this.decoder.put('"', '"');
		this.decoder.put('\n','\n');
		this.decoder.put('\t','\t');
		
	}
	
	public ReaderRot13Decorator(DocumentReader documentReader) 
	{
		super(documentReader);
	}
	
	// Read document and decode it
	public ArrayList<String> read()
	{
		ArrayList<String> retArray = new ArrayList<String>();
		ArrayList<String> encodedContents = documentReader.read(); // read encoded contents
		this.initializeDecoder();
		// decoder
		for(String s:encodedContents)
		{
			String decodedLine = "";
			for(int i = 0;i<s.length();i++)
			{
				char letter = s.charAt(i);
				char decodedLetter = decoder.get(letter);
				decodedLine += decodedLetter;
			}
			retArray.add(decodedLine);
		}
		return retArray;
		
	}

}
