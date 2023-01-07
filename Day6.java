import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Apuluokkia.Lukija;

public class Day6 {
  private File f = new File("input6.txt");
  private ArrayList<String> input = getInput(f); 


  private ArrayList<String> getInput(File f){
    var l = new Lukija();
    return l.read(f);
  }

  public int results_E1andE2(int disctinct){
    var recentFour = new ArrayList<Character>();
    int index = 1;
    boolean found = false;
      char[] ch = input.get(0).toCharArray();
      for(int i = 0; i<ch.length;i++){
        recentFour.add(ch[i]);
         found = letsCheck(recentFour, disctinct);

        if(!found){
          index++;
          if(recentFour.size() == disctinct){
            recentFour.remove(0);
          }
          continue;
        }else{
          return index;
        }
      }
      return -1;

}
  private boolean letsCheck(ArrayList<Character> ar, int disctinct) {
   // System.out.println(ar.toString());
    Set<Character> set = new HashSet<>();
      for(int i = 0;i<ar.size();i++){
        set.add(ar.get(i));
      }
    //  System.out.println("Set: "  + set.toString());
      if(set.size()<disctinct){
        return false;
      }else{
        return true;
      }
   
  }
}