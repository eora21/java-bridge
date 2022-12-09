package bridge.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BridgeGameLog {

    private final List<Log> gameLog = new ArrayList<>();

    public void addLog(Log log) {
        gameLog.add(log);
    }

    public void resetLog() {
        gameLog.clear();
    }

    public List<Log> getLog() {
        return Collections.unmodifiableList(gameLog);
    }
}
