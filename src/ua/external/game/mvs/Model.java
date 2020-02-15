package ua.external.game.mvs;
import java.util.ArrayList;
import java.util.List;

public class Model implements GlobalConstants {
    private int secretValue;
    private int min_limit ;
    private int max_limit ;
    private List<Integer> userValue = new ArrayList<Integer>();

    public boolean checkValue (int value){
        userValue.add(value);
        if (value == secretValue){
            return true;
        } else if (value > secretValue){
            max_limit = value;
        } else {
            min_limit = value;
        }
        return false;
    }

    public void setPrimaryLimit(int max_limit ,int min_limit) {
        this.max_limit = max_limit;
        this.min_limit = min_limit;
    }
    public void setSecretValue() {
        this.secretValue = (int) Math.ceil(Math.random()*(max_limit
                - min_limit - 1) + min_limit);
    }
    public int getSecretValue() {
        return secretValue;
    }
    public int getMin_limit() {
        return min_limit;
    }
    public int getMax_limit() {
        return max_limit;
    }

    public List<Integer> getUserValue() {
        return userValue;
    }

    public Model() {
    }


}

