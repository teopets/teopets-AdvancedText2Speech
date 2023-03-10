// MARIOS IAKOVIDIS AM 4063
// THEOFILOS GEORGIOS PETSIOS AM 4158
package input;

// Creates DocumentReader objects
public class DocumentReaderFactory 
{
	public DocumentReader createReader(String format,String encoding, String fileName)
	{
		if(format.equals("Word") && encoding.equals("Atbash"))
		{
			WordReader wordReader = new WordReader(fileName);
			return new ReaderAtbashDecorator(wordReader);
		}
		else if(format.equals("Excel") && encoding.equals("Atbash"))
		{
			ExcelReader excelReader = new ExcelReader(fileName);
			return new ReaderAtbashDecorator(excelReader);
		}
		else if(format.equals("Word") && encoding.equals("Rot13"))
		{
			WordReader wordReader = new WordReader(fileName);
			return new ReaderRot13Decorator(wordReader);
		}
		else if(format.equals("Excel") && encoding.equals("Rot13"))
		{
			ExcelReader excelReader = new ExcelReader(fileName);
			return new ReaderRot13Decorator(excelReader);
		}
		else if(format.equals("Word") == true)
		{
			return new WordReader(fileName);
		}else if(format.equals("Excel") == true)
		{
			return new ExcelReader(fileName);
		}else
		{
			System.out.println("File format is not supported");
			System.exit(-1);
			return null;
		}
	}
}
