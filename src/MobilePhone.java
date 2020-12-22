import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {

    private static Scanner scanner = new Scanner(System.in);
    private ArrayList<Contact> myContacts = new ArrayList<>();

    public MobilePhone() {
        boolean quit = false;
        int choice = 0;
        printInstructions();
        while (!quit) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    addContact();
                    break;
                case 2:
                    updateContact();
                    break;
                case 3:
                    removeContact();
                    break;
                case 4:
                    searchContact();
                    break;
                case 5:
                    printContactList();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
    }

    private void printInstructions() {
        System.out.println("\n Press");
        System.out.println("\t 0 - To print choice options");
        System.out.println("\t 1 - To add contact");
        System.out.println("\t 2 - To update contact");
        System.out.println("\t 3 - To remove contact");
        System.out.println("\t 4 - To search contact");
        System.out.println("\t 5 - To print contact list");
        System.out.println("\t 6 - To quit the application");
    }

    private void addContact() {
        System.out.println("Enter the new Contact name\t");
        String name = scanner.nextLine();
        System.out.println("Enter the new Contact phone\t");
        String phone = scanner.nextLine();
        Contact contact = new Contact(name, phone);
        myContacts.add(contact);
    }

    private void updateContact() {
        System.out.println("Enter contact to update: ");
        String searchName = scanner.nextLine();
        int position = findInt(searchName);
        if (position >= 0) {
            System.out.println("Which one you want to update? \n" +
                    "1. Update contact name\n" +
                    "2. Update contact phone number ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // need to be added, after nextInt
            if (choice == 1) {
                System.out.println("Enter new Name: ");
                String updateName = scanner.nextLine();
                int hasUpdate = findInt(updateName);
                if (hasUpdate != -1) {
                    System.out.println(updateName + " is already exiting ");
                } else {
                    myContacts.get(position).setName(updateName);
                    System.out.println("Contact " + searchName + " has been updated with " + updateName);
                }
            } else if (choice == 2) {
                System.out.println("Enter new phone number: ");
                String updateNumber = scanner.nextLine();
                myContacts.get(position).setPhoneNumber(updateNumber);
                System.out.println("Contact " + searchName + "'s phone number has been updated with " + updateNumber);
            }
        } else {
            System.out.println("Contact couldn't be located");
        }
    }

    private void removeContact() {
        System.out.println("Enter contact to remove: ");
        String removeName = scanner.nextLine();
        int position = findInt(removeName);
        if (position >= 0) {
            myContacts.remove(position);
            System.out.println("Contact " + removeName + " has been removed ");
        } else {
            System.out.println("Contact couldn't be located");
        }

    }

    private void searchContact() {
        System.out.println("Search contact: ");
        String searchName = scanner.nextLine();
        int position = findInt(searchName);
//        System.out.println("position = " + position);
        if (position >= 0) {
            System.out.println("Contact " + searchName + " has been found.\n" +
                    "Phone number: " + myContacts.get(position).getPhoneNumber());
        } else {
            System.out.println("Contact " + searchName + " couldn't be located");
        }
    }

    private int findInt(String searchName) {
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i);
            if (contact.getName().equals(searchName)) {
                return i;
            }
        }
        return -1;
    }
//    private int findInt(String searchName) {
//        return myContacts.indexOf(searchName);
//    }

    private void printContactList() {
        System.out.println("Contact List");
        for (int i = 0; i < myContacts.size(); i++) {
            System.out.println((i + 1) + ". \nName: " + myContacts.get(i).getName() + "\nPhone number: " + myContacts.get(i).getPhoneNumber());
        }
    }
}
