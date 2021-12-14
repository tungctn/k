package uet.oop.bomberman.entities.animatableEntities.moveableEntities;
import java.util.Random;


import javafx.scene.image.Image;
import uet.oop.bomberman.Board;
import uet.oop.bomberman.entities.animatableEntities.AnimatableEntities;
import uet.oop.bomberman.entities.animatableEntities.Brick;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.stillEntities.Wall;
import uet.oop.bomberman.graphics.Sprite;

public abstract class MovableEntities extends AnimatableEntities {
  protected boolean up = false, left = false, down = false, right = false;
  protected String facingDirection = "";
  protected boolean moving;
  protected boolean alive = true;
  protected double speed = 1;
  protected final int DIE_TIME_SECOND = 3;
  protected int deadAnimeTime = 60 * DIE_TIME_SECOND;



  public MovableEntities(int boardX, int boardY, Image img) {
    super(boardX, boardY, img);
  }
  public MovableEntities(int x, int y, Image img, Board board) {
    super(x,y,img, board);
  }


  // xử lý di chuyển
  public void moveHandler() {
    int xS = 0, yS = 0;
    if (up) yS -= speed * Sprite.SCALE;
    if (down) yS += speed * Sprite.SCALE;
    if (left) xS -= speed * Sprite.SCALE;
    if (right) xS += speed * Sprite.SCALE;

    //Thứ tự 4 cái này là quan trọng khi nhiều nút đươc bấm cùng lúc
    if (xS > 0) facingDirection = "RIGHT";
    if (xS < 0) facingDirection = "LEFT";
    if (yS > 0) facingDirection = "DOWN";
    if (yS < 0) facingDirection = "UP";

    if (xS == 0 && yS == 0) {
      moving = false;
      return;
    }
    move(xS,yS);
    moving = true;
  } // nếu không có -> sẽ đứng im

  public void move(int xS, int yS) {
    // Chia ra làm 2 để xử lý ấn 2 nút khi 1 nút đang đâm đầu vào tường
    if (canMoveBrickAndWall(xS, 0)) {
      this.x += xS;
      realBodyRectangle.setX(realBodyRectangle.getX() + xS);
    }
    if (canMoveBrickAndWall(0, yS)) {
      this.y += yS;
      realBodyRectangle.setY(realBodyRectangle.getY() + yS);
    }

    // Cập nhật boardX,Y
    boardX = x / Sprite.SCALED_SIZE;
    boardY = y / Sprite.SCALED_SIZE;
  }

  // kiểm tra va chạm
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
  } // nếu không có -> đi xuyên tường

  public void seftDestruct() {
    alive = false;
    this.up = false;
    this.right = false;
    this.down = false;
    this.left = false;
  } // nếu không có -> không bị chết

  public abstract void collide(Entity entity);

  public void chooseDirectionRandom() {
    up = false; left = false; down = false; right = false;
    Random rand = new Random();
    int ranNum = rand.nextInt(4)+1;
    if(ranNum==1) up=true;
    if(ranNum==2) right=true;
    if(ranNum==3) down=true;
    if(ranNum==4) left=true;
  }

  public void moveHandlerBalloon() {
    int xS = 0, yS = 0;
    if (up) yS -= speed * Sprite.SCALE;
    if (down) yS += speed * Sprite.SCALE;
    if (left) xS -= speed * Sprite.SCALE;
    if (right) xS += speed * Sprite.SCALE;

    //Thứ tự 4 cái này là quan trọng khi nhiều nút đươc bấm cùng lúc
//    if (xS > 0) facingDirection = "RIGHT";
//    if (xS < 0) facingDirection = "LEFT";
//    if (yS > 0) facingDirection = "DOWN";
//    if (yS < 0) facingDirection = "UP";

    if (xS == 0 && yS == 0) {
      moving = false;
      return;
    }
    moveBalloon(xS,yS);
    moving = true;
  }

  public void moveBalloon(int xS, int yS) {
    // Chia ra làm 2 để xử lý ấn 2 nút khi 1 nút đang đâm đầu vào tường
    if (canMoveBrickAndWall(xS,yS)) {
      this.x += xS;
      this.y += yS;
      realBodyRectangle.setX(realBodyRectangle.getX() + xS);
    } else { chooseDirectionRandom(); }

    System.out.println();
    // Cập nhật boardX,Y
    boardX = x / Sprite.SCALED_SIZE;
    boardY = y / Sprite.SCALED_SIZE;
  }

  public void chooseDirectionOneal() {
//    Entity object = null;
//    System.out.println(boardX+"  "+boardY+"\n");
//    object = board.getStillObjectByBoard(boardX,boardY-1);
//    if((object instanceof Wall || object instanceof Brick)) {
//      System.out.println("up");
//    }
//    object = board.getStillObjectByBoard(boardX+1,boardY);
//    if((object instanceof Wall || object instanceof Brick)) {
//      System.out.println("left");
//    }
//    object = board.getStillObjectByBoard(boardX,boardY+1);
//    if((object instanceof Wall || object instanceof Brick)) {
//      System.out.println("down");
//    }
//    object = board.getStillObjectByBoard(boardX-1,boardY);
//    if((object instanceof Wall || object instanceof Brick)) {
//      System.out.println("right");
//    }

  }
  public double distanceTwoPoint(int x1, int y1, int x2, int y2) {
    return Math.sqrt((double)((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)));
  }

}
