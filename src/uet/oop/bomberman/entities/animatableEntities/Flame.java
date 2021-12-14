package uet.oop.bomberman.entities.animatableEntities;
import uet.oop.bomberman.BombermanGame;


import javafx.scene.image.Image;
import uet.oop.bomberman.Board;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.Portal;
import uet.oop.bomberman.entities.animatableEntities.moveableEntities.Balloon;
import uet.oop.bomberman.entities.animatableEntities.moveableEntities.Bomber;
import uet.oop.bomberman.entities.stillEntities.Wall;
import uet.oop.bomberman.graphics.Sprite;

import java.util.List;

public class Flame extends AnimatableEntities{
  private int size = 1;
  private String direction = "CENTER";
  private boolean edge = false;
  private int time = 20;

  public Flame(int boardX, int boardY, int size, Board board) {
    super(boardX, boardY, Sprite.bomb_exploded.getFxImage(), board);
    this.size = size;
    addFlameIfPossible();
    Entity object = board.getBBomber();
    Bomber Bo = (Bomber) object;
    Bo.setNumberBombOfBomber();

  }

  private Flame(int boardX, int boardY, String direction, boolean isEdge) {
    super(boardX, boardY, null);
    this.direction = direction;
    this.edge = isEdge;
  }

  private void ignite() {

    for (int i = 1; i < size; ++i) {
      board.addStillObject(new Flame(boardX, boardY - i, "UP", false));
      board.addStillObject(new Flame(boardX + i, boardY, "RIGHT", false));
      board.addStillObject(new Flame(boardX, boardY + i, "DOWN", false));
      board.addStillObject(new Flame(boardX - i, boardY, "LEFT", false));
    }
    board.addStillObject(new Flame(boardX, boardY - size, "UP", true));
    board.addStillObject(new Flame(boardX + size, boardY, "RIGHT", true));
    board.addStillObject(new Flame(boardX, boardY + size, "DOWN", true));
    board.addStillObject(new Flame(boardX - size, boardY, "LEFT", true));
  }

  private void addFlameIfPossible() {
    int up = size, right = size, left = size, down = size;

    //UP
    for (int i = 1; i <= size; ++i) {
      Entity entity = board.getStillObjectByBoard(boardX, boardY - i);
      List<Entity> entity2 = board.getEntities();
      if (entity instanceof Wall || entity instanceof Portal) {
        up = i - 1;
        break;
      } else if (entity instanceof Brick) {
        up = i - 1;
        Brick brick = (Brick) entity;
        brick.destroy();
        break;
      } else {
        for(int j = entity2.size()-1; j >= 0; j --){
          if(entity2.get(j).getBoardX() == boardX&&entity2.get(j).getBoardY() == boardY - i){
            if(!(entity2.get(j) instanceof Bomber)){ entity2.get(j).destroyEntity();}
            else BombermanGame.WinOrLose = "lose";
          }
        }
      }
    }
    if (up > 0) {
      for (int i = 1; i < up; ++i) {
        board.addStillObject(new Flame(boardX, boardY - i, "UP", false));
      }
      board.addStillObject(new Flame(boardX, boardY - up, "UP", true));
    }

    //RIGHT
    for (int i = 1; i <= size; ++i) {
      Entity entity = board.getStillObjectByBoard(boardX + i, boardY);
      List<Entity> entity2 = board.getEntities();
      if (entity instanceof Wall || entity instanceof Portal) {
        right = i - 1;
        break;
      } else if (entity instanceof Brick) {
        right = i - 1;
        Brick brick = (Brick) entity;
        brick.destroy();
        break;
      } else {
        for(int j = entity2.size()-1; j >= 0; j --){
          if(entity2.get(j).getBoardX() == boardX + i&&entity2.get(j).getBoardY() == boardY){
            if(!(entity2.get(j) instanceof Bomber)) {entity2.get(j).destroyEntity(); }
            else BombermanGame.WinOrLose = "lose";
          }
        }
      }
    }
    if (right > 0) {
      for (int i = 1; i < right; ++i) {
        board.addStillObject(new Flame(boardX + i, boardY, "RIGHT", false));
      }
      board.addStillObject(new Flame(boardX + right, boardY, "RIGHT", true));
    }

    //DOWN
    for (int i = 1; i <= size; ++i) {
      Entity entity = board.getStillObjectByBoard(boardX, boardY + i);
      List<Entity> entity2 = board.getEntities();
      if (entity instanceof Wall || entity instanceof Portal) {
        down = i - 1;
        break;
      } else if (entity instanceof Brick) {
        down = i - 1;
        Brick brick = (Brick) entity;
        brick.destroy();
        break;
      } else {
        for(int j = entity2.size()-1; j >= 0; j --){
          if(entity2.get(j).getBoardX() == boardX &&entity2.get(j).getBoardY() == boardY + i){
            if(!(entity2.get(j) instanceof Bomber)) {entity2.get(j).destroyEntity();}
            else BombermanGame.WinOrLose = "lose";
          }
        }
      }
    }
    if (down > 0) {
      for (int i = 1; i < down; ++i) {
        board.addStillObject(new Flame(boardX, boardY + i, "DOWN", false));
      }
      board.addStillObject(new Flame(boardX, boardY + down, "DOWN", true));
    }

    //LEFT
    for (int i = 1; i <= size; ++i) {
      Entity entity = board.getStillObjectByBoard(boardX - i, boardY);
      List<Entity> entity2 = board.getEntities();
      if (entity instanceof Wall || entity instanceof Portal) {
        left = i - 1;
        break;
      } else if (entity instanceof Brick) {
        left = i - 1;
        Brick brick = (Brick) entity;
        brick.destroy();
        break;
      } else {
        for(int j = entity2.size()-1; j >= 0; j --){
          if(entity2.get(j).getBoardX() == boardX - i&&entity2.get(j).getBoardY() == boardY){
            if(!(entity2.get(j) instanceof Bomber)) {entity2.get(j).destroyEntity();}
            else BombermanGame.WinOrLose = "lose";
          }
        }
      }
    }
    if (left > 0) {
      for (int i = 1; i < left; ++i) {
        board.addStillObject(new Flame(boardX - i, boardY, "LEFT", false));
      }
      board.addStillObject(new Flame(boardX - left, boardY, "LEFT", true));
    }

  }

