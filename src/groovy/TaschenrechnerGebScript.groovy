import geb.Browser

Browser.drive {
    go "http://web2.0rechner.de/"
    assert $("title", 0).text() == "Web 2.0 Taschenrechner"

    $("a", id: "num_1").click()
    $("a", id: "A42").click()
    $("a", id: "num_2").click()
    $("a", id: "btn_equal").click()

    assert $("input", id: "input").value() == "3"
}

