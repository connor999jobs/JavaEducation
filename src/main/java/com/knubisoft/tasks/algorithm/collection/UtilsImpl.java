package com.knubisoft.tasks.algorithm.collection;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class UtilsImpl implements Utils{
    @Override
    public <K, V> Map<V, K> invertMap(Map<K, V> map) {
        return null;
    }

    @Override
    public <E> List<E> union(List<? extends E> list1, List<? extends E> list2) {
        return null;
    }

    @Override
    public boolean isEqualList(Collection<?> list1, Collection<?> list2) {
        return false;
    }

    @Override
    public <K, V> Map<K, V> synchronizedMap(Map<K, V> map) {
        return null;
    }

    @Override
    public <O> Collection<O> disjunction(Iterable<? extends O> a, Iterable<? extends O> b) {
        return null;
    }

    @Override
    public <O> Collection<O> subtract(Iterable<? extends O> a, Iterable<? extends O> b) {
        return null;
    }

    @Override
    public <E> Comparator<E> chainedComparator(Comparator<E>... comparators) {
        return null;
    }

    @Override
    public boolean isSubCollection(Collection<?> a, Collection<?> b) {
        return false;
    }
}
