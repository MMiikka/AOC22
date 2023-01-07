import java.io.File;
import java.util.ArrayList;

import Apuluokkia.Lukija;

public class Day4 {
  private ArrayList<String> input; 
  private File f = new File("input4.txt");
  private int result;
  private ArrayList<String> getInput(File f){
    var l = new Lukija();
    return l.read(f);
  }
  public int results_E1(){
    result = 0;
    input = getInput(this.f);
    int i = 0;
    for(String s : input){
 
      int minA = Integer.parseInt(s.substring(0,s.indexOf("-")));
      int maxA = Integer.parseInt(s.substring(s.indexOf("-" ) +1,s.indexOf(",")));
      String s2 = s.substring(s.indexOf(","),s.length());
      int minB = Integer.parseInt(s2.substring(1,s2.indexOf("-")));
      int maxB = Integer.parseInt(s2.substring(s2.indexOf("-" ) +1,s2.length()));
      //System.out.println(a + " " + b + ", " + c + " " + d );
      if((minA >= minB && maxA <= maxB) || (minB >= minA && maxB <= maxA) ){
        result++;
      }

    
    }
    return result;
  }

  public int results_E2(){
    result = 0;
    input = getInput(this.f);
    int i = 0;
    for(String s : input){
 
      int minA = Integer.parseInt(s.substring(0,s.indexOf("-")));
      int maxA = Integer.parseInt(s.substring(s.indexOf("-" ) +1,s.indexOf(",")));
      String s2 = s.substring(s.indexOf(","),s.length());
      int minB = Integer.parseInt(s2.substring(1,s2.indexOf("-")));
      int maxB = Integer.parseInt(s2.substring(s2.indexOf("-" ) +1,s2.length()));
      //System.out.println(a + " " + b + ", " + c + " " + d );
      if((minA > maxB) || (maxA < minB)) {
       continue; 
      }else{result++;}

    
    }
    return result;
  }
}
/*
 * 14-38,14-14
 */