public enum Color {
    HEART("♡"), SPADE("♠"), CLUB("♣"), DIAMOND("♢");

    private String symbole;

    private Color(String symbole) {
        this.symbole = symbole;
    }

    public String getSymbole() {
        return symbole;
    }
}
