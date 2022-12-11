public class CharCounter {
    private char symbol;
    private String str;

    public CharCounter(char symbol, String str) {
        this.symbol = symbol;
        this.str = str;
    }

    public int getCharCount() {
        int cnt = 0;
        char[] a;
        a = str.toCharArray();
        for (char c : a) {
            if (c == symbol) {
                cnt++;
            }
        }
        return cnt;
    }
}
