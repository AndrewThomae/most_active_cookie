public class Testing {
    public static void main(String[] args) {
        //Basic test from command line
        CookieFinder finder = new CookieFinder(args[0], args[2]);
        String[] results = finder.get_active_cookies();
        for (String cookie : results) {
            System.out.println(cookie);
        }
    }
}
