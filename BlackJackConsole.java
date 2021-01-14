import java.util.Scanner;

public class BlackJackConsole {
    public BlackJackConsole() {
        System.out.println("Welcome to the BlackJack table. Let's play !");
        Scanner sc = new Scanner(System.in);
        char reponse = 'y';
        String str;

        try {
            BlackJack jack = new BlackJack();
            System.out.println("The bank draw : " + jack.getBankHandString());
            System.out.println("Your draw : " + jack.getPlayerHandString());
            while (jack.isGameFinished() == false && reponse == 'y') {
                System.out.println("Do you want another card ? (y/n)");
                str = sc.next();
                reponse = str.charAt(0);
                if (reponse == 'y') {
                    jack.playerDrawAnotherCard();
                    System.out.println(jack.getPlayerHandString());
                }
                else {
                    jack.bankLastTurn();
                    System.out.println(jack.getBankHandString());
                }
            }
            sc.close();
            System.out.println("The bank draw cards. New hand : " + jack.getBankHandString());
            System.out.println("Player best : " + jack.getPlayerBest());
            System.out.println("Bank best : " + jack.getBankBest());
            if (jack.isPlayerWinner() == true) {
                System.out.println("The player won !");
            } else if (jack.isBankWinner() == true) {
                System.out.println("The bank won !");
            } else {
                System.out.println("Nodoby won !");
            }
            jack.updateScores();
            jack.writeScore();
            jack.readScore();
        } catch (EmptyDeckException e) {
            System.err.println(e.getMessage());
            System.exit(-1);
        }
    }

    public static void main(String[] args) {
        new BlackJackConsole();
    }
}