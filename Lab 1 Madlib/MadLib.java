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
               + wordFillIns.getRandomPlace()
               + "\n\n"
               + wordFillIns.getProtagonists()
               + "\n\n"
               + wordFillIns.getAntagonists()
               + "\n\n"
               + wordFillIns.getPlaces()
               + "\n\n"
               + wordFillIns.getWeapons();
    }
}