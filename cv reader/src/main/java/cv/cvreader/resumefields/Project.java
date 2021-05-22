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
public class Project {
    private String projectName;
    private Date startDate;
    private Date endDate;
    private String description;

    public static void insertProject(Resume resume) throws ParseException {
        Project project = new Project();
        Keyboard keyboard = new Keyboard();
        List<Project> projects = resume.getProjects();
        if(resume.getProjects() == null) {
            projects = new ArrayList<Project>();
        }

        System.out.println("Insert project name: ");
        String newProjectName = keyboard.getInput();
        project.setProjectName(newProjectName);

        System.out.println("Insert start date: ");
        Date newStartDate = keyboard.getDate();
        project.setStartDate(newStartDate);

        System.out.println("Insert end date: ");
        Date newEndDate = keyboard.getDate();
        project.setEndDate(newEndDate);

        System.out.println("Insert description: ");
        String newDescription = keyboard.getInput();
        project.setDescription(newDescription);

        projects.add(project);
        resume.setProjects(projects);
    }

    @Override
    public String toString() {
        return "Project name: " + projectName + "\n" +
                "Start date: " + startDate + "\n" +
                "End date: " + endDate + "\n" +
                "Description: " + description;
    }
}
