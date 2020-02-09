package ua.external.game.mvs;

public class JavaGame {
    public static void main(String args[]){
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        controller.processUser();
    }
}
