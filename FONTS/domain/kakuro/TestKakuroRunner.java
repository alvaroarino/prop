package domain.kakuro;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestKakuroRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(KakuroTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("El test ha ido bien");
        } else {
            System.out.println("El test ha ido mal");
        }
    }
}

