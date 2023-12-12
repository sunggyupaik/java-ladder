package nextstep.ladder.domain;

import java.util.Random;

public class Brace {
    private final boolean left;
    private final boolean right;

    public Brace(boolean left, boolean right) {
        validate(left, right);

        this.left = left;
        this.right = right;
    }

    private void validate(boolean left, boolean right) {
        checkTwoPointsAttached(left, right);
    }

    private static void checkTwoPointsAttached(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("사다리는 2개가 연속해서 만들어질 수 없습니다.");
        }
    }

    public int move(int index) {
        if (isLeft()) {
            return index - 1;
        }

        if (isRight()) {
            return index + 1;
        }

        return index;
    }

    public static Brace first() {
        return new Brace(false, random());
    }

    public Brace last() {
        return new Brace(this.right, false);
    }

    public Brace next() {
        if (isRight()) {
            return new Brace(true, false);
        }

        return new Brace(false, random());
    }

    private static boolean random() {
        return new Random().nextBoolean();
    }

    public boolean isLeft() {
        return this.left;
    }

    public boolean isRight() {
        return this.right;
    }
}
