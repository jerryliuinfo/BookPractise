package com.apache.book.framewok.aroute.facade.template;

/**
 * Created by Jerry on 2019/2/7.
 */
public interface ILogger {

    void showLog(boolean isShowLog);

    void showStackTrace(boolean isShowStackTrace);

    void debug(String tag, String message);

    void info(String tag, String message);

    void warning(String tag, String message);

    void error(String tag, String message);

    void monitor(String message);

    boolean isMonitorMode();

    String getDefaultTag();
}
