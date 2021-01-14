import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BlackJack {
    private Deck deck;
    private Hand playerHand;
    private Hand bankHand;
    private boolean gameFinished;
    private int playerScore;
    private int bankScore;
    private static String SCORE_FILENAME = "BlackJackGameData.txt";

    public BlackJack() throws EmptyDeckException {
        this.deck = new Deck(4);
        this.playerHand = new Hand();
        this.bankHand = new Hand();
        this.gameFinished = false;
        this.playerScore = 0;
        this.bankScore = 0;
        this.reset();

    }

    public void reset() throws EmptyDeckException {
        this.playerHand.clear();
        this.bankHand.clear();
        this.playerHand.add(this.deck.draw());
        this.playerHand.add(this.deck.draw());
        this.bankHand.add(this.deck.draw());
    }

    public String getPlayerHandString() {
        return this.playerHand.toString();
    }

    public String getBankHandString() {
        return this.bankHand.toString();
    }

    public int getPlayerBest() {
        return this.playerHand.best();
    }

    public int getBankBest() {
        return this.bankHand.best();
    }

    public boolean isPlayerWinner() {
        if (this.gameFinished == true && this.getPlayerBest() <= 21
                && (this.getPlayerBest() > this.getBankBest() || this.getBankBest() > 21)) {
            return true;
        }
        return false;
    }

    public boolean isBankWinner() {
        if (this.gameFinished == true && this.getBankBest() <= 21
                && (this.getBankBest() > this.getPlayerBest() || this.getPlayerBest() > 21)) {
            return true;
        }
        return false;
    }

    public boolean isGameFinished() {
        return this.gameFinished;
    }

    public void playerDrawAnotherCard() throws EmptyDeckException {
        if (this.gameFinished == false) {
            this.playerHand.add(this.deck.draw());

            if (this.getPlayerBest() > 21) {
                this.gameFinished = true;
            }

        }
    }

    public void bankLastTurn() throws EmptyDeckException {
        if (this.isGameFinished() == false) {
            if (this.getPlayerBest() < 21 && this.getBankBest() < 21) {
                while (this.isBankWinner() == false && this.getBankBest() < 21) {
                    this.bankHand.add(this.deck.draw());
                }
            }
        }
        this.gameFinished = true;
    }

    public void updateScores() {
        if (this.isBankWinner() == true) {
            this.bankScore++;
        } else if (this.isPlayerWinner() == true) {
            this.playerScore++;
        }
    }

    public void writeScore() {
        try {
            File file = new File(BlackJack.SCORE_FILENAME);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("player " + this.playerScore);
            bw.write("\nbank " + this.bankScore);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readScore() {
        try {
            File file = new File(BlackJack.SCORE_FILENAME);
            FileReader fw = new FileReader(file.getAbsoluteFile());
            BufferedReader bw = new BufferedReader(fw);
            String line;

            while ((line = bw.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
