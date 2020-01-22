import java.util.Random;
public class MadLib {
    public static void main(String[] args) {

        System.out.println(textToDisplayBuilder());

    }
    
    public static String textToDisplayBuilder() {
        WordFillInModel wordFillIns = new WordFillInModel();
        return   wordFillIns.getRandomProtagonist()
               + " attacked "
               + wordFillIns.getRandomAntagonist()
               + " with a "
               + wordFillIns.getRandomWeapon()
               + " on "
               +wordFillIns.getRandomPlace();
    }

    public static String getRandom(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

    public static class WordFillInModel {
        String[] protagonists = {"Luke Skywalker", "Princess Leia", "Han Solo", "Obi-Wan Kenobi"}; 
        String[] antagonists = {"Darth Vader", "Emperor Palpatine", "Darth Maul", "Jabba the Hutt"};
        String[] places = {"The Death Star", "Alderaan", "Endor", "Hoth", "Tatooine"};
        String[] weapons = {"Lightsaber", "Bowcaster", "Blaster", "Blast of Force Lightning", "Thermal Detonator"};

        void wordFillInModel() {}

        String getRandomProtagonist() {
            return getRandom(this.protagonists);
        }

        String getRandomAntagonist() {
            return getRandom(this.antagonists);
        }

        String getRandomPlace() {
            return getRandom(this.places);
        }

        String getRandomWeapon() {
            return getRandom(this.weapons);
        }
    }
}