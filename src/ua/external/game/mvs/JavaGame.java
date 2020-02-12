package ua.external.game.mvs;

public class JavaGame {
    public static void main(String args[]){
        Model modelImplementation = new Model();
        View viewGameProcess = new View();
        Controller controller = new Controller(modelImplementation, viewGameProcess);
        controller.processUser();
    }
}
