// MARIOS IAKOVIDIS AM 4063
// THEOFILOS GEORGIOS PETSIOS AM 4158

package output;

import java.util.ArrayList;

// Decorator for encoding and writing to files
public abstract class WriterDecorator implements DocumentWriter 
{
	protected DocumentWriter documentWriter;
	
	public WriterDecorator(DocumentWriter documentWriter)
	{
		this.documentWriter = documentWriter;
	}
	
	public abstract void write(ArrayList<String> contents);
}
