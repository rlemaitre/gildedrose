package com.gildedrose

class ConjuredQualityUpdater implements QualityUpdater {
    @Override
    Item updateQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 2
        }
        item.sellIn = item.sellIn - 1
        if (item.sellIn < 0) {
            if (item.quality > 0) {
                item.quality = item.quality - 2
            }
        }
        return item
    }
}
