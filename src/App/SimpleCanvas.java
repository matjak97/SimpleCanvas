package App;

import javax.swing.*;

public class SimpleCanvas extends JWindow {

    public JFrame contentPane;

    public static void main(String[] args) {
        SimpleCanvas application = new SimpleCanvas();
        application.startApp();
    }

    private void startApp() {
        contentPane = new JFrame();
        contentPane.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        contentPane.setVisible(true);
    }
}