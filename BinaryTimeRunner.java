
/**
 * Binary Time Method
 * 
 * Takes a file of binary clocks and outputs the time in 24-hour format.
 * 
 * @author Cody King
 * @version 7/20/2016
 */

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class BinaryTimeRunner 
{
    public static void main(String[] args) throws IOException
    {
        String[] clock = new String[4];
        Scanner inFile = new Scanner(new File("data.txt")); //read file
        int index = 0;
        int clocks = 0;
        String tmp = "";
        
        while(inFile.hasNext())
        {
            if(index <= 3)
            {
                clock[index] = inFile.nextLine();  //read line
                index++;
            }
            
            if(index == 4)  //we have reached end of reading first binary clock
            {
                BinaryClock bClock = new BinaryClock(clock);
                bClock.printClock();
                clocks++;
                
                if(clocks < 10)
                {
                    tmp = inFile.nextLine();       
                    index = 0;
                    clock[index] = inFile.nextLine();  //read line
                    index++;
                } 
            }
        }
    }
}


/* Output Tests

Input File:
  0   0   0
  * 0 0 0 *
0 0 * * * *
0 * 0 * 0 0

  0   0   0
  0 0 * 0 0
* * 0 0 0 0
0 0 * * 0 0

  0   0   *
  * 0 0 0 0
0 * 0 * 0 0
0 * 0 * 0 *

  *   0   0
  0 0 0 0 0
0 0 0 * 0 0
* 0 0 0 0 0

  0   *   0
  0 * 0 * 0
* * 0 0 0 0
0 * * * * 0

  0   0   0
  0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 *

  0   0   0
  0 0 * 0 *
* * * * * 0
0 0 * * 0 *

  0   0   0
  * 0 0 0 0
0 * 0 0 0 *
0 0 0 * 0 *

  0   *   0
  0 * 0 0 0
0 * 0 0 0 0
* 0 * * 0 *

  0   *   0
  0 0 0 0 0
* * * 0 0 0
0 * * * 0 0 
  
 
Output:
05:23:26
22:15:00
07:03:09
18:02:00
23:59:50
00:00:01
22:37:25
06:01:03
12:59:01
23:39:00

 */
