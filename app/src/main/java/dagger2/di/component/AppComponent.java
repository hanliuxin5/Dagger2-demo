package dagger2.di.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger2.MyApplication;
import dagger2.di.annotation.qualifier.App;
import dagger2.di.annotation.qualifier.Net1;
import dagger2.di.annotation.qualifier.Net2;
import dagger2.di.annotation.scope.PerActivity;
import dagger2.di.annotation.scope.PerFragment;
import dagger2.di.module.AppModule;
import dagger2.hulk.LogUtil;
import dagger2.hulk.NetWorkUtil;

/**
 * Created by lychee on 17-6-30.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder AppContent(@App Application application);

        AppComponent build();
    }

    @App
    Application application();

    @Net1
    NetWorkUtil netWork1();

    LogUtil logUtil();

//    ActSubComponent plusAct();

//    FragmentSubComponent plusFragment();

    void inject(MyApplication application);
}
