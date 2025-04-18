package commonutils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

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


}
