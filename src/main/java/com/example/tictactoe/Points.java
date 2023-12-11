package com.example.tictactoe;
import lombok.Getter;
import lombok.Setter;
public class Points {

    public Points (int x, int y){
        Xpos = x;
        Ypos = y;
    }

    @Getter @Setter
    private int Xpos;

    @Getter @Setter
    private int Ypos;
}
