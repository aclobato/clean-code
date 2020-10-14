package com.gildedrose.model;

public class ItemFactory {
    public Item createItem(String name, int sellIn, int quality) {
        switch (name) {
            case "Sulfuras, Hand of Ragnaros":
                return new SulfurasItem(name, sellIn, quality);
            case "Aged Brie":
                return new AgedBrieItem(name, sellIn, quality);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstageItem(name, sellIn, quality);
            case "Conjured":
                return new ConjuredItem(name, sellIn, quality);
            default:
                return new CommonItem(name, sellIn, quality);
        }
    }
}
