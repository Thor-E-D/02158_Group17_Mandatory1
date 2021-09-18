import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class runner {

    static String datafile;            // Name of data file

    public static void main(String[] argv) {
        int[] taskArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 30, 40, 50, 60};
        int[] threadArray = {1, 2, 4, 6, 8, 10, 12};

        datafile = "datafile.txt";
        int currentTask = 0;

        for (int thread: threadArray) {
            for (int task: taskArray) {
                argv[8] = Integer.toString(task);
                argv[9] = Integer.toString(thread);
                new Search(argv);
            }
            writeData("used " + thread + " threads for the above meassurments");
        }

        for (String hej: argv) {
            System.out.println(hej);
        }

        //Search search = new Search(argv);

    }

    static void writeData(String s) {
        try {
            if (datafile != null) {
                // Append result to data file
                FileWriter f = new FileWriter(datafile, true);
                PrintWriter data = new PrintWriter(new BufferedWriter(f));
                data.println(s.replace(".", ","));
                data.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
