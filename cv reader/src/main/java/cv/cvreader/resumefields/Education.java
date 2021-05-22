package cv.cvreader.resumefields;

import cv.cvreader.Keyboard;
import cv.cvreader.Resume;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Education {
    private String institutionName;
    private String city;
    private Date startDate;
    private Date endDate;

    public static void insertEducation(Resume resume) throws ParseException {
        Education education = new Education();
        Keyboard keyboard = new Keyboard();
        List<Education> educations = resume.getEducations();
        if(resume.getEducations() == null) {
            educations = new ArrayList<Education>();
        }

        System.out.println("Insert institution name: ");
        String newInstitutionName = keyboard.getInput();
        education.setInstitutionName(newInstitutionName);

        System.out.println("Insert city: ");
        String newCity = keyboard.getInput();
        education.setCity(newCity);

        System.out.println("Insert start date: ");
        Date newStartDate = keyboard.getDate();
        education.setStartDate(newStartDate);

        System.out.println("Insert end date: ");
        Date newEndDate = keyboard.getDate();
        education.setEndDate(newEndDate);

        educations.add(education);
        resume.setEducations(educations);
    }

    @Override
    public String toString() {
        return "Institution name: " + institutionName + "\n" +
                "City: " + city + "\n" +
                "Start date: " + startDate + "\n" +
                "End date: " + endDate;
    }

}
