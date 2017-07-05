package dagger2.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lychee.jtest.R;

import javax.inject.Inject;
import javax.inject.Named;

import dagger2.MyApplication;
import dagger2.di.annotation.qualifier.Net2;
import dagger2.di.annotation.qualifier.Net3;
//import dagger2.di.component.DaggerActSubComponent;
import dagger2.di.module.ActModule;
import dagger2.hulk.Boss;
import dagger2.hulk.LogUtil;
import dagger2.hulk.NetWorkUtil;

/**
 * Created by lychee on 17-7-1.
 */

public class Lychee3Fragment extends Fragment {

    @Inject
    @Net2
    NetWorkUtil netWorkUtil;
    @Inject
    @Net2
    NetWorkUtil netWorkUtil2;
    @Inject
    LogUtil logUtil;
    @Inject
    @Named("boss2")
    Boss boss;

    TextView tv;

    public Lychee3Fragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Lychee3Activity context1 = (Lychee3Activity) context;
        context1.getComponent().inject(this);
//        MyApplication.getAppComponent().plusFragment().inject(this);
//        DaggerActSubComponent.builder()
//                .appComponent(MyApplication.getAppComponent())
//                .actModule(new ActModule(context))
//                .build()
//                .plusFragment()
//                .inject(this);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lychee, container, false);
        tv = (TextView) view.findViewById(R.id.info);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        tv.setText(String.format("%s , %s\n%s , %s\n%s\n%s\n%s",
                netWorkUtil, netWorkUtil.getResult(),
                netWorkUtil2, netWorkUtil2.getResult(),
                logUtil, logUtil.getMsg(),
                boss.getAge()));
    }
}
