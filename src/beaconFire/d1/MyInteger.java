package beaconFire.d1;

public class MyInteger {

    private int value;

    public MyInteger(int value){
        this.value = value;
    }

    public int intValue(){
        return value;
    }

    public short shortValue(){
        return (short) value;
    }

    public boolean equals(MyInteger other){
        return this.value == other.value;
    }

    public boolean equals(int other){
        return this.value == other;
    }

    @Override
    public String toString(){
        return String.valueOf(value);
    }

    public int compareTo(MyInteger other){
        return Integer.compare(this.value, other.value);
    }

    public float floatValue() {
        return (float) value;
    }



    public static void main(String[] args) {
        MyInteger a = new MyInteger(5);
        MyInteger b = new MyInteger(5);
        MyInteger c = new MyInteger(10);

        System.out.println(a.intValue());           // 5
        System.out.println(a.shortValue());         // 5
        System.out.println(a.floatValue());         //5.0

        System.out.println(a.equals(b));            // true
        System.out.println(a.equals(c));            // false
        System.out.println(a.equals(5));            // true
        System.out.println(a.equals(10));           // false

        System.out.println(a.compareTo(b));         // 0
        System.out.println(a.compareTo(c));         // -1
        System.out.println(c.compareTo(a));         // 1


    }


}
