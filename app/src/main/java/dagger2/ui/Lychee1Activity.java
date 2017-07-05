package dagger2.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.lychee.jtest.R;

import javax.inject.Inject;

import dagger2.MyApplication;
import dagger2.di.annotation.qualifier.Net1;
import dagger2.di.annotation.qualifier.Net2;
import dagger2.di.component.DaggerActComponent;
import dagger2.di.module.ActModule;
import dagger2.hulk.Jedi;
import dagger2.hulk.LogUtil;
import dagger2.hulk.NetWorkUtil;

public class Lychee1Activity extends AppCompatActivity {

    private static final String TAG = "Lychee1Activity";

    @Inject
    @Net1
    NetWorkUtil netWorkUtil;
    @Inject
    LogUtil logUtil;
    @Inject
    Jedi jedi1;
    @Inject
    Jedi jedi2;

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        MyApplication.getAppComponent().plusAct().inject(this);
//        DaggerActSubComponent.builder()
//                .appComponent(MyApplication.getAppComponent())
//                .actModule(new ActModule(this))
//                .build()
//                .inject(this);
        DaggerActComponent.builder()
                .appComponent(MyApplication.getAppComponent())
                .ActContext(this)
                .build()
                .inject(this);
        setContentView(R.layout.activity_lychee1);

        setTitle(TAG);

        tv = (TextView) findViewById(R.id.textView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        tv.setText(String.format("%s , %s , %s\n%s , %s\n%s , %s",
                netWorkUtil, netWorkUtil.getResult(), netWorkUtil.getContext(),
                logUtil, logUtil.getMsg(),
                jedi1, jedi2));
    }

}
