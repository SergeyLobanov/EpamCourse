package task2;

/**
 * Created by Сергей on 21.05.2016.
 */
public class HyperbolicWork {
    public static void main(String[] args) {
        HyperbolicFunction hf = new HyperbolicFunction(2, Math.sqrt(5));
        System.out.println(hf.getXbyY(5));
        System.out.println(hf.getYbyX(10));
        System.out.println(hf);
        System.out.println(hf.getFocus1());
        Point focus = new Point(3, 0);
        HyperbolicFunction hf1 = new HyperbolicFunction(focus, 1.5);
        System.out.println(hf.equals(hf1));
        HyperbolicFunction hf2 = hf1.clone();
        hf1.getFocus1().setX(5);
        System.out.println(hf1);
        System.out.println(hf2);
    }
}
