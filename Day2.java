
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Apuluokkia.Lukija;
import Apuluokkia.Tuple;



public class Day2{

public int results(){
    BufferedReader lukija;
    File f = new File("input2.txt");
    var l = new Lukija();
    var lista = l.read(f);
    ArrayList tuplet = new ArrayList<Tuple<Character>>();
   
 

    for(int i = 0; i<lista.size(); i++){
   
      String a = (String)lista.get(i);
      char[] chars= a.toCharArray();
      Tuple<Character> tuple = new Tuple(chars[0], chars[2]); 
      tuplet.add(tuple);
    }

    int points = 0;
    for(int i = 0; i< tuplet.size();i++){
     var enemy = tuplet.get(i);
     var player = tuplet.get(i);
      char a = ((Tuple<Character>) enemy).getFirst();
      char b = ((Tuple<Character>) enemy).getSecond();
      //Part one
      /*
      if(b == 'X'){
        points++;
        if(a == 'A'){points += 3;}
        if(a == 'B'){points += 0;}
        if(a == 'C'){points += 6;}
      }
      else if(b == 'Y'){
        points += 2;
        if(a == 'A'){points += 6;}
        if(a == 'B'){points += 3;}
        if(a == 'C'){points += 0;}
      }
      else{
        points += 3;
        if(a == 'A'){points += 0;}
        if(a == 'B'){points += 6;}
        if(a == 'C'){points += 3;}
      }
       */
      //Part 2
      if(a == 'A'){
        
        if(b == 'X'){points += 3;}
        if(b == 'Y'){points += 4;}
        if(b == 'Z'){points += 8;}
      }
      else if(a == 'B'){
  
        if(b == 'X'){points += 1;}
        if(b == 'Y'){points += 5;}
        if(b == 'Z'){points += 9;}
      }
      else{
    
        if(b == 'X'){points += 2;}
        if(b == 'Y'){points += 6;}
        if(b == 'Z'){points += 7;}
      }
    }
return points;

  }
}

