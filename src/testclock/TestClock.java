/**
Name: Christopher Showalter
Class: CSc 2310: Introduction to programming
Filename: TestClock.java
Date written: April 25, 2011

Description:
This class represents the clock tester
*/

package TestClock;
import jpb.*;

public class TestClock {

    public static void main(String[] args) {

        //Create clock object
        Clock myClock = new Clock();
        
        //Print introductory message
        System.out.println("Welcome to the clock testing program.");
        
        //Leave a blank line
        System.out.println();
        
        //Explain the commands
        System.out.println("Commands:");
        System.out.println("---------");
        System.out.println("a = advance (increase time by one second)");
        System.out.println("c = calibrate (set to current time)");
        System.out.println("q = quit");
        System.out.println("r = reset (set hours, minutes, "
                + "and second to zero");
        System.out.println("s = set (allow user to set time)");
        System.out.println("t = toggle (switch from 24-hour clock to "
                + "12-hour clock, or vice-versa)");
        
        //Leave a blank line
        System.out.println();
        
        //Display initial time
        System.out.println("The time is now" + myClock);
        
        //Prompt user for a command and test input value
        //for necessary formatting
        while(true) {
            SimpleIO.prompt("Enter command (a, c, q, r, s, or t):");
            String userInput = SimpleIO.readLine();  
            testInput(userInput);

            char command = userInput.charAt(0);
            if (command=='a'){
                myClock.advance();
            }
            else if(command=='c')
            {
                myClock.calibrate();
            }
            else if(command=='q')
            {
                System.exit(0);
            }
            else if(command=='r')
            {
                myClock.reset();
            }
            else if(command=='s')
            {
                myClock.set(readHour(), readMinute(), readSecond());
            }
            else if(command=='t') {
                myClock.toggleClockMode();
            }
            
            //Display time and add two blank lines
            System.out.println(myClock);
            System.out.println();
            System.out.println();
            }   
        }
        
    /////////////////////////////////////////////////////////////////////////
    //Name:         testInput
    //Behavior:     Checks the input given by the user to make sure that 
    //              it is a single character command and that it is in the
    //              correct format
    //
    //Parameters:   input - the input read by the SimpleIO
    //Returns:      Error message if input is incorrect
    //////////////////////////////////////////////////////////////////////// 
    private static void testInput(String input) {
            input = input.trim().toLowerCase();
            if (input.length() > 1){
                System.out.println("Illegal command; please try again");
            }
            try {
                String command = input;
            }
            catch (NumberFormatException e) {
                System.out.println("Illegal comman; please try again");
            }
        }
    
    /////////////////////////////////////////////////////////////////////
    //Name:         readHour
    //Behavior:     Prompts the user to enter the hour and checks
    //              to see that the integer falls into the correct range
    //
    //
    //Parameters:   none
    //Returns:      The hour if within the correct range.
    //              Otherwise, an error message & a prompt to re-enter
    ///////////////////////////////////////////////////////////////////
        private static int readHour () {
            int hour = 0;
            hour = readInt("Enter hours:");
            if (hour < 24){
                return hour;
            }
            else {
                System.out.println("Input must be between 0 and 23;" +
                        "please try again.");
                return readHour ();
            }
        }
    /////////////////////////////////////////////////////////////////////
    //Name:         readMinute
    //Behavior:     Prompts the user to enter the minute and checks
    //              to see that the integer falls into the correct range
    //
    //
    //Parameters:   none
    //Returns:      The minute if within the correct range.
    //              Otherwise, an error message & a prompt to re-enter
    ///////////////////////////////////////////////////////////////////
        private static int readMinute () {
            int minute = 0;
            minute = readInt("Enter minutes:");
            if (minute < 60){
                return minute;
            }
            else {
                System.out.println("Input must be between 0 and 59;" +
                        "please try again.");
                return readMinute ();
            }
        }
    /////////////////////////////////////////////////////////////////////
    //Name:         readSecond
    //Behavior:     Prompts the user to enter the second and checks
    //              to see that the integer falls into the correct range
    //
    //
    //Parameters:   none
    //Returns:      The second if within the correct range.
    //              Otherwise, an error message & a prompt to re-enter
    ///////////////////////////////////////////////////////////////////
        private static int readSecond () {
            int second = 0;
            second = readInt("Enter seconds:");
            if (second < 60){
                return second;
            }
            else {
                System.out.println("Input must be between 0 and 59;" +
                        "please try again.");
                return readSecond ();
            }
        }


    /////////////////////////////////////////////////////////////////////
    //Name:         readInt
    //Behavior:     Prompts the user to enter a number, reads the user's  
    //              input, checks to see if it is proper type, and  
    //              converts it to Integer form
    //
    //Parameters:   prompt - the prompt to be displayed   
    //Returns:      User's input as Integer if correct.
    //              Otherwise, error message & prompt to re-enter
    /////////////////////////////////////////////////////////////////////
    private static int readInt (String prompt) {
        while (true) {
            SimpleIO.prompt(prompt);
            String userInput = SimpleIO.readLine();
            try {
              return Integer.parseInt(userInput);
            } catch (NumberFormatException e)   {
              System.out.println("Not an integer; try again.");
            }
        }
    }
}