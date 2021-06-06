public class StringRotation {
    public static boolean isSubstring(StringBuilder s1, String s2) {
        return s1.indexOf(s2) != -1;
    }

    public static void main(String[] args) {
        String s1 = "erbottlewat";
        String s2 = "waterbottle";
        StringBuilder s3 = new StringBuilder(s1.concat(s1));
        System.out.println(isSubstring(s3, s2));
    }
}
