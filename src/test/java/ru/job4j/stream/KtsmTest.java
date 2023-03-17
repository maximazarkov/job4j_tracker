package ru.job4j.stream;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class KtsmTest {

    @Test
    public void whenBuildObj() {
        Ktsm ktsm = new Ktsm.Builder("КТСМ-02", 12356)
                .buildTypeB("БУНК")
                .buildTypeSktr("СКТР v.2.0")
                .build();
        String expected = "КТСМ тип: КТСМ-02, серийный номер: 12356, наличие Ethernet: false, "
                + "тип подсистемы Б: БУНК, тип подсистемы СКТР: СКТР v.2.0.";
        assertThat(expected).isEqualTo(ktsm.toString());
    }

}