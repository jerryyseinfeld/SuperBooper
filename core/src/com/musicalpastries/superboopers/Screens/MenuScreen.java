package com.musicalpastries.superboopers.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.musicalpastries.superboopers.SuperBoopers;

/**
 * Andrew Groeling - 12/23/2017.
 */

public class MenuScreen implements Screen {

    private SuperBoopers game;
 //   private ArrayList<Actor> actors;
    private Viewport viewport;
    private float dt;
    private Stage stage;

    public MenuScreen(SuperBoopers game){
        this.game = game;
        //input processing for UI
        stage = new Stage(new ExtendViewport(SuperBoopers.V_WIDTH, SuperBoopers.V_HEIGHT));
        Gdx.input.setInputProcessor(stage);
        //viewport = new ExtendViewport(SuperBoopers.V_WIDTH, SuperBoopers.V_HEIGHT);

    }

    @Override
    public void show() {
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(false);
        stage.addActor(table);

        //temporary
        Skin skin = new Skin(Gdx.files.internal("skin/pixthulhu-ui.json"));

        //buttons
        TextButton back = new TextButton("Return", skin);
        TextButton settings = new TextButton("Settings", skin);
        TextButton credits = new TextButton("Credits", skin);

        table.add(back).fillX().uniformX();
        table.row().pad(15,0,15,0);
        table.add(settings).fillX().uniformX();
        table.row();
        table.add(credits).fillX().uniformX();

        //listeners
        back.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.changeScreen(SuperBoopers.MAIN);
            }
        });

        settings.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.changeScreen(SuperBoopers.SETTINGS);
            }
        });

        credits.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                game.changeScreen(SuperBoopers.CREDITS);
            }
        });
    }


    public void update(){
    }

    @Override
    public void render(float delta) {
    //    dt += Gdx.graphics.getDeltaTime();
        //clear screen
        Gdx.gl.glClearColor(0,.5f,0.2f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1/30f));
        stage.draw();

        //drawing
       // hud.stage.draw();
        /*game.batch.begin();

        game.batch.end();*/
    }


    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
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
        stage.dispose();
        game.batch.dispose();
    }
}