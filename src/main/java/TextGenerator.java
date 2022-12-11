import java.util.Random;

public class TextGenerator {
    private String letters;
    private int length;

    public TextGenerator(String letters, int length) {
        this.letters = letters;
        this.length = length;
    }

    public String getGeneratedText() {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < this.length; i++) {
            text.append(this.letters.charAt(random.nextInt(this.letters.length())));
        }
        return text.toString();
    }
}
