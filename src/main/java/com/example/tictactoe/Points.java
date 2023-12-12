package com.example.tictactoe;
import lombok.Getter;
import lombok.Setter;
public class Points {

    public Points (int x, int y){
        Xpos = x;
        Ypos = y;
    }

    //@Getter @Setter
    private int Xpos;

    public int getXpos() {
        return Xpos;
    }

    public void setXpos(int xpos) {
        Xpos = xpos;
    }

    public int getYpos() {
        return Ypos;
    }

    public void setYpos(int ypos) {
        Ypos = ypos;
    }

    //@Getter @Setter
    private int Ypos;
}
