package com.gildedrose

class DefaultQualityUpdater implements QualityUpdater {
    @Override
    Item updateQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1
        }
        item.sellIn = item.sellIn - 1
        if (item.sellIn < 0) {
            if (item.quality > 0) {
                item.quality = item.quality - 1
            }
        }
        return item
    }
}
