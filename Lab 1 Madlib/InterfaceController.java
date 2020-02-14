public class InterfaceController {
    public static void openMainMenu(WordFillInModel wordFillInModel, InterfaceStatusModel status) {
        boolean inputIsInvalid = true; 
        if (status.mainMenuInput.equals("")) {
            InterfaceController.displayMainMenu();
        }

        status.mainMenuInput = (status.mainMenuInput.contentEquals("")) 
                      ? status.myScanner.nextLine()
                      : status.mainMenuInput;

        switch (status.mainMenuInput) {
            case "0":
                status.runInterface = false;
                status.myScanner.close();
                break;
            case "1":
                System.out.println(displayCompletedMadlib(wordFillInModel));
                inputIsInvalid = true;
                while (inputIsInvalid) {
                    System.out.println("\nPress enter to continue\n");
                    String validateInput = status.myScanner.nextLine();
                    if (validateInput.equals("")) {
                        inputIsInvalid = false;
                    }
                }
                status.mainMenuInput = "";
                break;
            case "2":
                openListSelectionMenu(wordFillInModel, status);
                break;
            default:
            status.mainMenuInput = "";
            status.editMenuProInput = "";
            status.subEditMenuInput = "";
                break;
        }
    }

        public static void openListSelectionMenu(WordFillInModel wordFillInModel, InterfaceStatusModel status) {
            if (status.editMenuProInput.equals("")) {
                InterfaceController.displayListSelection();
            }

            status.editMenuProInput = status.editMenuProInput.contentEquals("") 
                                 ? status.myScanner.nextLine() 
                                 : status.editMenuProInput;

                switch (status.editMenuProInput) {
                    case "0":
                        status.editMenuProInput = "";
                        status.mainMenuInput = "";
                        status.subEditMenuInput = "";
                        break;
                    case "1":
                        MenuItemModel protagonsitMenuItem = new MenuItemModel("Protagonist");
                        startSpecificEditMenu(protagonsitMenuItem, status, wordFillInModel);
                        break;
                    case "2":
                        MenuItemModel antagonsitMenuItem = new MenuItemModel("Antagonist");
                        startSpecificEditMenu(antagonsitMenuItem, status, wordFillInModel);
                        break;
                    case "3":
                        MenuItemModel weaponMenuItem = new MenuItemModel("Weapons");
                        startSpecificEditMenu(weaponMenuItem, status, wordFillInModel);
                        break;
                    case "4":
                        MenuItemModel placeMenuItem = new MenuItemModel("Places");
                        startSpecificEditMenu(placeMenuItem, status, wordFillInModel);
                        break;
                    default:
                        status.editMenuProInput = "";
                        status.mainMenuInput = "2";
                        break;
                }
        }
        

    public static void startSpecificEditMenu(MenuItemModel menuItem,
                                            InterfaceStatusModel status,
                                            WordFillInModel wordFillInModel) {

        boolean inputIsInvalid = true;

        if (status.subEditMenuInput.equals("")) {                                   
            InterfaceController.displaySpecificListMenu(menuItem.getTitle());
        }

        status.subEditMenuInput = status.subEditMenuInput.contentEquals("") 
                                ? status.myScanner.nextLine()
                                : status.subEditMenuInput;

        switch (status.subEditMenuInput) {
            case "0":
                status.mainMenuInput = "2";
                status.editMenuProInput = "";
                status.subEditMenuInput = "";
                break;

            case "1":
                System.out.println(menuItem.getSpecificListAsString(wordFillInModel, menuItem));
                inputIsInvalid = true;
                while (inputIsInvalid) {
                    System.out.println("\nPress enter to continue\n");
                    String validateInput = status.myScanner.nextLine();
                    if (validateInput.equals("")) {
                        inputIsInvalid = false;
                    }
                }

                status.mainMenuInput = "2";
                status.editMenuProInput = menuItem.getMenuCode().toString();
                status.subEditMenuInput = "";
                break;
    
            case "2":
                System.out.println("Please enter the item you would like to add");
                status.itemToAdd = status.myScanner.nextLine();

                if (status.itemToAdd.equals("")) {
                    System.out.println("You cannot add a blank item");
                    status.mainMenuInput = "2";
                    status.editMenuProInput = menuItem.getMenuCode().toString();
                    status.subEditMenuInput = "2";
                    break;
                }
                menuItem.addElementToSpecificList(wordFillInModel, menuItem, status.itemToAdd);

                System.out.println("\nYou have added " + status.itemToAdd  + " to the list");
                inputIsInvalid = true;
                while (inputIsInvalid) {
                    System.out.println("\nPress enter to continue\n");
                    String validateInput = status.myScanner.nextLine();
                    if (validateInput.equals("")) {
                        inputIsInvalid = false;
                    }
                }

                status.mainMenuInput = "2";
                status.editMenuProInput = menuItem.getMenuCode().toString();
                status.subEditMenuInput = "";
                break;
    
            case "3":
                menuItem.resetSpecificListsDefaultValues(wordFillInModel, menuItem);

                System.out.println("You are now using the defult " + menuItem.getTitle() + " list");
    
                inputIsInvalid = true;
                while (inputIsInvalid) {
                    System.out.println("\nPress enter to continue\n");
                    String validateInput = status.myScanner.nextLine();
                    if (validateInput.equals("")) {
                        inputIsInvalid = false;
                    }
                }

                status.mainMenuInput = "2";
                status.editMenuProInput = menuItem.getMenuCode().toString();
                status.subEditMenuInput = "";
                break;
    
            default:
                status.mainMenuInput = "2";
                status.editMenuProInput = menuItem.getMenuCode().toString();
                status.subEditMenuInput = "";
                break;
        }
    }

    public static void displayMainMenu() {
        System.out.println("\nMain Menu\n");
            System.out.println("Enter 1 to get a star wars mad lib");
            System.out.println("Enter 2 to add items");
            System.out.println("Enter 0 to exit\n");
    }

    public static void displayListSelection() {
        System.out.println("\nList Edit Menu\n");
        System.out.println("Enter 1 to edit the protagonists list");
        System.out.println("Enter 2 to edit the antagonists list");
        System.out.println("Enter 3 to edit the weapons list");
        System.out.println("Enter 4 to edit the places list");
        System.out.println("Enter 0 to go back to the main menu\n");
    }

    public static void displaySpecificListMenu(String menuText) {
        System.out.println("\n" + menuText + " list edit menu\n");
        System.out.println("Enter 1 to display current list");
        System.out.println("Enter 2 to add an item");
        System.out.println("Enter 3 to use default list");
        System.out.println("Enter 0 to go up one menu menu\n");
    }

    public static String displayCompletedMadlib(WordFillInModel wordFillIns) {
        return   wordFillIns.getRandomProtagonist()
               + " attacked "
               + wordFillIns.getRandomAntagonist()
               + " with a "
               + wordFillIns.getRandomWeapon()
               + " on "
               + wordFillIns.getRandomPlace();
    }
}