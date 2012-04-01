import geb.spock.GebSpec
import spock.lang.Unroll

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
        $("input#input").value() == "3"

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
        calculate("1+2")

        then:
        result == "3"
    }


    @Unroll("#formula ergibt #expectedResult")
    def "Addition von zwei Zahlen"() {
        given:
        to TaschenrechnerPage

        expect:
        at TaschenrechnerPage

        when:
        calculate(formula)

        then:
        result == expectedResult

        where:
        formula | expectedResult
        "1+2"   | "3"
        "2+3"   | "5"
        "3+4"   | "7"
        "4+5"   | "9"
        "5+6"   | "11"
    }
}
