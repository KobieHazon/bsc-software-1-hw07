package il.ac.tau.cs.software1.bufferedIO;

import java.io.FileWriter;
import java.io.IOException;


/**************************************
 *  Add your code to this class !!!   *
 **************************************/

public class MyBufferedWriter implements IBufferedWriter{
	
	private FileWriter fWriter;
	private char[] buffer;
	
	public MyBufferedWriter(FileWriter fWriter, int bufferSize){
		this.fWriter = fWriter;
		this.buffer = new char[bufferSize];
	}

	
	@Override
	public void write(String str) throws IOException {
		if (buffer.length == 0) {
			return;
		}
		int writeCnt = 0;
		int n = str.length();
		for (int i = 0; i < Math.ceil((double)n/buffer.length); i++) {
			buffer = new char[buffer.length];
			for (int j = 0; j < 10 && (writeCnt*buffer.length + j) < n; j++) {
				buffer[j] = str.charAt(writeCnt*buffer.length + j);
			}
			fWriter.write(buffer);
			writeCnt++;
		}
	}
	
	@Override
	public void close() throws IOException {
		String notWritten = new String(buffer);
		if (notWritten == "") {
			write(notWritten);
		}
		fWriter.close();
	}

}