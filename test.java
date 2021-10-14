import java.io.IOException;
import java.util.Scanner;

public class test {

    // test các chức năng
    public static void main(String[] args) throws IOException {

        //Dictionary dic = new Dictionary();

        DictionaryCommandline dictionaryCommandline = new DictionaryCommandline();
        //DictionaryManagement dictionaryManagement = new DictionaryManagement();
        // test với số lượng từ là 6, copy các từ trong in.txt
        Scanner sc = new Scanner(System.in);
        dictionaryCommandline.dictionaryManagement.insertFromCommandline();

        while (true) {

            System.out.println("Chon chuc nang");
            int n = sc.nextInt();
            if (n == 1) {
                dictionaryCommandline.dictionaryManagement.repair();
            } else if (n == 2) {
                dictionaryCommandline.dictionaryManagement.lookup();
            } else if (n == 3) {
                dictionaryCommandline.Searcher();
            } else if (n == 4) {
                dictionaryCommandline.dictionaryManagement.showAllWord();
            } else continue;
            //dictionaryCommandline.dictionaryManagement.repair();
            //dictionaryManagement.delete("lik");
            //dictionaryCommandline.dictionaryManagement.lookup();
        }

    }

}
