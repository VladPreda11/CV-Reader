package cv.cvreader;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.nio.file.Paths;
import java.util.HashMap;

public class ResumeDatabase {
    HashMap<String, Resume> resumes = new HashMap<>();
    private final String fileName = "resumes.json";

    public HashMap<String, Resume> insertResume(String email, Resume resume) {
        resumes.put(email, resume);
        try{
            ObjectMapper mapper = new ObjectMapper();
            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

            writer.writeValue(Paths.get("resumes.json").toFile(), resumes);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resumes;
    }

    public void displayResume(String email) {
        System.out.println(resumes.get(email));
    }

    public void displayAllResumes() {
        try {
            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            // convert JSON file to map
            resumes = mapper.readValue(Paths.get("resumes.json").toFile(), HashMap.class);

            // print map entries
            for (HashMap.Entry<String, Resume> resumes : resumes.entrySet()) {
                System.out.println(resumes.getKey() + "=" + resumes.getValue());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
