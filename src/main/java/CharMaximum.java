import java.util.concurrent.ArrayBlockingQueue;

public class CharMaximum extends Thread {
    private static int showLength;
    private char symbol;
    private ArrayBlockingQueue<String> strings;
    private String maxFreqSymbolString;

    public CharMaximum(char symbol, int size) {
        this.symbol = symbol;
        this.strings = new ArrayBlockingQueue<>(size);
        this.showLength = showLength;
    }

    public static void setShowLength(int showLength) {
        CharMaximum.showLength = showLength;
    }

    @Override
    public void run() {
        super.run();
        maxFreqSymbolString = strings.stream()
                .max((o1, o2) -> {
                    int charCount1 = new CharCounter(symbol, o1).getCharCount();
                    int charCount2 = new CharCounter(symbol, o2).getCharCount();
                    return charCount1 - charCount2;
                })
                .get();
        System.out.println("Символ [" + getSymbol()
                + "] в строке [" + maxFreqSymbolString.substring(0, showLength) + "] повторяется "
                + new CharCounter(symbol, maxFreqSymbolString).getCharCount()
                + " раз");
    }

    public ArrayBlockingQueue<String> getStrings() {
        return strings;
    }

    public char getSymbol() {
        return symbol;
    }
}
