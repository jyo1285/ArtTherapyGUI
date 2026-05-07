package main;

import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

import database.DatabaseInitializer;
import ui.SplashScreen;

public class MainApp {

    public static void main(String[] args) {

        try {

            UIManager.setLookAndFeel(
                    new FlatLightLaf()
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

        DatabaseInitializer.initialize();

        new SplashScreen();
    }
}