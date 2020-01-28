public class WordFillInModel {

    private String[] protagonists = {}; 
    private String[] antagonists = {};
    private String[] places = {};
    private String[] weapons = {};

    void wordFillInModel() {
    }

    void useDefaultLists() {
        String[] protagonists = {"Luke Skywalker", "Princess Leia", "Han Solo", "Obi-Wan Kenobi"}; 
        String[] antagonists = {"Darth Vader", "Emperor Palpatine", "Darth Maul", "Jabba the Hutt"};
        String[] places = {"The Death Star", "Alderaan", "Endor", "Hoth", "Tatooine"};
        String[] weapons = {"Lightsaber", "Bowcaster", "Blaster", "Blast of Force Lightning", "Thermal Detonator"};

        setProtagonists(protagonists);
        setAntagonists(antagonists);
        setPlaces(places);
        setWeapons(weapons);
    }

    String getProtagonists() {
       String protagonists = "";

        for (String person : this.protagonists) {
            protagonists += person + ", ";
        }

       return protagonists;
    }

    void setProtagonists(String[] newProtagonists) {
        this.protagonists = newProtagonists;
    }

    String getAntagonists() {
       String antagonists = "";

        for (String person : this.antagonists) {
            antagonists += person + ", ";
        }

       return antagonists;
    }

    void setAntagonists(String[] newProtagonists) {
        this.antagonists = newProtagonists;
    }

    String getPlaces() {
       String places = "";

        for (String person : this.places) {
            places += person + ", ";
        }

       return places;
    }

    void setPlaces(String[] newProtagonists) {
        this.places = newProtagonists;
    }

    String getWeapons() {
       String weapons = "";

        for (String person : this.weapons) {
            weapons += person + ", ";
        }

       return weapons;
    }

    void setWeapons(String[] newProtagonists) {
        this.weapons = newProtagonists;
    }

    String getRandomProtagonist() {
        return MyUtilities.getRandomStringFromArray(this.protagonists);
    }

    String getRandomAntagonist() {
        return MyUtilities.getRandomStringFromArray(this.antagonists);
    }

    String getRandomPlace() {
        return MyUtilities.getRandomStringFromArray(this.places);
    }

    String getRandomWeapon() {
        return MyUtilities.getRandomStringFromArray(this.weapons);
    }

    void addWeapon(String person) {
        addItem(weapons, person);
    }

    void addPlace(String person) {
        addItem(places, person);
    }

    void addAntagonist(String person) {
        addItem(antagonists, person);
    }

    void addProtagonist(String person) {
        addItem(protagonists, person);
    }

    String[] addItem(String initialArray[], String itemToAdd) {
        String newArray[] = new String[initialArray.length + 1];

        for (int i = 0; i < initialArray.length; i++) {
            newArray[i] = initialArray[i];
        }

        newArray[initialArray.length] = itemToAdd;

        return newArray;
    }
}