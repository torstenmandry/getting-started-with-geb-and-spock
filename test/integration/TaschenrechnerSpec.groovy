import geb.spock.GebSpec

class TaschenrechnerSpec extends GebSpec {

    def "Addition von 1 und 2 ergibt 3 - ohne Page Object"() {
        given:
        go "http://web2.0rechner.de/"

        expect:
        title == "Web 2.0 Taschenrechner"

        when:
        $("a#num_1").click()
        $("a#A42").click()
        $("a#num_2").click()
        $("a#btn_equal").click()

        then:
        $("input", id: "input").value() == "3"

    }


    def "Addition von 1 und 2 ergibt 3 - mit Page Object"() {
        given:
        to TaschenrechnerPage

        expect:
        at TaschenrechnerPage

        when:
        btn_1.click()
        btn_add.click()
        btn_2.click()
        btn_equals.click()

        then:
        display.value() == "3"
    }



    def "Addition von 1 und 2 ergibt 3 - funktional"() {
        given:
        to TaschenrechnerPage

        expect:
        at TaschenrechnerPage

        when:
        page.type( "1+2=" )

        then:
        result == "3"
    }

}
