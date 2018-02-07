/*
* File: OperandNode.java
* Author: Claire Stovall
* Date: January 31, 2018
* Purpose: This class implements the Node interface.
*/

import java.io.*;

public class OperandNode extends Node {
  private int value;

  // Constructor
  public OperandNode(int value) {
    this.value = value;
  }

  // Getter
  public String inOrderWalk() {
    return String.valueOf(value);
  }

  // Setter
  public void setName() {
  }

  public void printOutput() {
  }

  // Getter
  public String getName() {
    return this.inOrderWalk();
  }

  public void postOrderWalk(PrintWriter printWriter) {
  }
}
