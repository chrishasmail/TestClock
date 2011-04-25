/**
Name: Christopher Showalter
Class: CSc 2310: Introduction to programming
Filename: TestClock.java
Date written: April 25, 2011

Description:
This class represents the clock
*/

package TestClock;
import java.util.*;

public class Clock {
    
    //Initializing values 
    int sec = 00; int min = 00; int hr = 00;
    boolean militaryTime = true;

    public Clock(int hours, int minutes, int sec){
        this.hr= hours;
        this.min = minutes;
        this.sec = sec;
    }
    
    public Clock(int hours, int minutes){
        this.hr= hours;
        this.min=minutes;
    }
    
    public Clock(int hours){
        this.hr = hours;
    }

    public Clock(){    
    }

    //This advances the clock forward one second
    public void advance() {
        sec += 1;
        if (sec > 59){
            min += 1;
            sec = 0;
        }
        if (min > 59){
            hr += 1;
            min = 0;
        }
        if (hr > 23) {
            hr = 0;
        }
    }

    //Found this code to get the time of day from Example Dept
    //and incorporated it into my code.
    //URL: http://www.exampledepot.com/egs/java.util/GetCurTime.html
    //
    //
    //This code sets the time according to the current time     
    public void calibrate() {      
        Calendar cal = new GregorianCalendar();
        hr = cal.get(Calendar.HOUR_OF_DAY);     
        min = cal.get(Calendar.MINUTE);           
        sec = cal.get(Calendar.SECOND);             
    }
       
    //Resets the time to 00:00:00
    public void reset() {
        hr = 0;
        min = 0;
        sec = 0;        
    }
   
    //Sets the time to a set of values given by the user
    public void set(int hours, int minutes, int seconds) {
        this.hr = hours;
        this.min = minutes;
        this.sec = seconds;
    }
     
    //Switches between military time and normal time
    public void toggleClockMode() {
        militaryTime = !militaryTime;          
    }
       
    // Returns time as a string
    // If the 24-hour clock is in effect, the string has the form
    //   "hh:mm:ss"
    // If the 12-hour clock is in effect, the string has the form
    //   "hh:mm:ss a.m." or "hh:mm:ss p.m."
    @Override
    public String toString() {
        if (militaryTime) {
            String Time = formatDigits(hr) + ":" +
                           formatDigits(min) + ":" +
                           formatDigits(sec);
            return "The time is now " + Time;           
            
        }
        else {
            int otherHours = hr;
            String amOrPm = null;
            if (otherHours > 12){
                otherHours -= 12;
                amOrPm = "P.M.";
            }
            else if (otherHours < 12) {
                amOrPm = "A.M.";    
            }
            String Time = formatDigits(otherHours) + ":" +
                          formatDigits(min) + ":" +
                          formatDigits(sec) + " " + amOrPm;
            return "The time is now " + Time;
        }
       
    }

    /////////////////////////////////////////////////////////////////////
    //Name:         formatDigits
    //Behavior:     Checks the value of the time to see whether it is a 
    //              single digit and if so adds a zero in front of that
    //              digit
    //
    //Parameters:   digit - the value for the time (hours, minutes, 
    //              or seconds)
    //Returns:      The time in the two character space format
    /////////////////////////////////////////////////////////////////////
    private static String formatDigits(int digit) {
        return (digit <= 9) ? (0+convertInt(digit)): (convertInt(digit)); 
    }
   
    ///////////////////////////////////////////////////////////////////////
    //Name:         convertInt
    //Behavior:     Converts int value to string value
    //
    //Parameters:   Value - the integer number 
    //Returns:      The integer value as a string
    /////////////////////////////////////////////////////////////////////
    private static String convertInt(int value) {
        String newValue = Integer.toString(value);
        return newValue;
        
    }
}