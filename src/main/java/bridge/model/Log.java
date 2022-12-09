package bridge.model;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

public class Log {
    enum Safe{O, X}

    private static final Map<Bridge, Map<Safe, Log>> CACHE = new EnumMap<>(Bridge.class) {{
        for (Bridge bridge : Bridge.values()) {
            put(bridge, new EnumMap<>(Safe.class));
        }
    }};

    private final Bridge bridge;
    private final Safe safe;

    private Log(Bridge bridge, Safe safe) {
        this.bridge = bridge;
        this.safe = safe;
    }

    public static Log getInstance(Bridge bridge, Safe safe) {
        Log log = CACHE.get(bridge).get(safe);

        if (Objects.isNull(log)) {
            log = new Log(bridge, safe);
            CACHE.get(bridge).put(safe, log);
        }

        return log;
    }

    public Bridge getBridge() {
        return bridge;
    }

    public Safe getSafe() {
        return safe;
    }
}
