package uet.oop.bomberman.entities.animatableEntities;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;

public class Brick extends Entity {
  public Brick(int boardX, int boardY, Image img) {
    super( boardX, boardY, img);
  }

  public void destroy() {
    removedFromBoard = true;
  }

  @Override
  public void update() {

  }
}
