public enum Value {
    AS(1, "AS"), TWO(2, "2"), THREE(3, "3"), FOUR(4, "4"), FIVE(5, "5"), SIX(6, "6"), SEVEN(7, "7"), EIGHT(8, "8"),
    NINE(9, "9"), TEN(10, "10"), JACK(10, "J"), QUEEN(10, "Q"), KING(10, "K");
    
    private int points;
    private String symbole;
    

    private Value(int points, String symbole) {
        this.symbole = symbole;
        this.points = points;
    }

    public String getSymbole() {
        return symbole;
    }

    public int getPoints() {
        return points;
    }

}
