package bridge.model;

public enum GameStatus {
    IN_PROGRESS("진행중"),
    SUCCESS("성공"),
    FAIL("실패");

    private final String description;

    GameStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
