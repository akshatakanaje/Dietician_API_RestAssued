package commonutils;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelReader {

    String path;
    FileInputStream fis;
    Workbook workbook;
    Sheet sheet;
    Row row ;

    public ExcelReader(String path){
        this.path = path;
    }

    public Map<? extends String, ? extends List<String>> readSheet(String sheetName) throws IOException {

        File file = new File(path);
        fis = new FileInputStream(file);

        // Below API can ready both xls and xlsx formats
        workbook= WorkbookFactory.create(fis);

        // Below API only ready xls formats
        // workbook=new HSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
        return null;
    }

    public HashMap<String,Object> readSheet1(String sheetName) throws Exception {

        File file = new File(path);
        fis = new FileInputStream(file);

        // Below API can ready both xls and xlsx formats
        workbook = WorkbookFactory.create(fis);

        // Below API only ready xls formats
        // workbook=new HSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
        return null;
    }

    public String getDataFromExcel(String rowName, String colName) throws IOException {
        int dataRowNum = -1;
        int dataColNum = -1;
        //String retVal = null;
        int totalRows = sheet.getLastRowNum();
        int totalCols = sheet.getRow(0).getPhysicalNumberOfCells();
        for (int i = 0; i <= totalRows; i++) {
            if (sheet.getRow(i).getCell(0).getStringCellValue().equals(rowName)) {
                dataRowNum = i;
                break;
            }

        }
        for (int j = 0; j <= totalCols; j++) {
            if (sheet.getRow(0).getCell(j).getStringCellValue().equals(colName)) {
                dataColNum = j;
                break;
            }
        }
        // String body=sheet.getRow(dataRowNum).getCell(dataColNum).getStringCellValue();
        // fis.close();
        // return body;

        DataFormatter formatter = new DataFormatter(); // creating formatter using the default locale
        Cell cell = sheet.getRow(dataRowNum).getCell(dataColNum);
        String retVal1 = formatter.formatCellValue(cell); // Returns the formatted value of a cell as a String
        // regardless of the cell type.
        fis.close();
        return retVal1;
    }

    public String getDataFromExcelPost(String rowName, String colName) throws IOException {
        int dataRowNum = -1;
        int dataColNum = -1;
        int totalRows = sheet.getLastRowNum();
        int totalCols = sheet.getRow(0).getPhysicalNumberOfCells();
        for (int i = 0; i <= totalRows; i++) {
            if (sheet.getRow(i).getCell(0).getStringCellValue().equals(rowName)) {
                dataRowNum = i;
                break;
            }

        }
        for (int j = 0; j <= totalCols; j++) {
            if (sheet.getRow(0).getCell(j).getStringCellValue().equals(colName)) {
                dataColNum = j;
                break;
            }
        }
        String body=sheet.getRow(dataRowNum).getCell(dataColNum).getStringCellValue();
        fis.close();
        return body;

    }

}
