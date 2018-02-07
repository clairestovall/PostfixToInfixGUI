/*
* File: OperatorNode.java
* Author: Claire Stovall
* Date: January 31, 2018
* Purpose: This class implements the Node interface.
*/

import java.io.*;

public class OperatorNode extends Node {
  private Node left;
  private Node right;
  private String operator;
  private String leftValue;
  private String rightValue;
  private File file;
  private PrintWriter printWriter;
  private String registerName;
  private static int counter = 0;

  // Constructor
  public OperatorNode(String operator, Node right, Node left) {
    this.operator = operator;
    this.left = left;
    this.right = right;
  }

  // Getter
  public String getName() {
    return registerName;
  }

  // Setter
  public void setName() {
    this.registerName = "R" + counter;
    counter++;
  }

  // Initialize file and writer to print output to file, call methods
  // to print three address instructions to file and close writer
  public void printOutput() {
    file = new File("file.txt");
    try {
      printWriter = new PrintWriter(file);
      this.postOrderWalk(printWriter);
      printWriter.close();
      counter = 0;
    } catch (FileNotFoundException ex) {
      System.out.println("File not found!");
    }
  }

  // Method to walk tree and print three address instructions to file
  public void postOrderWalk(PrintWriter printWriter) {
    left.postOrderWalk(printWriter);
    right.postOrderWalk(printWriter);
    if (this instanceof OperatorNode) {
      this.setName();
    }
    leftValue = left.getName();
    rightValue = right.getName();
    printWriter.println(getOutput(operator) + " " + registerName + " "
        + leftValue + " " + rightValue);
  }

  // Method to walk tree and return infix expression
  public String inOrderWalk() {
    leftValue = left.inOrderWalk();
    rightValue = right.inOrderWalk();
    return "(" + leftValue + " " + operator + " " + rightValue + ")";
  }

  // Method to return proper operation for three address output
  private static String getOutput(String operation) {
    switch (operation) {
      case "+":
          return "Add";
      case "-":
          return "Sub";
      case "*":
          return "Mul";
      case "/":
        return "Div";
    }
    return "Err";
  }
}
