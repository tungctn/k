package uet.oop.bomberman.entities.items;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;

public class SpeedItem extends Entity {

  public SpeedItem(int boardX, int boardY, Image img) {
    super( boardX, boardY, img);
  }

  @Override
  public void update() {

  }

  public void destroy() {
    removedFromBoard = true;
  }


}
