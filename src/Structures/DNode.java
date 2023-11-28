package Structures;
public class DNode<T>
{
    private T item;
    private DNode next;
    private DNode back;

    public DNode(T item)
    {
        this.item = item;
        next = this;
        back = this;
    }

    public DNode(T item, DNode next, DNode back)
    {
        this.item = item;
        this.next = next;
        this.back = back;
    }

    public T getItem()
    {
        return item;
    }

    public void setItem(T item)
    {
        this.item = item;
    }

    public DNode getNext()
    {
        return next;
    }

    public void setNext(DNode next)
    {
        this.next = next;
    }

    public DNode getBack()
    {
        return back;
    }

    public void setBack(DNode back)
    {
        this.back = back;
    }
}
