import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class testExcelSheet {

	public static void main(String[] args) throws Throwable {
		
		XSSFWorkbook wb = new XSSFWorkbook("D:\\PB_Uploads\\salary_advanced_template.xlsx");  
	    XSSFSheet worksheet = wb.getSheetAt(0); 
	    Map<String, Object[]> data = new TreeMap<String, Object[]>();
	    data.put("1", new Object[]{"ID", "NAME", "LASTNAME"});
	    data.put("2", new Object[]{1, "Amit", "Shukla"});
	    data.put("3", new Object[]{2, "Lokesh", "Gupta"});
	    data.put("4", new Object[]{3, "John", "Adwards"});
	    data.put("5", new Object[]{4, "Brian", "Schultz"});
	    Row row = worksheet.createRow(1);
	    Object[] objArr = data.get("2");
	    int cellnum = 0;
	    for (Object obj : objArr) 
	    {
	       Cell cell = row.createCell(cellnum++);
	       if (obj instanceof String) 
	       {
	    	   cell.setCellValue((String) obj);
	       }
	       else if (obj instanceof Integer) 
	       {
	    	   cell.setCellValue((Integer) obj);
	       }
	     }
	    try{
	    FileOutputStream output_file =new FileOutputStream(new File("D:\\PB_Uploads\\New_import_sheet.xlsx")); 
        wb.write(output_file); 
        output_file.close();
		}
	    catch(Exception e){
	    	System.out.println("Can not write in the file chosen");
	    }
//		Process test = Runtime.getRuntime().exec("cmd /c C:\\Wget\\wget.exe -P D:\\PB_Uploads --no-check-certificate https://rana.purplebureau-qa.com/salary_advanced_template.xlsx");
//		int wait = test.waitFor();
//		System.out.println("Exit value: " + wait);
	}
	
         

}
