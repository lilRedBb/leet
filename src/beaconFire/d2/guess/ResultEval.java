package beaconFire.d2.guess;

public class ResultEval {


    public String evaluateGuess(int guess, int answer) {
        if (guess > answer) {
            return "Too High";
        } else if (guess < answer) {
            return "Too Low";
        } else {
            return "Correct";
        }
    }


    public String evaluateWarmCold(int previousDiff, int currentDiff) {
        if (previousDiff == -1) {
            // First guess → no warm/cold feedback yet
            return "";
        }

        if (currentDiff < previousDiff) {
            return "Getting Warmer";
        } else if (currentDiff > previousDiff) {
            return "Getting Colder";
        } else {
            return "";
        }
    }
}
