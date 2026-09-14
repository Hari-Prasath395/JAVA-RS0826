package TestNGDemo.test;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class SuiteLevelListener implements ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        System.out.println("Suite execution about to START: " + suite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("Suite execution FINISHED: " + suite.getName());
        // e.g. send suite summary via email/Slack webhook here
    }
}
