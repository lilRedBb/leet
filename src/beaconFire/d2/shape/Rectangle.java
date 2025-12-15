package beaconFire.d2.shape;

public class Rectangle extends Shape{
    Rectangle(int a, int b) {
        super(a, b);
    }

    @Override
    void printArea() {
        System.out.println((height*width)/2);
    }
}
