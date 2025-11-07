
public class ArrayStack<T> implements IStack<T> {
    private Object[] data;
    private int top;

    public ArrayStack() { this(10); }
    public ArrayStack(int initialCapacity) {
        data = new Object[initialCapacity];
        top = 0;
    }

    private void ensureCapacity(int need) {
        if (need <= data.length) return;
        Object[] newArr = new Object[Math.max(data.length * 2, need)];
        for (int i = 0; i < top; i++) newArr[i] = data[i];
        data = newArr;
    }

    @Override
    public void push(T element) {
        ensureCapacity(top + 1);
        data[top++] = element;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T pop() {
        if (isEmpty()) return null;
        T value = (T) data[--top];
        data[top] = null;
        return value;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T peek() {
        if (isEmpty()) return null;
        return (T) data[top - 1];
    }

    @Override
    public void clear() {
        data = new Object[10];
        top = 0;
    }

    @Override public int size() { return top; }
    @Override public boolean isEmpty() { return top == 0; }

    @Override
    public void print() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = top - 1; i >= 0; i--) {
            sb.append(data[i]);
            if (i > 0) sb.append(" -> ");
        }
        sb.append("]");
        System.out.println(sb);
    }
}