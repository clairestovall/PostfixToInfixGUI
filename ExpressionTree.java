/*
* File: ExpressionTree.java
* Author: Claire Stovall
* Date: January 31, 2018
* Purpose: This class builds the expression tree and calls the methods to walk
* the tree.
*/

import java.util.*;

public class ExpressionTree {
  private StringTokenizer tokenizer;
  private String token;
  private Stack<Node> stack;
  private Node root;

  // Method to build tree
  public ExpressionTree(String expression) {
    stack = new Stack<Node>();
    expression = expression.replaceAll("", " ");
    tokenizer = new StringTokenizer(expression, " ", false);
    while (tokenizer.hasMoreTokens()) {
      token = tokenizer.nextToken().trim();
      if (token.matches("[0-9]")) {
        stack.push(new OperandNode(Integer.parseInt(token)));
      } else if (token.matches("[*/+-]")) {
        stack.push(new OperatorNode(token, stack.pop(), stack.pop()));
      } else {
        throw new RuntimeException(token);
      }
    }
    root = stack.pop();
  }

  // Method to call methods to walk tree and create outputs
  public String getInfix() {
    root.printOutput();
    return root.inOrderWalk();
  }
}
