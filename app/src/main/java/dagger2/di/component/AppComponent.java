package dagger2.di.component;

import android.content.Context;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger2.MyApplication;
import dagger2.di.annotation.qualifier.App;
import dagger2.di.module.BuildersModule;
import dagger2.di.module.AppModule;

/**
 * Created by lychee on 17-6-30.
 */
@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class,
        BuildersModule.class})
public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder AppContent(@App Context context);

        AppComponent build();
    }

    void inject(MyApplication application);
}
