package dagger2.hulk;

import android.content.Context;

/**
 * Created by lychee on 17-7-1.
 */

public class NetWorkUtil {

    private String result;
    private Context context;

    public NetWorkUtil(Context context) {
        this.context = context;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
