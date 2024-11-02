package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class lottoDraw {
    public static List<Integer> pickNumbers(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
    public static Lotto drawLotto(){
        return new Lotto(pickNumbers());
    }

    public static List<Lotto> drawLottos(int count){
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < count; i++){
            lottos.add(drawLotto());
        }
        return lottos;
    }
}
