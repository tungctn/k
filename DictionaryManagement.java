import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;


public class DictionaryManagement {
    // khởi tạo dic
    Dictionary dic = new Dictionary();

    // nhập các từ vào mảng dic
    public void insertFromCommandline() throws IOException {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("nhập số lượng từ cần thêm: ");
        n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            word w = new word();
            w.word_target = sc.nextLine();
            w.word_explain = sc.nextLine();
            dic.addWord(w);
        }
    }

    public void dictionaryExportToFile() throws IOException {
        int len = dic.size();
        try {
            FileWriter fw = new FileWriter("D:\\dictionaryExportToFile.txt");
            for(int i = 0; i < len; i ++ ) {
                fw.write(dic.getWord(i).word_target);
                fw.write("\n");
                fw.write(dic.getWord(i).word_explain);
                fw.write("\n");
            }
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("địa chỉ tệp được lưu: D:\\dictionaryExportToFile.txt");
    }

    public void insertFromFile() throws  IOException {

        word w = new word();
        int i = 0;
        try
        {
            FileInputStream fis=new FileInputStream("C:\\Users\\admin\\Desktop\\OOP_N3_BTL_N10\\source_code\\word.txt");
            Scanner sc=new Scanner(fis);    //file to be scanned
            while(sc.hasNextLine())
            {
                String s = sc.nextLine();
                if (i%2 == 0) {
                    w.word_target = s;
                } else {
                    w.word_explain = s;
                    dic.addWord(w);
                    w = new word();
                }
                i++;
            }
            sc.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
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

    /*public String lookup (String word) {
        for (int i = 0; i < dic.size(); i++) {
            if (word.equals(dic.getWord(i).word_target)) {
                return dic.getWord(i).word_explain;
            }
        }
        return "khong tim thay";
    }*/
    // tìm nghĩa của từ
    public void lookup () {
        Scanner sc = new Scanner(System.in);
        boolean ok = false;
        System.out.println("Nhập từ cần tìm:");
        String word = sc.nextLine();
        for (int i = 0; i < dic.size(); i++) {
            if (word.equals(dic.getWord(i).word_target)) {
                System.out.println(dic.getWord(i).word_explain);
                ok = true;
            }
        }
        if(!ok) System.out.println( "không tìm thấy");
    }
    // xóa từ
    public void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("từ muốn xoá:");
        String word = sc.nextLine();
        int i = position(word);
        if (i == -1) {
            System.out.println("không tìm thấy");
            return;
        }
        dic.remove(i);
    }
    // sửa nghĩa của từ
    public void repair() {
        Scanner sc = new Scanner(System.in);
        System.out.println("từ muốn sửa:");
        String w = sc.nextLine();
        int i = position(w);
        if (i == 0) {
            System.out.println("không tìm thấy");
            return;
        }
        word w1 = new word();
        w1.word_target = w;
        w1.word_explain = sc.nextLine();
        dic.remove(i);
        dic.addarray(i, w1);
    }

}
