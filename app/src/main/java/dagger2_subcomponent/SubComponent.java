package dagger2_subcomponent;

import dagger.Subcomponent;

/**
 * Created by lychee on 17-6-30.
 */
@Subcomponent(modules = SubModule.class)
public interface SubComponent {

//
//    @Subcomponent.Builder
//    interface Builder {
//
//        SubComponent build();
//    }
    void inject(App act);

}
