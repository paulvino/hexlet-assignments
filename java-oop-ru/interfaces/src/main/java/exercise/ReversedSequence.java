package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {
    private String string;

    public ReversedSequence() {
    }

    public ReversedSequence(String string) {
        this.string = string;
    }

    public CharSequence reverse(String incomeString) {
        StringBuilder resultString = new StringBuilder(incomeString);
        return new StringBuilder(resultString).reverse();
    }

    public String getString() {
        return reverse(string).toString();
    }

    public String toString() {
        return getString();
    }

    @Override
    public int length() {
        return getString().length();
    }

    @Override
    public char charAt(int index) {
        return getString().charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return getString().subSequence(start, end);
    }
}
// END
