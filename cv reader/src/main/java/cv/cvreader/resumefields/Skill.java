package cv.cvreader.resumefields;

import cv.cvreader.Keyboard;
import cv.cvreader.Resume;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Skill {
    private String skill;

    public static void insertSkill(Resume resume) {
        Skill skill = new Skill();
        Keyboard keyboard = new Keyboard();
        List<Skill> skills = resume.getSkills();
        if(resume.getSkills() == null) {
            skills = new ArrayList<Skill>();
        }

        System.out.println("Insert skill: ");
        String newSkill = keyboard.getInput();
        skill.setSkill(newSkill);

        skills.add(skill);
        resume.setSkills(skills);
    }

    @Override
    public String toString() {
        return skill;
    }
}
