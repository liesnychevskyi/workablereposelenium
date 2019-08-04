package core.helper.excel;

import core.helper.logger.MyLogger;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

public class ExcelHelper
{
    private Logger log = MyLogger.getLogger(ExcelHelper.class);
    //========================================================//
    public Object[][] getExcelData(String excelLocation, String sheetName)
    {
        try
        {
            Object dataSets[][] = null;
            FileInputStream file = new FileInputStream(new File(excelLocation));
            //Create workbook instance
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            //Get sheet name from Workbook
            XSSFSheet sheet = workbook.getSheet(sheetName);
            //Count number of active rows in excel sheet
            int totalRow = sheet.getLastRowNum();
            //Count active columns in row
            int totalColumn = sheet.getRow(0).getLastCellNum();
            dataSets = new Object[totalRow][totalColumn];
            //Iterate through each Row one by one
            Iterator<Row> rowIterator = sheet.iterator();
            int i = 0;
            while (rowIterator.hasNext())
            {
                i++;
                //for every row, we need to iterate over columns
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                int j = 0;
                while (cellIterator.hasNext())
                {
                    j++;
                    Cell cell = cellIterator.next();

                    switch(cell.getCellTypeEnum())
                    {
                        case STRING:
                            dataSets[i][j++] = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            dataSets[i][j++] = cell.getNumericCellValue();
                            break;
                        case BOOLEAN:
                            dataSets[i][j++] = cell.getBooleanCellValue();
                            break;
                        case FORMULA:
                            dataSets[i][j++] = cell.getCellFormula();
                            break;

                        default:
                            System.out.println("No matching DATA TYPE FOUND..");
                            break;

                    }
                }
            }
            return dataSets;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //========================================================//
    //========================================================//
    //========================================================//
    //========================================================//
    //========================================================//
}
