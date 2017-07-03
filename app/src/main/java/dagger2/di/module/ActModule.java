package dagger2.di.module;

import android.content.Context;


import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import dagger2.di.annotation.qualifier.App;
import dagger2.di.annotation.qualifier.Net3;
import dagger2.di.annotation.scope.PerActivity;
import dagger2.hulk.Boss;
import dagger2.hulk.NetWorkUtil;

/**
 * Created by lychee on 17-7-1.
 */
@Module
public class ActModule {


    @Provides
    @PerActivity
    @Net3
    static NetWorkUtil providesNetWork3(@App Context context) {
        NetWorkUtil netWorkUtil = new NetWorkUtil(context);
        netWorkUtil.setResult("network3");
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
