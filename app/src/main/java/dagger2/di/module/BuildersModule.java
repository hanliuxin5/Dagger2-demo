package dagger2.di.module;

import android.app.Activity;
import android.support.v4.app.Fragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;
import dagger2.MainActivity;
import dagger2.di.annotation.scope.PerActivity;
import dagger2.di.annotation.scope.PerFragment;
import dagger2.di.component.ActSubComponent;
import dagger2.di.component.FragmentSubComponent;
import dagger2.di.module.ActModule;
import dagger2.di.module.FragmentModule;
import dagger2.ui.Lychee1Activity;
import dagger2.ui.Lychee2Activity;
import dagger2.ui.Lychee3Activity;
import dagger2.ui.Lychee3Fragment;
import dagger2.ui.Lychee4Activity;
import dagger2.ui.Lychee4Fragment;

/**
 * Created by lychee on 17-7-1.
 */
@Module(subcomponents = {ActSubComponent.class, FragmentSubComponent.class})
public abstract class BuildersModule {
    @ContributesAndroidInjector
    abstract MainActivity mainActivity();

    @ContributesAndroidInjector
    abstract Lychee1Activity lycheeActivity();

    @ContributesAndroidInjector
    abstract Lychee2Activity lychee2Activity();

    @Binds
    @IntoMap
    @ActivityKey(Lychee3Activity.class)
    abstract AndroidInjector.Factory<? extends Activity> lychee3Activity(ActSubComponent.Builder builder);

    @PerActivity
    @ContributesAndroidInjector(modules = ActModule.class)
    abstract Lychee4Activity lychee4Activity();


    @Binds
    @IntoMap
    @FragmentKey(Lychee3Fragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> lychee3Fragment(FragmentSubComponent.Builder builder);

    @PerFragment
    @ContributesAndroidInjector(modules = FragmentModule.class)
    abstract Lychee4Fragment lychee4Fragment();
}
