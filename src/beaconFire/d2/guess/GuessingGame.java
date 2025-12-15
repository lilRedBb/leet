package beaconFire.d2.guess;

public class GuessingGame {

    private int max;
    private  int maxGuessesAllowed;
    private int maxGuessesTaken;
    private boolean gameOver;
    private int differential = -1;
    private int answer;
    private Generator generator;

    private ResultEval resultEval;

    public GuessingGame() {
        generator = new Generator();
        resultEval = new ResultEval();
        setMax(0);
    }

    public GuessingGame(int max) {
        setMax(max);
        generator = new Generator();
        resultEval = new ResultEval();
    }


    public void newGame(int numberOfGuesses){
        setMaxGuessesAllowed(numberOfGuesses);
        setAnswer(generator.generate(getMax()));
        setGameOver(false);
        setDifferential(-1);
        setMaxGuessesTaken(0);

    }

    public boolean isGameOver(){return getGameOver();}

    public String guess(int guess){
        if (isGameOver()) {
            return "Game is already over. Start a new game.";
        }

        setMaxGuessesTaken(getMaxGuessesTaken()+1);

        if (getMaxGuessesTaken()>getMaxGuessesAllowed()){
            setGameOver(true);
            return "You have used all chances to guess";
        }
        if (guess>getMax() || guess<0) return "Your guess is out of range. The range is 0 to "+ getMax();

        int currentDiff = Math.abs(guess-getAnswer());
        String temperature = resultEval.evaluateWarmCold(getDifferential(),currentDiff);
        setDifferential(currentDiff);


        String rightOrWrong = resultEval.evaluateGuess(guess,getAnswer());

        return rightOrWrong+ "\n" +temperature;

    }

    public int getMax() {
        return max;
    }

    public int getMaxGuessesAllowed() {
        return maxGuessesAllowed;
    }

    public int getMaxGuessesTaken() {
        return maxGuessesTaken;
    }

    public boolean getGameOver() {

        return gameOver;
    }

    public int getDifferential() {
        return differential;
    }

    public int getAnswer() {
        return answer;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setMaxGuessesAllowed(int maxGuessesAllowed) {
        this.maxGuessesAllowed = maxGuessesAllowed;
    }

    public void setMaxGuessesTaken(int maxGuessesTaken) {
        this.maxGuessesTaken = maxGuessesTaken;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public void setDifferential(int differential) {
        this.differential = differential;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}
