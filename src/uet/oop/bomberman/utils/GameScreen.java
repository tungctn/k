package uet.oop.bomberman.utils;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import uet.oop.bomberman.entities.animatableEntities.moveableEntities.Bomber;
import uet.oop.bomberman.entities.Entity;

import java.util.List;

public class GameScreen {
  public static void screenShiftHandler(List<Entity> entities, Canvas canvas, Pane screenPane) {
    Entity bomber = null;
    for (Entity e : entities) {
      if (e instanceof Bomber) bomber = e;
    }

    assert bomber != null;
    if (bomber.getX() > screenPane.getWidth() / 2 && bomber.getX() < canvas.getWidth() - screenPane.getWidth() / 2) {
      canvas.setTranslateX(-bomber.getX() + screenPane.getWidth() / 2);
    }
  }
}
