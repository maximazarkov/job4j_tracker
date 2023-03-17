package ru.job4j.stream;

public class Ktsm {
    private final String type;
    private final long id;
    private final boolean ethernetPort;
    private final String typeB;
    private final String typeSktr;

    public static class Builder {
        private final String type;
        private final long id;

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
        return "КТСМ "
                + "тип: " + type + ", "
                + "серийный номер: " + id + ", "
                + "наличие Ethernet: " + ethernetPort + ", "
                + "тип подсистемы Б: " + typeB + ", "
                + "тип подсистемы СКТР: " + typeSktr + ".";
    }
}

