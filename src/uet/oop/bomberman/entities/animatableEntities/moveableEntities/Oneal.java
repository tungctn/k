package uet.oop.bomberman.entities.animatableEntities.moveableEntities;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;

public class Oneal extends MovableEntities {

  public Oneal(int boardX, int boardY, Image img) {
    super( boardX, boardY, img);
    speed = 0.5;
  }

  public void destroy() {
    removedFromBoard = true;
  }

  @Override
  public void update() {
    //



  }


  @Override
  public void imageAnimationHandler() {

  }

  @Override
  public void moveHandler() {

  }

  @Override
  public void move(int xS, int yS) {

  }

  @Override
  public boolean canMoveBrickAndWall(int xS, int yS) {
    return false;
  }

  @Override
  public void collisionHandler() {

  }

  @Override
  public void collide(Entity entity) {

  }
}
