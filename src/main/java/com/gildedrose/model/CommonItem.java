package com.gildedrose.model;

public class CommonItem extends Item {
    public CommonItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        int decrementValue = getDecrementValue();
        decrementQuality(decrementValue);
    }

    private int getDecrementValue() {
        int decrementValue = 1;
        if (this.sellIn <= 0) {
            decrementValue *= 2;
        }
        return decrementValue;
    }


}
