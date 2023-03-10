// MARIOS IAKOVIDIS AM 4063
// THEOFILOS GEORGIOS AM 4158

package input;

import java.util.ArrayList;
import java.util.HashMap;

// Read document and perform atbash decoding
public class ReaderAtbashDecorator extends ReaderDecorator
{
	
	private HashMap<Character,Character> decoder = new HashMap<Character,Character>();
	
	// initialize HashMap for AtBash decoding
	private void initializeDecoder()
	{
		this.decoder.put('a', 'z');
		this.decoder.put('b', 'y');
		this.decoder.put('c', 'x');
		this.decoder.put('d', 'w');
		this.decoder.put('e', 'v');
		this.decoder.put('f', 'u');
		this.decoder.put('g', 't');
		this.decoder.put('h', 's');
		this.decoder.put('i', 'r');
		this.decoder.put('j', 'q');
		this.decoder.put('k', 'p');
		this.decoder.put('l', 'o');
		this.decoder.put('m', 'n');
		this.decoder.put('n', 'm');
		this.decoder.put('o', 'l');
		this.decoder.put('p', 'k');
		this.decoder.put('q', 'j');
		this.decoder.put('r', 'i');
		this.decoder.put('s', 'h');
		this.decoder.put('t', 'g');
		this.decoder.put('u', 'f');
		this.decoder.put('v', 'e');
		this.decoder.put('w', 'd');
		this.decoder.put('x', 'c');
		this.decoder.put('y', 'b');
		this.decoder.put('z', 'a');
		this.decoder.put('A', 'Z');
		this.decoder.put('B', 'Y');
		this.decoder.put('C', 'X');
		this.decoder.put('D', 'W');
		this.decoder.put('E', 'V');
		this.decoder.put('F', 'U');
		this.decoder.put('G', 'T');
		this.decoder.put('H', 'S');
		this.decoder.put('I', 'R');
		this.decoder.put('J', 'Q');
		this.decoder.put('K', 'P');
		this.decoder.put('L', 'O');
		this.decoder.put('M', 'N');
		this.decoder.put('N', 'M');
		this.decoder.put('O', 'L');
		this.decoder.put('P', 'K');
		this.decoder.put('Q', 'J');
		this.decoder.put('R', 'I');
		this.decoder.put('S', 'H');
		this.decoder.put('T', 'G');
		this.decoder.put('U', 'F');
		this.decoder.put('V', 'E');
		this.decoder.put('W', 'D');
		this.decoder.put('X', 'C');
		this.decoder.put('Y', 'B');
		this.decoder.put('Z', 'A');
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
		this.decoder.put('\n', '\n');
		this.decoder.put('\t', '\t');
	}

	// constructor
	public ReaderAtbashDecorator(DocumentReader documentReader) 
	{
		super(documentReader);
	}
	
	
	// read Atbash encoded documents
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
