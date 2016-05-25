// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    List<Integer> list = new ArrayList<Integer>();
    int cnt = 0;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (cnt < list.size()) {
            return list.get(cnt);
        }
        return null;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (cnt < list.size()) {
            return list.get(cnt++);
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        return cnt < list.size();
    }
}