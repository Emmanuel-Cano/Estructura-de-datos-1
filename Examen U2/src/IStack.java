public interface IStack<T> {
    void push(T element);
    T pop();
    T peek();
    void clear();
    int size();
    boolean isEmpty();
    void print();
}
