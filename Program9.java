/*
Zava
CS2050
05/05/2024
 */

/*
Reqs:
1) Create a HashMap with default constructor.  The student ID will be the key, and the value  will be the entire Student object.

2) Determine the load factor after all the students are loaded into the hashmap.

3) Do steps 1-4 again but this time with initial capacity of 1,000 and load factor of 0.75

4) Do steps 1-4 a third time with initial capacity of 5,000 and load factor of 0.75

5) Submit Program9.java and results.txt in a .zip file.
 */
/*
Steps:

Create Hashmap using default constructor using Stu ID as key and value being the entire Stu obj
Read file and insert into hashmap with values Stu ID and Name
Get load factor
Make another except with cap of 1k and override load factor of .75
^ except cap of 5k and override load factor of .75
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;


public class Program9 {
    public static void main(String[] args) {
        HashMap<Integer, String> stuData = new HashMap<>(1000, 0.75f);
        HashMap<Integer, String> stuData2 = new HashMap<>(5000, 0.75f);
        String line;

        try {
            BufferedReader br = new BufferedReader(new FileReader("students.txt"));
            while ((line = br.readLine()) != null) {
                String[] curr = line.split("\\s+");
                stuData.put(Integer.valueOf(curr[1]), curr[0]);
                stuData2.put(Integer.valueOf(curr[1]), curr[0]);
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.print("Unable to read/write files");
        }
        double a = (double) stuData.size() /1000;
        double b = (double) stuData2.size() /5000;

        try {
            FileWriter fw = new FileWriter("results.txt");
            fw.write("Zava\nCS2050\n\n");
            fw.write("Default class of HashMap has a load factor of .75\n");
            fw.write("Load factor for HashMap with capacity of 1000 is: " + a + "\n");
            fw.write("Load factor for HashMap with capacity of 1000 is: " + b + "\n");

            fw.close();
        }
        catch(IOException e) {
            System.out.println("Trouble trying to write to file");
            e.printStackTrace();
        }

    }

}
