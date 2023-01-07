import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

import Apuluokkia.Lukija;
public class Day5 {
  private File f = new File("input5.txt");
  private ArrayList<String> input = getInput(f); 


  private ArrayList<String> getInput(File f){
    var l = new Lukija();
    return l.read(f);
  }

  public StringBuilder results_E1(){
  
    input = getInput(this.f);
    ArrayList<String> picture = new ArrayList<>();
    char[][] array = new char[9][9];
    //kopioidaan input mappi
    for(String s : input){
      picture.add(s);
    }
  //Putsataan inputit
    String s = "m";
    for(int i= 0; i< 5;i++){
     input.removeIf(e -> !e.contains(s));
     picture.removeIf(e -> e.contains(s));
    }

    //Tehdään konteista taulu
    int kirjain = 1;
    boolean full = false;
    for(int i = 0; i<picture.size();i++){
     kirjain = 1;
      for(int j = 0; j<9;j++){
       String a = picture.get(i);
       if(a.charAt(kirjain) == '1'){
        full = true;
        break;
      }
       array[i][j] = a.charAt(kirjain);
        kirjain += 4;
      }
      if(full){
        break;
      }
    }
    ArrayList<Stack<Character>> stacks = new ArrayList<>();
    Stack<Character> stack;
    for(int i = 0; i <array.length;i++){
      stack = new Stack<Character>();
      for(int j = 7;j>=0;j--){
        if(array[j][i] != ' '){
          stack.add(array[j][i]);
        }else{continue;}
      }
      
      stacks.add(stack);
      System.out.println(stack.toString());
    }
   
    boolean cont = true;
    int from = 0;
    int to = 0;
    int move = 0;
    int indexInput = 0;
    while(cont){
     
     String inst1 = input.get(indexInput);
     move = Integer.parseInt(inst1.substring(inst1.indexOf('e')+2, inst1.indexOf('f')-1));
     String inst2 = inst1.substring(inst1.indexOf('f'),inst1.length());
     from = Integer.parseInt(inst2.substring(inst2.indexOf('m')+2,  inst2.indexOf('t')-1));
     String inst3 = inst2.substring(inst2.indexOf('t'),inst2.length());
     to = Integer.parseInt(inst3.substring(inst3.indexOf('o')+2, inst3.length()));
     System.out.println("move: " + move + " from: " + from + " to: " + to);
      
    
      
     
        
      for(int i = 0;i<move;i++){
       stacks.get(to - 1).push(stacks.get(from -1).pop());
      }
        /* 
      //[R, D, L, C, T, F, H, G,V,Z,N,H,P]
      System.out.println(stacks.get(to - 1).toString());
      break;
     */
      indexInput++;
      if(indexInput == input.size()){
        cont = false;
      }
     
    }
 StringBuilder sb = new StringBuilder();
    for(int i = 0; i<stacks.size();i++){
      Character c = ' ';
      c = stacks.get(i).peek();
      sb.append(c);
    }
   //VCTFTJQCG
    return sb;
  }

  public StringBuilder results_E2(){
  
    input = getInput(this.f);
    ArrayList<String> picture = new ArrayList<>();
    char[][] array = new char[9][9];
    //kopioidaan input mappi
    for(String s : input){
      picture.add(s);
    }
  //Putsataan inputit
    String s = "m";
    for(int i= 0; i< 5;i++){
     input.removeIf(e -> !e.contains(s));
     picture.removeIf(e -> e.contains(s));
    }

    //Tehdään konteista taulu
    int kirjain = 1;
    boolean full = false;
    for(int i = 0; i<picture.size();i++){
     kirjain = 1;
      for(int j = 0; j<9;j++){
       String a = picture.get(i);
       if(a.charAt(kirjain) == '1'){
        full = true;
        break;
      }
       array[i][j] = a.charAt(kirjain);
        kirjain += 4;
      }
      if(full){
        break;
      }
    }
    ArrayList<Stack<Character>> stacks = new ArrayList<>();
    Stack<Character> stack;
    for(int i = 0; i <array.length;i++){
      stack = new Stack<Character>();
      for(int j = 7;j>=0;j--){
        if(array[j][i] != ' '){
          stack.add(array[j][i]);
        }else{continue;}
      }
      
      stacks.add(stack);
      System.out.println(stack.toString());
    }
   
    boolean cont = true;
    int from = 0;
    int to = 0;
    int move = 0;
    int indexInput = 0;
    while(cont){
     ArrayList<Character> tmp = new ArrayList<>();;
     String inst1 = input.get(indexInput);
    // System.out.println(inst1);
     move = Integer.parseInt(inst1.substring(inst1.indexOf('e')+2, inst1.indexOf('f')-1));
     String inst2 = inst1.substring(inst1.indexOf('f'),inst1.length());
     //System.out.println(inst2);
     from = Integer.parseInt(inst2.substring(inst2.indexOf('m')+2,  inst2.indexOf('t')-1));
     String inst3 = inst2.substring(inst2.indexOf('t'),inst2.length());
    // System.out.println(inst3);
     to = Integer.parseInt(inst3.substring(inst3.indexOf('o')+2, inst3.length()));
     System.out.println("move: " + move + " from: " + from + " to: " + to);

      for(int i = 0;i<move;i++){
      
      tmp.add(stacks.get(from -1).pop());
      
      }
      Collections.reverse(tmp);
      System.out.println("Temppi: " + tmp.toString());
      for(int i = 0;i<move;i++){
      stacks.get(to -1).push(tmp.get(i));
      }

       /* 
      //[R, D, L, C, T, F, H, G,V,Z,N,H,P]
      System.out.println(stacks.get(to - 1).toString());
      break;
         */
      indexInput++;
      if(indexInput == input.size()){
        cont = false;
      }
  
    }
 StringBuilder sb = new StringBuilder();
    for(int i = 0; i<stacks.size();i++){
      Character c = ' ';
      c = stacks.get(i).peek();
      sb.append(c);
    }
   //VCTFTJQCG
    return sb;
  }

}
