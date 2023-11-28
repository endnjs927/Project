package Structures;
import java.util.*;

public class List<T> implements ListInterface<T>
{
    private DNode<T> head;
    private int numItems;

    public List()
    {
        head = null;
        numItems = 0;
    }

    public boolean isEmpty()
    {
        return numItems == 0;
    }

    public int size()
    {
        return numItems;
    }

    public void removeAll()
    {
        head = null;
        numItems = 0;
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
        DNode<T> curr = head;

        for(int i = 0; i < numItems; i++) {
            result.append(curr.getItem()+" ");
            curr = curr.getNext();
        }

        return result.toString();
    }

    private DNode<T> find(int index)
    {
        DNode<T> result = head;
        index = index % numItems;

        if(index <= numItems / 2) {
            for(int i = 0; i < index; i++) {
                result = result.getNext();
            }
        } else {
            for(int i = 0; i < numItems - index; i++) {
                result = result.getBack();
            }
        }

        return result;
    }

    public T get(int index) throws ListIndexOutOfBoundsException
    {
        if(index < 0 || index >= numItems) {
            throw new ListIndexOutOfBoundsException("List index out of bounds exception on get");
        }

        return find(index).getItem();
    }

    public void add(int index, T item)
    {
        if(index < 0 || index > numItems) {
            throw new ListIndexOutOfBoundsException("List index out of bounds exception on add");
        }

        if(numItems == 0) {
            DNode newNode = new DNode(item);
            head = newNode;
        } else {
            DNode curr = find(index);
            DNode prev = curr.getBack();
            DNode newNode = new DNode(item, curr, prev);

            prev.setNext(newNode);
            curr.setBack(newNode);

            if(index == 0) {
                head = newNode;
            }
        }

        numItems++;
    }

    public T remove(int index)
    {
        if(index < 0 || index >= numItems) {
            throw new ListIndexOutOfBoundsException("List index out of bounds exception on remove");
        }

        DNode<T> curr = find(index);
        T result = curr.getItem();

        if(numItems == 1) {
            head = null;
        } else {
            DNode prev = curr.getBack();
            DNode next = curr.getNext();

            prev.setNext(next);
            next.setBack(prev);

            if(index == 0) {
                head = next;
            }
        }

        numItems--;

        return result;
    }
}
