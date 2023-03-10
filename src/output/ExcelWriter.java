// MARIOS IAKOVIDIS AM 4063
// THEOFILOS GEORGIOS PETSIOS AM 4158

package output;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// Write an Excel Document
public class ExcelWriter implements DocumentWriter 
{
	private String fileName;
	
	public ExcelWriter(String fileName)
	{
		this.fileName = fileName;
	}

	public void write(ArrayList<String> contents) 
	{
		int rownum;
		int cellnum;
		try
		{
			File file = new File(fileName);
			FileOutputStream fos = new FileOutputStream(file);
			Workbook workbook = new XSSFWorkbook();
			for(String s:contents)
			{
				rownum = 0;
				Sheet sheet = workbook.createSheet();
				String[] rows = s.split(" \n");
				for(String str:rows)
				{
					cellnum = 0;
					Row row = sheet.createRow(rownum++);
					String[] cells = str.split(" ");
					for(String string:cells)
					{
						Cell cell = row.createCell(cellnum++);
						cell.setCellValue((String)string);
					}
				}
			}
			workbook.write(fos);
			fos.close();
			workbook.close();
		}catch(Exception exception)
		{
			exception.printStackTrace();
		}
	}

}
