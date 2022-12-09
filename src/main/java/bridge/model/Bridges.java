package bridge.model;

import java.util.List;
import java.util.stream.Collectors;

public class Bridges {
    private final List<Bridge> bridges;

    public Bridges(List<String> bridgeCommands) {
        this.bridges = bridgeCommands.stream()
                .map(Bridge::findBridgeByCommand)
                .collect(Collectors.toList());
    }

    public boolean isSafe(int turn, Bridge bridge) {
        try {
            return bridges.get(turn) == bridge;
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("다리의 범위를 벗어났습니다.");
        }
    }

    public int size() {
        return bridges.size();
    }
}
