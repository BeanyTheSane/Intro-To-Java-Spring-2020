import java.util.Random;
public class MadLib {
    public static void main(String[] args) {
        
        
        String[] protagonists = {"Luke Skywalker", "Princess Leia", "Han Solo", "Obi-Wan Kenobi"}; 
        String[] antagonists = {"Darth Vader", "Emperor Palpatine", "Darth Maul", "Jabba the Hutt"};
        String[] places = {"The Death Star", "Alderaan", "Endor", "Hoth", "Tatooine"};
        String[] weapons = {"Lightsaber", "Bowcaster", "Blaster", "Blast of Force Lightning", "Thermal Detonator"};

        String randomProtagonist = getRandom(protagonists);
        String randomAntagonist = getRandom(antagonists);
        String randomPlace = getRandom(places);
        String randomWeapon = getRandom(weapons);

        String completedTextToDisplay = randomProtagonist 
                                      + " attacked " 
                                      + randomAntagonist 
                                      + " with a " 
                                      + randomWeapon
                                      + " on "
                                      + randomPlace;

        System.out.println(completedTextToDisplay);
    }

    public static String getRandom(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }
}