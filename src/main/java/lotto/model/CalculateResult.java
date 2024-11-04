package lotto.model;

import static lotto.view.output.printLottoReturn;
import static lotto.view.output.printWinCounts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CalculateResult {
    private final List<Integer> winningLottoNumbers;
    private final int bonusNumber;
    private final List<SingleResult> results;

    public CalculateResult(WinningLotto winningLotto) {
        this.winningLottoNumbers = winningLotto.getNumbers();
        this.bonusNumber = winningLotto.getBonusNumber();
        this.results = new ArrayList<>();
    }

    public SingleResult findMatches(Lotto lotto){
        List<Integer> numbers = lotto.getNumbers();
        SingleResult result = new SingleResult();
        for (Integer number : numbers) {
            if (this.winningLottoNumbers.contains(number)) {
                result.countUp();
            }
        }
        if (numbers.contains(this.bonusNumber)) {
            result.bonusCountUp();
        }
        return result;
    }

    public void calculateMatches(List<Lotto> lottos){
        for (Lotto lotto : lottos) {
            this.results.add(findMatches(lotto));
        }
    }

    public List<Integer> getWinCounts(){
        List<Integer> winCounts = new ArrayList<>(Collections.nCopies(6, 0));
        for (SingleResult singleResult : this.results) {
            int rank = singleResult.getRank();
            winCounts.set(rank, winCounts.get(rank) + 1);
        }
        return winCounts;
    }

    public float getLottoReturns(int totalCount){
        int total = 0;
        for (SingleResult singleResult : this.results) {
            total += singleResult.getPrize();
        }
        return ((float) total / (totalCount * 1000)) * 100;
    }

    public void getTotalResult(int totalCount){
        float lottoReturn = getLottoReturns(totalCount);
        List<Integer> winCounts = getWinCounts();
        printWinCounts(winCounts);
        printLottoReturn(lottoReturn);
    }
}
