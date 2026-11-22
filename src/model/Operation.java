package model;

public enum Operation {

    ADDITION
    {
        @Override
        public int apply(int x, int y) {
            return x + y;
        }
        @Override
        public String symbol() {
            return "+";
        }
    },
    SUBTRACTION
    {
        @Override
        public int apply(int x, int y) {
            if (x - y < 0) {
                throw new IllegalArgumentException("Arithmetic must result in a non-negative value");
            }
            return x - y;
        }
        @Override
        public String symbol() {
            return "-";
        }
    },
    MULTIPLICATION
    {
        @Override
        public int apply(int x, int y) {
            return x * y;
        }
        @Override
        public String symbol() {
            return "×";
        }
    },
    DIVISION
    {
        @Override
        public int apply(int x, int y) {
            return x / y;
        }
        @Override
        public String symbol() {
            return "÷";
        }
    };

    public abstract int apply(int x, int y);
    public abstract String symbol();
}