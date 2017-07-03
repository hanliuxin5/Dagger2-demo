package dagger2.hulk;

import android.app.Application;
import android.content.Context;

/**
 * Created by lychee on 17-7-1.
 */

public class NetWorkUtil<T extends Context> {

    private String result;
    private T context;

    public NetWorkUtil(T context) {
        this.context = context;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getContext() {
        if (context instanceof Application) {
            return "application";
        }
        if (context != null) {
            return "context";
        }
        return "???";
    }
}
