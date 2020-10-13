package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void updateQuality_shouldBeLowersQualityAndSellValuesEveryItemEndEachDay() {
        Item[] items = new Item[] { new Item("Any Item",10, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(9, app.items[0].sellIn);
        assertEquals(9, app.items[0].quality);
    }

    @Test
    void updateQuality_whenPastExpirationDate_shouldBeLowersQualityTwiceFast() {
        Item[] items = new Item[] { new Item("Any Item",0, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(-1, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void updateQuality_whenQualityValueBelowZero_shouldNeverLowersQuality() {
        Item[] items = new Item[] { new Item("Any Item",10, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(9, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void updateQuality_whenAgedBrie_shouldIncreasesQualityEndEachDay()  {
        Item[] items = new Item[] { new Item("Aged Brie",10, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(9, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void updateQuality_whenAgedBrieQualitiAbove50_shouldNeverIncrease() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(9, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void updateQuality_whenSulfuras_shouldNeverLowersQualityAndSellInValues() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros",10,10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(10, app.items[0].sellIn);
        assertEquals(10, app.items[0].quality);
    }

    @Test
    void updateQuality_whenBackstagePasses_shouldIncreasesQualityEndEachDay() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 20, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(19, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void updateQuality_whenBackstagePasses_shouldNeverIncreasesQualityAbove50() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert",20,50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(19, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void updateQuality_whenBackstagePassesSellInValueEqualLessThan10_shouldIncreasesQualityTwiceFast() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert",10,10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(9, app.items[0].sellIn);
        assertEquals(12, app.items[0].quality);
    }

    @Test
    void updateQuality_whenBackstagePassesSellInValueEqualLessThan5_shouldIncreasesQualityThriceFast() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert",5,10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(4, app.items[0].sellIn);
        assertEquals(13, app.items[0].quality);
    }

    @Test
    void updateQuality_whenBackstagePassesPastExpirationDate_shouldLowersQualityZero() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

}
