package gb.ru.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import gb.ru.base.Sprite;
import gb.ru.math.Rect;

public class GameOver extends Sprite {

    private final static float HEIGHT = 0.08f;
    private final static float BOTTOM_MARGIN = 0.009f;

    public GameOver(TextureAtlas atlas) {
        super(atlas.findRegion("message_game_over"));
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(HEIGHT);
        setBottom(BOTTOM_MARGIN);
    }
}
