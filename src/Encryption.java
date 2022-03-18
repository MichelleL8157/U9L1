import java.util.Arrays;
public class Encryption {
    private int shiftLet;
    private int shiftRow;
    private int shiftCol;
    private final String upperCase;
    private final String lowerCase;

    public Encryption(int shiftLet, int shiftRow, int shiftCol) {
        this.shiftLet = shiftLet;
        this.shiftRow = shiftRow;
        this.shiftCol = shiftCol;
        upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        lowerCase = "abcdefghijklmnopqrstuvwxyz";
    }

    public int rowsNeed(String message) {
        int rows = 0;
        for (int i = 2; i != message.length(); i++) {
            if (message.length() % i == 0) {
                rows = i;
                break;
            }
        }
        if (rows == 0) {
            rows = 1;
        }
        return rows;
    }

    public String encryptor(String message) {
        int rows = rowsNeed(message);
        int cols = message.length() / rows;
        String[][] temp = new String[rows][cols];
        int index = 0;
        for (int row = 0; row != rows; row++) {
            for (int col = 0; col != cols; col++) {
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
            }
        }
        /*System.out.println("After change in letter:");
        for (String[] row: temp) {
            System.out.println(Arrays.toString(row));
        }*/
        String[][] temp2 = new String[rows][cols];
        for (int row = 0; row != rows; row++) {
            for (int col = 0; col != cols; col++) {
                int moved = col + shiftCol;
                while (moved >= cols) {
                    moved -= cols;
                }
                temp2[row][moved] = temp[row][col];
            }
        }
        /*System.out.println("Change in col:");
        for (String[] row: temp2) {
            System.out.println(Arrays.toString(row));
        }*/
        String[][] temp3 = new String[rows][cols];
        for (int col = 0; col != cols; col++) {
            for (int row = 0; row != rows; row++) {
                int moved = row + shiftRow;
                while (moved >= rows) {
                    moved -= rows;
                }
                temp3[moved][col] = temp2[row][col];
            }
        }
        /*System.out.println("Change in row:");
        for (String[] row: temp3) {
            System.out.println(Arrays.toString(row));
        }*/
        String encryptedWord = "";
        for (String[] row: temp3) {
            for (String letter: row) {
                encryptedWord += letter;
            }
        }
        return encryptedWord;
    }

    public String decryptor(String message) {
        int rows = rowsNeed(message);
        int cols = message.length() / rows;
        String[][] temp = new String[rows][cols];
        int index = 0;
        for (int row = 0; row != rows; row++) {
            for (int col = 0; col != cols; col++) {
                String letter = message.substring(index, index + 1);
                boolean uppercaseBefore = upperCase.indexOf(letter) > -1;
                String newLetter = letter.toUpperCase();
                int moved = upperCase.indexOf(newLetter) - shiftLet;
                while (moved < 0) {
                    moved += upperCase.length();
                }
                if (uppercaseBefore) {
                    newLetter = upperCase.substring(moved, moved + 1);
                }
                else {
                    newLetter = lowerCase.substring(moved, moved + 1);
                }
                temp[row][col] = newLetter;
                index++;
            }
        }
        /*System.out.println("After change in letter:");
        for (String[] row: temp) {
            System.out.println(Arrays.toString(row));
        }*/
        String[][] temp2 = new String[rows][cols];
        for (int row = 0; row != rows; row++) {
            for (int col = 0; col != cols; col++) {
                int moved = col - shiftCol;
                while (moved < 0) {
                    moved += cols;
                }
                temp2[row][moved] = temp[row][col];
            }
        }
        /*System.out.println("Change in col:");
        for (String[] row: temp2) {
            System.out.println(Arrays.toString(row));
        }*/
        String[][] temp3 = new String[rows][cols];
        for (int col = 0; col != cols; col++) {
            for (int row = 0; row != rows; row++) {
                int moved = row - shiftRow;
                while (moved < 0) {
                    moved += rows;
                }
                temp3[moved][col] = temp2[row][col];
            }
        }
        /*System.out.println("Change in row:");
        for (String[] row: temp3) {
            System.out.println(Arrays.toString(row));
        }*/
        String decryptedWord = "";
        for (String[] row: temp3) {
            for (String letter: row) {
                decryptedWord += letter;
            }
        }
        return decryptedWord;
    }
}
