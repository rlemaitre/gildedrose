package com.gildedrose

class NoOpQualityUpdater implements QualityUpdater {

    @Override
    Item updateQuality(Item item) {
        return item
    }
}
