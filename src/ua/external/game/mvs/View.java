package ua.external.game.mvs;
import java.util.Locale;
import java.util.ResourceBundle;

public class View {

    static String MESSAGES_BUNDLE_NAME = "property.messages";
    public static final ResourceBundle bundle =
            ResourceBundle.getBundle(
                    MESSAGES_BUNDLE_NAME,
                    new Locale("uk", "UA"));  // Ukrainian
                    //new Locale("en", "US"));        // English


    // Text's constants
    public static final String EQUAL_SING = "=";
    public static final String SPACE_SING = " ";
    public static final String OPENS_SQUARE_BRACKET = "[";
    public static final String CLOSING_SQUARE_BRACKET = "]";

    public static final String FROM = "string.from";
    public static final String TILL = "string.till";
    public static final String GAME_STORY = "finish.story";
    public static final String WELCOME = "start.welcome";
    public static final String INPUT_INT_DATA = "input.data";
    public static final String WRONG_INPUT_DATA ="input.wrong";
    public static final String VALUE_LESS = " is less then unknown number";
    public static final String VALUE_MORE = " is more then unknown number";
    public static final String WIN ="finish.win";


    public void printMessage(String message){
        System.out.println(message);
    }

    public void printWelcome(){
        printMessage(bundle.getString(WELCOME));
    }

    private String concatenationString(String... message){
        StringBuilder concatString = new StringBuilder();
        for(String v : message) {
            concatString = concatString.append(v);
        }
        return new String(concatString);
    }

    String getInputMessage(int min_limit , int max_limit) {
        String str = concatenationString(bundle.getString(INPUT_INT_DATA),
                SPACE_SING, bundle.getString(FROM),SPACE_SING,
                String.valueOf(min_limit), SPACE_SING, bundle.getString(TILL),
                SPACE_SING, String.valueOf(max_limit), SPACE_SING, EQUAL_SING);
        return str;
    }

    public void wrongInput(){
            printMessage(bundle.getString(WRONG_INPUT_DATA));
    }

    public void printWin() {
        printMessage(bundle.getString(WIN));
    }
    void printStory(Model modelImplementation) {
        printMessage(bundle.getString(GAME_STORY ) +
                String.valueOf(modelImplementation.getUserValue()));
    }
}


