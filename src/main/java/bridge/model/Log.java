package bridge.model;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Log {

    private static final Map<Bridge, Map<Boolean, Log>> CACHE = new EnumMap<>(Bridge.class) {{
        for (Bridge bridge : Bridge.values()) {
            put(bridge, new HashMap<>());
        }
    }};

    private final Bridge bridge;
    private final boolean safe;

    private Log(Bridge bridge, boolean safe) {
        this.bridge = bridge;
        this.safe = safe;
    }

    public static Log getInstance(Bridge bridge, boolean isSafe) {
        Log log = CACHE.get(bridge).get(isSafe);

        if (Objects.isNull(log)) {
            log = new Log(bridge, isSafe);
            CACHE.get(bridge).put(isSafe, log);
        }

        return log;
    }

    public Bridge getBridge() {
        return bridge;
    }

    public boolean getSafe() {
        return safe;
    }
}
