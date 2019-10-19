package daaassignment;
import java.io.*;
import java.util.*;
import java.util.LinkedList;


class DAAassignment {
 private int V;
 private LinkedList < Integer > adj[];

 DAAassignment(int v) {
  V = v;
  adj = new LinkedList[v];
  for (int i = 0; i < v; ++i)
   adj[i] = new LinkedList();
 }

 void addEdge(int v, int w) {
  adj[v].add(w);
  adj[w].add(v);
 }

 void printVertexCover() {
  boolean visited[] = new boolean[V];
  for (int i = 0; i < V; i++)
   visited[i] = false;

  Iterator < Integer > i;

  for (int u = 0; u < V; u++) {
   if (visited[u] == false) {
    i = adj[u].iterator();
    while (i.hasNext()) {
     int v = i.next();
     if (visited[v] == false) {
      visited[v] = true;
      visited[u] = true;
      break;
     }
    }
   }
  }

  for (int j = 0; j < V; j++)
   if (visited[j] == true)
    System.out.print(j + " ");
 }
 public static void main(String args[]) {
  DAAassignment g = new DAAassignment(7);
  g.addEdge(0, 1);
  g.addEdge(1, 2);
  g.addEdge(1, 3);
  g.addEdge(3, 4);
  g.addEdge(4, 2);
  g.addEdge(2, 5);

  g.printVertexCover();
 }
}