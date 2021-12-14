package uet.oop.bomberman.entities;

import javafx.scene.shape.Rectangle;
import uet.oop.bomberman.graphics.Sprite;

public class EntityRectangle extends Rectangle {
  public EntityRectangle(double x, double y, double width, double height) {
    super(x,y, width, height);
  }

  public boolean overlaps (Rectangle r) {
    return getX() < r.getX() + r.getWidth()
            && getX() + getWidth() > r.getX() && getY() < r.getY() + r.getHeight() && getY() + getHeight() > r.getY();
  }
}
