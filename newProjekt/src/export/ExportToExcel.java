package export;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExportToExcel {

    public void excel(String musteriAd,String opAd, String deAd, String onAd) throws IOException  {
        
            FileInputStream inputStream = new FileInputStream(new File("MagneticReport.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream); 
            XSSFSheet sheet = workbook.getSheetAt(0);
            CellStyle style1 = workbook.createCellStyle();
            style1.setAlignment(HorizontalAlignment.CENTER);
            style1.setVerticalAlignment(VerticalAlignment.CENTER);
            
            XSSFRow row = sheet.getRow(2);
            XSSFCell cell = row.createCell(3);
            cell.setCellValue(musteriAd);
            cell.setCellStyle(style1);
            
            XSSFRow row2 = sheet.getRow(3);
            XSSFCell cell2 = row2.createCell(3);
            cell2.setCellValue("ARSLAN PROJE");
            cell2.setCellStyle(style1);
            
            XSSFRow row3 = sheet.getRow(4);
            XSSFCell cell3 = row3.createCell(3);
            cell3.setCellValue("İSTANBUL");            
            cell3.setCellStyle(style1);
            
            XSSFRow row40 = sheet.getRow(39);
            XSSFCell cell6 = row40.createCell(5);
            cell6.setCellValue(opAd);            
            cell6.setCellStyle(style1);
            
            
            XSSFCell cell16 = row40.createCell(15);
            cell16.setCellValue(deAd);            
            cell16.setCellStyle(style1); 
            
          
            XSSFCell cell21 = row40.createCell(20);
            cell21.setCellValue(onAd);            
            cell21.setCellStyle(style1);            
            
            inputStream.close();
 
            FileOutputStream outputStream = new FileOutputStream("C:\\Users\\arsla\\Documents\\NetBeansProjects\\Projekt\\newProjekt\\MagneticReport.xlsx");
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
            System.out.println("Excel written successfully");

     
    
    }

}
