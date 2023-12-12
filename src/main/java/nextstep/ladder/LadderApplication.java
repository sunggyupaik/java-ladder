package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.concrete.RandomLineCreateStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderApplication {
    public static void main(String[] args) {
        String[] inputNames = InputView.inputNames();
        Players players = new Players(inputNames);

        String[] inputAmounts = InputView.inputAmounts();
        Amounts amounts = new Amounts(inputAmounts);

        int inputHeight = InputView.inputHeight();
        Height height = new Height(inputHeight);

        Ladder ladder = new Ladder(players, height, new RandomLineCreateStrategy());
        LadderGame ladderGame = new LadderGame(players, ladder, amounts);
        OutputView.printLadder(players, ladder, amounts);

        LadderGameResult ladderGameResult = ladderGame.realPlay();
        OutputView.printResultLoop(ladderGameResult);
    }
}
