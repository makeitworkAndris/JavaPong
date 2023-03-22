import javax.swing.*;

public class Main {
    static JFrame frame = new JFrame("Pong");

    public static void main(String[] args) {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(650,495);

        PongGame game = new PongGame();
        frame.add(game);

        frame.setVisible(true);
    }
}
