package task4;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
	// write your code here
        Circle circle = new Circle(3, 2, 4);

        Circle circle1 = circle.clone();
        circle1.getCenterCircle().setX(12);
        System.out.println(circle);
        System.out.println(circle1);

        Rectangle rect = new Rectangle(2, 4, 5, 1);
        Rectangle rect1 = rect.clone();
        rect1.setRightBottom(new Point(20, 12));
        System.out.println(rect);
        System.out.println(rect1);
    }
}
