package bridge.model;

import java.util.Arrays;

public enum QuitStatus {
    QUIT("Q", "종료"),
    RETRY("R", "재시도");

    private final String command;
    private final String description;

    QuitStatus(String command, String description) {
        this.command = command;
        this.description = description;
    }

    public static QuitStatus findByCommand(String command) {
        return Arrays.stream(QuitStatus.values())
                .filter(quitStatus -> quitStatus.command.equals(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 커맨드입니다."));
    }

    public String getCommand() {
        return command;
    }

    public String getDescription() {
        return description;
    }
}
