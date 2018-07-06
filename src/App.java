import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class App {
	public static void main( String[] args ) throws Exception
    {
		BufferedReader br = null;
		StringTree tree = new StringTree();
	
		System.out.println("Do you want to manually input words or upload file?");
		System.out.println("1) Upload File");
		System.out.println("2) Manually Input");
		
		Scanner sc = new Scanner(System.in);
		
		if(sc.nextLine().equals("2"))
		{
			System.out.println("Enter new word");
			tree.addNode(sc.nextLine());
			System.out.println("Do you want to input a new word? (y/n)");
			while(sc.nextLine().equals("y"))
			{
				System.out.println("Enter new word");
				tree.addNode(sc.nextLine());
				System.out.println("Do you want to input a new word? (y/n)");
			}
			tree.printTree();
		}
		else
		{
			System.out.println("Please enter file location and name");
			try
			{
				br = new BufferedReader(new FileReader(sc.nextLine()));
				String line;
			    while ((line = br.readLine()) != null)
			    {
			    	if(!line.isEmpty())
			    		tree.addNode(line);
			    }
				tree.printTree();
			}
			finally
			{
				if(br != null)
					br.close();
			}
		}
    }
}