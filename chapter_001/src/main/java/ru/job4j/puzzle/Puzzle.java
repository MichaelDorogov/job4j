package ru.job4j.puzzle;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import ru.job4j.puzzle.firuges.Block;
import ru.job4j.puzzle.firuges.Cell;
import ru.job4j.puzzle.firuges.Checker;
import ru.job4j.puzzle.firuges.Figure;

import java.net.URL;
import java.util.Random;

public class Puzzle extends Application {
    private static final String JOB4J = "Пазлы на www.job4j.ru";
    private final int size = 5;
    private final Logic logic = new Logic(size);
    private static final int RECTANGLE_SIZE = 40;
    private static final int FIGURE_SIZE = 30;

    private Rectangle buildRectangle(int x, int y) {
        Rectangle rect = new Rectangle();
        rect.setX(x * RECTANGLE_SIZE);
        rect.setY(y * RECTANGLE_SIZE);
        rect.setHeight(RECTANGLE_SIZE);
        rect.setWidth(RECTANGLE_SIZE);
        rect.setFill(Color.WHITE);
        rect.setStroke(Color.BLACK);
        return rect;
    }

    private Rectangle buildFigure(int x, int y, String image) {
        Rectangle rect = new Rectangle();
        rect.setX(x);
        rect.setY(y);
        rect.setHeight(FIGURE_SIZE);
        rect.setWidth(FIGURE_SIZE);
        URL resource = this.getClass().getClassLoader().getResource(image);
        if (resource == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(JOB4J);
            alert.setHeaderText(null);
            alert.setContentText("Обнаружена ошибка в ходе выполнения программы!");
            alert.showAndWait();
            Platform.exit();
            System.exit(-1);
        }
        Image img = new Image(resource.toString());
        rect.setFill(new ImagePattern(img));
        final Rectangle memento = new Rectangle(x, y);
        rect.setOnDragDetected(
                event -> {
                    memento.setX(event.getX());
                    memento.setY(event.getY());
                }
        );
        rect.setOnMouseDragged(
                event -> {
                    rect.setX(event.getX() - (double) (FIGURE_SIZE / 2));
                    rect.setY(event.getY() - (double) (FIGURE_SIZE / 2));
                }
        );
        rect.setOnMouseReleased(
                event -> {
                    if (logic.move(this.extract(memento.getX(), memento.getY()), this.extract(event.getX(), event.getY()))) {
                        rect.setX((double) ((int) event.getX() / 40) * 40 + 5);
                        rect.setY((double) ((int) event.getY() / 40) * 40 + 5);
                        checkWinner();
                    } else {
                        rect.setX((double) ((int) memento.getX() / 40) * 40 + 5);
                        rect.setY((double) ((int) memento.getY() / 40) * 40 + 5);
                    }
                }
        );
        return rect;
    }

    private void checkWinner() {
        if (this.logic.isWin()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(JOB4J);
            alert.setHeaderText(null);
            alert.setContentText("Пазл решен! Начните новую Игру!");
            alert.showAndWait();
        }
    }

    private Group buildGrid() {
        Group panel = new Group();
        for (int y = 0; y != this.size; y++) {
            for (int x = 0; x != this.size; x++) {
                panel.getChildren().add(
                        this.buildRectangle(x, y)
                );
            }
        }
        return panel;
    }

    @Override
    public void start(Stage stage) {
        BorderPane border = new BorderPane();
        HBox control = new HBox();
        control.setPrefHeight(40);
        control.setSpacing(10.0);
        control.setAlignment(Pos.BASELINE_CENTER);
        Button start = new Button("Начать");
        start.setOnMouseClicked(
                event -> this.refresh(border)
        );
        control.getChildren().addAll(start);
        border.setBottom(control);
        border.setCenter(this.buildGrid());
        stage.setScene(new Scene(border, 400, 400));
        stage.setTitle(JOB4J);
        stage.setResizable(false);
        stage.show();
        this.refresh(border);
    }

    private void refresh(final BorderPane border) {
        Group grid = this.buildGrid();
        this.logic.clean();
        border.setCenter(grid);
        this.generate(true, 6, grid);
        this.generate(false, 5, grid);
    }

    public void generate(boolean block, int total, Group grid) {
        int count = total;
        final Random random = new Random();
        while (count > 0) {
            Cell position = new Cell(random.nextInt(size), random.nextInt(size));
            if (this.logic.isFree(position)) {
                if (block) {
                    this.add(new Block(position), grid);
                } else {
                    this.add(new Checker(position), grid);
                }
                count--;
            }
        }
    }

    public void add(Figure figure, Group grid) {
        this.logic.add(figure);
        Cell position = figure.position();
        grid.getChildren().add(
                this.buildFigure(
                        position.x * 40 + 5,
                        position.y * 40 + 5,
                        figure.icon()
                )
        );
    }

    private Cell extract(double graphX, double graphY) {
        return new Cell((int) graphX / 40, (int) graphY / 40);
    }
}
