package newprojekt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import static javafx.scene.input.KeyCode.V;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExportToExcel {

    public static void main(String[] args) throws IOException  {
        
            FileInputStream inputStream = new FileInputStream(new File("MagneticReport.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream); 
            XSSFSheet sheet = workbook.getSheetAt(0);
            CellStyle style1 = workbook.createCellStyle();
            style1.setAlignment(HorizontalAlignment.CENTER);
            style1.setVerticalAlignment(VerticalAlignment.CENTER);
            
            XSSFRow row = sheet.getRow(2);
            XSSFCell cell = row.createCell(3);
            cell.setCellValue("ARSLAN GEMİ");
            cell.setCellStyle(style1);
            
            XSSFRow row2 = sheet.getRow(3);
            XSSFCell cell2 = row2.createCell(3);
            cell2.setCellValue("ARSLAN PROJE");
            cell2.setCellStyle(style1);
            
            XSSFRow row3 = sheet.getRow(4);
            XSSFCell cell3 = row3.createCell(3);
            cell3.setCellValue("İSTANBUL");            
            cell3.setCellStyle(style1);
            
            inputStream.close();
 
            FileOutputStream outputStream = new FileOutputStream("MagneticReport1.xlsx");
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
            System.out.println("Excel written successfully");
             
     
    
    }

}
