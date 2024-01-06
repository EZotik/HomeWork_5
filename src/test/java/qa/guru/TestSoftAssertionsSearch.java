package qa.guru;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestSoftAssertionsSearch {

    @Test
    void softAssertionsSearchTest() {
        Configuration.pageLoadStrategy = "eager";
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $(".markdown-body").$("ul").shouldHave(text("Soft assertions"));
        $(byText("Soft assertions")).click();
        $("#wiki-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));
        // sleep(5000); //Чтобы браузер сразу не закрывался;
    }
}
