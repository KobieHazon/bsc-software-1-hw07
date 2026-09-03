package il.ac.tau.cs.software1.bufferedIO;

import java.io.Closeable;
import java.io.IOException;

public interface IBufferedWriter extends Closeable {
    void write(String str) throws IOException;
}
