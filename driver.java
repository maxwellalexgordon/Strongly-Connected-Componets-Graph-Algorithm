import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class driver {

	public static void main(String[] args) throws FileNotFoundException {
		// pass the path to the file as a parameter
		File file = new File("C:/Users/maxwe/Documents/Senior/Data/HW5/figure22_6.txt");
		Scanner sc = new Scanner(file);

		// read first line
		int numVertex = sc.nextInt();
		System.out.println("Size: " + numVertex);
		sc.nextLine(); //get rid of blank line
		graph G = new graph(numVertex);

		// read rest of lines
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			System.out.println(line);
			String[] line_split = line.split("");
			int temp = Integer.parseInt(line_split[0]);
			int temp2 = Integer.parseInt(line_split[2]);
			G.addEdge(temp, temp2);
		}
		
		G.fullConstrained();
		
		
		
		

	}
}
