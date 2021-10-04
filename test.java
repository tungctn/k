import java.io.IOException;

public class test {

    // test các chức năng
    public static void main(String[] args) throws IOException {

        //Dictionary dic = new Dictionary();

        DictionaryCommandline dictionaryCommandline = new DictionaryCommandline();
        //DictionaryManagement dictionaryManagement = new DictionaryManagement();
        // test với số lượng từ là 6, copy các từ trong in.txt
        dictionaryCommandline.dictionaryManagement.insertFromCommandline();
        //dictionaryManagement.repair();
        //dictionaryManagement.delete("lik");
        dictionaryCommandline.dictionaryManagement.lookup("like"); // chức năng này bị lỗi
        //dictionaryCommandline.Searcher();
        //dictionaryManagement.showAllWord();
    }

}
