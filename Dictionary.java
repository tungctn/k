import java.util.*;

public class Dictionary {
   private ArrayList<word> words = new ArrayList<>();
   // khởi tạo Dictionary
   Dictionary() {
      words = new ArrayList<>();
   }
   // thêm từ vào mảng words
   public void addWord(word word){
      words.add(word);
   }
   // thêm từ vào vị trí trong mảng words
   public void addarray(int i, word word){
      words.add(i,word);
   }
   // in ra từ ở vị trí i
   public word getWord(int i){
      return words.get(i);
   }
   // xóa từ ở vị trí i
   public void remove(int i){
      words.remove(i);
   }
   // số từ trong mảng words
   public int size(){
      return words.size();
   }
   //public ArrayList<word> getWords(){
   //   return words;
   //}

}