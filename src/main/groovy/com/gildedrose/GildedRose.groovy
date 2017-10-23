package com.gildedrose

class GildedRose {
    Item[] items

    GildedRose(Item[] items) {
        this.items = items
    }

    void updateQuality() {
        for (Item item: items) {
            QualityUpdater updater=new QualityUpdaterFactory().create(item)
            updater.updateQuality(item)
        }
    }
}
