package Factories;

import Reporter.TextReporter;

/**
 * Created by Parikshith on 3/4/2017.
 */
public class ReporterFactory {

    private static TextReporter textReporter = null;

    public static TextReporter getReporter(){

        if(textReporter==null){
            textReporter = new TextReporter();
        }
        return textReporter;
    }

}
