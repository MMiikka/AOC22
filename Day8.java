import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import Apuluokkia.Lukija;

public class Day8 {
  private File f = new File("input8.txt");
  private ArrayList<String> input = getInput(f);
  private ArrayList<String> getInput(File f){
    var l = new Lukija();
    return l.read(f);
  }

  
  private int[][] forest = new int[input.get(0).length()][input.size()];
  private ArrayList<Integer> visible = new ArrayList<>();


  private boolean isVisible(int i, int[][] forest,int x,int y) {
    boolean[] visible = new boolean[4];
    //left
    for(int index = y-1; index >= 0;index--){
      if(i > forest[x][index] ){
        visible[0] = true;
      }else{
        visible[0] = false;
        break;
      }
    }
    //up
    for(int index = x-1; index >= 0;index--){
      if(i > forest[index][y] ){
        visible[1] = true;
      }else{
        visible[1] = false;
        break;
      }
    }
    //right
    for(int index = y+1; index < forest[x].length;index++){
      if(i > forest[x][index] ){
        visible[2] = true;
      }else{
        visible[2] = false;
        break;
      }
    }
    //down
    for(int index = x+1; index < forest[y].length;index++){
      if(i > forest[index][y] ){
        visible[3] = true;
      }else{
        visible[3] = false;
        break;
      }
    }
    if(visible[0] || visible[1] ||visible[2] || visible[3]){
      return true;
    }else{
      return false;
    }
    
  }
 

  public int results_E1(){
    int x = 0;
    for(String rivi : input){
      
      String[] s = rivi.split("");
      for(int y = 0; y< rivi.length();y++){
        forest[x][y] = Integer.parseInt(s[y]);
      }
      x++;
    }
 
  return checkVisible(forest);
}

public int  checkVisible(int[][] forest){
  for(int x = 1;x<forest.length-1;x++){
    for(int y= 1;y<forest.length-1;y++){
      if(isVisible(forest[x][y],forest,x,y)){
        visible.add(forest[x][y]);
      }

    }
}
return visible.size() + (forest.length * 2 + forest[0].length *2) -4;
}

//Kakkostehtävä
public int results_E2(){
  int x = 0;
  for(String rivi : input){
    
    String[] s = rivi.split("");
    for(int y = 0; y< rivi.length();y++){
      forest[x][y] = Integer.parseInt(s[y]);
    }
    x++;
  }

return checkScore(forest);
}


public int  checkScore(int[][] forest){
  ArrayList<Integer> scores = new ArrayList<>();
  for(int x = 1;x<forest.length-1;x++){
    for(int y= 1;y<forest.length-1;y++){
    int score =  scenicScore(forest[x][y],forest,x,y);
    System.out.println(score);
    scores.add(score);
      

    }
}

return scores.stream().mapToInt(e -> e).max().orElseThrow(NoSuchElementException::new);
}
private int scenicScore(int i, int[][] forest,int x,int y) {
  ArrayList<Integer> score = new ArrayList<>();
  int left = 0;
  int up = 0;
  int right = 0;
  int down = 0;
  //left
  for(int index = y-1; index >= 0;index--){
    if(i > forest[x][index] ){
      left++;
    }else{
      left++;
      break;
    }
  }
 
  //up
  for(int index = x-1; index >= 0;index--){
    if(i > forest[index][y] ){
      up++;
    }else{
      up++;
      break;
    }
  }
  
  
  //right
  for(int index = y+1; index < forest[x].length;index++){
    if(i > forest[x][index] ){
      right++;
    }else{
      right++;
      break;
    }
  }
  
  //down
  for(int index = x+1; index < forest[y].length;index++){
    if(i > forest[index][y] ){
     down++;
    }else{
      down++;
      break;
    }
  }
  if(left != 0) score.add(left);
  if(up != 0) score.add(up);
  if(right != 0) score.add(right);
  if(down != 0) score.add(down);
  System.out.println("indeksissä: " + x + ","+ y+ ": " + left + " " + up + " " + right + " " + down + " scoret ja kerrottuna: " + score.stream().reduce(1, (a, b) -> a * b ));
  
  return score.stream().reduce(1, (a, b) -> a * b);
}
}
