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

    public void processUser()  {

        modelImplementation.setPrimaryLimit(GlobalConstants.PRIMARY_MAX_LIMIT,GlobalConstants.PRIMARY_MIN_LIMIT);

        modelImplementation.setSecretValue();

        viewGameProcess.printWelcome();

        BufferedReader br = new BufferedReader(new	InputStreamReader(System.in));

        while (!modelImplementation.checkValue(Input_Int(br)));

        viewGameProcess.printWin();
        viewGameProcess.printStory(modelImplementation);

    }
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
}
