package ua.external.game.mvs;

public class View {
    public static final String WRONG_INPUT_DATA ="Wrong input! Repeat please! ";
    public static final String ATTEMPT= "Attempt number  ";
    public static final String VALUE_LESS = " is less then unknown number";
    public static final String VALUE_MORE = " is more then unknown number";
    public static final String WIN_FIRST_ATTEMPT = "Congratulation you win with first attempt :)";
    public static final String Lose = "Sorry, you lose :(\nYou use all attempts";
    public void printMessage(String message){
        System.out.println(message);
    }
    public void printWelcome(int min_limit, int max_limit){
        System.out.println("Welcome to the Java Game");
        System.out.println("Guess the integer between " + min_limit + " and " + max_limit);
    }
    public void inputInteger(int min_limit, int max_limit){
        System.out.println("Input the integer please between " + min_limit + " and " + max_limit);
    }
    public void printWin(int integer) {
        System.out.println("Congratulation you win :)\nYou use "+ integer + " attempts");
    }
}
