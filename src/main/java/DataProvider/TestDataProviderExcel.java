package DataProvider;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Parikshith on 3/1/2017.
 * Reads data from excel sheet
 */
public class TestDataProviderExcel {

    private String testDataFilePath;
    private FileInputStream fileInputStream;
    private XSSFWorkbook xssfWorkbook;
    private XSSFSheet xssfSheet;
    DataFormatter formatter = new DataFormatter(); //creating formatter using the default locale
    Cell cell = null;

    public TestDataProviderExcel(String testDataFilePath) throws IOException {
        this.testDataFilePath = testDataFilePath;
        fileInputStream = new FileInputStream(this.testDataFilePath);
        xssfWorkbook = new XSSFWorkbook(fileInputStream);
        xssfSheet = xssfWorkbook.getSheet("testdata");
    }

    private String getData(String testCaseName, String keyName){

        int lastRow = xssfSheet.getLastRowNum();
        String data = null;
        for (int i=1;i<=lastRow;i++){
            String testName = xssfSheet.getRow(i).getCell(0).getStringCellValue();
            if(testName.equalsIgnoreCase(testCaseName)){
                int j=0;
                String colName = xssfSheet.getRow(0).getCell(j).getStringCellValue();
                while(!colName.isEmpty()){
                    colName = xssfSheet.getRow(0).getCell(j).getStringCellValue();
                    if(colName.equalsIgnoreCase(keyName)){
                        cell = xssfSheet.getRow(i).getCell(j);
                        data = formatter.formatCellValue(cell);
                        break;
                    }
                    j++;
                }
                break;
            }
        }
        return data;
    }

    public String getUserName(String testCaseName){
        return getData(testCaseName,"Username");
    }

    public String getPassword(String testCaseName){
        return getData(testCaseName,"Password");
    }

    public String getFirstName(String testCaseName){
        return getData(testCaseName,"First Name");
    }

    public String getLastName(String testCaseName){
        return getData(testCaseName,"Last Name");
    }

    public String getEmail(String testCaseName){
        return getData(testCaseName,"Email");
    }

    public String getProductName(String testCaseName){
        return getData(testCaseName,"Product Name");
    }

    public String getProductID(String testCaseName){
        return getData(testCaseName,"Product ID");
    }

    public int getPrice(String testCaseName){
        return Integer.parseInt(getData(testCaseName,"Price"));
    }

    public String getTestData(String testCaseName,String keyName){
        return getData(testCaseName,keyName);
    }

    public void closeTestDataSheet(){
        /*try {
            xssfWorkbook.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

}
