import java.io.*;
import java.util.ArrayList;

public class CookieFinder {
    public static void main(String[] args) {
        //Make sure arguments are passed
        if (args.length != 3) {
            System.out.println("MUST GIVE PROPER ARGUMENTS");
        }
        //Run from the command line
        CookieFinder finder = new CookieFinder(args[0], args[2]);
        String[] results = finder.get_active_cookies();
        for (String cookie : results) {
            System.out.println(cookie);
        }
    }

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
        int curQuant = -1; //value of most requested cookie
        boolean done = false; //ends the program when you get past the correct date

        //Open the file and reader
        BufferedReader reader;
        try {
            //I open the file from my personal file locations
            reader = new BufferedReader(new FileReader("C:\\Users\\drewt\\IdeaProjects\\most_active_cookies\\" + filename));
            String line = reader.readLine();
            //Read every line
            while (line != null) {
                //System.out.println(line);
                //Split the line into separate variables
                int commaInd = line.indexOf(',');
                String cookie = line.substring(0, commaInd);
                line = line.substring(commaInd);
                String cDate = line.substring(1, line.indexOf('T'));
                line = line.substring(line.indexOf('T') + 1);
                String strNum = line.substring(0, line.indexOf(':'));
                int cookNum = Integer.parseInt(strNum);

                //System.out.println("Cookie: " + cookie + ", cDate: " + cDate + ",strNum: " + strNum);

                if (cDate.equals(date)) {
                    //When the read cookie is requested more than the saved cookies,
                    //restart the array
                    if (cookNum > curQuant) {
                        cookies.clear();
                        cookies.add(cookie);
                        curQuant = cookNum;
                        done = true;
                    }
                    //When they are the same, add it to the array
                    else if (cookNum == curQuant) {
                        cookies.add(cookie);
                    }
                } else if (done){
                    //This ends the loop early when the date is past
                    break;
                }

                line = reader.readLine();
            }

            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR FINDING FILE");
            cookies.clear();
        } catch (Exception e) {
            System.out.println("FORMATTING ERROR");
            cookies.clear();
        }

        String[] cookieList = new String[cookies.size()];
        cookieList = cookies.toArray(cookieList);
        return cookieList;
    }
}