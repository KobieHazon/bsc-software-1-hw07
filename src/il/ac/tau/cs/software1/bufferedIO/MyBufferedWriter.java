package il.ac.tau.cs.software1.bufferedIO;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class MyBufferedWriter implements IBufferedWriter {
    private final FileWriter fileWriter;
    private final char[] buffer;
    private int position = 0;
    private boolean closed = false;

    public MyBufferedWriter(FileWriter fileWriter, int bufferSize) {
        if (bufferSize <= 0) {
            throw new IllegalArgumentException("bufferSize must be positive");
        }
        this.fileWriter = Objects.requireNonNull(fileWriter, "fileWriter");
        this.buffer = new char[bufferSize];
    }

    @Override
    public void write(String str) throws IOException {
        ensureOpen();
        Objects.requireNonNull(str, "str");
        for (int i = 0; i < str.length(); i++) {
            buffer[position] = str.charAt(i);
            position++;
            if (position == buffer.length) {
                flushBuffer();
            }
        }
    }

    @Override
    public void close() throws IOException {
        if (closed) {
            return;
        }
        try {
            flushBuffer();
        } finally {
            closed = true;
            fileWriter.close();
        }
    }

    private void flushBuffer() throws IOException {
        if (position > 0) {
            fileWriter.write(buffer, 0, position);
            position = 0;
        }
    }

    private void ensureOpen() throws IOException {
        if (closed) {
            throw new IOException("writer is closed");
        }
    }
}
