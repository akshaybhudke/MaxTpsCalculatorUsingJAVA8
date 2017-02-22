package simple.cr.code;


import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CalculateMaxTps {

    public static void main(String[] args) {
    String line;

    try {
        FileReader input = new FileReader("20-02_get.txt");

        BufferedReader bufRead = new BufferedReader(input);

        //String line1; // String that holds current file line
        int count = 0; // Line number of count

        // Read first line
        line = bufRead.readLine();
        count++;
       String currentLine=line;
        String nextLine=bufRead.readLine();
        Map<String,Integer> stringIntegerMap = new LinkedHashMap<String, Integer>();
       // Map<String,String> stringIntegerMap = new LinkedHashMap<String, String>();
        // Read through file one line at time. Print line # and line
        while (line != null){
            if (currentLine==null){
                System.out.println("File processing Done");
                break;
            }else if (currentLine.equals(nextLine)) {
                count++;
                currentLine = nextLine;
                nextLine = bufRead.readLine();
                stringIntegerMap.put(currentLine,count);
            }else{
                stringIntegerMap.put(currentLine,count);
                currentLine=nextLine;
                nextLine=bufRead.readLine();

                count=1;



            }

        }


        Set obEntrySet = stringIntegerMap.entrySet();
        System.out.println("Set of entries : " + obEntrySet);

        bufRead.close();


        //Map<String,String> stringStringMap = new HashMap<>();
        Map<String, Integer> newMapSortedByValue = stringIntegerMap.entrySet().stream()
                .sorted(Map.Entry.<String,Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));


        Set obEntrySetaftersort = newMapSortedByValue.entrySet();
        System.out.println("Set of entries : " + obEntrySetaftersort);

    }catch (ArrayIndexOutOfBoundsException e){
        System.out.println("Usage: java ReadFile filename\n");

    }catch (IOException e){
        // If another exception is generated, print a stack trace
        e.printStackTrace();
    }

}
    }
