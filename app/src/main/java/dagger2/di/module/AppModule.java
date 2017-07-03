package dagger2.di.module;


import android.app.Application;
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
//    private final Context mContext;
//
//    public AppModule(Context context) {
//        mContext = context;
//    }
//
//    @Provides
//    @Singleton
//    @App
//    Context providesContext() {
//        return mContext;
//    }

    @Provides
    @Singleton
    @Net1
    NetWorkUtil providesNetWork1(@App Application application) {
        NetWorkUtil<Application> netWorkUtil = new NetWorkUtil<>(application);
        netWorkUtil.setResult("network1");
        return netWorkUtil;
    }


    @Provides
    @Singleton
    LogUtil providesLog(@App Application application) {
        LogUtil logUtil = new LogUtil(application);
        logUtil.setMsg("im log");
        return logUtil;
    }

}
