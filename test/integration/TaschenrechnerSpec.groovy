import geb.spock.GebSpec

class TaschenrechnerSpec extends GebSpec {

    def "öffne Web 2.0 Taschenrechner"() {
        when:
        go "http://web2.0rechner.de/"

        then:
        title == "Web 2.0 Taschenrechner"
    }
}
