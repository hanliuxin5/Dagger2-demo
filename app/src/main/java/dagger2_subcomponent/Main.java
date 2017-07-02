package dagger2_subcomponent;

/**
 * Created by lychee on 17-6-30.
 */

public class Main {

    public static void main(String[] args) {
        App act = new App();
        System.out.println(act.lychee.getName());
        System.out.println(act.emma.getName());

    }
}
