public class MadLib {
    public static void main(String[] args) {
        WordFillInModel wordFillInModel = new WordFillInModel();
        wordFillInModel.useDefaultLists();
        InterfaceStatusModel status = new InterfaceStatusModel();

        System.out.println("Lab #1 Adam Knitter");
        System.out.println("Star Wars MadLib Generator\n");

        while (status.runInterface) {
            InterfaceController.openMainMenu(wordFillInModel, status );
        }
    }   
}