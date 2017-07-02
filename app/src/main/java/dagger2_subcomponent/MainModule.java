package dagger2_subcomponent;

import javax.inject.Named;
import javax.inject.Provider;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created by lychee on 17-6-30.
 */
@Module
public class MainModule {


//    @Provides
//    static String providesName() {
//        return "hlx";
//    }

    @Provides
    static Lychee providesLychee(String name) {
        return new Lychee(name);
    }


//    @Named("emma")
//    @Provides
//    static Lychee providesLycheeEmma(Emma emma) {
////        SubComponent build = provider.get().build();
////        Emma emma = build.getEmma();
//        return new Lychee(emma.getName());
//    }
}
