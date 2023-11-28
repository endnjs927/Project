import Structures.*;

public class Cinema {
    private int earnings;

    private Line line1;
    private Line line2;
    private Line linep;
    private Theatre theatre1;
    private Theatre theatre2;

    public Cinema(int t1_width, int t1_height, int t2_width, int t2_height)
    {
        earnings = 0;

        line1 = new Line();
        line2 = new Line();
        linep = new Line();
        theatre1 = new Theatre(t1_width, t1_height);
        theatre2 = new Theatre(t2_width, t2_height);
    }
}
