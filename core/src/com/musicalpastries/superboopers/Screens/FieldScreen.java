package com.musicalpastries.superboopers.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.musicalpastries.superboopers.Actors.Actor;
import com.musicalpastries.superboopers.Scenes.Hud;
import com.musicalpastries.superboopers.SuperBoopers;

import java.util.ArrayList;

/**
 * Created by Andrew Groeling on 9/29/2017.
 */

public class FieldScreen implements Screen {

    private SuperBoopers game;
    private ArrayList<Actor> actors;
    private OrthographicCamera gamecam;
    private Viewport viewport;
    private Hud hud;
    private float dt;

    public FieldScreen(SuperBoopers game){
        this.game = game;
        actors = new ArrayList<Actor>();
        gamecam = new OrthographicCamera();
        gamecam.setToOrtho(false, SuperBoopers.V_WIDTH, SuperBoopers.V_HEIGHT);
        viewport = new ScreenViewport(gamecam);
        hud = new Hud(game.batch);
        actors.add(new Actor(4, 0, 0));
    }

    @Override
    public void show() {

    }


    public void update(){
        gamecam.update();
    }

    @Override
    public void render(float delta) {
        dt += Gdx.graphics.getDeltaTime();
        //clear screen
        Gdx.gl.glClearColor(0,.5f,0.2f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //some stuff that I don't understand but needs to be here
        gamecam.update();
        game.batch.setProjectionMatrix(gamecam.combined);
        //drawing
        hud.stage.draw();

        game.batch.begin();
        for (int i = 0; i < actors.size(); i++) {
            game.batch.draw(actors.get(i).draw().getKeyFrame(dt, true),0,0);
        }
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        gamecam.update();
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
        game.batch.dispose();
    }
}