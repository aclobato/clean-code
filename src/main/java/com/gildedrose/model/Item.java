package com.gildedrose.model;

public abstract class Item {

    private static final int MAX_QUALITY_VALUE = 50;
    private static final int MIN_QUALITY_VALUE = 0;

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void updateSellIn() {
        this.sellIn = this.sellIn - 1;
    }

    public abstract void updateQuality();

    protected void incrementQuality(int incrementValue) {
        int newQuality = this.quality + incrementValue;
        if (newQuality > MAX_QUALITY_VALUE) {
            newQuality = MAX_QUALITY_VALUE;
        }
        this.quality = newQuality;
    }

    protected void decrementQuality(int decrementValue) {
        int newQuality = this.quality - decrementValue;
        if (newQuality < MIN_QUALITY_VALUE) {
            newQuality = MIN_QUALITY_VALUE;
        }
        this.quality = newQuality;
    }
}
