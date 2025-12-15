package beaconFire.d2.guess;
import java.util.Random;
public class Generator {


    private Random rand = new Random();

    public int generate(int max) {
        return rand.nextInt(max + 1);
    }



}
