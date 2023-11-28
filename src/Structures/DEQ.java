package Structures;
public class DEQ<T> extends Queue<T> implements ExtendedQueueInterface<T>
{
    public void enqueueFront(T item)
    {
        if(numItems == items.length) {
            resize();
        }

        front = (front + items.length -1) % items.length;
        items[front] = item;
        numItems++;
    }

    public T peekBack()
    {
        if(numItems == 0) {
            throw new ExtendedQueueException("ExtendedQueueException on peekBack.");
        }

        return items[(back + items.length - 1) % items.length];
    }

    public T dequeueBack()
    {
        if(numItems == 0) {
            throw new ExtendedQueueException("ExtendedQueueException on dequeueBack.");
        }

        back = (back + items.length - 1) % items.length;
        T result = items[back];
        items[back] = null;
        numItems--;

        return result;
    }
}
