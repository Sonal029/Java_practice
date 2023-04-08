package Question1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AddingMobileNo 
{
	public static void main(String[] args) throws IOException {
		 File file = new File("abc.txt");
		   if(!file.exists())
		   {
			   System.out.println("File doesnot exist");
			   return;
		   }
		   
		   BufferedReader br = new BufferedReader(new FileReader("abc.txt"));
           FileWriter fw2 = new FileWriter("filtered_numbers.txt");
           String line = br.readLine();
           while (line != null) 
           {
		      	  if (line.matches("[9|8|7|6]\\d{9}"))
		      	  {
		      		  fw2.write(line + "\n");
		      	  }
           }
           br.close();
           fw2.close();
           
           System.out.println("Contents of abc.txt:");
           br = new BufferedReader(new FileReader("abc.txt"));
           while ((line = br.readLine()) != null) {
               System.out.println(line);
           }
           br.close();

           System.out.println("\nContents of filtered_numbers.txt:");
           br = new BufferedReader(new FileReader("filtered_numbers.txt"));
           while ((line = br.readLine()) != null) {
               System.out.println(line);
           }
           br.close();

       } 	   
	}
  
