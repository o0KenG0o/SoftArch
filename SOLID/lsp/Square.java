package com.solid.lsp;

public class Square extends Rectangle {

    Square(int side) {
        super(side,side);
    }

    @Override
    public void setWidth(int width) {
        this.setSide(width);
    }

    @Override
    public void setHeight(int height) {
        this.setSide(height);
    }

    public void setSide(int side) {
        super.setWidth(side);
        super.setHeight(side);
    }
}
