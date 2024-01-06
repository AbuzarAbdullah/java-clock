package com.example;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ClockApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Clock");

        Label timeLabel = new Label();
        StackPane root = new StackPane();
        root.getChildren().add(timeLabel);

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            timeLabel.setText(dateFormat.format(new Date()));
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        Scene scene = new Scene(root, 300, 150);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
