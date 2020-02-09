package ua.external.game.mvs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {
    private View view;
    private Model model;

    public Controller(Model model, View view) {
        this.view = view;
        this.model = model;
    }

    public void processUser()  {
        BufferedReader br = new BufferedReader(new	InputStreamReader(System.in));
        view.printWelcome(model.getMin_limit(), model.getMax_limit());
        for(int i = 1; i <= model.getAttempt(); i++) {
            view.printMessage(View.ATTEMPT + i);
            view.inputInteger(model.getMin_limit(), model.getMax_limit());
            model.setValue(Input_Int(br));
            if (model.getValue() < model.getRand()) {
                model.setMin_limit(model.getValue());
                view.printMessage(model.getValue() + View.VALUE_LESS);
            } else if (model.getValue() > model.getRand()) {
                model.setMax_limit(model.getValue());
                view.printMessage(model.getValue() + View.VALUE_MORE);
            } else if(model.getValue() == model.getRand()) {
                if (i == 1) view.printMessage(View.WIN_FIRST_ATTEMPT);
                else view.printWin(i);
                return;
            }
        } view.printMessage(View.Lose);
    }
    private int Input_Int(BufferedReader br) {
        int inputValue= 0;
        do {
            try {
                inputValue = Integer.parseInt(br.readLine());
                if(inputValue < model.getMin_limit()
                        || inputValue > model.getMax_limit()){
                    inputValue = 0;
                    view.printMessage(View.WRONG_INPUT_DATA);
                    view.inputInteger(model.getMin_limit(), model.getMax_limit());
                }
            } catch (NumberFormatException | IOException e) {
                view.printMessage(View.WRONG_INPUT_DATA);
                view.inputInteger(model.getMin_limit(), model.getMax_limit());
            }
        }while(inputValue == 0);
        return inputValue;
    }
}
