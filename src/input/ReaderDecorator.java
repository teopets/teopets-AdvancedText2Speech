//MARIOS IAKOVIDIS AM 4063
//THEOFILOS GEORGIOS PETSIOS AM 4158

package input;

import java.util.ArrayList;

// Decorator class for Atbash and Rot13 decoding
public abstract class ReaderDecorator implements DocumentReader
{
	protected DocumentReader documentReader;
	
	// constructor
	public ReaderDecorator(DocumentReader documentReader)
	{
		this.documentReader = documentReader;
	}
	
	// read encoded contents from document
	public abstract ArrayList<String> read();
}
