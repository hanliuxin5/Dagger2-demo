package dagger2_subcomponent;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lychee on 17-6-30.
 */
@Module
public class SubModule {

    @Provides
    static Emma providesEmma(){
        return new Emma("emma");
    }
}
