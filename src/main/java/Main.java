public class Main {
    private static final String LETTERS = "abc";
    private static final char[] ARR = LETTERS.toCharArray();
    public static final int STRINGS_COUNT = 10_000;
    private static final int MAX_LENGTH = 100_000;
    private static final int MAX_SHOW_LENGTH = 100;
    private static final CharMaximums charMaximumList = new CharMaximums();
    private static final TextGenerator textGenerator = new TextGenerator(LETTERS, MAX_LENGTH);

    public static void main(String[] args) throws InterruptedException {
        CharMaximum.setShowLength(MAX_SHOW_LENGTH);
        Thread generateThread = new Thread(() -> {
            for (int i = 0; i < STRINGS_COUNT; i++) {
                String symbolsString = textGenerator.getGeneratedText();
                for (char c : ARR) {
                    CharMaximum cm = charMaximumList.find(c, STRINGS_COUNT);
                    if (cm.getStrings().size() < STRINGS_COUNT) {
                        cm.getStrings().add(symbolsString);
                    }
                }
            }
        });
        generateThread.start();
        generateThread.join();
        for (CharMaximum cm : charMaximumList.getThreads()) {
            cm.start();
        }
    }

}
