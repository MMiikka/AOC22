import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import Apuluokkia.Lukija;

class Point {
  private int y;
  private int x;
  private ArrayList<Point> visited;
  private Point head;
  private String name;
  public Point(int y, int x){
    this.y = y;
    this.x = x;
   
    visited = new ArrayList<>();
  }
  public Point getHead() {
    return this.head;
  }
  public void setHead(Point head) {
    this.head = head;
  }
  public String getName() {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public void setVisit(Point p) {
    boolean isVisited = false;
    for (Point po : visited){
      if(p.equals(po)){
        isVisited = true;
        return;
      }else{
        isVisited = false;
       
      }
    }
      if(!isVisited){
        this.visited.add(p);
      }

    
    

   
  }
  public ArrayList<Point> getVisited() {
    return visited;
  }
  public void setY(int y) {
    this.y = y;
  }
  public void setX(int x) {
    this.x = x;
  }
  public int getY() {
    return y;
  }
  public int getX() {
    return x;
  }

  public boolean isClose(Point head){
    
    return Math.abs(this.getY() - head.getY()) < 2 && Math.abs(this.getX() - head.getX()) < 2;
  }

  public boolean isLeftUpRightDown(Point head){
    return this.getX() == head.getX() || this.getY() == head.getY();
  }
  @Override
  public boolean equals(Object o){
    Point p;
    if(o instanceof Point){
      p = (Point)o;
    
   
    return this.getX() == p.getX() && this.getY() == p.getY() ? true : false;
  }else{
    return false;
  }
  }

  
  public String toString(){
    return "Y:" + this.y + " X:" + this.x + " ";
}
}
class Rope{
  private Point head;
  private Point tail;
  private ArrayList<Point> knots;
  public Rope(Point head, Point tail) {
    this.head = head;
    this.tail = tail;
    this.knots = new ArrayList<>();
    
  }
  public void setKnot(Point knot){
    this.knots.add(knot);
  }
  public ArrayList<Point> getKnots(){
    return this.knots;
  }
  public void setHead(Point head) {
    this.head = head;
  }
  public void setTail(Point tail) {
    this.tail = tail;
  }
  public Point getHead() {
    return head;
  }
  public Point getTail() {
    return tail;
  }
 

  }


public class Day9{
  private File f = new File("input9.txt");
  private ArrayList<String> input = getInput(f);
  private ArrayList<String> getInput(File f){
    var l = new Lukija();
    return l.read(f);
  }
  

  private ArrayList<String> v = new ArrayList<>();
  private ArrayList<String[]> parsedInput = new ArrayList<>();
  public int results_E1(){
    var rope = new Rope(new Point(0,0), new Point(0,0));
    
    for(String rivi : input){
      String[] s = rivi.split(" ");
      parsedInput.add(s);
    }
  
    Point head = rope.getHead();
    Point tail = rope.getTail();

    Point middle = new Point(0, 0);
    tail.setHead(middle);
    middle.setHead(head);
    rope.setKnot(head);
    rope.setKnot(middle);
    rope.setKnot(tail);
    tail.setVisit(new Point(0,0));
    v.add("00");
 
    for(String[] s : parsedInput){
      int a = Integer.parseInt(s[1]);
        for(int i = 0; i<a;i++){

          if(s[0].equals("L")){
            head.setX(head.getX()-1);
            if(!tail.isClose(head)){
              int x = head.getX();
              int y = head.getY();
              tail.setX(x+1);
              tail.setY(y);
              tail.setVisit(new Point(tail.getY(), tail.getX()));
      
            }
          }else if(s[0].equals("U")){
            head.setY(head.getY()+1);
            if(!tail.isClose(head)){
              int x = head.getX();
              int y = head.getY();
              tail.setX(x);
              tail.setY(y-1);
              tail.setVisit(new Point(tail.getY(), tail.getX()));
        
            }
          }else if(s[0].equals("R")){
            head.setX(head.getX()+1);
            if(!tail.isClose(head)){
              int x = head.getX();
              int y = head.getY();
              tail.setX(x-1);
              tail.setY(y);
              tail.setVisit(new Point(tail.getY(), tail.getX()));
       
            }
          }else if(s[0].equals("D")){
            head.setY(head.getY()-1);
            if(!tail.isClose(head)){
              int x = head.getX();
              int y = head.getY();
              tail.setX(x);
              tail.setY(y+1);
              tail.setVisit(new Point(tail.getY(), tail.getX()));
            
            }
          }else{
            System.out.println(new Exception("Suuntaa ei löytynyt"));
            return -1;
          }
      }
      }
    
    System.out.println(head.getY() + " " + head.getX() + " " +tail.getY() + " " + tail.getX());
      tail.getVisited().stream().distinct().collect(Collectors.toList());
      System.out.println( tail.getVisited().toString());

    return tail.getVisited().size();
  }
//KAKKONE
  public int results_E2(){
    var rope = new Rope(new Point(0,0), new Point(0,0));
    
    for(String rivi : input){
      String[] s = rivi.split(" ");
      parsedInput.add(s);
    }
  
    Point head = rope.getHead();
    head.setHead(head);
    head.setName("head");
    Point start = new Point(0, 0);
 
    rope.setKnot(head);
    rope.setKnot(new Point(0, 0));
    rope.setKnot(new Point(0,0));
    rope.setKnot(new Point(0,0));
    rope.setKnot(new Point(0,0));
    rope.setKnot(new Point(0,0));
    rope.setKnot(new Point(0,0));
    rope.setKnot(new Point(0,0));
    rope.setKnot(new Point(0,0));
    rope.setKnot(new Point(0,0));
    
    for(int i = 1; i< rope.getKnots().size();i++){
      rope.getKnots().get(i).setHead(rope.getKnots().get(i-1));
    }
    head.setHead(start);
    
    
    v.add("00");
 
    
      ArrayList<Point> visited = new ArrayList<>();
      visited =  getPath(rope,start);
      for(Point p : rope.getKnots()){
        System.out.println(p.getHead());
      }
    //System.out.println(head.getY() + " " + head.getX() + " " +tail.getY() + " " + tail.getX());
     // visited.stream().distinct().collect(Collectors.toList());
      System.out.println( visited.toString());
   

    return visited.size() +1;
  }

