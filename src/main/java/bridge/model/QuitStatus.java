package bridge.model;

import java.util.Arrays;

public enum QuitStatus {
    QUIT("Q", "종료", true),
    RETRY("R", "재시도", false);

    private final String command;
    private final String description;
    private final boolean status;

    QuitStatus(String command, String description, boolean status) {
        this.command = command;
        this.description = description;
        this.status = status;
    }

    public static boolean findStatusByCommand(String command) {
        return Arrays.stream(QuitStatus.values())
                .filter(quitStatus -> quitStatus.command.equals(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 커맨드입니다."))
                .status;
    }

    public String getCommand() {
        return command;
    }

    public String getDescription() {
        return description;
    }
}
