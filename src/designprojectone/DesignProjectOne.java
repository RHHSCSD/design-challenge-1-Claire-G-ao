/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package designprojectone;
import java.util.*;
/***************************************************
*
*  Program: Tech Fair Cost Calculator
*  Author: Claire Gao
*  Date: Mar 7 2024
*  Description: calculating the cost for each student to participate in the science fair
****************************************************/

/**************** IPO CHART ************************
*INPUT:
*the number of students completing the Arduino project 
*the number of students doing the Raspberry PI project
* the number of students doing VR project
* 
*PROCESSING:
*calculate the total material cost
*divide the total cost by the total number of students participating
*
*OUTPUT:
*the cost for each student to participate in the Science fair
*
***************************************************/
  
/**************** TEST CASES ************************
*Test      Input      Desired Ouput
*          15 20 65   $67.5
*          16 21 64   $64.09
*          -1 1  1    Invalid input
*
*
*
*
*
***************************************************/
public class DesignProjectOne {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   //Write Pseudocode FIRST as comments and THEN write the code
   Scanner kb = new Scanner (System.in);
   
  //CONSTANTS
  final double DISCOUNT = 0.05;
  final double FIXED_COST = 50;
  
  //VARIABLES
  int ArduinoNum, RaspberryNum, VRNum;
  int totalNum;
  double ArduinoCost, RaspberryCost, VRCost;
  double costPerStudent, totalCost, totalFixedCost;

  //CODE
  //read in the number of students doing each project
  System.out.print("Enter the number of student doing Arduino Project: ");
  ArduinoNum = kb.nextInt();
  System.out.print("Enter the number of students doing Raspberry PI Project: ");
  RaspberryNum = kb.nextInt();
  System.out.print("Enter the number of students doing VR Project: ");
  VRNum = kb.nextInt();
  
  //Check if the inputs are valid
  if (ArduinoNum < 0 || RaspberryNum < 0 || VRNum < 0){
      System.out.println("Invalid Input");
      return;
  }
  //calculate the total number of students 
  totalNum = ArduinoNum + RaspberryNum + VRNum;
  
  //calculate the fixed cost based on the total number of students 
  if (totalNum > 100){
      totalFixedCost = FIXED_COST * (1 - DISCOUNT) * totalNum;
  }
  else{
      totalFixedCost = FIXED_COST * totalNum;
  }
  
  //calculate the cost for Arduino Project
  if (ArduinoNum > 15){
      ArduinoCost = ArduinoNum * 9.0;
  }
  else{
      ArduinoCost = ArduinoNum * 10.0;
  }
  
  //calculate the cost for Raspberry PI Project
  if (RaspberryNum > 20){
      RaspberryCost = RaspberryNum * 12.0;
  }
  else{
      RaspberryCost = RaspberryNum * 15.0;
  }
  
  //calculate the cost for VR Project
  VRCost = VRNum * 20.0;
  
  //calculate the total cost
  totalCost = ArduinoCost + RaspberryCost + VRCost + totalFixedCost;
  
  //calculate the cost per student
  costPerStudent = totalCost / totalNum;
  
  //output the cost for each student to participate in the science fair
  System.out.println("There are " + totalNum + " students participating in the science fair.");
  System.out.println("Cost per student is $" + costPerStudent);
  
    }
    
}
