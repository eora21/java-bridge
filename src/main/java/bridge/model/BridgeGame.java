package bridge.model;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final int DEFAULT = 0;

    private final Bridges bridges;
    private final BridgeGameLog bridgeGameLog;
    private int tryCount = DEFAULT;
    private int turn = DEFAULT;

    public BridgeGame(Bridges bridges, BridgeGameLog bridgeGameLog) {
        this.bridges = bridges;
        this.bridgeGameLog = bridgeGameLog;
        tryCount++;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public GameStatus move(Bridge bridge) {
        boolean safe = bridges.isSafe(turn++, bridge);
        bridgeGameLog.addLog(bridge, safe);
        return gameStatus(safe);
    }

    private GameStatus gameStatus(boolean safe) {
        if (!safe) {
            return GameStatus.FAIL;
        }

        if (turn == bridges.size()) {
            return GameStatus.SUCCESS;
        }

        return GameStatus.IN_PROGRESS;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        tryCount++;
        turn = DEFAULT;
        bridgeGameLog.resetLog();
    }
}
