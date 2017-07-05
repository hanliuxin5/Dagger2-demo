package dagger2.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.lychee.jtest.R;

import javax.inject.Inject;
import javax.inject.Named;

import dagger2.MyApplication;
import dagger2.di.annotation.qualifier.Net2;
import dagger2.di.annotation.qualifier.Net3;
import dagger2.di.component.DaggerActComponent;
import dagger2.di.module.ActModule;
import dagger2.hulk.Boss;
import dagger2.hulk.LogUtil;
import dagger2.hulk.NetWorkUtil;

public class Lychee4Activity extends AppCompatActivity {


    private static final String TAG = "Lychee3Activity";

    @Inject
    @Net2
    NetWorkUtil netWorkUtil;
    @Inject
    @Net2
    NetWorkUtil netWorkUtil2;
    @Inject
    LogUtil logUtil;
    @Inject
    @Named("boss1")
    Boss boss;
    @Inject
    @Named("boss1")
    Boss boss2;
    @Inject
    @Named("boss2")
    Boss boss3;
    @Inject
    @Named("boss2")
    Boss boss4;

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
        FragmentManager manager = getSupportFragmentManager();
        if (savedInstanceState != null) {
            Fragment fragment = manager.findFragmentByTag("lychee");
            manager.beginTransaction()
                    .show(fragment)
                    .commit();
        } else {
            Lychee4Fragment fragment = new Lychee4Fragment();
            manager.beginTransaction()
                    .add(R.id.content, fragment, "lychee")
                    .commit();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        tv.setText(String.format("%s , %s\n%s , %s\n%s\n%s\n%s , %s\n%s , %s",
                netWorkUtil, netWorkUtil.getResult(),
                netWorkUtil2, netWorkUtil2.getResult(),
                logUtil, logUtil.getMsg(),
                boss.getAge(), boss2.getAge(),
                boss3.getAge(), boss4.getAge()));
    }

}
