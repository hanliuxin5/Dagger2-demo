package dagger2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lychee.jtest.R;


import javax.inject.Inject;

import dagger2.di.annotation.qualifier.Net1;
import dagger2.di.annotation.qualifier.Net2;
import dagger2.di.annotation.qualifier.Net3;
import dagger2.di.component.ActComponent;
import dagger2.di.component.DaggerActComponent;
import dagger2.di.component.DaggerAppComponent;
import dagger2.di.module.ActModule;
import dagger2.hulk.Jedi;
import dagger2.hulk.LogUtil;
import dagger2.hulk.NetWorkUtil;
import dagger2.ui.Lychee1Activity;
import dagger2.ui.Lychee2Activity;
import dagger2.ui.Lychee3Activity;
import dagger2.ui.Lychee4Activity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Inject
    @Net2
    NetWorkUtil netWorkUtil;
    @Inject
    LogUtil logUtil;
    @Inject
    Jedi jedi;

    TextView tv;
    Button lychee1;
    Button lychee2;
    Button lychee3;
    Button lychee4;

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
        setContentView(R.layout.activity_main);

        setTitle(TAG);

        tv = (TextView) findViewById(R.id.textView);
        lychee1 = (Button) findViewById(R.id.lychee1);
        lychee2 = (Button) findViewById(R.id.lychee2);
        lychee3 = (Button) findViewById(R.id.lychee3);
        lychee4 = (Button) findViewById(R.id.lychee4);

        lychee1.setOnClickListener(clickListener);
        lychee2.setOnClickListener(clickListener);
        lychee3.setOnClickListener(clickListener);
        lychee4.setOnClickListener(clickListener);

    }


    @Override
    protected void onResume() {
        super.onResume();
        tv.setText(String.format("%s , %s , %s\n%s , %s\n%s",
                netWorkUtil, netWorkUtil.getResult(), netWorkUtil.getContext(),
                logUtil, logUtil.getMsg(),
                jedi));
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent;
            switch (v.getId()) {
                case R.id.lychee1:
                    intent = new Intent();
                    intent.setClass(MainActivity.this, Lychee1Activity.class);
                    startActivity(intent);
                    break;
                case R.id.lychee2:
                    intent = new Intent();
                    intent.setClass(MainActivity.this, Lychee2Activity.class);
                    startActivity(intent);
                    break;
                case R.id.lychee3:
                    intent = new Intent();
                    intent.setClass(MainActivity.this, Lychee3Activity.class);
                    startActivity(intent);
                    break;
                case R.id.lychee4:
                    intent = new Intent();
                    intent.setClass(MainActivity.this, Lychee4Activity.class);
                    startActivity(intent);
                    break;
            }
        }
    };

}
