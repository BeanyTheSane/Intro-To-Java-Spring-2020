public class MadLib {
    public static void main(String[] args) {

        System.out.println(textToDisplayBuilder());

    }
    
    public static String textToDisplayBuilder() {
        WordFillInModel wordFillIns = new WordFillInModel();
        wordFillIns.useDefaultLists();
        return   wordFillIns.getRandomProtagonist()
               + " attacked "
               + wordFillIns.getRandomAntagonist()
               + " with a "
               + wordFillIns.getRandomWeapon()
               + " on "
               + wordFillIns.getRandomPlace();
    }
}