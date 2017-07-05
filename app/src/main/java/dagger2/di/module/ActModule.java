package dagger2.di.module;

import android.app.Application;
import android.content.Context;


import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import dagger2.di.annotation.qualifier.Act;
import dagger2.di.annotation.qualifier.App;
import dagger2.di.annotation.qualifier.Net2;
import dagger2.di.annotation.qualifier.Net3;
import dagger2.di.annotation.scope.PerActivity;
import dagger2.hulk.Boss;
import dagger2.hulk.NetWorkUtil;

/**
 * Created by lychee on 17-7-1.
 */
@Module
public class ActModule {
//    private final Context context;
//
//    public ActModule(Context context) {
//
//        this.context = context;
//    }
//
//    @Provides
//    @Act
//    Context context() {
//        return context;
//    }

    @Provides
    @PerActivity
    @Net2
    static NetWorkUtil providesNetWork2(@Act Context context) {
        NetWorkUtil<Context> netWorkUtil = new NetWorkUtil<>(context);
        netWorkUtil.setResult("network2");
        return netWorkUtil;
    }

    @Provides
    @PerActivity
    @Named("boss1")
    static Boss providesBoss() {
        Boss boss = new Boss();
        boss.setAge("" + Math.random() * 26);
        return boss;
    }

    @Provides
    @Named("boss2")
    static Boss providesBoss2() {
        Boss boss = new Boss();
        boss.setAge("" + Math.random() * 26);
        return boss;
    }

}
