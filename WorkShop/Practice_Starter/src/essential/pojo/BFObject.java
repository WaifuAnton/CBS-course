package essential.pojo;

import essential.interfaces.Drawable;

/**
 * Created by Asus on 21.09.2019.
 */
public abstract class BFObject implements Drawable {

    private int x;
    private int y;

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


}
