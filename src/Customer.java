import Structures.*;

public class Customer 
{
    private int size;
    private String name;
    
    private List<Integer> positions;

    public Customer(int size, String name)
    {
        this.size = size;
        this.name = name;
        positions = new List<>();
    }
}
