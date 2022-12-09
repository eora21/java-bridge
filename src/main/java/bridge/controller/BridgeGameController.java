package bridge.controller;

import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.model.GameStatus;
import bridge.model.QuitStatus;
import bridge.service.BridgeGameService;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView(outputView);
    private final BridgeGameService bridgeGameService = new BridgeGameService();
    private final ExceptionController exceptionController = new ExceptionController(outputView);

    public void startGame() {
        outputView.printGameStart();
        BridgeGame bridgeGame = createBridgeGame();
        GameStatus gameStatus = playGame(bridgeGame);
    }

    private BridgeGame createBridgeGame() {
        int bridgeSize = exceptionController.getCorrectInput(inputView::readBridgeSize);
        return bridgeGameService.createBridgeGame(bridgeSize);
    }

    private GameStatus playGame(BridgeGame bridgeGame) {
        while (true) {
            Bridge bridge = selectBridge();
            GameStatus status = bridgeGame.move(bridge);

            if (isOver(status)) {
                return status;
            }
        }
    }

    private Bridge selectBridge() {
        return exceptionController.getCorrectInput(() -> {
            String command = inputView.readMoving();
            return bridgeGameService.selectBridge(command);
        });
    }

    private boolean isOver(GameStatus status) {
        if (status == GameStatus.IN_PROGRESS) {
            return false;
        }

        if (status == GameStatus.FAIL) {
            return wantQuit();
        }

        return true;
    }

    private boolean wantQuit() {
        return exceptionController.getCorrectInput(() -> {
            String command = inputView.readGameCommand();
            return QuitStatus.findStatusByCommand(command);
        });
    }
}
