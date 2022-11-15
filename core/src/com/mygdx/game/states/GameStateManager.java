package com.mygdx.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

public class GameStateManager {
    private Stack<State> states;

    public GameStateManager(){
        states = new Stack<State>();
    }

    public void push(State state){
        states.push(state);
    }

    public void pop(){
        states.pop().dispose();
    }

    public void set(State state) {
        states.pop().dispose();
        states.push(state);
    }

    public void update(float dt) {
        if (states.empty()) {
            System.out.println("Trying to update empty game state stack");
            return;
        }
        states.peek().update(dt);
    }

    public void render(SpriteBatch sb) {
        if (states.empty()) {
            System.out.println("Trying to render empty game state stack");
            return;
        }
        states.peek().render(sb);
    }
}