  public ArrayList<Point> getPath(Rope r, Point h){
    
    for(String[] s : parsedInput){
      int a = Integer.parseInt(s[1]);
    
      for(int i = 0; i<a;i++){
            for(int k = 0; k<r.getKnots().size()-1;k++){  
            
            r.setHead(r.getKnots().get(k));
            r.setTail(r.getKnots().get(k+1));

            var head = r.getHead();
            var tail = r.getTail();
          if(s[0].equals("L")){
            if(head.getName() != null){
       
            head.setX(head.getX()-1);
          
        
        
        
          }
            if(head.getName() == null){
              if(!tail.isLeftUpRightDown(head)){
                int x = head.getX();
                int y = head.getY();
                tail.setX(x+1);
                tail.setY(y);
                tail.setVisit(new Point(tail.getY(), tail.getX()));
              }
            }
            
            if(!tail.isClose(head)){
              int x = head.getX();
              int y = head.getY();
              tail.setX(x+1);
              tail.setY(y);
              tail.setVisit(new Point(tail.getY(), tail.getX()));
      
            }
          }else if(s[0].equals("U")){
            if(head.getName() != null){
           
            head.setY(head.getY()+1);
            
          }
          if(head.getName() == null){
            if(!tail.isLeftUpRightDown(head)){
              int x = head.getX();
              int y = head.getY();
              tail.setX(x+1);
              tail.setY(y);
              tail.setVisit(new Point(tail.getY(), tail.getX()));
            }
          }
            if(!tail.isClose(head)){
              int x = head.getX();
              int y = head.getY();
              tail.setX(x);
              tail.setY(y-1);
              tail.setVisit(new Point(tail.getY(), tail.getX()));
        
            }
          }else if(s[0].equals("R")){
            if(head.getName() != null){

            head.setX(head.getX()+1);
            
          }
          if(head.getName() == null){
            if(!tail.isLeftUpRightDown(head)){
              int x = head.getX();
              int y = head.getY();
              tail.setX(x+1);
              tail.setY(y);
              tail.setVisit(new Point(tail.getY(), tail.getX()));
            }
          }
            if(!tail.isClose(head)){
              int x = head.getX();
              int y = head.getY();
              tail.setX(x-1);
              tail.setY(y);
              tail.setVisit(new Point(tail.getY(), tail.getX()));
       
            }
          }else if(s[0].equals("D")){
            if(head.getName() != null){
       
            head.setY(head.getY()-1);
            
          }
          if(head.getName() == null){
            if(!tail.isLeftUpRightDown(head)){
              int x = head.getX();
              int y = head.getY();
              tail.setX(x+1);
              tail.setY(y);
              tail.setVisit(new Point(tail.getY(), tail.getX()));
            }
          }
            if(!tail.isClose(head)){
              int x = head.getX();
              int y = head.getY();
              tail.setX(x);
              tail.setY(y+1);
              tail.setVisit(new Point(tail.getY(), tail.getX()));
            
            }
          }else{
            System.out.println(new Exception("Suuntaa ei löytynyt"));
            
          }
          
}
      }
      }
      return r.getKnots().get(9).getVisited();

  }

}
