package lotto;

import static lotto.model.lottoDraw.drawLottos;
import static lotto.view.input.readTotalAmount;
import static lotto.view.output.printBoughtLottos;

import java.util.List;
import lotto.controller.lottoController;
import lotto.model.Lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int totalCount = readTotalAmount();
        List<Lotto> Lottos = drawLottos(totalCount);
        printBoughtLottos(totalCount, Lottos);
        // buy lottos
        Lotto winningLotto = lottoController.winningLotto();
        int bonusNumber = lottoController.bonusNumber();
    }
}
