public class EncryptionRunner {
    public static void main(String[] args) {
        //Shows the process: change in let, col, row
        //testing shift in col
        Encryption test1 = new Encryption(0, 0, 2);
        String ogWord1 = "abcdefghi";
        String encrypted1 = test1.encryptor(ogWord1);
        String decrypted1 = test1.decryptor(encrypted1);
        System.out.println("Test 1 Word: " + ogWord1);
        System.out.println("\nExpected Encrypted: bcaefdhig\nActual Encrypted: " + encrypted1 + "\n");
        System.out.println("Expected Decrypted: " + ogWord1 + "\nActual Decrypted: " + decrypted1 + "\n");
        if (ogWord1.equals(decrypted1) && encrypted1.equals("bcaefdhig")) { System.out.println("TEST PASSED"); }
        else { System.out.println("TEST FAILED"); }
        System.out.println();

        //testing shift in row
        Encryption test2 = new Encryption(0, 2, 0);
        String ogWord2 = "abcdefghi";
        String expected2 = "defghiabc";
        String encrypted2 = test2.encryptor(ogWord2);
        String decrypted2 = test2.decryptor(encrypted2);
        System.out.println("\nTest 2 Word: " + ogWord2);
        System.out.println("\nExpected Encrypted: " + expected2 + "\nActual Encrypted: " + encrypted2 + "\n");
        System.out.println("Expected Decrypted: " + ogWord2 + "\nActual Decrypted: " + decrypted2 + "\n");
        if (ogWord2.equals(decrypted2) && encrypted2.equals(expected2)) { System.out.println("TEST PASSED"); }
        else { System.out.println("TEST FAILED"); }
        System.out.println();

        //testing change in letter
        Encryption test3 = new Encryption(1, 0, 0);
        String ogWord3 = "abcdefghi";
        String expected3 = "bcdefghij";
        String encrypted3 = test3.encryptor(ogWord3);
        String decrypted3 = test3.decryptor(encrypted3);
        System.out.println("\nTest 3 Word: " + ogWord3);
        System.out.println("\nExpected Encrypted: " + expected3 + "\nActual Encrypted: " + encrypted3 + "\n");
        System.out.println("Expected Decrypted: " + ogWord3 + "\nActual Decrypted: " + decrypted3 + "\n");
        if (ogWord3.equals(decrypted3) && encrypted3.equals(expected3)) { System.out.println("TEST PASSED"); }
        else { System.out.println("TEST FAILED"); }
        System.out.println();

        //testing different length
        Encryption test4 = new Encryption(0, 1, 2);
        String ogWord4 = "abcdefghij";

        String expected4 = "ijfghdeabc";
        String encrypted4 = test4.encryptor(ogWord4);
        String decrypted4 = test4.decryptor(encrypted4);
        System.out.println("\nTest 4 Word: " + ogWord4);
        System.out.println("\nExpected Encrypted: " + expected4 + "\nActual Encrypted: " + encrypted4 + "\n");
        System.out.println("Expected Decrypted: " + ogWord4 + "\nActual Decrypted: " + decrypted4 + "\n");
        if (ogWord4.equals(decrypted4) && encrypted4.equals(expected4)) { System.out.println("TEST PASSED"); }
        else { System.out.println("TEST FAILED"); }
        System.out.println();
    }
}
