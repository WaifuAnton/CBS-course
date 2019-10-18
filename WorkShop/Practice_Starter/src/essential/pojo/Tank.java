package essential.pojo;

import essential.BattleField;
import essential.interfaces.Destroyable;
import essential.interfaces.Drawable;

import java.awt.*;

/**
 * Created by Asus on 21.09.2019.
 */
public class Tank implements Drawable, Destroyable {

  private int speed = 10;
  private Direction direction = Direction.UP;
  private int x = 448;
  private int y = 512;
  private boolean destroyed;
  private Bullet bullet = new Bullet();
  private BattleField bf;

    public Tank(BattleField bf) {
        this.bf = bf;
    }

    public Bullet getBullet() {
        return bullet;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void move(Direction direction) throws Exception {

        if ((direction == Direction.UP && y == 0)||(direction == Direction.DOWN && y >= 512) ||(direction == Direction.LEFT && x == 0)||(direction == Direction.RIGHT && x >= 512)) {
            System.out.println("Can't move:" + direction + "tankX:" + x + "tankY:" + y);
            return;
        }
        turn(direction);


        for (int covered = 0; covered < 64; covered++) {
            if (direction == Direction.UP) {
                y -= 1;
                System.out.println(direction + "tankX:" + x + "tankY:" + y);
            }

            else if (direction == Direction.DOWN) {
                y += 1;
                System.out.println(direction + "tankX:" + x + "tankY:" + y);
            }

            else if (direction == Direction.LEFT) {
                x -= 1;
                System.out.println(direction + "tankX:" + x + "tankY:" + y);
            }

            else {
                x += 1;
                System.out.println(direction + "tankX:" + x + "tankY:" + y);
            }

            bf.repaint();
            Thread.sleep(speed);
        }

    }

    public void turn(Direction direction) {
        if (this.direction != direction) {
            this.direction = direction;
        }
    }

    public void kill(Tank tank) throws Exception {
        while (getX() < tank.getX() && !tank.isDestroyed()) {
            move(Direction.RIGHT);
            fire();
        }
        while (getX() > tank.getX() && !tank.isDestroyed()) {
            move(Direction.LEFT);
            fire();
        }
        if (getX() == tank.getX()) {
            if (getY() < tank.getY())
                turn(Direction.DOWN);
            else
                turn(Direction.UP);
            //fire();
        }
        else if (getY() == tank.getY()) {
            if (getX() < tank.getX())
                turn(Direction.RIGHT);
            else
                turn(Direction.LEFT);
            //fire();
        }
        //fire();
    }

    public void fire() throws Exception {
        bullet.setY(y + 25);
        bullet.setX(x + 25);


        while (!bullet.isDestroyed()) {
            if (direction == Direction.UP)
            {
                bullet.updateY(-1);
            }
            else if (direction == Direction.DOWN)
            {
                bullet.updateY(1);
            }
            else if (direction == Direction.LEFT)
            {
                bullet.updateX(-1);
            }

            else {
                bullet.updateX(1);
            }

            if (bf.processInterception()) {
                bullet.destroy();
            }


            bf.repaint();
            Thread.sleep(bullet.getSpeed());
        }

        bullet.destroy();
        bf.repaint();

    }

    @Override
    public void draw(Graphics g) {
        if (!destroyed) {
            g.setColor(new Color(255, 0, 0));
            g.fillRect(x, y, 64, 64);

            g.setColor(new Color(0, 255, 0));
            if (direction == Direction.UP) {
                g.fillRect(x + 20, y, 24, 34);
            } else if (direction == Direction.DOWN) {
                g.fillRect(x + 20, y + 30, 24, 34);
            } else if (direction == Direction.LEFT) {
                g.fillRect(x, y + 20, 34, 24);
            } else {
                g.fillRect(x + 30, y + 20, 34, 24);
            }
        }
//        else {
//            g.setColor(new Color(180, 180, 180));
//            g.fillRect(getX(), getY(), 64, 64);
//        }

        bullet.draw(g);
    }

    @Override
    public void destroy() {
        destroyed = true;
    }

    @Override
    public boolean isDestroyed() {
        return destroyed;
    }
}
