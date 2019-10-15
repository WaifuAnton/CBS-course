package essential.pojo;

import essential.interfaces.Destroyable;

import java.awt.*;

/**
 * Created by Asus on 21.09.2019.
 */
public class Brick extends BFObject implements Destroyable {

    private boolean destroyed;

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    @Override
    public void destroy() {
        destroyed = true;
    }

    @Override
    public void draw(Graphics g) {
        Color color = !destroyed ? new Color(0, 0, 255) : new Color(180, 180, 180);
        g.setColor(color);
        g.fillRect(getX(), getY(), 64, 64);
    }

}
