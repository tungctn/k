package uet.oop.bomberman;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.animatableEntities.moveableEntities.Bomber;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.utils.GameScreen;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.lang.Math;

public class BombermanGame extends Application {

    public static final int SCREEN_WIDTH = 20;
    public static final int SCREEN_HEIGHT = 20;
    public static String WinOrLose = "";
    public int loopCount = 0;
    public long start = System.currentTimeMillis();
    public  static int  levelGame=2;
    public static Clip clip;
    
    
    private GraphicsContext gc;
    private Canvas canvas;
    private Pane screenPane = new Pane();
    // Tao scene
    Scene scene = new Scene(screenPane);
    // Tao board
    Board board = new Board(scene);
    public static void main(String[] args) { launch(args); }
    @Override
    public void start(Stage stage) throws InterruptedException, IOException, UnsupportedAudioFileException, LineUnavailableException {
        File file = new File("res\\tieng-de-keu.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        // Tao root container
        screenPane.setMaxWidth(Sprite.SCALED_SIZE * SCREEN_WIDTH);
        screenPane.setMaxHeight(Sprite.SCALED_SIZE * SCREEN_HEIGHT);
        // Tao Canvas
        canvas = new Canvas(Sprite.SCALED_SIZE * board.width, Sprite.SCALED_SIZE * board.height);
        gc = canvas.getGraphicsContext2D();
        screenPane.getChildren().add(canvas);
        // Them scene vao stage
        stage.setScene(scene);
        Pane pane = (Pane) scene.getRoot();
        pane.getChildren().add(new Label("Hello"));
        stage.show();

   //     while (board.levelGame <= 2 ){ }

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                loopCount++;

                if (System.currentTimeMillis() - start > 1000) {
                    //log("FPS: " + loopCount, ANSI_BLUE);
                    stage.setTitle("Bomberman");
                    loopCount = 0;
                    start = System.currentTimeMillis();
                }
                if (WinOrLose =="lose") {
                    screenPane.getChildren().setAll(new Label("YOU LOSE"));
                    screenPane.getChildren().add(canvas);
                    WinOrLose = "";
                    System.out.println("lose"+board);
                    board = new Board(scene);
                    stage.setScene(scene);
                }
                if (WinOrLose =="win") {
                    screenPane.getChildren().setAll(new Label("YOU WIN"));
                    screenPane.getChildren().add(canvas);
                    WinOrLose = "";
                    if(levelGame==5) levelGame=1;
                    else levelGame++;
                    System.out.println("win"+levelGame);
                    board = new Board(scene);
                    stage.setScene(scene);
                }


                render();
                update();
            }
        };
        timer.start();
    }

    public void update() {
        board.update();
        GameScreen.screenShiftHandler(board.getEntities(), canvas, screenPane);
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        board.render(gc);
    }


}
