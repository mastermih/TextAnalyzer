package textanalyzer;

public class CommandParser {
    public int parseTopParameter(String str) {
        try {
            return Integer.parseInt(str.substring(5));
        } catch (NumberFormatException e) {
            if (str.substring(5).isEmpty()) {
                System.out.println("No value provided for '-top'. Please provide a valid integer.");
            }
            throw new RuntimeException(e);
        }
    }

    public int parsePhraseSize(String str) {
        try {
            return Integer.parseInt(str.substring(12));
        } catch (NumberFormatException e) {
            if (str.substring(12).isEmpty()) {
                System.out.println("No value provided for '-phraseSize'. Please provide a valid integer.");
            }
            throw new RuntimeException(e);
        }
    }
}
