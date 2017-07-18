package dagger2_subcomponent;

/**
 * Created by lychee on 17-6-30.
 */

public class Main {

    public static void main(String[] args) {
        App act = new App();
        System.out.println(act.lychee + "," + act.lychee.getName());
        System.out.println(act.lychee2 + "," + act.lychee2.getName());
        System.out.println(act.emma + "," + act.emma.getName());
        System.out.println(act.emma2 + "," + act.emma2.getName());


        App2 act2 = new App2();
        System.out.println(act2.lychee + "," + act2.lychee.getName());
        System.out.println(act2.lychee2 + "," + act2.lychee2.getName());
        System.out.println(act2.kim + "," + act2.kim.getName());
        System.out.println(act2.kim2 + "," + act2.kim2.getName());
//        System.out.println(act2.emma+","+act2.emma.getName());
    }
}
