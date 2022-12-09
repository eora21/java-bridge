package bridge.controller;

import bridge.view.OutputView;
import java.util.function.Supplier;

public class ExceptionController {

    private final OutputView outputView;

    public ExceptionController(OutputView outputView) {
        this.outputView = outputView;
    }

    public <T> T getCorrectInput(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printInputMessage(String.format("[ERROR] %s", e.getMessage()));
            }
        }
    }
}
