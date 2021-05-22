package cv.cvreader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ResumeReader resumeReader = new ResumeReader();
        try {
            resumeReader.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
