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
public class WorkExperience {
    private String jobTitle;
    private String companyName;
    private Date startDate;
    private Date endDate;
    private String description;

    public static void insertWorkExperience(Resume resume) throws ParseException {
        WorkExperience workExperience = new WorkExperience();
        Keyboard keyboard = new Keyboard();
        List<WorkExperience> workExperiences = resume.getWorkExperiences();
        if(resume.getWorkExperiences() == null) {
            workExperiences = new ArrayList<WorkExperience>();
        }

        System.out.println("Insert job title: ");
        String newJobTitle = keyboard.getInput();
        workExperience.setJobTitle(newJobTitle);

        System.out.println("Insert company name: ");
        String newCompanyName = keyboard.getInput();
        workExperience.setCompanyName(newCompanyName);

        System.out.println("Insert start date: ");
        Date newStartDate = keyboard.getDate();
        workExperience.setStartDate(newStartDate);

        System.out.println("Insert end date: ");
        Date newEndDate = keyboard.getDate();
        workExperience.setEndDate(newEndDate);

        System.out.println("Insert description: ");
        String newDescription = keyboard.getInput();
        workExperience.setDescription(newDescription);

        workExperiences.add(workExperience);
        resume.setWorkExperiences(workExperiences);
    }

    @Override
    public String toString() {
        return "Job title: " + jobTitle + "\n" +
                "Company: " + companyName + "\n" +
                "Start date: " + startDate + "\n" +
                "End date: " + endDate + "\n" +
                "Description: " + description;
    }
}
