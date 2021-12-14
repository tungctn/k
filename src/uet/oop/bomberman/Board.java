package uet.oop.bomberman;

import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.entities.animatableEntities.Bomb;
import uet.oop.bomberman.entities.items.BombItem;
import uet.oop.bomberman.entities.items.FlameItem;
import uet.oop.bomberman.entities.items.SpeedItem;
import uet.oop.bomberman.entities.animatableEntities.moveableEntities.Balloon;
import uet.oop.bomberman.entities.animatableEntities.moveableEntities.Bomber;
import uet.oop.bomberman.entities.animatableEntities.moveableEntities.Oneal;
import uet.oop.bomberman.entities.animatableEntities.Brick;
import uet.oop.bomberman.entities.stillEntities.Grass;
import uet.oop.bomberman.entities.Portal;
import uet.oop.bomberman.entities.stillEntities.Wall;
import uet.oop.bomberman.graphics.Sprite;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class Board {
  public int width;
  public int height;
  public Entity BoardBomber = null;
  private List<Entity> entities = new ArrayList<>();
  private List<Entity> stillObjects = new ArrayList<>();

  // Tránh java.util.ConcurrentModificationException
  private List<Entity> entitiesBuffer = new ArrayList<>();
  private List<Entity> stillObjectsBuffer = new ArrayList<>();

  public int vitriBomber = -1;
  public int levelGame = 1;
  private Scene scene = null;

  public Board(Scene scene, int levelGame) {
    this.scene = scene;
    loadLevel(levelGame);
  }

  public Scene getScene() {
    return scene;
  }

  public List<Entity> getEntities() {
    return entities;
  }

  public Entity getBBomber() {
    return entities.get(vitriBomber);
  }

  public List<Entity> getStillObjects() {
    return stillObjects;
  }

  public Entity getStillObjectByBoard(int boardX, int boardY) {
    // Trả về StillObject ở trên cùng
    for (int i = stillObjects.size() - 1; i >= 0; --i) {
      Entity object = stillObjects.get(i);
      if (object.getBoardX() == boardX && object.getBoardY() == boardY) {
        return object;
      }
    }
    return null;
  }

  public Entity getStillObjectByCanvas(int x, int y) {
    // Trả về StillObject ở trên cùng
    for (int i = stillObjects.size() - 1; i >= 0; --i) {
      Entity object = stillObjects.get(i);
      if (object.getBoardX() == x / Sprite.SCALED_SIZE && object.getBoardY() == y / Sprite.SCALED_SIZE) {
        return object;
      }
    }
    return null;
  }

  public void loadLevel(int level) {
    Scanner scan = null;
    try {
      scan = new Scanner(new FileReader("./res/levels/Level"+ level + ".txt")).useDelimiter("\\A");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    StringBuilder sb = new StringBuilder();
    while(true) {
      assert scan != null;
      if (!scan.hasNext()) break;
      sb.append(scan.next());
    }
    scan.close();
    //System.out.println(sb.toString());
    String[] lines = sb.toString().split("\n");
    String[] line1 = lines[0].split(" ");
    int rowCount = Integer.parseInt(line1[1].trim());
    this.height = rowCount;
    int colCount = Integer.parseInt(line1[2].trim());
    this.width = colCount;
    Character[][] mapMatrix = new Character[rowCount][colCount];
    for(int i = 1; i<= rowCount; ++i) {
      for (int j = 0; j < colCount; ++j) {
        mapMatrix[i-1][j] = lines[i].charAt(j);
      }
    }

    //xây map từ matrix
    for(int i = 0; i< rowCount; ++i) {
      for (int j = 0; j < colCount; ++j) {
        stillObjects.add(new Grass(j, i ,Sprite.grass.getFxImage()));
      }
    }
    for(int i = 0; i< rowCount; ++i) {
      for (int j = 0; j < colCount; ++j) {
        Entity object = null;
        char c = mapMatrix[i][j];
        switch (c) {
          case '#':
            object = new Wall(j, i, Sprite.wall.getFxImage());
            break;
          case '*':
            object = new Brick(j, i, Sprite.brick.getFxImage());
            break;
          case 'x':
            object = new Portal(j, i, Sprite.portal.getFxImage());
            stillObjects.add(object);
            object = new Brick(j, i, Sprite.brick.getFxImage());
            break;
          case 'p':
            entities.add(new Bomber(j, i, Sprite.player_right.getFxImage(), this));
            vitriBomber = entities.size() - 1;
            break;
          case '1':
            entities.add(new Balloon(j, i, Sprite.balloom_right1.getFxImage(),  this));
            break;
          case '2':
            entities.add(new Oneal(j, i, Sprite.oneal_right1.getFxImage(),  this));
            break;
          case 'b':
            object = new BombItem(j, i, Sprite.powerup_bombs.getFxImage());
            stillObjects.add(object);
            object = new Brick(j, i, Sprite.brick.getFxImage());
            break;
          case 'f':
            object = new FlameItem(j, i, Sprite.powerup_flames.getFxImage());
            stillObjects.add(object);
            object = new Brick(j, i, Sprite.brick.getFxImage());
            break;
          case 's':
            object = new SpeedItem(j, i, Sprite.powerup_speed.getFxImage());
            stillObjects.add(object);
            object = new Brick(j, i, Sprite.brick.getFxImage());
            break;
          default:
            break;
        }
        if(object !=null) stillObjects.add(object);
      }
      System.out.println();
    }
  }

  public void addEntity(Entity entity) {
    entitiesBuffer.add(entity);
  }

  public void addStillObject (Entity entity) {
    stillObjectsBuffer.add(entity);
  }

  private void commitBufferedArray() {
    entities.addAll(entitiesBuffer);
    stillObjects.addAll(stillObjectsBuffer);
    entitiesBuffer.clear();
    stillObjectsBuffer.clear();
  }

  public void update() {
    entities.removeIf(Entity::isRemovedFromBoard);
    stillObjects.removeIf(Entity::isRemovedFromBoard);
    entities.forEach(Entity::update);
    stillObjects.forEach(Entity::update);
    commitBufferedArray();

  }

  public void render(GraphicsContext gc) {
    // Vẽ Entities sau khi vẽ stillObjects
    stillObjects.forEach(g -> g.render(gc));
    entities.forEach(g -> g.render(gc));
  }
}
