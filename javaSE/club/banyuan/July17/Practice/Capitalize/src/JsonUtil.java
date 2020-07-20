public class JsonUtil {
    public static String capitalize(String str) {
        char[] chars = str.toCharArray();
        if (chars[0] >= 'a' && chars[0] <= 'z') {
            chars[0] = (char) (chars[0] - 'a' + 'A');
        }
        return new String(chars);
    }

    public static String unCapitalize(String str) {
        char[] chars = str.toCharArray();
        if (chars[0] >= 'A' && chars[0] <= 'Z') {
            chars[0] = (char) (chars[0] - 'A' + 'a');
        }
        return new String(chars);
    }

}
