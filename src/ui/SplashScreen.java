package ui;

import javax.swing.*;
import java.awt.*;

public class SplashScreen extends JFrame {

    JProgressBar bar;

    public SplashScreen() {

        setTitle("MindCanvas");

        setSize(600, 400);

        setLocationRelativeTo(null);

        setUndecorated(true);

        setLayout(null);

        JLabel title =
                new JLabel(
                        "MindCanvas"
                );

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        36
                )
        );

        title.setBounds(
                180,
                120,
                300,
                50
        );

        add(title);

        bar = new JProgressBar();

        bar.setBounds(
                100,
                250,
                400,
                30
        );

        add(bar);

        setVisible(true);

        load();
    }

    public void load() {

        try {

            for (int i = 0; i <= 100; i++) {

                bar.setValue(i);

                Thread.sleep(30);
            }

            dispose();

            new LoginPage();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}