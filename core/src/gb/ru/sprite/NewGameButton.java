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

    private final static float HEIGHT = 0.05f;
    private final static float TOP_MARGIN = 0.015f;

    private final GameScreen gameScreen;

    public NewGameButton(TextureAtlas atlas, GameScreen gameScreen) {
        super(atlas.findRegion("button_new_game"));
        this.gameScreen = gameScreen;
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(HEIGHT);
        setTop(TOP_MARGIN);
    }

    @Override
    public void action() {
        gameScreen.startNewGame();
    }

}
