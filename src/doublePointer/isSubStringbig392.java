package doublePointer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class isSubStringbig392 {
    public boolean isSubsequence(BufferedReader sReader, BufferedReader tReader) throws IOException {
        int sChar = sReader.read();
        int tChar = tReader.read();

        while (sChar != -1 && tChar != -1) {
            if (sChar == tChar) {
                sChar = sReader.read();
            }
            tChar = tReader.read();
        }

        return sChar == -1; // true if all characters of s are found
    }

    public static void main(String[] args) {
        try {
            BufferedReader sReader = new BufferedReader(new FileReader("path_to_s_file.txt"));
            BufferedReader tReader = new BufferedReader(new FileReader("path_to_t_file.txt"));

            isSubStringbig392 solution = new isSubStringbig392();
            boolean result = solution.isSubsequence(sReader, tReader);
            System.out.println("Is subsequence: " + result);

            sReader.close();
            tReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**BufferedReader:

     Used to read s and t one character at a time.
     This prevents loading the entire string into memory at once.
     isSubsequence Method:

     Reads characters from s and t sequentially.
     If characters match, reads the next character from s.
     Always reads the next character from t.
     The loop continues until all characters of s are found in t in order or until t is exhausted.**/
}
