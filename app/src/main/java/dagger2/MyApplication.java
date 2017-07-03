package dagger2;

import android.app.Application;

import dagger2.di.component.AppComponent;
import dagger2.di.component.DaggerAppComponent;
import dagger2.di.module.AppModule;


//import dagger2.di.component.DaggerAppComponent;

/**
 * Created by lychee on 17-6-30.
 */

public class MyApplication extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().AppContent(this).build();
        appComponent.inject(this);
//        DaggerAppComponent.builder().AppContent(this).build().inject(this);
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
