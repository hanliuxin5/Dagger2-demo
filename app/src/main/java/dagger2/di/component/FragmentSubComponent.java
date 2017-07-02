package dagger2.di.component;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger2.di.annotation.scope.PerFragment;
import dagger2.di.module.FragmentModule;
import dagger2.ui.Lychee3Fragment;

/**
 * Created by lychee on 17-7-1.FragmentSubComponent
 */
@PerFragment
@Subcomponent(modules = FragmentModule.class)
public interface FragmentSubComponent extends AndroidInjector<Lychee3Fragment> {
    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<Lychee3Fragment> {
    }
}