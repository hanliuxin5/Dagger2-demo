package dagger2.di.component;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger2.di.annotation.scope.PerActivity;
import dagger2.di.module.ActModule;
import dagger2.ui.Lychee3Activity;

/**
 * Created by lychee on 17-7-1.
 */
@PerActivity
@Subcomponent(modules = ActModule.class)
public interface ActSubComponent extends AndroidInjector<Lychee3Activity> {
    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<Lychee3Activity> {
    }
}
