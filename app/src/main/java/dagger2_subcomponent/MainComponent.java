package dagger2_subcomponent;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

/**
 * Created by lychee on 17-6-30.
 */
@Singleton
@Component(modules = MainModule.class)
public interface MainComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder userName(String name);

        MainComponent build();
    }

    Lychee getLychee();

    SubComponent plus();


}
