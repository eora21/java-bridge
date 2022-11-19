package bridge;

import bridge.model.BridgeSizeRule;
import bridge.model.BridgeType;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        validate(size);
        return new ArrayList<>(size) {{
            for (int idx = 0; idx < size; idx++) {
                add(BridgeType.convertRandomNumberToText(bridgeNumberGenerator.generate()));
            }
        }};
    }

    private void validate(int size) {
        if (size < BridgeSizeRule.START.getSize() || BridgeSizeRule.END.getSize() < size) {
            throw new IllegalArgumentException(
                    String.format("다리의 길이는 %d부터 %d사이의 숫자여야 합니다.",
                            BridgeSizeRule.START.getSize(),
                            BridgeSizeRule.END.getSize()));
        }
    }
}
