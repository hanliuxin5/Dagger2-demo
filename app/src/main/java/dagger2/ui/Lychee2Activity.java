package dagger2.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.lychee.jtest.R;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger2.di.annotation.qualifier.Net1;
import dagger2.di.annotation.qualifier.Net2;
import dagger2.hulk.LogUtil;
import dagger2.hulk.NetWorkUtil;

public class Lychee2Activity extends AppCompatActivity {

    private static final String TAG = "Lychee2Activity";

    @Inject
    @Net2
    NetWorkUtil netWorkUtil;
    @Inject
    LogUtil logUtil;

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lychee1);

        setTitle(TAG);

        tv = (TextView) findViewById(R.id.textView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        tv.setText(String.format("%s , %s\n%s , %s",
                netWorkUtil, netWorkUtil.getResult(),
                logUtil, logUtil.getMsg()));
    }
}
