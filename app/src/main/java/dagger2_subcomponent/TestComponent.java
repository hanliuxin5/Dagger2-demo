package dagger2_subcomponent;



import dagger.Component;
import dagger2_subcomponent.scope.App1;

/**
 * Created by lychee on 17-7-13.
 */
@App1
@Component(dependencies = {MainComponent.class},modules = Sub2Module.class)
public interface TestComponent {
    @Component.Builder
    interface Builder {

        Builder plusAppComponent(MainComponent mainComponent);


        TestComponent build();
    }


    void inject(App2 app2);

}
