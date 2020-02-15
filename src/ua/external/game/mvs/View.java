package ua.external.game.mvs;
import java.util.Locale;
import java.util.ResourceBundle;

public class View {
// text for message
    public static final String MESSAGES_BUNDLE_NAME = "property.messages";
    public static final String CHOSE_LANGUAGE ="Chose language please:\n1 English\n2 Ukrainian";
    public static final String EQUAL_SING = "=";
    public static final String SPACE_SING = " ";
    public static final String FROM = "string.from";
    public static final String TILL = "string.till";
    public static final String GAME_STORY = "finish.story";
    public static final String WELCOME = "start.welcome";
    public static final String INPUT_INT_DATA = "input.data";
    public static final String WRONG_INPUT_DATA = "input.wrong";
    public static final String WRONG_INPUT_LANGUAGE = "Wrong input! Repeat please!";
    public static final String WIN = "finish.win";
    public ResourceBundle bundle;
//  view Language
    public void viewLanguage(int i){
         String country = "";
         String language = "";
         switch (i) {
            case 1:
                country = ("US");
                language = ("en");
                break;
            case 2:
                country = ("UA");
                language = ("uk");
                break;
        }
        Locale current = new Locale(language, country);
        bundle = ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME, current);
    }


    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printWelcome() {
        printMessage(bundle.getString(WELCOME));
    }

    private String concatenationString(String... message) {
        StringBuilder concatString = new StringBuilder();
        for (String v : message) {
            concatString = concatString.append(v);
        }
        return new String(concatString);
    }

    String getInputMessage(int min_limit, int max_limit) {
        String str = concatenationString(bundle.getString(INPUT_INT_DATA),
                SPACE_SING, bundle.getString(FROM), SPACE_SING,
                String.valueOf(min_limit), SPACE_SING, bundle.getString(TILL),
                SPACE_SING, String.valueOf(max_limit), SPACE_SING, EQUAL_SING);
        return str;
    }

    public void wrongInput() {
        printMessage(bundle.getString(WRONG_INPUT_DATA));
    }

    public void printWin() {
        printMessage(bundle.getString(WIN));
    }

    public void printStory(Model modelImplementation) {
        printMessage(bundle.getString(GAME_STORY) +
                String.valueOf(modelImplementation.getUserValue()));
    }
}


