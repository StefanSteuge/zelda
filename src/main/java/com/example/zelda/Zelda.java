package com.example.zelda;

import com.example.zelda.engine.Game;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

@SpringBootApplication
public class Zelda {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Zelda::createAndRunGame);
    }
    private static void createAndRunGame() {
        JFrame frame = new JFrame();
        frame.setIgnoreRepaint(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);

        Game game = new Game();
        View view =new View(game, frame);
        Controller controller = new Controller(game, view, frame);

        if (game.isDebug()) {
            frame.setLocationRelativeTo(null);
            frame.setSize(game.getWidth(), game.getHeight());
        }

        frame.setVisible(true);
    }
}
