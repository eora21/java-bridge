package bridge.view;

import bridge.model.BridgeType;
import java.util.ArrayList;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String ERROR = "[ERROR] ";

    private static final String selectionGuide = String.join(", ", new ArrayList<>() {{
        for (BridgeType bridge : BridgeType.values()) {
            add(String.format("%s: %s", bridge.getPosition(), bridge.getText()));
        }
    }});

    public void printGameStart() {
        out("다리 건너기 게임을 시작합니다.");
    }

    public void printRequestBridgeLength() {
        blank();
        out("다리의 길이를 입력해주세요.");
    }

    public void printExceptionMessage(String text) {
        out(ERROR + text);
    }

    public void printRequestMoveBridge() {
        out(String.format("이동할 칸을 선택해주세요. (%s)", selectionGuide));
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    private void out(String text) {
        System.out.println(text);
    }

    private void blank() {
        System.out.println();
    }
}
