package com.gildedrose

import spock.lang.Specification

class GildedRoseSpec extends Specification {
    def "failing test"() {
        setup:
        def items = [ new Item("foo", 0, 0) ] as Item[]
        def app = new GildedRose(items)

        when:
        app.updateQuality()

        then:
        app.items[0].name == 'fixme'
    }
}
