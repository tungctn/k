import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        //Dictionary dic = new Dictionary();

        DictionaryCommandline dictionaryCommandline = new DictionaryCommandline();
        dictionaryCommandline.dictionaryManagement.insertFromFile();

        Scanner sc = new Scanner(System.in);
        dictionaryCommandline.dictionaryManagement.insertFromCommandline();

        while (true) {

            System.out.println("nhập số 1: sửa từ");
            System.out.println("nhập số 2: dịch");
            System.out.println("nhập số 3: tìm kiếm");
            System.out.println("nhập số 4: hiển thị danh sách");
            System.out.println("nhập số 5: xuất dữ liệu ra tệp");
            System.out.println("Nhập số ...");
            int n = sc.nextInt();
            if (n == 1) {
                dictionaryCommandline.dictionaryManagement.repair();
            } else if (n == 2) {
                dictionaryCommandline.dictionaryManagement.lookup();
            } else if (n == 3) {
                dictionaryCommandline.Searcher();
            } else if (n == 4) {
                dictionaryCommandline.dictionaryManagement.showAllWord();
            } else if (n == 5) {
                dictionaryCommandline.dictionaryManagement.dictionaryExportToFile();
            } else continue;
            //dictionaryCommandline.dictionaryManagement.repair();
            //dictionaryManagement.delete("lik");
            //dictionaryCommandline.dictionaryManagement.lookup();
        }

    }

}
