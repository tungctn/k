package uet.oop.bomberman.entities.animatableEntities;

import javafx.scene.image.Image;
import uet.oop.bomberman.Board;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.animatableEntities.moveableEntities.Bomber;
import uet.oop.bomberman.graphics.Sprite;

public class Bomb extends AnimatableEntities {
  private boolean exploded = false;

  public Bomb(int boardX, int boardY, Image img) {
    super(boardX, boardY, img);
  }

  public Bomb(int boardX, int boardY, Image img, Board board) {
    super(boardX, boardY, img, board);
  }

  public void animate() {
    if (!exploded) {
      if (anime < 150) {
        anime++;
        imageAnimationHandler();
      } else {
        explode();
      }
    }
  }

  @Override
  public void collide(Entity entity) {
    if (entity instanceof Flame) {
      explode();
    }
  }

  public void explode() {
    exploded = true;
    removedFromBoard = true;
    board.addStillObject(new Flame(boardX, boardY, Bomber.flameSize, board));
  }

  @Override
  public void imageAnimationHandler() {
    if (!exploded) {
      this.img = Sprite.movingSprite(Sprite.bomb_2, Sprite.bomb_1, Sprite.bomb, anime, 100).getFxImage();
    } else {
      this.img = Sprite.movingSprite(Sprite.bomb_exploded, Sprite.bomb_exploded1, Sprite.bomb_exploded2, anime, 120).getFxImage();
    }
  }

  @Override
  public void update() {
    animate();
    collisionHandler();

  }
}
