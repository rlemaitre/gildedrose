package com.gildedrose

import spock.lang.Specification

class GildedRoseSpec extends Specification {
    def "quality degrades by one when sell-in is positive"() {
        setup:
        Item[] items = [new Item("Thing", 1, 2)] as Item[]
        def app = new GildedRose(items)

        when:
        app.updateQuality()

        then:
        app.items[0].quality == 1
    }


    def "quality degrades by two once sellIn is zero"() {
        setup:
        Item[] items = [new Item("Thing", 0, 3)] as Item[]
        GildedRose app = new GildedRose(items)

        when:
        app.updateQuality()

        then:
        app.items[0].quality == 1
    }


    def "quality degrades by two when sellIn is negative"() {
        setup:
        Item[] items = [new Item("Thing", -56, 3)] as Item[]
        GildedRose app = new GildedRose(items)

        when:
        app.updateQuality()

        then:
        app.items[0].quality == 1
    }


    def "quality does not degrade below zero"() {
        setup:
        Item[] items = [new Item("Thing", 5, 0)] as Item[]
        GildedRose app = new GildedRose(items)

        when:
        app.updateQuality()

        then:
        app.items[0].quality == 0
    }


    def "quality does not degrade below zero when sellIn is negative"() {
        setup:
        Item[] items = [new Item("Thing", -5, 1)] as Item[]
        GildedRose app = new GildedRose(items)

        when:
        app.updateQuality()

        then:
        app.items[0].quality == 0
    }


    def "quality does not increase above 50"() {
        setup:
        Item[] items = [new Item("Aged Brie", 5, 50)] as Item[]
        GildedRose app = new GildedRose(items)

        when:
        app.updateQuality()

        then:
        app.items[0].quality == 50
    }


    def "quality does not increase above 50 when sellIn is negative"() {
        setup:
        Item[] items = [new Item("Aged Brie", -5, 49)] as Item[]
        GildedRose app = new GildedRose(items)

        when:
        app.updateQuality()

        then:
        app.items[0].quality == 50
    }


    def "quality of aged brie increases by 1 when sellIn is positive"() {
        setup:
        Item[] items = [new Item("Aged Brie", 5, 1)] as Item[]
        GildedRose app = new GildedRose(items)

        when:
        app.updateQuality()

        then:
        app.items[0].quality == 2
    }


    def "quality of aged brie increases by 2  when sellIn is negative"() {
        setup:
        Item[] items = [new Item("Aged Brie", -5, 1)] as Item[]
        GildedRose app = new GildedRose(items)

        when:
        app.updateQuality()

        then:
        app.items[0].quality == 3
    }


    def "sellIn decreases by 1"() {
        setup:
        Item[] items = [new Item("Thing", 10, 1)] as Item[]
        GildedRose app = new GildedRose(items)

        when:
        app.updateQuality()

        then:
        app.items[0].sellIn == 9
    }


    def "sellIn decreases by 1 even when negative"() {
        setup:
        Item[] items = [new Item("Thing", -10, 1)] as Item[]
        GildedRose app = new GildedRose(items)

        when:
        app.updateQuality()

        then:
        app.items[0].sellIn == -11
    }


    def "sulfuras never changes"() {
        setup:
        Item[] items = [new Item("Sulfuras, Hand of Ragnaros", 8, 5)] as Item[]
        GildedRose app = new GildedRose(items)

        when:
        app.updateQuality()

        then:
        app.items[0].quality == 5
        app.items[0].sellIn == 8
    }


    def "backstage pass increase in value by 1 if more than 10 days"() {
        setup:
        Item[] items = [new Item("Backstage passes to a TAFKAL80ETC concert", 11, 5)] as Item[]
        GildedRose app = new GildedRose(items)

        when:
        app.updateQuality()

        then:
        app.items[0].quality == 6
    }

    def "backstage pass increase in value by 2 if between 10 days and 5 days"() {
        setup:
        Item[] items = [new Item("Backstage passes to a TAFKAL80ETC concert", 10, 6)] as Item[]
        GildedRose app = new GildedRose(items)

        when:
        app.updateQuality()

        then:
        app.items[0].quality == 8
    }

    def "backstage pass increase in value by 3 if less than 5 days"() {
        setup:
        Item[] items = [new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10)] as Item[]
        GildedRose app = new GildedRose(items)

        when:
        app.updateQuality()

        then:
        app.items[0].quality == 13
    }

    def "backstage pass value is 0 if sell-in negative"() {
        setup:
        Item[] items = [new Item("Backstage passes to a TAFKAL80ETC concert", 0, 13)] as Item[]
        GildedRose app = new GildedRose(items)

        when:
        app.updateQuality()

        then:
        app.items[0].quality == 0
    }

    def "backstage pass quality does not increase above 50"() {
        setup:
        Item[] items = [new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50)] as Item[]
        GildedRose app = new GildedRose(items)

        when:
        app.updateQuality()

        then:
        app.items[0].quality == 50
    }

}
