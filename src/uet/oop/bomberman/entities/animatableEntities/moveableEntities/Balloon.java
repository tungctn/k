package uet.oop.bomberman.entities.animatableEntities.moveableEntities;

import javafx.scene.image.Image;
import uet.oop.bomberman.Board;
import uet.oop.bomberman.entities.Entity;

import java.util.Random;


public class Balloon extends MovableEntities {
//  protected boolean up = false, left = false, down = false, right = false;
//  protected String facingDirection = "";
//  protected boolean moving;
//  protected boolean alive = true;
//  protected double speed = 1;
//  protected final int DIE_TIME_SECOND = 3;
//  protected int deadAnimeTime = 60 * DIE_TIME_SECOND;

  public Balloon(int boardX, int boardY, Image img, Board board) {
    super( boardX, boardY, img, board);
    speed = 0.5;
    chooseDirectionRandom();
  }

  public void destroy() {
    removedFromBoard = true;
  }

  @Override
  public void imageAnimationHandler() {

  }


  @Override
  public void update() {
    //System.out.println(this.boardX+" "+this.boardY+"\n");
    moveHandlerBalloon();
   // collisionHandler();
  }

//  @Override
//  public void moveHandler() {}

  //@Override
  //public boolean canMoveBrickAndWall(int xS, int yS) {
  //  return false;
  //}



  @Override
  public void collide(Entity entity) {

  }
}
