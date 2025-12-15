package beaconFire.d2.shape;

abstract class Shape {
    int height;
    int width;
    Shape(int height, int width) {
        this.height = height;
        this.width = width;
    }

    Shape(int width) {
        this.height = width;
        this.width = width;
    }
    abstract void printArea();


}
