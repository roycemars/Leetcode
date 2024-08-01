public class LicenseKeyFormatting {

    public static void main(String[] args) {
        String s = "5F3Z-2e-9-wT";
        System.out.printf("%s -> %s\n", s, licenseKeyFormatting(s, 4));
    }

    private static String licenseKeyFormatting(String s, int k) {
        StringBuilder r = new StringBuilder();
        int g = 0;

        for (int i = s.length() - 1; i >= 0; --i) {
            char c = s.charAt(i);

            if (c != '-') {
                r.append(c);
                g++;
                if (g == k) {
                    r.append('-');
                    g = 0;
                }
            }
        }

        if (r.length() > 0 && r.charAt(r.length() - 1) == '-') {
            r.deleteCharAt(r.length() - 1);
        }
        return r.reverse().toString().toUpperCase();
    }
}
