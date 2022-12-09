package bridge.view;

import bridge.model.BridgeCommand;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String explainBridgeCommand = Arrays.stream(BridgeCommand.values())
            .map(bridgeCommand -> String.format("%s: %s", bridgeCommand.getCommand(), bridgeCommand.getDescription()))
            .collect(Collectors.joining(", ", "(", ")"));

    private final OutputView outputView;

    public InputView(OutputView outputView) {
        this.outputView = outputView;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        outputView.printInputMessage("다리의 길이를 입력해주세요.");
        String input = Console.readLine();
        outputView.blank();
        return toInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        outputView.printInputMessage(String.format("이동할 칸을 선택해주세요. %s", explainBridgeCommand));
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값을 정수로 변환할 수 없습니다.");
        }
    }
}
