import java.io.*;
import java.net.*;

public class ServerTCP {
    private static char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6789);
        System.out.println("Server in ascolto sulla porta 6789...");

        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connesso.");

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        while (true) {
            String input = in.readLine();
            if (input == null || input.equalsIgnoreCase("quit")) break;

            int row = Character.getNumericValue(input.charAt(0));
            int col = Character.getNumericValue(input.charAt(1));

            if (board[row][col] == ' ') {
                board[row][col] = 'X';

                if (checkWin('X')) {
                    out.println("player_win\n" + boardToString());
                    break;
                }

                if (isDraw()) {
                    out.println("draw\n" + boardToString());
                    break;
                }

                int[] move = getCpuMove();
                board[move[0]][move[1]] = 'O';

                if (checkWin('O')) {
                    out.println("cpu_move:" + move[0] + move[1] + "\n" + boardToString());
                    out.println("cpu_win\n" + boardToString());
                    break;
                }

                if (isDraw()) {
                    out.println("cpu_move:" + move[0] + move[1] + "\n" + boardToString());
                    out.println("draw\n" + boardToString());
                    break;
                }

                out.println("cpu_move:" + move[0] + move[1] + "\n" + boardToString());
            } else {
                out.println("invalid\n" + boardToString());
            }
        }

        clientSocket.close();
        serverSocket.close();
    }

    private static boolean checkWin(char symbol) {
        for (int i = 0; i < 3; i++)
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol)
                return true;

        for (int i = 0; i < 3; i++)
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)
                return true;

        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol)
            return true;

        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)
            return true;

        return false;
    }

    private static boolean isDraw() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == ' ') return false;
        return true;
    }

    private static int[] getCpuMove() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == ' ')
                    return new int[]{i, j};
        return new int[]{0, 0}; // fallback mai usato
    }

    private static String boardToString() {
        StringBuilder sb = new StringBuilder();
        sb.append("   0   1   2\n");
        for (int i = 0; i < 3; i++) {
            sb.append(i).append(" ");
            for (int j = 0; j < 3; j++) {
                sb.append(" ").append(board[i][j]).append(" ");
                if (j < 2) sb.append("|");
            }
            sb.append("\n");
            if (i < 2) sb.append("  ---+---+---\n");
        }
        return sb.toString();
    }
}
