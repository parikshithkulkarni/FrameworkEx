package Factories;

import DataProvider.*;

import java.io.IOException;

/**
 * Created by Parikshith on 3/2/2017.
 *
 * Creates and maintains a single instance of runconfigurationreader across the tests/framework
 */
public class DataProviderFactory {

    private static RunConfigReader runConfigReader = null;
    private static TestDataProviderExcel testDataProviderExcel = null;
    private static String runConfigFilePath = "framework.properties";
    private static String testDataExcelPath = "test_data.xlsx";

    public static RunConfigReader getRunConfigReader(){

        if(runConfigReader == null){

            try {
                runConfigReader = new RunConfigReader(runConfigFilePath);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Not able to create run config reader Exception ->"+e.getMessage());
            }
        }
        return runConfigReader;
    }

    public static TestDataProviderExcel getTestDataProviderExcel(){

        if(testDataProviderExcel == null){

            try {
                testDataProviderExcel = new TestDataProviderExcel(testDataExcelPath);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Not able to create test data provider Exception ->"+e.getMessage());
            }
        }
        return testDataProviderExcel;
    }

}
