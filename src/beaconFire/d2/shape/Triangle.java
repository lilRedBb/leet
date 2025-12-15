package beaconFire.d2.shape;

public class Triangle extends Shape{
    Triangle(int a, int b) {
        super(a, b);
    }

    @Override
    void printArea() {
        System.out.println(height*width);
    }
}
