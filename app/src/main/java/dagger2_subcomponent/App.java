package dagger2_subcomponent;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

import dagger.Subcomponent;

/**
 * Created by lychee on 17-6-30.
 */

public class App {


    @Inject
    public Lychee lychee;

    @Inject
    public Emma emma;

    public App() {
        DaggerMainComponent.builder()
                .userName("lychee")
                .build()
                .plus()
                .inject(this);
    }

}
