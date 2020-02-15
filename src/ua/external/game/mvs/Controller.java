package ua.external.game.mvs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Controller {
    private View viewGameProcess;
    private Model modelImplementation;

    public Controller(Model modelImplementation, View viewGameProcess) {
        this.viewGameProcess = viewGameProcess;
        this.modelImplementation = modelImplementation;
    }

    public void processUser() {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        modelImplementation.setPrimaryLimit(GlobalConstants.PRIMARY_MAX_LIMIT, GlobalConstants.PRIMARY_MIN_LIMIT);

        modelImplementation.setSecretValue();

        viewGameProcess.viewLanguage(choseLanguage(br));

        viewGameProcess.printWelcome();

        while (!modelImplementation.checkValue(Input_Int(br))) ;

        viewGameProcess.printWin();
        viewGameProcess.printStory(modelImplementation);

    }
// Read the input value and check that the value is a string and is within the range
    private int Input_Int(BufferedReader br) {
        int inputValue = 0;
        while (true) {
            do {
                viewGameProcess.printMessage(viewGameProcess.getInputMessage(modelImplementation.getMin_limit(),
                        modelImplementation.getMax_limit()));

                try {
                    inputValue = Integer.parseInt(br.readLine());
                    if (inputValue < modelImplementation.getMin_limit()
                            || inputValue > modelImplementation.getMax_limit()) {
                        inputValue = 0;
                        viewGameProcess.wrongInput();
                    }
                } catch (NumberFormatException | IOException e) {
                    viewGameProcess.wrongInput();
                }
            } while (inputValue == 0);
            return inputValue;

        }
    }
// read and check chosen language
    private int choseLanguage (BufferedReader br) {
        int language = 0;
        do {
            viewGameProcess.printMessage(viewGameProcess.CHOSE_LANGUAGE);
            try {
                language = Integer.parseInt(br.readLine());
                if (language > 2 || language < 1){
                    language = 0;
                    viewGameProcess.printMessage(viewGameProcess.WRONG_INPUT_LANGUAGE);
                }
            } catch (NumberFormatException | IOException e) {
                viewGameProcess.printMessage(viewGameProcess.WRONG_INPUT_LANGUAGE);
            }
        }while (language == 0);
        return language;
    }
}
