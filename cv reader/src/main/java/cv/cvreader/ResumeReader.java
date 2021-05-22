package cv.cvreader;

import java.io.IOException;
import java.util.HashMap;

public class ResumeReader {
    private Screen screen;
    private Keyboard keyboard;
    private ResumeDatabase database;

    private Resume currentResume = new Resume();

    private HashMap<String, Resume> currentResumes;

    public ResumeReader() {
        this.screen = new Screen();
        this.keyboard = new Keyboard();
        this.database = new ResumeDatabase();
    }

    public void run() throws IOException {
        while (true) {
            displayMenu();

            int actionChosen = keyboard.getInt();

            if (!executeAction(actionChosen)) {
                return;
            }
        }
    }

    private boolean executeAction(int actionChosen) throws IOException {
        switch (actionChosen) {
            case 1:
                currentResume = Resume.insertResume();
                currentResumes = database.insertResume(currentResume.getEmail(), currentResume);
                break;
            case 2:
                screen.displayMessage("Enter the e-mail addres: ");
                String email = keyboard.getInput();
                if(database.resumes.containsKey(email)) {
                    database.displayResume(email);
                    break;
                }
                System.out.println("The resume doesn't exist.");
                break;
            case 3:
                if(database.resumes.isEmpty()) {
                    screen.displayMessage("There are no resumes.");
                    break;
                }
                database.displayAllResumes();
                break;
            case 4:
                displayFiltersMenu();
                executeFilterAction();
                break;
            case 5:
                return false;
            default:
                screen.displayMessage("Invalid command!");
                break;
        }

        return true;
    }

    private void executeFilterAction() {
        int filterAction = keyboard.getInt();

        switch (filterAction) {
            case 1:
                Filters.filterByAge(currentResumes);
                break;
            case 2:
                Filters.filterByHasWorkedBefore(currentResumes);
                break;
            case 3:
                Filters.hasMoreThanThreeProjects(currentResumes);
                break;
            case 4:
                Filters.isFromBucharest(currentResumes);
                break;
            case 5:
                break;
            default:
                screen.displayMessage("Invalid command.");
                break;
        }
    }

    public void displayMenu() {
        screen.displayMessage("-----------------------------------------------");
        screen.displayMessage("Choose one of the following actions:");
        screen.displayMessage("1. Insert resume");
        screen.displayMessage("2. View your resume");
        screen.displayMessage("3. View all resumes");
        screen.displayMessage("4. Search resumes by a specific filter");
        screen.displayMessage("5. Exit");
    }

    private void displayFiltersMenu() {
        screen.displayMessage("-----------------------------------------------");
        screen.displayMessage("Choose one of the following actions:");
        screen.displayMessage("1. Search by age > 25");
        screen.displayMessage("2. Search by has worked before");
        screen.displayMessage("3. Search resumes that have at least 3 projects");
        screen.displayMessage("4. Search resumes from Bucharest");
        screen.displayMessage("5. Exit");
    }
}
