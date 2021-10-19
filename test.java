import java.io.IOException;
import java.util.Scanner;

public class test {

    public static void main(String[] args) throws IOException {

        //Dictionary dic = new Dictionary();

        DictionaryCommandline dictionaryCommandline = new DictionaryCommandline();
        dictionaryCommandline.dictionaryManagement.insertFromFile();

        Scanner sc = new Scanner(System.in);
        dictionaryCommandline.dictionaryManagement.insertFromCommandline();

        while (true) {

            System.out.println("enter 1: edit word");
            System.out.println("enter 2: translate");
            System.out.println("enter 3: search word");
            System.out.println("enter 4: show all word");
            System.out.println("Choose ?");
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
