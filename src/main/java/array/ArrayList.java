package array;

/**
 * 动态数组实现
 *
 * @author xiaoxin
 * @date 2019/8/27
 */
public class ArrayList<E> {

    /**
     * 元素的数量
     */
    private int size;

    /**
     * 所有的元素
     */
    private Object[] elementData;

    /**
     *
     */
    private static final Object[] EMPTY_ELEMENT_DATA = {};

    /**
     * 默认初始容量
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 元素没有找到标记
     */
    private static final int NOT_FOUNT_ELEMENT = -1;

    /**
     * 创建一个空的集合
     */
    public ArrayList() {
        this.elementData = EMPTY_ELEMENT_DATA;
    }

    /**
     * 创建一个指定容量的集合
     *
     * @param initialCapacity
     * @throws IllegalArgumentException 如果初始容量为负数
     */
    public ArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENT_DATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    /**
     * 指定位置获取元素
     * @param index 指定位置
     * @return 指定位置的元素
     * @throws IndexOutOfBoundsException
     */
    public E get(int index) {
        rangeCheck(index);
        return (E) this.elementData[index];
    }

    /**
     * 将指定的元素添加到集合尾部
     * @param e
     * @throws IndexOutOfBoundsException
     */
    public void add(E e) {
        add(size, e);
    }

    /**
     * 将指定的元素添加到指定的位置
     * @param index
     * @param e
     * @throws IndexOutOfBoundsException
     */
    public void add(int index, E e) {
        rangeCheckForAdd(index);
        ensureCapacity(size + 1);
        for (int i = size - 1; i >= index; i--)
            elementData[i + 1] = elementData[i];
        elementData[index] = e;
        size++;
    }

    /**
     * 扩容
     * @param capacity
     */
    private void ensureCapacity(int capacity) {
        int oldCapacity = this.elementData.length;
        if (oldCapacity > capacity) return;
        int newCapacity = 0;
        if (oldCapacity < DEFAULT_CAPACITY) {
            newCapacity = DEFAULT_CAPACITY;
        } else {
            newCapacity = oldCapacity + (oldCapacity >> 1);
        }
        Object[] newElementData = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElementData[i] = this.elementData[i];
        }
        this.elementData = newElementData;

    }

    /**
     * 修改指定位置的元素
     *
     * @param index
     * @param e
     * @return
     */
    public E set(int index, E e) {
        rangeCheck(index);
        E old = (E) elementData[index];
        this.elementData[index] = e;
        return old;
    }

    /**
     * 删除指定位置的元素
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        rangeCheck(index);
        E removeElement = (E) this.elementData[index];
        for (int i = index; i < size; i++) {
            elementData[i] = elementData[i + 1];
        }
        this.elementData[--size] = null;
        return removeElement;
    }

    /**
     * @param e 查找的元素
     * @return
     */
    public int indexOf(E e) {
        if (e == null) {
            for (int i = 0; i < size; i++) if (elementData[i]==null) return i;
        }else {
            for (int i = 0; i < size; i++) if (e.equals(elementData[i])) return i;
        }
        return NOT_FOUNT_ELEMENT;
    }

    /**
     * 添加时范围检查
     *
     * @param index
     */
    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0) throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    /**
     * 范围检查
     *
     * @param index
     */
    private void rangeCheck(int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + this.size;
    }

    /**
     * 返回元素的数量
     *
     * @return 元素的数量
     */
    public int size() {
        return size;
    }

    /**
     * @return 集合是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 是否包含某个元素
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return indexOf(e) != NOT_FOUNT_ELEMENT;
    }

    /**
     * 清空集合中的所有元素
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            this.elementData[i] = null;
        }
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("Array(size = %s , length = %s , elementData = ", size, this.elementData.length));
        for (int i = 0; i < size; i++) {
            if (size - 1 != i) {
                sb.append(this.elementData[i]).append(" , ");
            } else {
                sb.append(this.elementData[i]);
            }
        }
        return sb.append(")").toString();
    }
}
