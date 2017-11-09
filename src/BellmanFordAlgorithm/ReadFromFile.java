package BellmanFordAlgorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.SplitPaneUI;

public class ReadFromFile {
	private BufferedReader readFile;
	private JFileChooser chooser;
	private int verticesNumber;

	public ReadFromFile() {
		chooser = new JFileChooser();
	}

	public int[][] readFile() {
		File file = chooseReadFile();
		String url = null;
		int[][] graph = null;
		if (file != null) {
			url = file.getAbsolutePath();
			while (!url.substring(url.length() - 4).equals(".txt")) {
				System.out.println("Error! choose only \".txt\" files");
				url = chooseReadFile().getAbsolutePath();
			}
			try {
				readFile = new BufferedReader(new FileReader(url));
				String line = readFile.readLine();
				String[] splittedLine = line.split(" ");
				verticesNumber = Integer.parseInt(splittedLine[0]);
				graph = new int[Integer.parseInt(splittedLine[1])][3];
				int i = 0;
				line = readFile.readLine();
				while (line != null) {
					splittedLine = line.split(" ");
					graph[i][0] = Integer.parseInt(splittedLine[0]);
					graph[i][1] = Integer.parseInt(splittedLine[1]);
					graph[i][2] = Integer.parseInt(splittedLine[2]);
					i++;
					line = readFile.readLine();
				}
				readFile.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return graph;
	}

	public File chooseReadFile() {
		FileNameExtensionFilter txtFilter = new FileNameExtensionFilter(
				"tesxt files (*.txt)", "txt");
		chooser.addChoosableFileFilter(txtFilter);
		chooser.setFileFilter(txtFilter);
		chooser.setSelectedFile(new File("Untitled.txt"));
		int buttonChoosed = chooser.showSaveDialog(null);
		if (buttonChoosed == JFileChooser.CANCEL_OPTION)
			System.exit(0);
		File file = chooser.getSelectedFile();
		return file;
	}

	public int getVerticesNumber() {
		return verticesNumber;
	}

}
