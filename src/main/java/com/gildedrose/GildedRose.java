package com.gildedrose;

import com.gildedrose.model.Item;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateInventory() {
        for (Item item: items) {
            item.updateQuality();
            item.updateSellIn();
        }
    }
}