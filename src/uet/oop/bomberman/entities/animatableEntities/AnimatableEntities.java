package uet.oop.bomberman.entities.animatableEntities;

import javafx.scene.image.Image;
import uet.oop.bomberman.Board;
import uet.oop.bomberman.entities.Entity;

public abstract class AnimatableEntities extends Entity {
  public int anime = 0;
  protected Board board = null;

  public AnimatableEntities(int boardX, int boardY, Image img) {
    super(boardX, boardY, img);
  }

  public AnimatableEntities(int boardX, int boardY, Image img, Board board) {
    super(boardX, boardY, img);
    this.board = board;
  }

  public void animate() {
    if(anime < 60) anime++;
    else anime = 0;
  }

  public void collisionHandler() {
    board.getEntities().forEach(entity -> {
      if (entity != this && this.realBodyRectangle.overlaps(entity.getRealBodyRectangle())) {
        collide(entity);
      }
    });
    board.getStillObjects().forEach(entity -> {
      if (entity != this && this.realBodyRectangle.overlaps(entity.getRealBodyRectangle())) {
        collide(entity);
      }
    });
  }

  public abstract void collide(Entity entity);

  public abstract void imageAnimationHandler();

}
