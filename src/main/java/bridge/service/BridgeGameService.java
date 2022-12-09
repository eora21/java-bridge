package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.model.BridgeGameLog;
import bridge.model.Bridges;
import java.util.List;

public class BridgeGameService {

    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);


    public BridgeGame createBridgeGame(int bridgeSize) {
        List<String> bridgeCommands = bridgeMaker.makeBridge(bridgeSize);
        Bridges bridges = new Bridges(bridgeCommands);
        return new BridgeGame(bridges, new BridgeGameLog());
    }

    public Bridge selectBridge(String command) {
        return Bridge.findBridgeByCommand(command);
    }
}
