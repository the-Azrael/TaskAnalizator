import java.util.concurrent.CopyOnWriteArrayList;

public class CharMaximums {
    private static CopyOnWriteArrayList<CharMaximum> threads = new CopyOnWriteArrayList<>();

    public CharMaximums() {
    }

    public CopyOnWriteArrayList<CharMaximum> getThreads() {
        return threads;
    }

    public CharMaximum find(char symbol, int length) {
        for (CharMaximum cm : threads) {
            if (cm.getSymbol() == symbol) {
                return cm;
            }
        }
        CharMaximum cm = new CharMaximum(symbol, length);
        threads.add(cm);
        return cm;
    }
}
