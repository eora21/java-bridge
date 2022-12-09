package bridge.model;

import java.util.Arrays;

public enum BridgeCommand {
    UP("U", 1),
    DOWN("D", 0);

    private final String command;

    private final int randomValue;

    BridgeCommand(String command, int randomValue) {
        this.command = command;
        this.randomValue = randomValue;
    }

    public static String findCommandByRandomValue(int randomValue) {
        return Arrays.stream(BridgeCommand.values())
                .filter(bridge -> bridge.randomValue == randomValue)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 커맨드가 없습니다."))
                .command;
    }
}
