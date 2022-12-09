package bridge.model;

import java.util.Arrays;

public enum Bridge {
    UP("U", 1, "위"),
    DOWN("D", 0, "아래");

    private final String command;
    private final int randomValue;
    private final String description;

    Bridge(String command, int randomValue, String description) {
        this.command = command;
        this.randomValue = randomValue;
        this.description = description;
    }

    public static String findCommandByRandomValue(int randomValue) {
        return Arrays.stream(Bridge.values())
                .filter(bridgeCommand -> bridgeCommand.randomValue == randomValue)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 커맨드가 없습니다."))
                .command;
    }

    public static Bridge findBridgeByCommand(String command) {
        return Arrays.stream(Bridge.values())
                .filter(bridgeCommand -> bridgeCommand.command.equals(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("커맨드와 일치하는 다리가 없습니다."));
    }

    public String getCommand() {
        return command;
    }

    public String getDescription() {
        return description;
    }
}
