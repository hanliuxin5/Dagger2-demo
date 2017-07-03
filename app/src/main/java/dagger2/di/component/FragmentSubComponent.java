package dagger2.di.component;

import dagger.Subcomponent;
import dagger2.di.annotation.scope.PerFragment;
import dagger2.di.module.FragmentModule;
import dagger2.ui.Lychee3Fragment;
import dagger2.ui.Lychee4Fragment;

/**
 * Created by lychee on 17-7-1.FragmentSubComponent
 */
@PerFragment
@Subcomponent(modules = FragmentModule.class)
public interface FragmentSubComponent {


//    void inject(Lychee3Fragment activity);

    void inject(Lychee4Fragment activity);
}