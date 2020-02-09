package ua.external.game.mvs;
public class Model {
    private int value;
    private int rand = (int) ( Math.random() * 101  );
    private int min_limit = 0;
    private int max_limit = 100;
    private int attempt = 10;
    public int getAttempt() {
        return attempt;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public int getRand() {
        return rand;
    }
    public int getMin_limit() {
        return min_limit;
    }
    public void setMin_limit(int min_limit) {
        this.min_limit = min_limit;
    }
    public int getMax_limit() {
        return max_limit;
    }
    public void setMax_limit(int max_limit) {
        this.max_limit = max_limit;
    }
    public Model() {
    }
}

