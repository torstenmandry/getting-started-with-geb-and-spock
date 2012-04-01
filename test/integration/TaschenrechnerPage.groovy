import geb.Page

class TaschenrechnerPage extends Page {

    def btn_ids = [
            "1" : "num_1",
            "2" : "num_2",
            "+" : "A42",
            "=" : "btn_equal"
    ]

    static url = "http://web2.0rechner.de/"

    static at = { title == "Web 2.0 Taschenrechner" }

    static content = {
        btn_1 { $("a#num_1") }
        btn_2 { $("a#num_2") }
        btn_add { $("a#A42") }
        btn_equals { $("a#btn_equal") }

        display { $("input#input") }
        result { display.value() }
    }

    def type( String formula ) {
        formula.chars.each {
            type it
        }
    }
    
    def type( char character ) {
        println("${character} -> ${btn_ids[character]}")
        $("a#" + btn_ids[character.toString()]).click()
    }
}
