/*
* File: DefineGui.java
* Author: Claire Stovall
* Date: January 24, 2018
* Purpose: This class defines the GUI for the postfix expression arithmetic
* expression tree generator.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

// Class to define the GUI, with an inner class to handle button click event
public class DefineGui extends JFrame {

  private static final int WIDTH = 400;
  private static final int HEIGHT = 140;
  private JPanel panel;
  private JPanel inputPanel;
  private JPanel outputPanel;
  private JButton evaluate;
  private Handler handler;
  private JLabel enterExpression;
  private JLabel result;
  private JTextField expressionInput;
  private JTextField resultOutput;

  // Constructor to define the GUI
  public DefineGui() {
    // Customize frame
    super("Tree Address Generator");
    setSize(WIDTH, HEIGHT);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create new base panel and set layout
    panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

    // Create panel for first row and set layout
    inputPanel = new JPanel();
    inputPanel.setLayout(new FlowLayout());

    // Create input and label for first row and add to panels
    enterExpression = new JLabel("Enter Postfix Expression");
    inputPanel.add(enterExpression);
    expressionInput = new JTextField(18);
    inputPanel.add(expressionInput);
    panel.add(inputPanel);

    // Create button, add handler, and add button to panel
    evaluate = new JButton("Construct Tree");
    evaluate.setAlignmentX(Component.CENTER_ALIGNMENT);
    handler = new Handler();
    evaluate.addActionListener(handler);
    panel.add(evaluate);

    // Create panel for bottom row and set layout
    outputPanel = new JPanel();
    outputPanel.setLayout(new FlowLayout());

    // Create output and label for bottom row and add to panels
    result = new JLabel("Infix Expression");
    outputPanel.add(result);
    resultOutput = new JTextField(18);
    resultOutput.setEditable(false);
    outputPanel.add(resultOutput);
    panel.add(outputPanel);

    // Add base panel to frame
    add(panel);
   }

   // Method to make frame visible
   public void display() {
    setVisible(true);
   }

   // Class to handle the Compute button click event for evaluation
   private class Handler implements ActionListener {
     private ExpressionTree output;
     @Override
     public void actionPerformed(ActionEvent e) {
       try {
         output = new ExpressionTree(expressionInput.getText());
         resultOutput.setText(output.getInfix());
       } catch (RuntimeException ex) {
         resultOutput.setText("");
        JOptionPane.showMessageDialog(null, "Invalid token " + ex.getMessage(),
            "Warning", JOptionPane.WARNING_MESSAGE);
       }
     }
   }

  // Main method calling constructor to build and display the GUI
  public static void main(String[] args) {
    DefineGui gui = new DefineGui();
    gui.display();
  }
}
