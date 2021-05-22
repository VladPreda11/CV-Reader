package cv.cvreader;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Keyboard {
    private final Scanner scanner;

    public Keyboard() {
        this.scanner = new Scanner(System.in);
    }

    public String getInput() {
        return scanner.nextLine();
    }

    public Date getDate() throws ParseException {
        String dateString = scanner.nextLine();
        return new SimpleDateFormat("MM-yyyy").parse(dateString);
    }

    public int getInt(){
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }
}
