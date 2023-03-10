// MARIOS IAKOVIDIS AM 4063
// THEOFILOS GEORGIOS PETSIOS AM 4158

package output;

// Creates DocumentWriter objects
public class DocumentWriterFactory 
{
	public DocumentWriter createWriter(String format, String encoding, String fileName)
	{
		if(format.equals("Word") && encoding.equals("Atbash"))
		{
			WordWriter wordWriter = new WordWriter(fileName);
			return new WriterAtbashDecorator(wordWriter);
		}
		else if(format.equals("Excel") && encoding.equals("Atbash"))
		{
			ExcelWriter excelWriter = new ExcelWriter(fileName);
			return new WriterAtbashDecorator(excelWriter);
		}
		else if(format.equals("Word") && encoding.equals("Rot13"))
		{
			WordWriter wordWriter = new WordWriter(fileName);
			return new WriterRot13Decorator(wordWriter);
		}
		else if(format.equals("Excel") && encoding.equals("Rot13"))
		{
			ExcelWriter excelWriter = new ExcelWriter(fileName);
			return new WriterRot13Decorator(excelWriter);
		}
		else if(format.equals("Word") == true)
		{
			return new WordWriter(fileName);
		}else if(format.equals("Excel") == true)
		{
			return new ExcelWriter(fileName);
		}else
		{
			System.out.println("File format is not supported");
			System.exit(-1);
			return null;
		}
	}
}
