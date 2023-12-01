package nextstep.ladder.view;

import nextstep.ladder.domain.*;

public class OutputView {
    private static final StringBuilder sb = new StringBuilder();

    public static void printLadder(PersonNames personNames, Ladder ladder, ResultAmounts resultAmounts) {
        sb.setLength(0);

        appendPersonNames(personNames);
        appendLadder(ladder);
        appendResultAmounts(resultAmounts);

        System.out.println(sb);
    }

    private static void appendPersonNames(PersonNames personNames) {
        for (Name name : personNames) {
            sb.append(String.format ("%5s", name));
        }
        sb.append("\n");
    }

    private static void appendLadder(Ladder ladder) {
        for (Line line : ladder) {
            sb.append("   |");
            appendLine(line);
            sb.append("\n");
        }
    }

    private static void appendLine(Line line) {
        for (Point point : line.points()) {
            if(point.isPoint()) {
                sb.append("-----");
                sb.append("|");
            }

            if(!point.isPoint()) {
                sb.append("     ");
                sb.append("|");
            }
        }
    }

    private static void appendResultAmounts(ResultAmounts resultAmounts) {
        for (Amount amount : resultAmounts) {
            sb.append(String.format ("%5s", amount));
        }
        sb.append("\n");
    }
}
