package ru.appline.logic;

public class StoronaSveta {
    private String name;
    private int low;
    private int high;

    public StoronaSveta(String name, int low, int high) {
        this.name = name;
        this.low = low;
        this.high = high;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }
}
