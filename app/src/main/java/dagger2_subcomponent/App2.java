package dagger2_subcomponent;

import javax.inject.Inject;

/**
 * Created by lychee on 17-6-30.
 */

public class App2 {


    @Inject
    public Lychee lychee;
    @Inject
    public Lychee lychee2;

    @Inject
    public Kim kim;
    @Inject
    public Kim kim2;

    public App2() {
        DaggerTestComponent.builder()
                .plusAppComponent(DaggerMainComponent.builder().userName("sss").build())
                .build()
                .inject(this);
    }

}
