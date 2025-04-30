package com.LowLevelDesign.SystemDesign.Design.BehaviouralDesignPattern.ChainOfResponsibility;

public class ChainOfResp {
    public static void main(String[] args) {
LogProcessor logProcessor = new InfoLogProcessor(
        new DebugLogProcessor(
                new ErrorLogProcessor(null)));

logProcessor.log(LogProcessor.ERROR , "Exeception happen");
logProcessor.log(LogProcessor.DEBUG , "Need to debug this");
logProcessor.log(LogProcessor.INFO , "Just for info");
    }
}

abstract class LogProcessor{
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    LogProcessor nextLoggerProcessor;

    LogProcessor(LogProcessor logProcessor){
        this.nextLoggerProcessor = logProcessor;
    }

    public  void log(int logLevel , String message){
        if(nextLoggerProcessor != null){
            nextLoggerProcessor.log(logLevel, message);
        }
    }

}
class InfoLogProcessor extends LogProcessor{

    InfoLogProcessor(LogProcessor nextLoggerProcessor) {
        super(nextLoggerProcessor);
    }

    public  void log(int logLevel, String message){
        if (logLevel == INFO){
            System.out.println("INFO: " + message);
        }
        else super.log(logLevel,message);
    }
}

class ErrorLogProcessor extends LogProcessor{

    ErrorLogProcessor(LogProcessor logProcessor) {
        super(logProcessor);
    }

    public void log(int logLevel, String message){
        if (logLevel == ERROR) {
            System.out.println("ERROR: " + message);
        } else {
            super.log(logLevel, message);
        }
    }
}

class DebugLogProcessor extends LogProcessor{

    DebugLogProcessor(LogProcessor logProcessor) {
        super(logProcessor);
    }

    public void log(int logLevel, String message){
        if (logLevel == DEBUG) {
            System.out.println("DEBUG: " + message);
        } else {
            super.log(logLevel, message);
        }
    }
}