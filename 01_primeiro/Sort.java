import java.util.ArrayList;
import java.util.Arrays;

public class Sort<T> {
    public T[] sortCrescending(T[] array) throws Exception {
        Arrays.sort(array);
        return array;
    }

    public T[] sortDescrescending(T[] array) throws Exception {
        ArrayList<T> inv = new ArrayList<>(array.length);
        sortCrescending(array);
        //array.length - 1 pra pegar o último elemento (mas você já sabia disso)
        for (int i = (array.length - 1); i >= 0; i--) {
            inv.add(array[i]);
        }
        return (T[]) inv.toArray(array);
    }
}
