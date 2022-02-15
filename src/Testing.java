public class Testing {
    public static void main(String[] args) {
        testBasic("cookie_log.csv");
        testEmpty("no_cookies.csv");
        testBig("way_too_many_cookies.csv");
        testBadFile("don't work");
        testNonCookies("random_list.txt");
    }

    //The test the handout provided
    private static void testBasic(String filename) {
        CookieFinder finder = new CookieFinder(filename, "2018-12-09");
        System.out.print("\nExpected: \"AtY0laUfhglK3lC7\"\n Actual: ");
        String[] results = finder.get_active_cookies();
        for (String cookie: results) {
            System.out.println(cookie);
        }
    }

    //Tests a completely empty file
    private static void testEmpty(String filename) {
        CookieFinder finder = new CookieFinder(filename, "2022-17-31");
        System.out.print("\nExpected: \"\"\n Actual: ");
        String[] results = finder.get_active_cookies();
        for (String cookie: results) {
            System.out.println(cookie);
        }
    }

    //Tests many cookies to be printed
    private static void testBig(String filename) {
        CookieFinder finder = new CookieFinder(filename, "2022-17-31");
        System.out.print("\nExpected: \"asdgbuisdfhavuoh\nBHGUIDAbUIOGSAFU\nfgbuaroeghBGUOSA\nbgfuosadbBAWYBHG" +
                "\ngonnakeepdoingth\nisuntiligetbored\nwhichmighttakeaw\nhilebecauseimlis\n" +
                "teningtomusicimg\nonnakeeprambling\nuntiligettohourz\nerosoionlyhaveei\n" +
                "ghtmroelinesleft\nactuallythisispr\nobablyenoughimgo\nnnastopnowgadfuo" +
                "\"\n Actual: ");
        String[] results = finder.get_active_cookies();
        for (String cookie: results) {
            System.out.println(cookie);
        }
    }

    //Tests a file that doesn't exist
    private static void testBadFile(String filename) {
        CookieFinder finder = new CookieFinder(filename, "2022-17-31");
        System.out.print("\nExpected: \"ERROR FINDING FILE\"\n Actual: ");
        String[] results = finder.get_active_cookies();
        for (String cookie: results) {
            System.out.println(cookie);
        }
    }

    //Tests an improperly formatted file
    private static void testNonCookies(String filename) {
        CookieFinder finder = new CookieFinder(filename, "2022-17-31");
        System.out.print("\nExpected: \"FORMATTING ERROR\"\n Actual: ");
        String[] results = finder.get_active_cookies();
        for (String cookie: results) {
            System.out.println(cookie);
        }
    }
}
