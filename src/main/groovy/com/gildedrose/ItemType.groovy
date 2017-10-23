package com.gildedrose

enum ItemType {

    BACSTAGE_PASS("Backstage passes to a TAFKAL80ETC concert", new BackstagePassQualityUpdater()),
    AGED_BRIE("Aged Brie", new AgedBrieQualityUpdater()),
    SULFURAS("Sulfuras, Hand of Ragnaros", new NoOpQualityUpdater()),
    DEFAULT("DEFAULT", new DefaultQualityUpdater()),
    CONJURED("Conjured", new ConjuredQualityUpdater())

    String label
    QualityUpdater qualityUpdater

    ItemType(String label, QualityUpdater qualityUpdater) {
        this.label = label
        this.qualityUpdater = qualityUpdater
    }

    static ItemType fromLabel(String label) {
        return values().find {it.label==label} ?: DEFAULT
    }
}
