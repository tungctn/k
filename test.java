import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {

        //Dictionary dic = new Dictionary();

        DictionaryCommandline dictionaryCommandline = new DictionaryCommandline();
        //DictionaryManagement dictionaryManagement = new DictionaryManagement();
        dictionaryCommandline.dictionaryManagement.insertFromCommandline();
        //dictionaryManagement.repair();
        //dictionaryManagement.delete("lik");
        dictionaryCommandline.dictionaryManagement.lookup("like");
        //dictionaryCommandline.Searcher();
        //dictionaryManagement.showAllWord();
    }

}
