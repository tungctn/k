package uet.oop.bomberman.entities.animatableEntities.moveableEntities;

import javafx.scene.image.Image;
import uet.oop.bomberman.Board;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.animatableEntities.Brick;
import uet.oop.bomberman.entities.stillEntities.Wall;
import uet.oop.bomberman.graphics.Sprite;

public class Oneal extends MovableEntities {

  public Oneal(int boardX, int boardY, Image img, Board board) {
    super( boardX, boardY, img, board);
    speed = 1;
    chooseDirectionRandom();
  }

  public void destroy() {
    removedFromBoard = true;
  }

  @Override
  public void update() {
    //
    moveHandlerBalloon();
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
    int topLeftX = x + xS;
    int topLeftY = y + yS + 5 * Sprite.SCALE; // cúi cái đầu xuống 1 chút :)
    int topRightX = topLeftX + (Sprite.player_down.getRealWidth() - 1) * Sprite.SCALE;
    int topRightY = topLeftY;
    int botLeftX = topLeftX;
    int botLeftY = topLeftY + (Sprite.player_down.getRealHeight() - 5) * Sprite.SCALE;
    int botRightX = topRightX;
    int botRightY = botLeftY;
    Entity object = null;
    object = board.getStillObjectByCanvas(topLeftX, topLeftY);
    if((object instanceof Wall || object instanceof Brick)) return false;
    object = board.getStillObjectByCanvas(topRightX, topRightY);
    if((object instanceof Wall || object instanceof Brick)) return false;
    object = board.getStillObjectByCanvas(botLeftX, botLeftY);
    if((object instanceof Wall || object instanceof Brick)) return false;
    object = board.getStillObjectByCanvas(botRightX, botRightY);
    if((object instanceof Wall || object instanceof Brick)) return false;
    return true;
  }

  @Override
  public void collisionHandler() {

  }

  @Override
  public void collide(Entity entity) {

  }
}
