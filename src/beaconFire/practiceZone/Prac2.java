package beaconFire.practiceZone;

public class Prac2 {

    private int value;

    public Prac2(int value){this.value = value;}

    public int intValue(){return value;}

    public short shortValue(){return (short)value;}

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
