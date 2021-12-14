package uet.oop.bomberman.entities.items;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.Board;
import uet.oop.bomberman.entities.animatableEntities.moveableEntities.Bomber;

public class BombItem extends Entity {

  public BombItem(int boardX, int boardY, Image img) {
    super( boardX, boardY, img);

  }

  public void destroy() {
    removedFromBoard = true;
  }




  @Override
  public void update() {

  }
}
