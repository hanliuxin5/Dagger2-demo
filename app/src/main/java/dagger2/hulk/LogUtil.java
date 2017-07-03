package dagger2.hulk;

import android.app.Application;
import android.content.Context;

/**
 * Created by lychee on 17-7-1.
 */

public class LogUtil {
    private String msg;
    private Application context;


    public LogUtil(Application context) {
        this.context = context;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
