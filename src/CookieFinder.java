import java.io.*;
import java.util.ArrayList;

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
        ArrayList<String> cookies = new ArrayList<String>();
        int curQuant = 0;

        //Open the file and reader
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("C:\\Users\\drewt\\IdeaProjects\\most_active_cookies\\src\\" + filename));
            String line = reader.readLine();
            //Read every line
            while (line != null) {
                System.out.println(line);
                //Split the line into separate variables
                int commaInd = line.indexOf(',');
                String cookie = line.substring(0, commaInd);
                line = line.substring(commaInd);
                String cDate = line.substring(1, line.indexOf('T'));
                line = line.substring(line.indexOf('T') + 1);
                String strNum = line.substring(0, line.indexOf(':'));
                int cookNum = Integer.parseInt(strNum);

                //System.out.println("Cookie: " + cookie + ", cDate: " + cDate + ",strNum: " + strNum);

                //When the read cookie is requested more than the saved cookies,
                //restart the array
                if (cookNum > curQuant) {
                    cookies.clear();
                    cookies.add(cookie);
                    curQuant = cookNum;
                }
                //When they are the same, add it to the array
                else if (cookNum == curQuant) {
                    cookies.add(cookie);
                }

                line = reader.readLine();
            }


            reader.close();
        } catch (Exception e) {
            System.out.println("ERROR: TROUBLE OPENING FILE");
        }

        String[] cookieList = new String[cookies.size()];
        cookieList = cookies.toArray(cookieList);
        return cookieList;
    }
}