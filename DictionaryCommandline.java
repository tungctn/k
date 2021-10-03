import java.io.IOException;
import java.util.Scanner;

public class DictionaryCommandline {

    public DictionaryManagement dictionaryManagement = new DictionaryManagement();

    DictionaryCommandline(){};
    public void Searcher() {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap tu bn muon tra: ");
        String w = sc.nextLine();
        System.out.print("cac tu tim dc:");
        for (int i = 0; i < dictionaryManagement.dic.size(); i++) {
            if (dictionaryManagement.dic.getWord(i).word_target.contains(w)) {
                System.out.print(dictionaryManagement.dic.getWord(i).word_target + ", ");
            }
        }
    }


}
