package dagger2_subcomponent;

import dagger.Module;
import dagger.Provides;
import dagger2_subcomponent.scope.*;

/**
 * Created by lychee on 17-6-30.
 */
@Module
public class Sub2Module {

    @Provides
    @App1
    static Kim providesKim() {
        return new Kim("kim");
    }
}
