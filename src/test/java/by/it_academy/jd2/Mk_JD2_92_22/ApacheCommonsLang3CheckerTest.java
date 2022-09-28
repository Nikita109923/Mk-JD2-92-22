package by.it_academy.jd2.Mk_JD2_92_22;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ApacheCommonsLang3CheckerTest {
    @Test
    public void allLowerCase() {
        ApacheCommonsLang3Checker checker = new ApacheCommonsLang3Checker();


        Assertions.assertTrue(checker.isAllLowerCase("nikita"));
    }

    @Test
    public void notAllLowerCase() {
        ApacheCommonsLang3Checker checker = new ApacheCommonsLang3Checker();


        Assertions.assertFalse(checker.isAllLowerCase("Nikita"));
    }
}
