public class MenuItemModel {
    private String title = "";
    private Integer menuCode = null;

    public MenuItemModel() {}

    public MenuItemModel(String menuType) {
        setTitle(menuType);

        switch (menuType) {
            case "Protagonist":
                setMenuCode(1);
                break;
        
                case "Antagonist":
                setMenuCode(2);
                break;
        
                case "Weapons":
                setMenuCode(3);
                break;
        
                case "Places":
                setMenuCode(4);
                break;
        
            default:
                break;
        }
    }

    public String getTitle() {
        return this.title;
    }

    public Integer getMenuCode() {
        return this.menuCode;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMenuCode(Integer menuCode) {
        this.menuCode = menuCode;
    }

    public String getSpecificListAsString(WordFillInModel model, MenuItemModel menuItem) {
        switch (menuItem.getMenuCode()) {
            case 1:
                return model.getProtagonists();
            case 2:
                return model.getAntagonists();
            case 3:
                return model.getWeapons();
            case 4:
                return model.getPlaces();
            default:
                return "";
        }
    }

    public void addElementToSpecificList(WordFillInModel model, MenuItemModel menuItem, String itemToAdd) {
        switch (menuItem.getMenuCode()) {
            case 1:
                model.addProtagonist(itemToAdd);
                break;
            case 2:
                model.addAntagonist(itemToAdd);
                break;
            case 3:
                model.addWeapon(itemToAdd);
                break;
            case 4:
                model.addPlace(itemToAdd);
                break;
            default:
                break;
        }
    }

    public void resetSpecificListsDefaultValues(WordFillInModel model, MenuItemModel menuItem) {
            switch (menuItem.getMenuCode()) {
            case 1:
                model.resetProtagonistsDefaults();
                break;
            case 2:
                model.resetAntagonistsDefaults();
                break;
            case 3:
                model.resetWeaponsDefaults();
                break;
            case 4:
                model.resetPlacesDefaults();
                break;
            default:
                break;
        }
    }
}