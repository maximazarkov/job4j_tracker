package ru.job4j.stream;

// Устройство КТСМ - специальный железнодорожный комплекс по обнаружению нагретых буксовых узлов. Состоит из разных подсистем. Некоторые подсистемы могут отсутствовать.

public class Ktsm {
    private final String type;            // Тип КТСМ. блок базовый
    private final long id;                // Серийный номер, id
    private boolean ethernetPort;   // наличие Ethernet порта
    private String typeB;           // Подсистема контроля букс (опционально)
    private String typeSktr;        // Подсистема контроля температуры рельс

    public static class Builder {
        // необходимые параметры
        private final String type;
        private final long id;

        // необязательные параметры (по умолчанию)
        private boolean ethernetPort = false;
        private String typeB = null;
        private String typeSktr = null;

        public Builder(String type, long id) {
            this.type = type;
            this.id = id;
        }

        public Builder buildEthernet(boolean eth) {
            this.ethernetPort = eth;
            return this;
        }

        public Builder buildTypeB(String tb) {
            this.typeB = tb;
            return this;
        }

        public Builder buildTypeSktr(String tsktr) {
            this.typeSktr = tsktr;
            return this;
        }

        public Ktsm build() {
            return new Ktsm(this);
        }

    }

    public Ktsm(Builder builder) {
        type = builder.type;
        id = builder.id;
        ethernetPort = builder.ethernetPort;
        typeB = builder.typeB;
        typeSktr = builder.typeSktr;
    }

    @Override
    public String toString() {
        return "КТСМ " +
                "тип: " + type + ", " +
                "серийный номер: " + id + ", " +
                "наличие Ethernet: " + ethernetPort + ", " +
                "тип подсистемы Б: " + typeB + ", " +
                "тип подсистемы СКТР: " + typeSktr + ".";
    }
}

