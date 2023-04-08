package q1;

public class ConversionStringToNumber 
{
  public static void main(String[] args)
  {
	  Demo d =  Integer::parseInt;
		System.out.println(d.convetStringToNumber("10") + 1);
//		System.out.println(d.convetStringToNumber("A") + 1);
		
  }
}
