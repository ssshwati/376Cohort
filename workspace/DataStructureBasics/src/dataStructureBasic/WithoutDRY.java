package dataStructureBasic;

public class WithoutDRY {
    
    public void CSE()
    {
        System.out.println("This is computer science");
    }
  
    public void college()
    {
        System.out.println("Wiley-India");
    }
   
    public void ECE()
    {
        System.out.println("This is electronics");
    }
  
  
    public void college1()
    {
        System.out.println("Wiley-India");
    }
   
    public void IT()
    {
        System.out.println(
            "This is Information Technology");
    }
  
  
    public void college2()
    {
        System.out.println("Wiley-India");
    }
  
   
    public static void main(String[] args)
    {
  
        // Creating object of class in main() method
    	WithoutDRY s = new WithoutDRY();
  
        // Calling above methods one by one
        // as created above
        s.CSE();
        s.college();
        s.ECE();
        s.college1();
        s.IT();
        s.college2();
    }
}