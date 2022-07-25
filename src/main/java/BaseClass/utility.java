package BaseClass;
import Configuration.config;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class utility {
	public static String readExcelSheet(int row ,int col) throws EncryptedDocumentException, IOException {
		
		
		FileInputStream file=new FileInputStream(config.excelsheetpath);
		 Sheet sheet = WorkbookFactory.create(file).getSheet("Sheet1");
		 String sheet1 = sheet.getRow(row).getCell(col).getStringCellValue();
		return sheet1;
}

public static String readpropertiesfile(String key) throws IOException {
	
	Properties p=new Properties();
	FileInputStream f=new  FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\IB\\src\\main\\resources\\properties\\logincrediantials.properties"); 		
	p.load(f);
	String value=p.getProperty(key);
	return value;

}
}
