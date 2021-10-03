import java.util.*;

public class Dictionary {
   private ArrayList<word> words = new ArrayList<>();

   Dictionary() {
      words = new ArrayList<>();
   }
   public void addWord(word word){
      words.add(word);
   }
   public void addarray(int i, word word){
      words.add(i,word);
   }
   public word getWord(int i){
      return words.get(i);
   }
   public void remove(int i){
      words.remove(i);
   }
   public int size(){
      return words.size();
   }
   //public ArrayList<word> getWords(){
   //   return words;
   //}

}