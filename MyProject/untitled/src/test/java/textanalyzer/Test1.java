package textanalyzer;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test1 {
    private final CommandParser commandParser = new CommandParser();
    @Test
    // Pozitive value Tests for counting the words
   public void testCountWords()
    {
       int num = TextAnalyzer.countWords("This is just a test or not");
        Assertions.assertEquals(7, num);
    }
    @Test
    public void testCountWords2()
    {
        int num = TextAnalyzer.countWords("This");
        Assertions.assertEquals(1, num);
    }

    @Test
    public void testCountWords3()
    {
        int num = TextAnalyzer.countWords("Use the verification. Because you requested.");
        Assertions.assertEquals(6, num);
    }

    @Test
    public void testCountWords4()
    {
        int num = TextAnalyzer.countWords("FDF-2323DSD");
        Assertions.assertEquals(1, num);
    }
    // Negative case for Words
    @Test
    public void testNegativeCountWords()
    {
        Assertions.assertThrows(NullPointerException.class,()-> TextAnalyzer.countWords(null) );
    }

    // Pozitive value Tests for counting the sentences
    @Test
    public void testCountSentences1()
    {
        int num = TextAnalyzer.countSentences("Use the verification. Because you requested.");
        Assertions.assertEquals(2, num);
    }
    @Test
    public void testCountSentences2()
    {
        int num = TextAnalyzer.countSentences("Use the verification? Because you requested.");
        Assertions.assertEquals(2, num);
    }

    @Test
    public void testCountSentences3()
    {
        int num = TextAnalyzer.countSentences("Use the verification? Because you requested. But do not!");
        Assertions.assertEquals(3, num);
    }
    @Test
    public void testCountSentences4()
    {
        int num = TextAnalyzer.countSentences("      ");
        Assertions.assertEquals(0, num);
    }
    // Negative case for Sentences
    @Test
    public void testNegativeSentences()
    {
        Assertions.assertThrows(NullPointerException.class,()-> TextAnalyzer.countSentences(null) );
    }
    // Validation pozitive Tests
    @Test
    public void testValidation()
    {
        String filePath = "-file=src/test/resources/file.txt";
        String top = "-top=3";
        String phraseSize = "-phraseSize=2";

        TextAnalyzer.main(new String[] {filePath,top,phraseSize});
    }

    @Test
    public void testValidation2()
    {
        String filePath = "-file=src/test/resources/file.txt";
        String top = "-top=5";
        String phraseSize = "-phraseSize=1";

        TextAnalyzer.main(new String[] {filePath,top,phraseSize});
    }

    @Test
    public void testValidation3()
    {
        String filePath = "-file=src/test/resources/file.txt";
        String top = "-top=5";
        String phraseSize = "-phraseSize=4";

        TextAnalyzer.main(new String[] {filePath,top,phraseSize});
    }

    // Validation negative Tests
    @Test
    public void testNegativeValidation1() {
        String filePath = "-file=src/test/resources/file.txt";
        String top = "-top=";
        String phraseSize = "-phraseSize=2";
        try {
            TextAnalyzer.main(new String[]{filePath, top, phraseSize});
        } catch (RuntimeException e) {
        }
    }

    @Test
    public void testNegativeValidation2() {
        String filePath = "-file=src/test/resources/file.txt";
        String top = "-top=5";
        String phraseSize = "-phraseSize=0";
        try {
            TextAnalyzer.main(new String[]{filePath, top, phraseSize});
        } catch (RuntimeException e) {
        }
    }

    @Test
    public void testNegativeValidation3() {
        String filePath = "-file=src/test/resources/file.txt";
        String top = "-top=";
        String phraseSize = "-phraseSize=3";
        try {
            TextAnalyzer.main(new String[]{filePath, top, phraseSize});
        } catch (RuntimeException e) {
        }
    }

    @Test
    public void testNegativeValidation4() {
        String filePath = "-file=src/test/resources/file.txt";
        String top = "-top=5";
        String phraseSize = "-phraseSize=";
        try {
            TextAnalyzer.main(new String[]{filePath, top, phraseSize});
        } catch (RuntimeException e) {
        }
    }
    @Test
    public void testNegativeValidation5() {
        String filePath = "-file=src/test/resources/file.txt";
        String top = "-top=-5";
        String phraseSize = "-phraseSize=2";
        try {
            TextAnalyzer.main(new String[]{filePath, top, phraseSize});
        } catch (RuntimeException e) {
        }
    }

    @Test
    public void testNegativeValidation6() {
        String filePath = "-file=src/test/resources/file.txt";
        String top = "-top=5";
        String phraseSize = "-phraseSize=-2";
        try {
            TextAnalyzer.main(new String[]{filePath, top, phraseSize});
        } catch (RuntimeException e) {
        }
    }

    @Test
    public void testNegativeValidation7() {
        String filePath = "-file=src/test/resources/file.txt";
        String top = "-top=0";
        String phraseSize = "-phraseSize=";
        try {
            TextAnalyzer.main(new String[]{filePath, top, phraseSize});
        } catch (RuntimeException e) {
        }
    }

    @Test
    public void testNegativeValidation8() {
        String filePath = "-file=src/test/resources/file.txt";
        String top = "-top=";
        String phraseSize = "-phraseSize=0";
        try {
            TextAnalyzer.main(new String[]{filePath, top, phraseSize});
        } catch (RuntimeException e) {
        }
    }
    @Test
    public void testNegativeValidation9() {
        String filePath = "-file=src/test/resources/file.txt";
        String top = "-top=-2";
        String phraseSize = "-phraseSize=0";
        try {
            TextAnalyzer.main(new String[]{filePath, top, phraseSize});
        } catch (RuntimeException e) {
        }
    }

    @Test
    public void testNegativeValidation10() {
        String filePath = "-file=src/test/resources/file.txt";
        String top = "-top=0";
        String phraseSize = "-phraseSize=-2";
        try {
            TextAnalyzer.main(new String[]{filePath, top, phraseSize});
        } catch (RuntimeException e) {
        }
    }

    @Test
    public void testNegativeValidation11() {
        String filePath = "-file=src/test/resources/file.txt";
        String top = "-top=A";
        String phraseSize = "-phraseSize=2";

        try {
            TextAnalyzer.main(new String[]{filePath, top, phraseSize});
        } catch (RuntimeException e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void testNegativeValidation12() {
        String filePath = "-file=src/test/resources/file.txt";
        String top = "-top=2";
        String phraseSize = "-phraseSize=A";

        try {
            TextAnalyzer.main(new String[]{filePath, top, phraseSize});
        } catch (RuntimeException e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void testNegativeValidation13() {
        String filePath = "-file=src/test/resources/file.txt";
        String top = "-top=A";
        String phraseSize = "-phraseSize=A";

        try {
            TextAnalyzer.main(new String[]{filePath, top, phraseSize});
        } catch (RuntimeException e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void testNegativeValidation14() {
        String filePath = "-file=src/test/resources/file.txt";
        String top = "-top=A";
        String phraseSize = "-phraseSize=A";

        try {
            TextAnalyzer.main(new String[]{filePath, top, phraseSize});
        } catch (RuntimeException e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void testNegativeValidation15() {
        String filePath = "-file=src/test/resources/file.txt";
        String top = "-top=A";
        String phraseSize = "-phraseSize=0";

        try {
            TextAnalyzer.main(new String[]{filePath, top, phraseSize});
        } catch (RuntimeException e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void testNegativeValidation16() {
        String filePath = "-file=src/test/resources/file.txt";
        String top = "-top=-2";
        String phraseSize = "-phraseSize=A";

        try {
            TextAnalyzer.main(new String[]{filePath, top, phraseSize});
        } catch (RuntimeException e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void testNegativeValidation17() {
        String filePath = "-file=src/test/resources/file.txt";
        String top = "-top=-A";
        String phraseSize = "-phraseSize=7";

        try {
            TextAnalyzer.main(new String[]{filePath, top, phraseSize});
        } catch (RuntimeException e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }
}
