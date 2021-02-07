package dataprovider;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;

public class excelDataProvider {
    XSSFWorkbook wb;
    public excelDataProvider() {
        File src = new File("./appTestData/appData.xlsx");
        try {
            FileInputStream fis = new FileInputStream(src);
            wb= new XSSFWorkbook(fis);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String getData(int sheetIndex, int row, int col)
    {
     String data=wb.getSheetAt(sheetIndex).getRow(row).getCell(col).getStringCellValue();
     return data;
    }
    public String getData(String sheetName, int row, int col)
    {
        String data=wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
        return data;
    }

}
