package bambooSwords;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int numThreads = 1;
        int timePerRow = 1;
        
        Map<Double, String> map = new HashMap<>();
        
        
        for(int i = 1 ; i < 31 ; i++){
            for(int j = 8 ; j < 16 ; j++ ){
                double rate = 480 * i / j;

                map.put(rate, "Threads : " + i + " timePerRow : " + j );
            }
        }
        
        map.entrySet().stream().forEach(es -> System.out.println(es));
        
    }
}
