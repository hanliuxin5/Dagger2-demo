package dagger2.di.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger2.di.annotation.qualifier.Act;
import dagger2.di.annotation.qualifier.App;
import dagger2.di.annotation.qualifier.Net2;
import dagger2.di.annotation.qualifier.Net3;
import dagger2.di.annotation.scope.PerActivity;
import dagger2.di.annotation.scope.PerFragment;
import dagger2.hulk.Boss;
import dagger2.hulk.NetWorkUtil;

/**
 * Created by lychee on 17-7-1.
 */
@Module
public class FragmentModule {
    
    @Provides
    @PerFragment
    @Net3
    static NetWorkUtil providesNetWork3(@Act Context context) {
        NetWorkUtil<Context> netWorkUtil = new NetWorkUtil<>(context);
        netWorkUtil.setResult("network3");
        return netWorkUtil;
    }

    @Provides
    @PerFragment
    @Named("boss3")
    static Boss providesBoss() {
        Boss boss = new Boss();
        boss.setAge("" + Math.random() * 25);
        return boss;
    }

    @Provides
    @Named("boss4")
    static Boss providesBoss2() {
        Boss boss = new Boss();
        boss.setAge("" + Math.random() * 25);
        return boss;
    }
}
