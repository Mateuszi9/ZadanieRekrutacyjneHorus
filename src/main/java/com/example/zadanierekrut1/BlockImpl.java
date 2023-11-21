package com.example.zadanierekrut1;

public class BlockImpl implements Block {
    private String color;
    private String material;

    public BlockImpl(String color, String material) {
        this.color = color;
        this.material = material;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return "Block { color = " + color + ", material = "+material+ " }";
    }
}
