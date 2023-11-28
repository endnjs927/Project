import Structures.*;

public class Theatre {
    private int size;
    private int width;
    private int height;

    private List<String> seats;
    private List<Customer> locations;
    private Stack<Integer> remaining;

    public Theatre(int width, int height)
    {
        this.width = width;
        this.height = height;
        size = width * height;

        seats = new List<>();
        locations = new List<>();
        remaining = new Stack<>();

        // populate seats with empty
    }
}
