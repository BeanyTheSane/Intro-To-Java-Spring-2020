public class WordFillInModel {

    private String[] protagonists = {}; 
    private String[] antagonists = {};
    private String[] places = {};
    private String[] weapons = {};
    private String[] protagonistsDefaults = {"Luke Skywalker", "Princess Leia", "Han Solo", "Obi-Wan Kenobi"}; 
    private String[] antagonistsDefaults = {"Darth Vader", "Emperor Palpatine", "Darth Maul", "Jabba the Hutt"};
    private String[] placesDefaults = {"The Death Star", "Alderaan", "Endor", "Hoth", "Tatooine"};
    private String[] weaponsDefaults = {"Lightsaber", "Bowcaster", "Blaster", "Blast of Force Lightning", "Thermal Detonator"};

    void wordFillInModel() {
        if (protagonists.length == 0 &&
            antagonists.length == 0 &&
            weapons.length == 0 &&
            places.length == 0) {
                useDefaultLists();
        }
    }

    void useDefaultLists() {

        setProtagonists(protagonistsDefaults);
        setAntagonists(antagonistsDefaults);
        setPlaces(placesDefaults);
        setWeapons(weaponsDefaults);
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

    void resetProtagonistsDefaults() {
        this.protagonists = this.protagonistsDefaults;
    }

    void resetAntagonistsDefaults() {
        this.antagonists = this.antagonistsDefaults;
    }

    void resetWeaponsDefaults() {
        this.weapons = this.weaponsDefaults;
    }

    void resetPlacesDefaults() {
        this.places = this.placesDefaults;
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

    void addWeapon(String weapon) {
        this.weapons = MyUtilities.addItemToArray(weapons, weapon);
    }

    void addPlace(String item) {
        this.places = MyUtilities.addItemToArray(places, item);
    }

    void addAntagonist(String person) {
        this.antagonists = MyUtilities.addItemToArray(antagonists, person);
    }

    void addProtagonist(String person) {
        this.protagonists = MyUtilities.addItemToArray(protagonists, person);
    }
}