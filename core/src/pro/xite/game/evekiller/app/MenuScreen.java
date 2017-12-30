package pro.xite.game.evekiller.app;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Ellipse;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;

import static com.badlogic.gdx.math.Interpolation.circle;

/**
 * Created by Roman Syrchin on 12/11/17.
 */

public class MenuScreen extends Base2DScreen {

    private Sprite menuItem1;
    private Sprite menuItem2;
    private SpriteBatch batch;
    private ShapeRenderer shapeRenderer;

    private Texture bgBsod;

    public MenuScreen(Game game) {
        super(game);
        System.out.println("Menu constructor");
        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        bgBsod = new Texture("bsod.jpg");
        menuItem1 = new Sprite(new Texture("panic-button.png"));
        menuItem2 = new Sprite(new Texture("dont-panic-button.png"));
        menuItem1.setScale(0.33f);
        menuItem2.setScale(0.33f);
        menuItem1.setOrigin(300,350);
        menuItem2.setOrigin(300,100);
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        System.out.println(Gdx.input.getX() + " " + screenX);
        Circle c;
        Rectangle r;
        r = menuItem1.getBoundingRectangle();
        c = new Circle(r.getX()+r.getWidth()/2, r.getY()+r.getHeight()/2, 0.9f*r.getWidth()/2);
        if(c.contains(screenX, Gdx.graphics.getHeight()-screenY)) {
            menuItem1.setScale(0.33f*0.9f);
        }
        r = menuItem2.getBoundingRectangle();
        c = new Circle(r.getX()+r.getWidth()/2, r.getY()+r.getHeight()/2, 0.9f*r.getWidth()/2);
        if(c.contains(screenX, Gdx.graphics.getHeight()-screenY)) {
            menuItem2.setScale(0.33f*0.9f);
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        menuItem1.setScale(0.33f);
        menuItem2.setScale(0.33f);
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0.5f, 0.5f, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(bgBsod, 0f,0f);//, 0,0, bgBsod.getWidth(), bgBsod.getHeight());
        menuItem1.draw(batch);
        menuItem2.draw(batch);
        Ellipse circle = new Ellipse();
//        circle.


        batch.end();
//        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
//        Rectangle r = menuItem2.getBoundingRectangle();
//        shapeRenderer.circle(r.getX()+r.getWidth()/2, r.getY()+r.getHeight()/2, r.getWidth()/2);
//        shapeRenderer.setColor(Color.RED);
//        shapeRenderer.end();
    }
}
