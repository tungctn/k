import java.io.IOException;
import java.util.Scanner;

public class DictionaryCommandline {

    public DictionaryManagement dictionaryManagement = new DictionaryManagement();

    DictionaryCommandline(){};
    // tìm kiem cac từ
    public void Searcher() {
        Scanner sc = new Scanner(System.in);
        boolean ok = false;
        System.out.println("nhap tu bn muon tra: ");
        String w = sc.nextLine();
        System.out.println("cac tu tim dc:");
        for (int i = 0; i < dictionaryManagement.dic.size(); i++) {
            if (dictionaryManagement.dic.getWord(i).word_target.contains(w)) {
                System.out.println(dictionaryManagement.dic.getWord(i).word_target+": "+dictionaryManagement.dic.getWord(i).word_explain);
                ok = true;
            }
        }
        if(!ok) System.out.println("Khong tim thay");
    }
}
