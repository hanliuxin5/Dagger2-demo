package dagger2.di.component;

import android.content.Context;

import dagger.BindsInstance;
import dagger.Component;
import dagger.Subcomponent;
import dagger2.MainActivity;
import dagger2.di.annotation.qualifier.Act;
import dagger2.di.annotation.scope.PerActivity;
import dagger2.di.module.ActModule;
import dagger2.ui.Lychee1Activity;
import dagger2.ui.Lychee2Activity;
import dagger2.ui.Lychee3Activity;
import dagger2.ui.Lychee3Fragment;
import dagger2.ui.Lychee4Activity;

/**
 * Created by lychee on 17-7-1.
 */
@PerActivity
@Component(modules = ActModule.class, dependencies = AppComponent.class)
public interface ActSubComponent {
//    @Component.Builder
//    interface Builder {
////        @BindsInstance
////        Builder ActContext(@Act String age);
//
//        Builder actModule(ActModule actModule);
//
//        ActSubComponent build();
//    }

    @Act
    Context context();

    FragmentSubComponent plusFragment();

    void inject(MainActivity activity);

    void inject(Lychee1Activity activity);

    void inject(Lychee2Activity activity);

    void inject(Lychee3Activity activity);

    void inject(Lychee3Fragment activity);


    void inject(Lychee4Activity activity);

}
