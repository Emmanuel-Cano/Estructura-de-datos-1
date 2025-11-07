public class ArrayQueue<T> implements IQueue<T> {
    private Object[] data;
    private int rear;
    private int front;
    private int size;
    private static final int INITIAL_CAPACITY = 10;

    public ArrayQueue() {
        data = new Object[INITIAL_CAPACITY];
        rear = 0;
        front = 0;
        size = 0;
    }

    @Override
    public void offer(T element) {
        if (size == data.length) expandCapacity();
        data[rear] = element;
        rear = (rear + 1) % data.length;
        size++;
    }

    // Inserción al frente (para ROLLBACK)
    public void offerFront(T element) {
        if (size == data.length) expandCapacity();
        front = (front - 1 + data.length) % data.length;
        data[front] = element;
        size++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T poll() {
        if (isEmpty()) return null;
        T result = (T) data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T peek() {
        if (isEmpty()) return null;
        return (T) data[front];
    }

    private void expandCapacity() {
        Object[] newArr = new Object[data.length * 2];
        for (int i = 0; i < size; i++) {
            newArr[i] = data[(front + i) % data.length];
        }
        data = newArr;
        front = 0;
        rear = size;
    }

    @Override
    public void clear() {
        data = new Object[INITIAL_CAPACITY];
        front = 0;
        rear = 0;
        size = 0;
    }

    @Override
    public void print() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[(front + i) % data.length]);
            if (i < size - 1) sb.append(" -> ");
        }
        sb.append("]");
        System.out.println(sb);
    }

    @Override public boolean isEmpty() { return size == 0; }
    @Override public int getSize() { return size; }
}