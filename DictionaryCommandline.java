import java.io.IOException;
import java.util.Scanner;

public class DictionaryCommandline {

    public DictionaryManagement dictionaryManagement = new DictionaryManagement();

    DictionaryCommandline(){};
    // tìm kiem cac từ
    public void Searcher() {
        Scanner sc = new Scanner(System.in);
        boolean ok = false;
        System.out.println("nhập từ bạn muốn tra: ");
        String w = sc.nextLine();
        System.out.println("các từ tìm được:");
        for (int i = 0; i < dictionaryManagement.dic.size(); i++) {
            if (dictionaryManagement.dic.getWord(i).word_target.contains(w)) {
                System.out.println(dictionaryManagement.dic.getWord(i).word_target+": "+dictionaryManagement.dic.getWord(i).word_explain);
                ok = true;
            }
        }
        if(!ok) System.out.println("Không tìm thấy.");
    }
}
