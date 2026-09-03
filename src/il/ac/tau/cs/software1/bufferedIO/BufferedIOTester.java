package il.ac.tau.cs.software1.bufferedIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedIOTester {
    public static final String RESOURCES_FOLDER = "resources/hw7/out/";

    public static void main(String[] args) throws IOException {
        File outputFile = new File(RESOURCES_FOLDER + "buffered_writer_out.txt");
        File parent = outputFile.getParentFile();
        if (parent != null) {
            parent.mkdirs();
        }

        String outString1 = "A small buffered writer test starts here.\n";
        String outString2 = "It writes several parts";
        String outString3 = " and flushes the final partial buffer.\n";

        FileWriter fileWriter = new FileWriter(outputFile);
        IBufferedWriter bufferedWriter = new MyBufferedWriter(fileWriter, 10);
        bufferedWriter.write(outString1);
        bufferedWriter.write(outString2);
        bufferedWriter.write(outString3);
        bufferedWriter.close();
    }
}
