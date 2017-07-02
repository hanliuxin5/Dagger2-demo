package dagger2.di.module;


import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger2.di.annotation.qualifier.App;
import dagger2.di.annotation.qualifier.Net1;
import dagger2.di.annotation.qualifier.Net2;
import dagger2.hulk.LogUtil;
import dagger2.hulk.NetWorkUtil;

/**
 * Created by lychee on 17-7-1.
 */
@Module
public class AppModule {

    @Provides
    @Singleton
    @Net1
    static NetWorkUtil providesNetWork1(@App Context context) {
        NetWorkUtil netWorkUtil = new NetWorkUtil(context);
        netWorkUtil.setResult("network1");
        return netWorkUtil;
    }

    @Provides
    @Singleton
    @Net2
    static NetWorkUtil providesNetWork2(@App Context context) {
        NetWorkUtil netWorkUtil = new NetWorkUtil(context);
        netWorkUtil.setResult("network2");
        return netWorkUtil;
    }

    @Provides
    @Singleton
    static LogUtil providesLog(@App Context context) {
        LogUtil logUtil = new LogUtil(context);
        logUtil.setMsg("im log");
        return logUtil;
    }

}
