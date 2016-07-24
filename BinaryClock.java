
/**
 * BinaryClock class.
 * 
 * @author Cody King
 * @version 7/20/2016
 */

public class BinaryClock
{
    private String[] clock = new String[4];
    
    public BinaryClock(String[] clock)
    {
        this.clock = clock;
    }
    
    public String getEntry(int row, int index)
    {
        return clock[row].substring(index, index + 1);
    }
    
    public void printClock()
    {
        System.out.println(getHour() + ":" + getMins() + ":" + getSecs());
    }
    
    public String getHour()
    {
        int tens = 0;
        int units = 0;
        int exp = 0;
        
        for(int i = 3; i >= 2; i--)  //tens
        {
            if(getEntry(i, 0).equals("*"))
                tens += Math.pow(2, exp);
            
            exp++; 
        }
        
        exp = 0;
        
        for(int i = 3; i >= 0; i--)  //units
        {
            if(getEntry(i, 2).equals("*"))
                units += Math.pow(2, exp);
            
            exp++;
        }
        
        return Integer.toString(tens) + Integer.toString(units);
    }
    
    public String getMins()
    {
        int tens = 0;
        int units = 0;
        int exp = 0;
        
        for(int i = 3; i >= 1; i--)  //tens
        {
            if(getEntry(i, 4).equals("*"))
                tens += Math.pow(2, exp);
            
            exp++; 
        }
        
        exp = 0;
        
        for(int i = 3; i >= 0; i--)  //units
        {
            if(getEntry(i, 6).equals("*"))
                units += Math.pow(2, exp);
            
            exp++;
        }
        
        return Integer.toString(tens) + Integer.toString(units);
    }
    
    public String getSecs()
    {
        int tenths = 0;
        int hunds = 0;
        int exp = 0;
        
        for(int i = 3; i >= 1; i--)  //tenths
        {
            if(getEntry(i, 8).equals("*"))
                tenths += Math.pow(2, exp);
            
            exp++; 
        }
        
        exp = 0;
        
        for(int i = 3; i >= 0; i--)  //hundredths
        {
            if(getEntry(i, 10).equals("*"))
                hunds += Math.pow(2, exp);
         
            exp++;
        }
        
        return Integer.toString(tenths) + Integer.toString(hunds);
    }
}
