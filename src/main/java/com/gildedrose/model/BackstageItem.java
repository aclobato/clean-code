package com.gildedrose.model;

public class BackstageItem extends Item {
    public BackstageItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (this.sellIn == 0) {
            this.quality = 0;
        } else if (this.sellIn <= 5) {
            incrementQuality(3);
        } else if (this.sellIn <= 10) {
            incrementQuality(2);
        } else {
            incrementQuality(1);
        }

    }
}
