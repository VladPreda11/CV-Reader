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
public class Language {
    private String language;

    public static void insertLanguage(Resume resume) {
        Language language = new Language();
        Keyboard keyboard = new Keyboard();
        List<Language> languages = resume.getLanguages();
        if(resume.getLanguages() == null) {
            languages = new ArrayList<Language>();
        }

        System.out.println("Insert language: ");
        String newLanguage = keyboard.getInput();
        language.setLanguage(newLanguage);

        languages.add(language);
        resume.setLanguages(languages);
    }

    @Override
    public String toString() {
        return language;
    }
}
