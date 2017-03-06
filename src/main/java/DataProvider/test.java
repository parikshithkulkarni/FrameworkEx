package DataProvider;

import java.io.IOException;

/**
 * Created by Parikshith on 3/1/2017.
 */
public class test {

    public static void main(String[] args) {

        String filepath = "framework.properties";
        RunConfigReader runConfigReader = null;

        try {
            runConfigReader = new RunConfigReader(filepath);
        } catch (IOException e) {
            e.printStackTrace();

        }
        System.out.println("File Properties"+runConfigReader.getChromeServerPath());
        System.out.println("File Properties"+runConfigReader.getIEServerPath());
        System.out.println("File Properties"+runConfigReader.getBrowsers());
        System.out.println("File Properties"+runConfigReader.getHighlightElements());
        System.out.println("File Properties"+runConfigReader.getImplicitWait());
        System.out.println("File Properties"+runConfigReader.getPageLoadTimeout());
        System.out.println("File Properties"+runConfigReader.getScreenShotOnFailure());


        String excelData = "test_data.xlsx";
        TestDataProviderExcel testDataProviderExcel = null;

        try {
            testDataProviderExcel = new TestDataProviderExcel(excelData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Hey");

        System.out.println("Excel Data"+testDataProviderExcel.getEmail("Test001"));
        System.out.println("Excel Data"+testDataProviderExcel.getFirstName("Test002"));
        System.out.println("Excel Data"+testDataProviderExcel.getPassword("Test003"));
        System.out.println("Excel Data"+testDataProviderExcel.getPrice("Test004"));
        System.out.println("Excel Data"+testDataProviderExcel.getTestData("Test005","Product Name"));

    }

}
