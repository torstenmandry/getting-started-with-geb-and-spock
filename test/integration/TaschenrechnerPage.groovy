import geb.Page

class TaschenrechnerPage extends Page {

    static url = "http://web2.0rechner.de/"

    static at = { title == "Web 2.0 Taschenrechner" }

    static content = {
        btn_1 { $("a", id: "num_1") }
        btn_2 { $("a", id: "num_2") }
        btn_add { $("a", id: "A42") }
        btn_equals { $("a", id: "btn_equal") }

        display { $("input", id: "input") }
    }
}
