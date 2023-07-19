public class StringUtils {
    
    public static String[] dividirString(String string) {
        String[] strings = new String[2];

        // arrendondando pra baixo, o último caso de teste falhava
        int metade = (int) Math.ceil((double) string.length() / 2);

        strings[0] = string.substring(0, metade);
        strings[1] = string.substring(metade);

        return strings;
    }

    public static String inverterString(String string) {
        String retornoString = "";
        for (int i = (string.length() - 1); i >= 0; i--) {
            retornoString += string.charAt(i);
        }
        return retornoString;
    }
}
