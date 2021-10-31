package gb.ru.sprite;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import gb.ru.base.Ship;
import gb.ru.math.Rect;
import gb.ru.pool.BulletPool;

public class EnemyShip extends Ship {

    private static final float RELOAD_INTERVAL_SMALL_SHIP = 0.4f;
    private static final float RELOAD_INTERVAL_MEDIUM_SHIP = 0.5f;
    private static final float RELOAD_INTERVAL_BIG_SHIP = 0.6f;

    private final Vector2 enemySmallV = new Vector2(0f, -0.2f);
    private final Vector2 enemyMediumV = new Vector2(0f, -0.03f);
    private final Vector2 enemyBigV = new Vector2(0f, -0.005f);

    private float type;

    public EnemyShip(BulletPool bulletPool, Rect worldBounds, Sound bulletSound) {
        this.bulletPool = bulletPool;
        this.worldBounds = worldBounds;
        this.bulletSound = bulletSound;
        this.bulletV = new Vector2();
        this.bulletPos = new Vector2();
        this.v = new Vector2();
        this.v0 = new Vector2();
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        if (getTop() < worldBounds.getTop()) {
            if (type < 0.5f && type >= 0f) {
                v.set(enemySmallV);
                reloadInterval = RELOAD_INTERVAL_SMALL_SHIP;
            }
            if (type < 0.8f && type >= 0.5f) {
                v.set(enemyMediumV);
                reloadInterval = RELOAD_INTERVAL_MEDIUM_SHIP;
            }
            if (type < 1f && type >= 0.8f) {
                v.set(enemyBigV);
                reloadInterval = RELOAD_INTERVAL_BIG_SHIP;
            }
        }

        if (getBottom() < worldBounds.getBottom()) {
            destroy();
        }
    }

    public void set(
            TextureRegion[] regions,
            Vector2 v,
            TextureRegion bulletRegion,
            float bulletHeight,
            Vector2 bulletV,
            int damage,
            int hp,
            float reloadInterval,
            float height,
            float type
    ) {
        this.regions = regions;
        this.v.set(v);
        this.bulletRegion = bulletRegion;
        this.bulletHeight = bulletHeight;
        this.bulletV.set(bulletV);
        this.damage = damage;
        this.hp = hp;
        this.reloadInterval = reloadInterval;
        setHeightProportion(height);
        this.type = type;
    }
}
