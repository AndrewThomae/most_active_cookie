public class Testing {
    public static void main(String[] args) {
        //Basic test from command line
        CookieFinder finder = new CookieFinder(args[0], args[2]);
        finder.get_active_cookies();
    }
}
