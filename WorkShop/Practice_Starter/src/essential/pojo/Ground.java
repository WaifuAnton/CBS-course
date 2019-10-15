package essential.pojo;

import java.awt.*;

/**
 * Created by Asus on 21.09.2019.
 */
public class Ground extends BFObject {

    @Override
    public void draw(Graphics g) {
        Color cc = new Color(180, 180, 180);
        g.setColor(cc);
        g.fillRect(getX(), getY(), 64, 64);
    }

}
