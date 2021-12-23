package com.example.bytlogutil;

import android.util.Log;



/**
 * The Class LogUtils for log printing, which help us
 * easy to trace our codes or logics in the project .
 *
 * @author zhouzhihao
 * @time 2021.12.17
 */
public class BytLogUtil {

    private final static int VERBOSE = 0;
    private final static int DEBUG = 1;
    private final static int INFO = 2;
    private final static int WARN = 3;
    private final static int ERROR = 4;
    private final static int DEFAULT_LEVEL = -1;

    private static boolean isAble= true;
    private static int level;

    private static final String TAG = "LogUtils";


    public static void setIsAble(boolean isAble) {
        BytLogUtil.isAble = isAble;
    }

    public static boolean isIsAble() {
        return isAble;
    }

    public static void verbose(String message) {
        StackTraceElement[] traceElements = Thread.currentThread().getStackTrace();
        log(message,traceElements,VERBOSE);
    }

    public static void debug(String message) {
        StackTraceElement[] traceElements = Thread.currentThread().getStackTrace();
        log(message,traceElements, DEBUG);
    }

    public  static void info(String message) {
        StackTraceElement[] traceElements = Thread.currentThread().getStackTrace();
        log(message, traceElements,INFO);
    }

    public static void warn(String message) {
        StackTraceElement[] traceElements = Thread.currentThread().getStackTrace();
        log(message, traceElements,WARN);
    }

    public  static void error(String message) {
        StackTraceElement[] traceElements = Thread.currentThread().getStackTrace();
        log(message, traceElements,ERROR);
    }




    private static void log(String msg, StackTraceElement[] traceElements ,int type) {
        if(type<level||!isAble){
            return;
        }

        StackTraceElement element = traceElements[3];
        switch (type){
            case VERBOSE:
                Log.v(TAG, "(" + element.getFileName() + ":" + element.getLineNumber() + "):>>> " + msg);
                break;
            case INFO:
                Log.i(TAG, "(" + element.getFileName() + ":" + element.getLineNumber() + "):>>> " + msg);
                break;
            case DEBUG:
                Log.d(TAG, "(" + element.getFileName() + ":" + element.getLineNumber() + "):>>> " + msg);
                break;
            case WARN:
                Log.w(TAG, "(" + element.getFileName() + ":" + element.getLineNumber() + "):>>> " + msg);
                break;
            case ERROR:
                Log.e(TAG, "(" + element.getFileName() + ":" + element.getLineNumber() + "):>>> " + msg);
                break;

            default:
                break;
        }
    }
}