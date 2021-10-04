

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DictionaryManagement {
    // khởi tạo dic
    Dictionary dic = new Dictionary();
    // nhập các từ vào mảng dic
    public void insertFromCommandline() throws IOException {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("nhap so luong tu them vao: ");
        n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            word w = new word();
            w.word_target = sc.nextLine();
            w.word_explain = sc.nextLine();
            dic.addWord(w);
        }
    }
    // đọc file. hàm này bị lỗi
    public void insertFromFile() throws  IOException {

        String url = "D:\\Java\\IdeaProjects\\src\\word.txt";
        FileInputStream fileInputStream = new FileInputStream(url);
        Scanner scanner = new Scanner(fileInputStream);
        word w;
        while (scanner.hasNext()) {
            w = new word();

            String s = scanner.next();
            String[] a = s.split("\t");

            w.word_target = a[0];
            w.word_explain = a[1];

            dic.addWord(w);
        }
    }
    // in ra các từ vừa nhập
    public void showAllWord() throws IOException
        {
            int n = dic.size();
            String format = "%-10s| %-10s| %-10s%n";
            System.out.printf(format, "No", "English", "Vietnamese");
            for (int i = 0; i < n; i++) {
                System.out.printf(format, i + 1, dic.getWord(i).word_target, dic.getWord(i).word_explain);
            }
        }
    // tìm vị trí từ trong mảng dic
    public int position(String word) {
        for (int i = 0; i < dic.size(); i++) {
            if (word.equals(dic.getWord(i).word_target)) {
                return i;
            }
        }
        return -1;
    }
    // tìm nghĩa của từ
    public String lookup(String word) {


        for (int i = 0; i < dic.size(); i++) {
            if (word.equals(dic.getWord(i).word_target)) {
                return dic.getWord(i).word_explain;
            }

        }
        return "khong tim thay";
    }

    // xóa từ
    public void delete(String word) {
        int i = position(word);
        if (i == -1) {
            System.out.println("khong tim thay");
            return;
        }
        dic.remove(i);
    }
    // sửa nghĩa của từ
    public void repair() {
        Scanner sc = new Scanner(System.in);
        System.out.println("tu muon sua:");
        String w = sc.nextLine();
        int i = position(w);
        if (i == 0) {
            System.out.println("khong tim thay");
            return;
        }
        word w1 = new word();
        w1.word_target = w;
        w1.word_explain = sc.nextLine();
        dic.remove(i);
        dic.addarray(i, w1);
    }

    /*public class CreatFile{
        public String urlFileInput = "src\\in.txt";
        public String urlFileOutput = "src\\word.txt";

    }*/
}


