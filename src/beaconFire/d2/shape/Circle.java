package beaconFire.d2.shape;

public class Circle extends Shape{

    Circle(int a) {
        super(a);
    }

    @Override
    void printArea() {
        System.out.println(Math.PI*height*height);;
    }
}
