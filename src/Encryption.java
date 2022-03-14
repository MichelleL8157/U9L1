public class Encryption {
    private int shiftLet;
    private int shiftRow;
    private int shiftCol;

    public Encryption(int shiftLet, int shiftRow, int shiftCol) {
        this.shiftLet = shiftLet;
        this.shiftRow = shiftRow;
        this.shiftCol = shiftCol;
    }

    public String encryptor(String message) {
        int rows = 0;
        for (int i = 2; i != message.length(); i++) {
            if (message.length() % i == 0) {
                rows = i;
                break;
            }
        }
        int cols = 0;
        if (rows == 0) {
            rows = message.length() / 3;
            cols = 3;
        } else {
            cols = message.length() / rows;
        }
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String[][] temp = new String[rows][cols];
        int index = 0;
        for (int row = 0; row != rows; row++) {
            for (int col = 0; col != cols; col++) {
                if (index < message.length()) {
                    String letter = message.substring(index, index + 1);
                    boolean uppercaseBefore = upperCase.indexOf(letter) > -1;
                    String newLetter = letter.toUpperCase();
                    int moved = upperCase.indexOf(newLetter) + shiftLet;
                    while (moved >= upperCase.length()) {
                        moved -= upperCase.length();
                    }
                    if (uppercaseBefore) {
                        newLetter = upperCase.substring(moved, moved + 1);
                    }
                    else {
                        newLetter = lowerCase.substring(moved, moved + 1);
                    }
                    temp[row][col] = newLetter;
                    index++;
                } else {
                    temp[row][col] = "=";
                }
            }
        }
        String[][] temp2 = new String[rows][cols];
        for (int row = 0; row != rows; row++) {
            for (int col = 0; col != cols; col++) {
                int moved = col + shiftCol;
                while (shiftCol >= cols) {
                    moved -= cols;
                }
                temp2[row][moved] = temp[row][col];
            }
        }
        String[][] temp3 = new String[rows][cols];
        for (int col = 0; col != cols; col++) {
            for (int row = 0; row != rows; row++) {
                int moved = row + shiftRow;
                while (shiftRow >= rows) {
                    moved -= rows;
                }
                temp3[moved][cols] = temp2[row][col];
            }
        }
        String encryptedWord = "";
        for (String[] row: temp3) {
            for (String letter: row) {
                encryptedWord += letter;
            }
        }
        return encryptedWord;
    }
}
