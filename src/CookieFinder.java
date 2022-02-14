import java.io.*;

public class CookieFinder {
    //Set up variable
    String filename;
    String date;


    public CookieFinder(String filename, String date) {
        this.filename = filename;
        this.date = date;
    }

    //Find all the cookies that fit the date requirement, and return in an array
    public String[] get_active_cookies() {
        String[] cookies = new String[5];

        //Open the file and reader
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            //Read every line
            while (line != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("ERROR: TROUBLE OPENING FILE");
        }

        return cookies;
    }
}