  @Override
  public void collide(Entity entity) {

  }

  public void animate() {
    if (!removedFromBoard){
      if (anime < 60) {
        anime++;
        imageAnimationHandler();
      } else {
        removedFromBoard = true;
      }
    }
  }

  @Override
  public void imageAnimationHandler() {
    switch (direction) {
      case "CENTER":
        this.img = Sprite.oneCycleMovingSprite(Sprite.bomb_exploded, Sprite.bomb_exploded1, Sprite.bomb_exploded2, anime, time).getFxImage();
        break;
      case "UP":
        if (edge) this.img = Sprite.oneCycleMovingSprite(Sprite.explosion_vertical_top_last, Sprite.explosion_vertical_top_last1, Sprite.explosion_vertical_top_last2, anime, time).getFxImage();
        else this.img = Sprite.oneCycleMovingSprite(Sprite.explosion_vertical, Sprite.explosion_vertical1, Sprite.explosion_vertical2, anime, time).getFxImage();
        break;
      case "RIGHT":
        if (edge) this.img = Sprite.oneCycleMovingSprite(Sprite.explosion_horizontal_right_last, Sprite.explosion_horizontal_right_last1, Sprite.explosion_horizontal_right_last2, anime, time).getFxImage();
        else this.img = Sprite.oneCycleMovingSprite(Sprite.explosion_horizontal, Sprite.explosion_horizontal1, Sprite.explosion_horizontal2, anime, time).getFxImage();
        break;
      case "DOWN":
        if (edge) this.img = Sprite.oneCycleMovingSprite(Sprite.explosion_vertical_down_last, Sprite.explosion_vertical_down_last1, Sprite.explosion_vertical_down_last2, anime, time).getFxImage();
        else this.img = Sprite.oneCycleMovingSprite(Sprite.explosion_vertical, Sprite.explosion_vertical1, Sprite.explosion_vertical2, anime, time).getFxImage();
        break;
      case "LEFT":
        if (edge) this.img = Sprite.oneCycleMovingSprite(Sprite.explosion_horizontal_left_last, Sprite.explosion_horizontal_left_last1, Sprite.explosion_horizontal_left_last2, anime, time).getFxImage();
        else this.img = Sprite.oneCycleMovingSprite(Sprite.explosion_horizontal, Sprite.explosion_horizontal1, Sprite.explosion_horizontal2, anime, time).getFxImage();
        break;

    }
  }

  @Override
  public void update() {
    animate();
  }
}
