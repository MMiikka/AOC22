import java.io.File;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.Stack;
import java.util.regex.Pattern;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.swing.event.TreeSelectionListener;
import javax.swing.text.html.HTMLDocument.BlockElement;

import Apuluokkia.Lukija;

public class Day7 {
  private File f = new File("input7.txt");
  private ArrayList<String> input = getInput(f);
  private ArrayList<String> getInput(File f){
    var l = new Lukija();
    return l.read(f);
  }
 
  private ArrayList<Folder> folders = new ArrayList<>();
  private HashMap<String,Integer> map = new HashMap<>();
  private Folder root;
  private Folder parent;
 

  private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
  private ArrayList<Integer> folderSizes = new ArrayList<>();
private boolean isNumeric(String strNum) {
    if (strNum == null) {
        return false; 
    }
    return pattern.matcher(strNum).matches();
}

  public int results_E1(){
   boolean rootFound = false;
   boolean cd = false;
   boolean cdBack = false;
   int treeDepth = -1;
    int file = 0;
   for(String s : input){
    String[] line = s.split(" ");
    
    if(line[1].equals("cd")){
      cd = true;
    }else{
      cd = false;
    }

    if(line.length > 2 && line[2].equals("..")){
      cdBack = true;
    }else{
      cdBack = false;
    }

    if(line.length == 3 && cd && !cdBack){
    if(!rootFound){
      root = new Folder(null,line[2]);
      root.setIndex(0);
      folders.add(root);
      parent = root;
      rootFound = true;
     
    }else{
      root = new Folder(parent,line[2]);
      folders.add(root);
      parent.setFolder(root);
      parent = root;
    }
   }else if(line.length == 3 && cd && cdBack){
    parent = parent.getRoot();
   }
   if(isNumeric(line[0])){
    parent.setSize(Integer.parseInt(line[0]));
    }
  }

 int sum = 0;
 folders.get(0).getOverallSize();
 for (int item : folderSizes) {
  System.out.println(item);
  if(item <= 100000) {
      sum += item;
  }


 }

  return sum;

}
public int results_E2(){
  boolean rootFound = false;
  boolean cd = false;
  boolean cdBack = false;
  int treeDepth = -1;
   int file = 0;
  for(String s : input){
   String[] line = s.split(" ");
   
   if(line[1].equals("cd")){
     cd = true;
   }else{
     cd = false;
   }

   if(line.length > 2 && line[2].equals("..")){
     cdBack = true;
   }else{
     cdBack = false;
   }

   if(line.length == 3 && cd && !cdBack){
   if(!rootFound){
     root = new Folder(null,line[2]);
     root.setIndex(0);
     folders.add(root);
     parent = root;
     rootFound = true;
    
   }else{
     root = new Folder(parent,line[2]);
     folders.add(root);
     parent.setFolder(root);
     parent = root;
   }
  }else if(line.length == 3 && cd && cdBack){
   parent = parent.getRoot();
  }
  if(isNumeric(line[0])){
   parent.setSize(Integer.parseInt(line[0]));
   }
 }
//8381165
int sum = 0;
folders.get(0).getOverallSize();
ArrayList<Integer> lista = new ArrayList<>();
Collections.sort(folderSizes);
for (int item : folderSizes) {
 System.out.println(item);
 if(item > unusedSpace(folderSizes.get(folderSizes.size()-1))) {
     lista.add(item);
 }
}
 return lista.get(0);
}
public int unusedSpace(int size){
  int space = 70000000 - size;
  return spaceNeeded(space);
}
public int spaceNeeded(int space){
  
  return 30000000 - space;
}



class Folder {
  private int index;
  private boolean isVisited = false;
  private ArrayList<Folder> list;
  private ArrayList<Integer> sizeList;
  private int overallSize;
  private int fileSize;
  private Folder root;
  private String name;
  public Folder(Folder root, String name){
    list = new ArrayList<>();
    this.root = root;
    this.name = name;
    this.sizeList = new ArrayList<>();
  }


  public int getIndex(){
    return this.index;
  }
  public void setIndex(int index){
    this.index = index;
  }
  public Folder getRoot(){
    return this.root;
  }

  public void setName(String name){
    this.name = name;
  }
  public String getName(){
    return this.name;
  }
  public void setSize(int size){
    this.sizeList.add(size);
  }
  public int getSize(){

    return fileSize;
  }
  public void setFolder(Folder f){
    this.list.add(f);
  }
  public ArrayList<Folder> getfolders(){
    return list;
  }
  
  public int getOverallSize() {
    int retval = 0;
    for(Folder kansio : this.getfolders()) {
        retval += kansio.getOverallSize();
    }
    for(int i : this.sizeList) {
        retval += i;
    }
    folderSizes.add(retval);
    return retval;
}
  
  @Override
  public String toString(){
    return this.getName();
  }
  
}
}