package gb.ru.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import gb.ru.base.Sprite;
import gb.ru.math.Rect;

public class Logo extends Sprite {

    private Texture img;
    private Vector2 pos;

    public Logo(TextureRegion region) {
        super(region);
    }

    public Logo(){
        img = new Texture("badlogic.jpg");
        pos = new Vector2();

    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(worldBounds.getHeight());
        pos.set(worldBounds.pos);
    }


    public void draw(SpriteBatch batch) {
        batch.draw(
                img,
                pos.x, pos.y,
                0.5f, 0.5f
        );
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        pos.set(touch);
        return super.touchDown(touch, pointer, button);
    }

    public Texture getImg() {
        return img;
    }

    public void setImg(Texture img) {
        this.img = img;
    }

    public Vector2 getPos() {
        return pos;
    }

    public void setPos(Vector2 pos) {
        this.pos = pos;
    }
}
