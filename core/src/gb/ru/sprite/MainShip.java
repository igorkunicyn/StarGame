package gb.ru.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import gb.ru.base.Sprite;
import gb.ru.math.Rect;

public class MainShip extends Sprite {

    private final float V_LENGTH = 0.01f;
    private final static float HEIGHT = 0.2f;
    private final static float PADDING = 0.08f;
    private final  Vector2 v;
    private final Vector2 touch;
    private Rect worldBounds;
    private TextureRegion region;
    private boolean leftMove;
    private boolean rightMove;
    private boolean upMove;
    private boolean downMove;



    public MainShip(TextureAtlas atlas){
        super(atlas.findRegion("main_ship"));
        this.region = atlas.findRegion("main_ship");
        region.setRegionWidth(region.getRegionWidth()/2);
        v = new Vector2();
        touch = new Vector2();
    }


    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
        setHeightProportion(HEIGHT);
        pos.set(0,worldBounds.getBottom()+PADDING);
    }

    @Override
    public void update(float delta) {
        if (touch.dst(pos)> V_LENGTH){
            pos.add(v);
        }else {
            pos.set(touch);
        }
        if (leftMove) pos.x-=1 * Gdx.graphics.getDeltaTime();
        if (rightMove) pos.x+=1 * Gdx.graphics.getDeltaTime();
        if (upMove) pos.y+=1 * Gdx.graphics.getDeltaTime();
        if (downMove) pos.y-=1 * Gdx.graphics.getDeltaTime();
//        calculationPosition(pos.x, pos.y);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        this.touch.set(touch);
        v.set(touch.cpy().sub(pos).setLength(V_LENGTH));
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        return super.touchUp(touch, pointer, button);
    }

    public boolean keyDown(int keyCode){
        switch (keyCode){
            case Input.Keys
                    .LEFT:
                setLeftMove(true);
                break;
            case Input.Keys
                    .RIGHT:
                setRightMove(true);
                break;
            case Input.Keys
                    .UP:
                setUpMove(true);
                break;
            case Input.Keys
                    .DOWN:
                setDownMove(true);
                break;

        }
        return true;
    }
    public boolean keyUp(int keyCode){
        switch (keyCode){
            case Input.Keys
                    .LEFT:
                setLeftMove(false);
                break;
            case Input.Keys
                    .RIGHT:
                setRightMove(false);
                break;
            case Input.Keys
                    .UP:
                setUpMove(false);
                break;
            case Input.Keys
                    .DOWN:
                setDownMove(false);
                break;

        }
        return true;
    }

    public void setLeftMove(boolean t){
        if(rightMove && t) rightMove = false;
        leftMove = t;
    }
    public void setRightMove(boolean t){
        if(leftMove && t) leftMove = false;
        rightMove = t;
    }

    public void setUpMove(boolean t){
        if(downMove && t) downMove = false;
        upMove = t;
    }
    public void setDownMove(boolean t){
        if(upMove && t) upMove = false;
        downMove = t;
    }

    private void calculationPosition(float x, float y){
        float minX = 0;
        float maxX = Gdx.graphics.getWidth() - getWidth();
        float minY = 0;
        float maxY = Gdx.graphics.getHeight() - getHeight();
        float newX = Math.min(maxX, Math.max(x, minX));
        float newY = Math.min(maxY, Math.max(y, minY));
        pos.set(newX,newY);

    }

}
