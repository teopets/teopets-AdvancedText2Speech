//MARIOS IAKOVIDIS AM 4063
//THEOFILOS GEORGIOS PETSIOS AM 4063

package input;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;

// class for reading .xlsx documents
public class ExcelReader implements DocumentReader
{
	private String fileName;
	
	// constructor
	public ExcelReader(String fileName)
	{
		this.fileName = fileName;
	}
	
	// read contents of .xlsx file
	public ArrayList<String> read()
	{
		ArrayList<String> retArray = new ArrayList<String>();
		try
		{
			File file = new File(fileName);
			FileInputStream fis = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(fis);
			DataFormatter dataFormatter = new DataFormatter();
			Iterator<Sheet> sheets = workbook.sheetIterator();
			while(sheets.hasNext())
			{
				String lineContents = "";
				Sheet sheet = sheets.next();
				Iterator<Row> rowIterator = sheet.iterator();
				while(rowIterator.hasNext())
				{
					Row row = rowIterator.next();
					Iterator<Cell> cellIterator = row.iterator();
					while(cellIterator.hasNext())
					{
						Cell cell = cellIterator.next();
						String cellValue = dataFormatter.formatCellValue(cell);
						lineContents += cellValue + " ";
					}
					lineContents += "\n";
				}
				retArray.add(lineContents);
			}
			workbook.close();
			fis.close();
			return retArray;
		}catch(Exception exception)
		{
			exception.printStackTrace();
			return null;
		}
	}
}
