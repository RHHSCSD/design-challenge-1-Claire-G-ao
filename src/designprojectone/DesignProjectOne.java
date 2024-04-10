/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package designprojectone;
import java.util.*;
import java.text.*;
import javax.swing.JOptionPane;
/***************************************************
*
*  Program: Tech Fair Cost Calculator
*  Author: Claire Gao
*  Date: Mar 7 2024
*  Description: calculating the cost for each student to participate in the science fair
****************************************************/

/**************** IPO CHART ************************
*INPUT:
*the number of students doing the Arduino project 
*the number of students doing the Raspberry PI project
*the number of students doing VR project
* 
*PROCESSING:
*calculate the total material cost
*divide the total cost by the total number of students participating
*
*OUTPUT:
*the cost for each student to participate in the science fair
*
***************************************************/
  
/**************** TEST CASES ************************
*Test      Input      Desired Output
*          15 20 65   $67.50
*          16 21 64   $64.09
*          -1 1  1    Invalid Input
*          0  1  2    $68.33
*          20 20 30   $65.43
*          99 99 99   $61.17
*
***************************************************/
public class DesignProjectOne {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   //Write Pseudocode FIRST as comments and THEN write the code
   Scanner kb = new Scanner (System.in);
   DecimalFormat df = new DecimalFormat ("#.00");
   
  //CONSTANTS
  final double DISCOUNT = 0.05;
  final double FIXED_COST = 50;
  
  //VARIABLES
  int arduinoNum, raspberryNum, VRNum;
  int totalNum;
  double arduinoCost, raspberryCost, VRCost;
  double costPerStudent, totalCost, totalFixedCost;

  //CODE
  //read in the number of students doing each project
  String input1 = JOptionPane.showInputDialog("Enter the number of student doing Arduino Project: ");
  arduinoNum = Integer.parseInt(input1);
  
  String input2 = JOptionPane.showInputDialog("Enter the number of students doing Raspberry PI Project: ");
  raspberryNum = Integer.parseInt(input2);
  
  String input3 = JOptionPane.showInputDialog("Enter the number of students doing VR Project: ");
  VRNum = Integer.parseInt(input3);
  
  //Check if the inputs are valid
  if (arduinoNum < 0 || raspberryNum < 0 || VRNum < 0){
      System.out.println("Invalid Input");
      return;
  }
  //calculate the total number of students 
  totalNum = arduinoNum + raspberryNum + VRNum;
  
  //calculate the fixed cost based on the total number of students 
  if (totalNum > 100){
      totalFixedCost = FIXED_COST * (1 - DISCOUNT) * totalNum;
  }
  else{
      totalFixedCost = FIXED_COST * totalNum;
  }
  
  //calculate the cost for Arduino Project
  if (arduinoNum > 15){
      arduinoCost = arduinoNum * 9.0;
  }
  else{
      arduinoCost = arduinoNum * 10.0;
  }
  
  //calculate the cost for Raspberry PI Project
  if (raspberryNum > 20){
      raspberryCost = raspberryNum * 12.0;
  }
  else{
      raspberryCost = raspberryNum * 15.0;
  }
  
  //calculate the cost for VR Project
  VRCost = VRNum * 20.0;
  
  //calculate the total cost
  totalCost = arduinoCost + raspberryCost + VRCost + totalFixedCost;
  
  //calculate the cost per student
  costPerStudent = totalCost / totalNum;
  
  //output the cost for each student to participate in the science fair
  JOptionPane.showMessageDialog(null, "There are " + totalNum + " students participating in the science fair.");
  int confirmValue = JOptionPane.showConfirmDialog(null, "Do you want to know the price?");
  if (confirmValue == 0){
    JOptionPane.showMessageDialog(null, "Every student has to pay $" + df.format(costPerStudent) + ".");
  }
  
    }
    
}
