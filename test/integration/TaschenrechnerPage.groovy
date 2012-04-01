import geb.Page

class TaschenrechnerPage extends Page {

    static url = "http://web2.0rechner.de/"

    static at = { title == "Web 2.0 Taschenrechner" }

    static content = {
        btn_1 { $("a#num_1") }
        btn_2 { $("a#num_2") }
        btn_add { $("a#A42") }
        btn_equals { $("a#btn_equal") }
        display { $("input#input") }

        btn { char c -> $("a#" + ids[c.toString()]) }
        result { display.value() }
    }

    def ids = [
            "1" : "num_1",
            "2" : "num_2",
            "3" : "num_3",
            "4" : "num_4",
            "5" : "num_5",
            "6" : "num_6",
            "7" : "num_7",
            "8" : "num_8",
            "9" : "num_9",
            "+" : "A42",
            "=" : "btn_equal"
    ]

    def calculate( String formula ) {
        formula.chars.each {
            type it
        }
        type('='.charAt(0))
    }
    
    def type( char character ) {
        btn(character).click()
    }
}
