package com.gildedrose

class QualityUpdaterFactory {

    QualityUpdater create(Item item) {
        return ItemType.fromLabel(item.name).qualityUpdater

    }
}
