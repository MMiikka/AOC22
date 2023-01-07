
import Apuluokkia.Lukija;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Day3 {

  public int results_E1(){
    int results = 0;
    var l = new Lukija();
    File f = new File("input3.txt");
    var rivit = l.read(f);
    ArrayList<Character> characters =  new ArrayList<Character>();;
    
    for(int i = 0; i< rivit.size();i++){
      int pituus = rivit.get(i).length();
      String line1 = rivit.get(i).substring(0,pituus / 2);
      String line2 = rivit.get(i).substring(pituus / 2,pituus);

      for (char a : line1.toCharArray()){      
          if(line2.indexOf(a) != -1){            
            int temp_lowerCase = 96;
            int temp_upperCase = 38;
            if(Character.isLowerCase(a)){
             int number = (int)a;
             results += number - temp_lowerCase;
            }else{
              int number = (int)a;
              results += number - temp_upperCase;
            }
            break;
          }
       } 
      }
      /*
      for(char a : line1.toCharArray()){
       boolean found = false;
        int j = 0;
        while(j < line2.length()){
        if(a == line2.charAt(j)){
          characters.add(a);
          found = true;
          break;
        }
        j++;
        }
        if(found) break;
      }
     
      }
    //  System.out.println(characters.size() + "," + rivit.size());
      for(int k = 0; k< characters.size();k++){
        int temp_lowerCase = 96;
        int temp_upperCase = 38;
        if(Character.isLowerCase(characters.get(k))){
         int number = (int)characters.get(k);
         results += number - temp_lowerCase;
        }else{
          int number = (int)characters.get(k);
          results += number - temp_upperCase;
        }
        */
       return results;
    }

    public int results_E2(){
      int results = 0;
      var l = new Lukija();
      File f = new File("input3.txt");
      var rivit = l.read(f);

      for(int i= 0; i<rivit.size();i+=3){
        int pituus = rivit.get(i).length();
        char[] rivi1;
        String rivi2;
        String rivi3;
        rivi1 = rivit.get(i).toCharArray();
        rivi2 = rivit.get(i+1);
        rivi3 = rivit.get(i+2);
     
        for(char a : rivi1){
          if(rivi2.indexOf(a) != -1 && rivi3.indexOf(a) != -1){
            int temp_lowerCase = 96;
              int temp_upperCase = 38;
              if(Character.isLowerCase(a)){
               int number = (int)a;
               results += number - temp_lowerCase;
              }else{
                int number = (int)a;
                results += number - temp_upperCase;
              }
              break;
          }
        }
    
    
      }
     
      
        return results;
    }


}


/*
 *   for (char a : line1.toCharArray()){      
            if(line2.indexOf(a) != -1){            
              int temp_lowerCase = 96;
              int temp_upperCase = 38;
              if(Character.isLowerCase(a)){
               int number = (int)a;
               results += number - temp_lowerCase;
              }else{
                int number = (int)a;
                results += number - temp_upperCase;
              }
              break;
            }
         } 
 */