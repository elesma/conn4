import java.util.Scanner;

public class Main {
    private final Board board;
    private final Player player1;
    private final Player player2;

    public Main() {
        board = new Board();
        player1 = new Player("Jatekos 1", 'X');
        player2 = new Player("Jatekos 2", 'O');
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        Player currentPlayer = player1;

        while (true) {
            board.printBoard();
            System.out.println(currentPlayer.getNev() + " kovetkezik. Jele: " + currentPlayer.getJel() + " Irj be egy szamot 0-6 kozott");
            int col = scanner.nextInt();

            if (!board.dropDisc(col, currentPlayer.getJel())) {
                System.out.println("Helytelen mezo, nem sikerult lepni!");
                continue;
            }

            if (board.checkWin(currentPlayer.getJel())) {
                board.printBoard();
                System.out.println(currentPlayer.getNev() + " gyozott!");
                break;
            }

            if (board.isFull()) {
                board.printBoard();
                System.out.println("Dontetlen!");
                break;
            }

            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }
        scanner.close();
    }

    public static void main(String[] args) {
        Main game = new Main();
        game.playGame();
    }
}
