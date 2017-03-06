package Reporter;

import org.openqa.selenium.TakesScreenshot;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Parikshith on 3/4/2017.
 */
public class TextReporter {

    private BufferedWriter bufferedWriter = null;
    private FileWriter fileWriter = null;
    private File file = null;

    public TextReporter(){

        String fileName = (new Date()).toString().trim().replace("/","_").replace(":","_").replace("-","_")+".txt";
        file = new File(fileName);
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void log(String logInfo){
        try {
            bufferedWriter.write(logInfo+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void debug(String debugInfo){
        try {
            bufferedWriter.write(debugInfo+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void warn(String warInfo){
        try {
            bufferedWriter.write(warInfo+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void error(String errorInfo){
        try {
            bufferedWriter.write(errorInfo+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startTest(String testCaseName){

        try {
            bufferedWriter.write("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            bufferedWriter.write("+++++++++++++++++++++++ Start Test"+testCaseName+"++++++++++++++");
            bufferedWriter.write("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void stopTest(String testCaseName){

        try {
            bufferedWriter.write("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            bufferedWriter.write("+++++++++++++++++++++++ Stop Test"+testCaseName+"++++++++++++++");
            bufferedWriter.write("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void startSuite(String testSuiteName){

        try {
            bufferedWriter.write("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            bufferedWriter.write("+++++++++++++++++++++++ Stop Suite"+testSuiteName+"++++++++++++++");
            bufferedWriter.write("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void stopSuite(String testSuiteName){

        try {
            bufferedWriter.write("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            bufferedWriter.write("+++++++++++++++++++++++ Stop Suite"+testSuiteName+"++++++++++++++");
            bufferedWriter.write("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void stopLogging(){
        try {
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
