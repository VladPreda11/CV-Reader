package cv.cvreader;

import cv.cvreader.resumefields.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.ParseException;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Resume {
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String phoneNumber;
    private String address;

    private List<Education> educations;
    private List<Language> languages;
    private List<Project> projects;
    private List<Skill> skills;
    private List<WorkExperience> workExperiences;

    public static Resume insertResume() {
        Keyboard keyboard = new Keyboard();
        Resume newResume = new Resume();

        System.out.println("Insert your first name: ");
        String newFirstName = keyboard.getInput();
        newResume.setFirstName(newFirstName);

        System.out.println("Insert your last name: ");
        String newLastName = keyboard.getInput();
        newResume.setLastName(newLastName);

        System.out.println("Insert your age: ");
        int newAge = keyboard.getInt();
        newResume.setAge(newAge);

        System.out.println("Insert your e-mail: ");
        String newEmail = keyboard.getInput();
        newResume.setEmail(newEmail);

        System.out.println("Insert your phone number: ");
        String newPhoneNumber = keyboard.getInput();
        newResume.setPhoneNumber(newPhoneNumber);

        System.out.println("Insert your address: ");
        String newAddress = keyboard.getInput();
        newResume.setAddress(newAddress);

        while(true) {
            displayResumeBuilder();
            int action = keyboard.getInt();

            switch (action) {
                case 1:
                    try{
                        Education.insertEducation(newResume);
                    } catch(ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    Language.insertLanguage(newResume);
                    break;
                case 3:
                    try{
                        Project.insertProject(newResume);
                    } catch(ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    Skill.insertSkill(newResume);
                    break;
                case 5:
                    try{
                        WorkExperience.insertWorkExperience(newResume);
                    } catch(ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    return newResume;
                default:
                    System.out.println("Invalid command!");
            }
        }
    }

    private static void displayResumeBuilder() {
        System.out.println("-----------------------------------------------");
        System.out.println("Choose one of the following actions:");
        System.out.println("1. Insert education");
        System.out.println("2. Insert language");
        System.out.println("3. Insert project");
        System.out.println("4. Insert skill");
        System.out.println("5. Insert work experience");
        System.out.println("6. Exit");
    }

    @Override
    public String toString() {
        return "First name: " + firstName + "\n" +
                "Last name: " + lastName + "\n" +
                "Age: " + age + "\n" +
                "E-mail: " + email + "\n" +
                "Phone number:" + phoneNumber + "\n" +
                "Address: " + address + "\n" +
                "--------------------------------------" + "\n" +
                "Education: " + "\n\t" +
                educations + "\n" +
                "--------------------------------------" + "\n" +
                "Work experience: " + "\n\t" +
                workExperiences + "\n" +
                "--------------------------------------" + "\n" +
                "Projects: " + "\n\t" +
                projects + "\n" +
                "--------------------------------------" + "\n" +
                "Skills: " + "\n\t" +
                skills + "\n" +
                "--------------------------------------" + "\n" +
                "Languages: " + "\n\t" +
                languages;
    }
}
