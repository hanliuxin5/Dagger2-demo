package dagger2.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.lychee.jtest.R;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import dagger2.di.annotation.qualifier.Net3;
import dagger2.hulk.Boss;
import dagger2.hulk.LogUtil;
import dagger2.hulk.NetWorkUtil;

public class Lychee4Activity extends AppCompatActivity implements HasSupportFragmentInjector {


    private static final String TAG = "Lychee3Activity";
    @Inject
    DispatchingAndroidInjector<Fragment> fragmentInjector;

    @Inject
    @Net3
    NetWorkUtil netWorkUtil;
    @Inject
    @Net3
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
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
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

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentInjector;
    }
}
