package bridge.model;

import java.util.Arrays;

public enum BridgeCommand {
    UP_COMMAND("U", 1, "위", Bridge.UP_BRIDGE),
    DOWN_COMMAND("D", 0, "아래", Bridge.DOWN_BRIDGE);

    private final String command;
    private final int randomValue;
    private final String description;
    private final Bridge bridge;

    BridgeCommand(String command, int randomValue, String description, Bridge bridge) {
        this.command = command;
        this.randomValue = randomValue;
        this.description = description;
        this.bridge = bridge;
    }

    public static String findCommandByRandomValue(int randomValue) {
        return Arrays.stream(BridgeCommand.values())
                .filter(bridgeCommand -> bridgeCommand.randomValue == randomValue)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 커맨드가 없습니다."))
                .command;
    }

    public static Bridge findBridgeByCommand(String command) {
        return Arrays.stream(BridgeCommand.values())
                .filter(bridgeCommand -> bridgeCommand.command.equals(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("커맨드와 일치하는 다리가 없습니다."))
                .bridge;
    }

    public String getCommand() {
        return command;
    }

    public String getDescription() {
        return description;
    }
}
