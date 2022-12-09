package bridge.controller;

import bridge.model.BridgeGame;
import bridge.service.BridgeGameService;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView(outputView);
    private final BridgeGameService bridgeGameService = new BridgeGameService();

    public void startGame() {
        outputView.printGameStart();
        BridgeGame bridgeGame = createBridgeGame();
    }

    private BridgeGame createBridgeGame() {
        int bridgeSize = inputView.readBridgeSize();
        return bridgeGameService.createBridgeGame(bridgeSize);
    }
}
