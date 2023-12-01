package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ResultAmounts implements Iterable<Amount> {
    private final List<Amount> amounts;

    public ResultAmounts(String inputAmounts) {
        validate(inputAmounts);

        String[] inputs = inputAmounts.split(",");
        List<Amount> amountList = new ArrayList<>();
        for (String input : inputs) {
            amountList.add(new Amount(input.trim()));
        }

        this.amounts = amountList;
    }

    private void validate(String inputAmounts) {
        checkAmountsSizeIsValid(inputAmounts);
    }

    private void checkAmountsSizeIsValid(String inputAmounts) {
        if (inputAmounts == null) {
            throw new IllegalArgumentException("실행 결과의 갯수는 최소 1개 이상이어야 합니다.");
        }
    }

    @Override
    public Iterator<Amount> iterator() {
        return this.amounts.iterator();
    }
}
