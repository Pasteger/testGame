package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

public class EndGameScreen implements Screen {
    final Drop game;
    OrthographicCamera camera;
    Texture background;
    int socialCredits;

    EndGameScreen(final Drop gam, int socialCredits){
        game = gam;
        this.socialCredits = socialCredits;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        if (this.socialCredits <= -100){
            background = new Texture("pictures/final1.png");
        }
        else if (this.socialCredits <= 0){
            background = new Texture("pictures/final2.png");
        }
        else if (this.socialCredits < 500){
            background = new Texture("pictures/final3.png");
        }
        else if (this.socialCredits < 1000){
            background = new Texture("pictures/final4.png");
        }
        else {
            background = new Texture("pictures/final5.png");
        }

        game.batch.draw(background, 0, 0);
        game.batch.end();
        if (Gdx.input.isTouched()) {
            game.setScreen(new MainMenuScreen(game));
            dispose();
        }

    }

    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
