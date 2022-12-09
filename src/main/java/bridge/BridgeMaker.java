package bridge;

import bridge.model.Bridge;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private static final int START = 3;

    private static final int END = 20;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        validSize(size);
        return new ArrayList<>() {{
            add(Bridge.findCommandByRandomValue(bridgeNumberGenerator.generate()));
        }};
    }

    private void validSize(int size) {
        if (size < START || END < size) {
            throw new IllegalArgumentException(String.format("다리 길이는 %d부터 %d 사이의 숫자여야 합니다.", START, END));
        }
    }
}
