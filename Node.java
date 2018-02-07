/*
* File: Node.java
* Author: Claire Stovall
* Date: January 31, 2018
* Purpose: This class is a Node interface to build a tree.
*/

import java.io.*;

public abstract class Node {
  public abstract String inOrderWalk();
  public abstract void postOrderWalk(PrintWriter printWriter);
  public abstract void printOutput();
  public abstract String getName();
  public abstract void setName();
}
