package DataProvider;

import java.io.*;
import java.util.*;

import static java.util.Arrays.asList;

/**
 * Created by Parikshith on 3/1/2017.
 */
public class RunConfigReader {

    Properties properties;
    String fileName;

    public RunConfigReader(String propertyFilePath) throws IOException {
        this.fileName = propertyFilePath;
        FileInputStream fileInputStream= new FileInputStream(new File(fileName));
        properties = new Properties();
        properties.load(fileInputStream);
        fileInputStream.close();
    }

    public List<String> getBrowsers(){

        String browserTypes = properties.getProperty("browserType");
        return Arrays.asList(browserTypes.split(","));
    }

    public long getPageLoadTimeout(){
        return Long.parseLong(properties.getProperty("pageLoadTimeOut"));
    }

    public long getImplicitWait(){
        return Long.parseLong(properties.getProperty("implicitWait"));
    }

    public boolean getScreenShotOnFailure(){
        return Boolean.parseBoolean(properties.getProperty("screenShotFailure"));
    }

    public boolean getHighlightElements(){
        return Boolean.parseBoolean(properties.getProperty("highlightElements"));
    }

    public String getIEServerPath(){
        return properties.getProperty("IEServerPath");
    }

    public String getChromeServerPath(){
        return properties.getProperty("ChromeServerPath");
    }

    public List<String> getTestSuites(){
        String [] list = properties.getProperty("xmlSuites").split(",");
        List<String> suites = new ArrayList<String>();
        for(String suite: list){
            suites.add(suite.trim());
        }
        return suites;
    }
}
