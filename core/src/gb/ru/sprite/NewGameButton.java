package gb.ru.sprite;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import gb.ru.base.BaseButton;
import gb.ru.base.Sprite;
import gb.ru.math.Rect;
import gb.ru.pool.BulletPool;
import gb.ru.pool.EnemyPool;
import gb.ru.screen.GameScreen;

public class NewGameButton extends BaseButton {

    private final static float HEIGHT = 0.07f;
    private final static float WIGHT = 0.3f;
    private final static float PADDING = 0.02f;

    private final Game game;

    public NewGameButton(TextureAtlas atlas, Game game) {
        super(atlas.findRegion("button_new_game"));
        this.game = game;
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(HEIGHT);
        setWidth(WIGHT);
        setBottom(worldBounds.getBottom() + PADDING);
    }

    @Override
    public void action() {
        game.setScreen(new GameScreen(game));
    }

}
