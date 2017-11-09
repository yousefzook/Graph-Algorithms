package BellmanFordAlgorithm;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {

	private FileWriter saveFile;

	public WriteToFile() {
		try {
			saveFile = new FileWriter("src/" + "outputFile" + ".txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeToFile(String firstLine, String secondLine) {
		try {
			saveFile.write(firstLine + System.getProperty("line.separator")
					+ secondLine);
			saveFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
