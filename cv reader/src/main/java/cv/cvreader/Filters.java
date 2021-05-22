package cv.cvreader;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Filters {
    public static void filterByAge(HashMap<String, Resume> resumes) {
        AtomicInteger isAny = new AtomicInteger();
        AtomicInteger zero = new AtomicInteger(0);

        resumes.forEach((k, v) -> {
            if(resumes.get(k).getAge() > 25) {
                System.out.println(resumes.get(k).toString());
                isAny.getAndIncrement();
            }
        });

        if(isAny.equals(zero)) {
            System.out.println("There are no people with the age over 25...");
        }
    }

    public static void filterByHasWorkedBefore(HashMap<String, Resume> resumes) {
        AtomicInteger isAny = new AtomicInteger();
        AtomicInteger zero = new AtomicInteger(0);

        resumes.forEach((k, v) -> {
            if(!resumes.get(k).getWorkExperiences().isEmpty()) {
                System.out.println(resumes.get(k).toString());
                isAny.getAndIncrement();
            }
        });

        if(isAny.equals(zero)) {
            System.out.println("Nobody works");
        }
    }

    public static void hasMoreThanThreeProjects(HashMap<String, Resume> resumes) {
        AtomicInteger isAny = new AtomicInteger();
        AtomicInteger zero = new AtomicInteger(0);

        try{
            resumes.forEach((k, v) -> {
                if(resumes.get(k).getProjects().size() >= 3) {
                    System.out.println(resumes.get(k).toString());
                    isAny.getAndIncrement();
                }
            });
        } catch(NullPointerException e) {
            e.printStackTrace();
        }

        if(isAny.equals(zero)) {
            System.out.println("No hard-working people here...");
        }
    }

    public static void isFromBucharest(HashMap<String, Resume> resumes) {
        AtomicInteger isAny = new AtomicInteger();
        AtomicInteger zero = new AtomicInteger(0);

        resumes.forEach((k, v) -> {
            if(resumes.get(k).getAddress().contains("Bucharest")) {
                System.out.println(resumes.get(k).toString());
                isAny.getAndIncrement();
            }
        });

        if(isAny.equals(zero)) {
            System.out.println("Nobody is from Bucharest");
        }
    }
}
