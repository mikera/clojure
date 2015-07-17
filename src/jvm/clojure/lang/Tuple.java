/**
 *   Copyright (c) Rich Hickey. All rights reserved.
 *   The use and distribution terms for this software are covered by the
 *   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
 *   which can be found in the file epl-v10.html at the root of this distribution.
 *   By using this software in any fashion, you are agreeing to be bound by
 *       the terms of this license.
 *   You must not remove this notice, or any other, from this software.
 **/

// this file is generated by https://github.com/ztellman/cambrian-collections
// do not directly modify

package clojure.lang;

import java.util.Iterator;
import java.util.RandomAccess;

public class Tuple {
    static final int MAX_SIZE = 6;
    public static IPersistentVector EMPTY = new T0();

    public static IPersistentVector create() {
	return EMPTY;
    }

    public static T1 create(Object e0) {
	return new T1(e0);
    }

    public static T2 create(Object e0, Object e1) {
	return new T2(e0, e1);
    }

    public static T3 create(Object e0, Object e1, Object e2) {
	return new T3(e0, e1, e2);
    }

    public static T4 create(Object e0, Object e1, Object e2,
	    Object e3) {
	return new T4(e0, e1, e2, e3);
    }

    public static T5 create(Object e0, Object e1, Object e2,
	    Object e3, Object e4) {
	return new T5(e0, e1, e2, e3, e4);
    }

    public static T6 create(Object e0, Object e1, Object e2,
	    Object e3, Object e4, Object e5) {
	return new T6(e0, e1, e2, e3, e4, e5);
    }
    
    public static IPersistentVector createFromColl(Object coll){
        if(coll instanceof RandomAccess) {
            switch(RT.count(coll)){
                case 0:
                    return EMPTY;
                case 1:
                    return create(RT.nth(coll, 0));
                case 2:
                    return create(RT.nth(coll,0), RT.nth(coll,1));
                case 3:
                    return create(RT.nth(coll,0), RT.nth(coll,1), RT.nth(coll,2));
                case 4:
                    return create(RT.nth(coll,0), RT.nth(coll,1), RT.nth(coll,2), RT.nth(coll,3));
                case 5:
                    return create(RT.nth(coll,0), RT.nth(coll,1), RT.nth(coll,2), RT.nth(coll,3), RT.nth(coll,4));
                case 6:
                    return create(RT.nth(coll,0), RT.nth(coll,1), RT.nth(coll,2), RT.nth(coll,3), RT.nth(coll,4), RT.nth(coll,5));
               }
            }
        return createFromArray(RT.toArray(coll));
    }
    
    public static IPersistentVector createFromArray(Object[] items){
        if(items.length <= Tuple.MAX_SIZE){
               switch(items.length){
               case 0:
                   return EMPTY;
               case 1:
                   return create(items[0]);
               case 2:
                   return create(items[0], items[1]);
               case 3:
                   return create(items[0], items[1], items[2]);
               case 4:
                   return create(items[0], items[1], items[2], items[3]);
               case 5:
                   return create(items[0], items[1], items[2], items[3], items[4]);
               case 6:
                   return create(items[0], items[1], items[2], items[3], items[4], items[5]);
               }
           }
        throw new IllegalAccessError("Too large an array for tuple");
    }
    
    static public abstract class ATuple extends APersistentVector implements IObj, IEditableCollection{
        PersistentVector vec(){
            return PersistentVector.adopt(toArray());
        }

        public final IObj withMeta(IPersistentMap meta){
            if (meta==null) return this;
        	return vec().withMeta(meta);
        }

        public final IPersistentMap meta(){
            return null;
        }
    }
    
    
    public static final class T0 extends ATuple implements IObj,
	    IEditableCollection, IReduce {

	public T0() {
	}

	public Object nth(int i) {
	    throw new IndexOutOfBoundsException();
	}

	public Object nth(int i, Object notFound) {
	    return notFound;
	}

	public int count() {
	    return 0;
	}

	public IPersistentVector empty() {
	    return EMPTY;
	}

	public IPersistentVector assocN(int i, Object val) {
	    switch (i) {
	    case 0:
		return cons(val);
	    default:
		throw new IndexOutOfBoundsException();
	    }
	}

	public IPersistentVector cons(Object val) {
	    return new T1(val);
	}

	public ITransientCollection asTransient() {
	    return new Transient();
	}

	public IPersistentVector pop() {
	    throw new IllegalStateException("Can't pop empty vector");
	}

	public Object kvreduce(IFn f, Object init) {
	    return init;
	}

	public Object reduce(IFn f) {
	    return f.invoke();
	}

	public Object reduce(IFn f, Object init) {
	    return init;
	}

	public int hashCode() {
	    if (_hash == -1) {
		int hash = 1;
		_hash = hash;
	    }
	    return _hash;
	}

	public int hasheq() {
	    if (_hasheq == -1) {
		int hash = 1;
		hash = Murmur3.mixCollHash(hash, 0);
		_hasheq = hash;
	    }
	    return _hasheq;
	}

	public boolean equals(Object o) {
	    return o == this ? true : super.equals(o);
	}

	public boolean equiv(Object o) {
	    return o == this ? true : super.equiv(o);
	}

	public Object[] toArray() {
	    return new Object[] {};
	}

	public Iterator iterator() {
	    return new Iterator() {
		int i = 0;

		public boolean hasNext() {
		    return i < 0;
		}

		public Object next() {
		    return nth(i++);
		}

		public void remove() {
		    throw new UnsupportedOperationException();
		}
	    };
	}

	public ISeq seq() {
	    return null;
	}
    }

    public static final class T1 extends ATuple implements IObj,
	    IEditableCollection, IReduce {
	final Object e0;

	public T1(Object e0) {
	    this.e0 = e0;
	}

	public Object nth(int i) {
	    switch (i) {
	    case 0:
		return e0;
	    default:
		throw new IndexOutOfBoundsException();
	    }
	}

	public Object nth(int i, Object notFound) {
	    switch (i) {
	    case 0:
		return e0;
	    default:
		return notFound;
	    }
	}

	public int count() {
	    return 1;
	}

	public IPersistentVector empty() {
	    return EMPTY;
	}

	public IPersistentVector assocN(int i, Object val) {
	    switch (i) {
	    case 0:
		return new T1(val);
	    case 1:
		return cons(val);
	    default:
		throw new IndexOutOfBoundsException();
	    }
	}

	public IPersistentVector cons(Object val) {
	    return new T2(e0, val);
	}

	public ITransientCollection asTransient() {
	    return new Transient(e0);
	}

	public IPersistentVector pop() {
	    return new T0();
	}

	public Object kvreduce(IFn f, Object init) {
	    init = f.invoke(init, 0, e0);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    return init;
	}

	public Object reduce(IFn f) {
	    return e0;
	}

	public Object reduce(IFn f, Object init) {
	    init = f.invoke(init, e0);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    return init;
	}

	public int hashCode() {
	    if (_hash == -1) {
		int hash = 1;
		hash = (31 * hash) + (e0 == null ? 0 : e0.hashCode());
		_hash = hash;
	    }
	    return _hash;
	}

	public int hasheq() {
	    if (_hasheq == -1) {
		int hash = 1;
		hash = (31 * hash) + Util.hasheq(e0);
		hash = Murmur3.mixCollHash(hash, 1);
		_hasheq = hash;
	    }
	    return _hasheq;
	}

	public boolean equals(Object o) {
	    if (o instanceof T1) {
		return Util.equals(e0, ((T1) o).e0);
	    } else {
		return super.equals(o);
	    }
	}

	public boolean equiv(Object o) {
	    if (o instanceof T1) {
		return Util.equiv(e0, ((T1) o).e0);
	    } else {
		return super.equiv(o);
	    }
	}

	public Object[] toArray() {
	    return new Object[] { e0 };
	}

	public Iterator iterator() {
	    return new Iterator() {
		int i = 0;

		public boolean hasNext() {
		    return i < 1;
		}

		public Object next() {
		    return nth(i++);
		}

		public void remove() {
		    throw new UnsupportedOperationException();
		}
	    };
	}

	class UnrolledChunkedSeq extends ASeq implements IChunkedSeq, Counted {
	    private final IPersistentMap meta;
	    private final int offset;

	    UnrolledChunkedSeq(IPersistentMap meta, int offset) {
		this.offset = offset;
		this.meta = meta;
	    }

	    public IChunk chunkedFirst() {
		return new ArrayChunk(toArray(), 0);
	    }

	    public ISeq chunkedNext() {
		return null;
	    }

	    public ISeq chunkedMore() {
		return PersistentList.EMPTY;
	    }

	    public UnrolledChunkedSeq withMeta(IPersistentMap meta) {
		return new UnrolledChunkedSeq(meta, offset);
	    }

	    public Object first() {
		return nth(offset);
	    }

	    public ISeq next() {
		if (offset < 0) {
		    return new UnrolledChunkedSeq(null, offset + 1);
		}
		return null;
	    }

	    public int count() {
		return 1 - offset;
	    }
	}

	public ISeq seq() {
	    return new UnrolledChunkedSeq(null, 0);
	}
    }

    public static final class T2 extends ATuple implements IObj,
	    IEditableCollection, IReduce, IMapEntry {
	final Object e0;
	final Object e1;

	public Object key() {
	    return e0;
	}

	public Object getKey() {
	    return e0;
	}

	public Object val() {
	    return e1;
	}

	public Object getValue() {
	    return e1;
	}

	public Object setValue(Object v) {
	    throw new UnsupportedOperationException();
	}

	public T2(Object e0, Object e1) {
	    this.e0 = e0;
	    this.e1 = e1;
	}

	public Object nth(int i) {
	    switch (i) {
	    case 0:
		return e0;
	    case 1:
		return e1;
	    default:
		throw new IndexOutOfBoundsException();
	    }
	}

	public Object nth(int i, Object notFound) {
	    switch (i) {
	    case 0:
		return e0;
	    case 1:
		return e1;
	    default:
		return notFound;
	    }
	}

	public int count() {
	    return 2;
	}

	public IPersistentVector empty() {
	    return EMPTY;
	}

	public IPersistentVector assocN(int i, Object val) {
	    switch (i) {
	    case 0:
		return new T2(val, e1);
	    case 1:
		return new T2(e0, val);
	    case 2:
		return cons(val);
	    default:
		throw new IndexOutOfBoundsException();
	    }
	}

	public IPersistentVector cons(Object val) {
	    return new T3(e0, e1, val);
	}

	public ITransientCollection asTransient() {
	    return new Transient(e0, e1);
	}

	public IPersistentVector pop() {
	    return new T1(e0);
	}

	public Object kvreduce(IFn f, Object init) {
	    init = f.invoke(init, 0, e0);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    init = f.invoke(init, 1, e1);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    return init;
	}

	public Object reduce(IFn f) {
	    Object init = e0;
	    init = f.invoke(init, e1);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    return init;
	}

	public Object reduce(IFn f, Object init) {
	    init = f.invoke(init, e0);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    init = f.invoke(init, e1);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    return init;
	}

	public int hashCode() {
	    if (_hash == -1) {
		int hash = 1;
		hash = (31 * hash) + (e0 == null ? 0 : e0.hashCode());
		hash = (31 * hash) + (e1 == null ? 0 : e1.hashCode());
		_hash = hash;
	    }
	    return _hash;
	}

	public int hasheq() {
	    if (_hasheq == -1) {
		int hash = 1;
		hash = (31 * hash) + Util.hasheq(e0);
		hash = (31 * hash) + Util.hasheq(e1);
		hash = Murmur3.mixCollHash(hash, 2);
		_hasheq = hash;
	    }
	    return _hasheq;
	}

	public boolean equals(Object o) {
	    if (o instanceof T2) {
		return Util.equals(e0, ((T2) o).e0)
			&& Util.equals(e1, ((T2) o).e1);
	    } else {
		return super.equals(o);
	    }
	}

	public boolean equiv(Object o) {
	    if (o instanceof T2) {
		return Util.equiv(e0, ((T2) o).e0)
			&& Util.equiv(e1, ((T2) o).e1);
	    } else {
		return super.equiv(o);
	    }
	}

	public Object[] toArray() {
	    return new Object[] { e0, e1 };
	}

	public Iterator iterator() {
	    return new Iterator() {
		int i = 0;

		public boolean hasNext() {
		    return i < 2;
		}

		public Object next() {
		    return nth(i++);
		}

		public void remove() {
		    throw new UnsupportedOperationException();
		}
	    };
	}

	class UnrolledChunkedSeq extends ASeq implements IChunkedSeq, Counted {
	    private final IPersistentMap meta;
	    private final int offset;

	    UnrolledChunkedSeq(IPersistentMap meta, int offset) {
		this.offset = offset;
		this.meta = meta;
	    }

	    public IChunk chunkedFirst() {
		return new ArrayChunk(toArray(), 0);
	    }

	    public ISeq chunkedNext() {
		return null;
	    }

	    public ISeq chunkedMore() {
		return PersistentList.EMPTY;
	    }

	    public UnrolledChunkedSeq withMeta(IPersistentMap meta) {
		return new UnrolledChunkedSeq(meta, offset);
	    }

	    public Object first() {
		return nth(offset);
	    }

	    public ISeq next() {
		if (offset < 1) {
		    return new UnrolledChunkedSeq(null, offset + 1);
		}
		return null;
	    }

	    public int count() {
		return 2 - offset;
	    }
	}

	public ISeq seq() {
	    return new UnrolledChunkedSeq(null, 0);
	}
    }

    public static final class T3 extends ATuple implements IObj,
	    IEditableCollection, IReduce {
	final Object e0;
	final Object e1;
	final Object e2;

	public T3(Object e0, Object e1, Object e2) {
	    this.e0 = e0;
	    this.e1 = e1;
	    this.e2 = e2;
	}

	public Object nth(int i) {
	    switch (i) {
	    case 0:
		return e0;
	    case 1:
		return e1;
	    case 2:
		return e2;
	    default:
		throw new IndexOutOfBoundsException();
	    }
	}

	public Object nth(int i, Object notFound) {
	    switch (i) {
	    case 0:
		return e0;
	    case 1:
		return e1;
	    case 2:
		return e2;
	    default:
		return notFound;
	    }
	}

	public int count() {
	    return 3;
	}

	public IPersistentVector empty() {
	    return EMPTY;
	}

	public IPersistentVector assocN(int i, Object val) {
	    switch (i) {
	    case 0:
		return new T3(val, e1, e2);
	    case 1:
		return new T3(e0, val, e2);
	    case 2:
		return new T3(e0, e1, val);
	    case 3:
		return cons(val);
	    default:
		throw new IndexOutOfBoundsException();
	    }
	}

	public IPersistentVector cons(Object val) {
	    return new T4(e0, e1, e2, val);
	}

	public ITransientCollection asTransient() {
	    return new Transient(e0, e1, e2);
	}

	public IPersistentVector pop() {
	    return (IPersistentVector) new T2(e0, e1);
	}

	public Object kvreduce(IFn f, Object init) {
	    init = f.invoke(init, 0, e0);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    init = f.invoke(init, 1, e1);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    init = f.invoke(init, 2, e2);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    return init;
	}

	public Object reduce(IFn f) {
	    Object init = e0;
	    init = f.invoke(init, e1);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    init = f.invoke(init, e2);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    return init;
	}

	public Object reduce(IFn f, Object init) {
	    init = f.invoke(init, e0);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    init = f.invoke(init, e1);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    init = f.invoke(init, e2);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    return init;
	}

	public int hashCode() {
	    if (_hash == -1) {
		int hash = 1;
		hash = (31 * hash) + (e0 == null ? 0 : e0.hashCode());
		hash = (31 * hash) + (e1 == null ? 0 : e1.hashCode());
		hash = (31 * hash) + (e2 == null ? 0 : e2.hashCode());
		_hash = hash;
	    }
	    return _hash;
	}

	public int hasheq() {
	    if (_hasheq == -1) {
		int hash = 1;
		hash = (31 * hash) + Util.hasheq(e0);
		hash = (31 * hash) + Util.hasheq(e1);
		hash = (31 * hash) + Util.hasheq(e2);
		hash = Murmur3.mixCollHash(hash, 3);
		_hasheq = hash;
	    }
	    return _hasheq;
	}

	public boolean equals(Object o) {
	    if (o instanceof T3) {
		return Util.equals(e0, ((T3) o).e0)
			&& Util.equals(e1, ((T3) o).e1)
			&& Util.equals(e2, ((T3) o).e2);
	    } else {
		return super.equals(o);
	    }
	}

	public boolean equiv(Object o) {
	    if (o instanceof T3) {
		return Util.equiv(e0, ((T3) o).e0)
			&& Util.equiv(e1, ((T3) o).e1)
			&& Util.equiv(e2, ((T3) o).e2);
	    } else {
		return super.equiv(o);
	    }
	}

	public Object[] toArray() {
	    return new Object[] { e0, e1, e2 };
	}

	public Iterator iterator() {
	    return new Iterator() {
		int i = 0;

		public boolean hasNext() {
		    return i < 3;
		}

		public Object next() {
		    return nth(i++);
		}

		public void remove() {
		    throw new UnsupportedOperationException();
		}
	    };
	}

	class UnrolledChunkedSeq extends ASeq implements IChunkedSeq, Counted {
	    private final IPersistentMap meta;
	    private final int offset;

	    UnrolledChunkedSeq(IPersistentMap meta, int offset) {
		this.offset = offset;
		this.meta = meta;
	    }

	    public IChunk chunkedFirst() {
		return new ArrayChunk(toArray(), 0);
	    }

	    public ISeq chunkedNext() {
		return null;
	    }

	    public ISeq chunkedMore() {
		return PersistentList.EMPTY;
	    }

	    public UnrolledChunkedSeq withMeta(IPersistentMap meta) {
		return new UnrolledChunkedSeq(meta, offset);
	    }

	    public Object first() {
		return nth(offset);
	    }

	    public ISeq next() {
		if (offset < 2) {
		    return new UnrolledChunkedSeq(null, offset + 1);
		}
		return null;
	    }

	    public int count() {
		return 3 - offset;
	    }
	}

	public ISeq seq() {
	    return new UnrolledChunkedSeq(null, 0);
	}
    }

    public static final class T4 extends ATuple implements IObj,
	    IEditableCollection, IReduce {
	final Object e0;
	final Object e1;
	final Object e2;
	final Object e3;

	public T4(Object e0, Object e1, Object e2, Object e3) {
	    this.e0 = e0;
	    this.e1 = e1;
	    this.e2 = e2;
	    this.e3 = e3;
	}

	public Object nth(int i) {
	    switch (i) {
	    case 0:
		return e0;
	    case 1:
		return e1;
	    case 2:
		return e2;
	    case 3:
		return e3;
	    default:
		throw new IndexOutOfBoundsException();
	    }
	}

	public Object nth(int i, Object notFound) {
	    switch (i) {
	    case 0:
		return e0;
	    case 1:
		return e1;
	    case 2:
		return e2;
	    case 3:
		return e3;
	    default:
		return notFound;
	    }
	}

	public int count() {
	    return 4;
	}

	public IPersistentVector empty() {
	    return EMPTY;
	}

	public IPersistentVector assocN(int i, Object val) {
	    switch (i) {
	    case 0:
		return new T4(val, e1, e2, e3);
	    case 1:
		return new T4(e0, val, e2, e3);
	    case 2:
		return new T4(e0, e1, val, e3);
	    case 3:
		return new T4(e0, e1, e2, val);
	    case 4:
		return cons(val);
	    default:
		throw new IndexOutOfBoundsException();
	    }
	}

	public IPersistentVector cons(Object val) {
	    return new T5(e0, e1, e2, e3, val);
	}

	public ITransientCollection asTransient() {
	    return new Transient(e0, e1, e2, e3);
	}

	public IPersistentVector pop() {
	    return new T3(e0, e1, e2);
	}

	public Object kvreduce(IFn f, Object init) {
	    init = f.invoke(init, 0, e0);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    init = f.invoke(init, 1, e1);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    init = f.invoke(init, 2, e2);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    init = f.invoke(init, 3, e3);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    return init;
	}

	public Object reduce(IFn f) {
	    Object init = e0;
	    init = f.invoke(init, e1);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    init = f.invoke(init, e2);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    init = f.invoke(init, e3);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    return init;
	}

	public Object reduce(IFn f, Object init) {
	    init = f.invoke(init, e0);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    init = f.invoke(init, e1);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    init = f.invoke(init, e2);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    init = f.invoke(init, e3);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    return init;
	}

	public int hashCode() {
	    if (_hash == -1) {
		int hash = 1;
		hash = (31 * hash) + (e0 == null ? 0 : e0.hashCode());
		hash = (31 * hash) + (e1 == null ? 0 : e1.hashCode());
		hash = (31 * hash) + (e2 == null ? 0 : e2.hashCode());
		hash = (31 * hash) + (e3 == null ? 0 : e3.hashCode());
		_hash = hash;
	    }
	    return _hash;
	}

	public int hasheq() {
	    if (_hasheq == -1) {
		int hash = 1;
		hash = (31 * hash) + Util.hasheq(e0);
		hash = (31 * hash) + Util.hasheq(e1);
		hash = (31 * hash) + Util.hasheq(e2);
		hash = (31 * hash) + Util.hasheq(e3);
		hash = Murmur3.mixCollHash(hash, 4);
		_hasheq = hash;
	    }
	    return _hasheq;
	}

	public boolean equals(Object o) {
	    if (o instanceof T4) {
		return Util.equals(e0, ((T4) o).e0)
			&& Util.equals(e1, ((T4) o).e1)
			&& Util.equals(e2, ((T4) o).e2)
			&& Util.equals(e3, ((T4) o).e3);
	    } else {
		return super.equals(o);
	    }
	}

	public boolean equiv(Object o) {
	    if (o instanceof T4) {
		return Util.equiv(e0, ((T4) o).e0)
			&& Util.equiv(e1, ((T4) o).e1)
			&& Util.equiv(e2, ((T4) o).e2)
			&& Util.equiv(e3, ((T4) o).e3);
	    } else {
		return super.equiv(o);
	    }
	}

	public Object[] toArray() {
	    return new Object[] { e0, e1, e2, e3 };
	}

	public Iterator iterator() {
	    return new Iterator() {
		int i = 0;

		public boolean hasNext() {
		    return i < 4;
		}

		public Object next() {
		    return nth(i++);
		}

		public void remove() {
		    throw new UnsupportedOperationException();
		}
	    };
	}

	class UnrolledChunkedSeq extends ASeq implements IChunkedSeq, Counted {
	    private final IPersistentMap meta;
	    private final int offset;

	    UnrolledChunkedSeq(IPersistentMap meta, int offset) {
		this.offset = offset;
		this.meta = meta;
	    }

	    public IChunk chunkedFirst() {
		return new ArrayChunk(toArray(), 0);
	    }

	    public ISeq chunkedNext() {
		return null;
	    }

	    public ISeq chunkedMore() {
		return PersistentList.EMPTY;
	    }

	    public UnrolledChunkedSeq withMeta(IPersistentMap meta) {
		return new UnrolledChunkedSeq(meta, offset);
	    }

	    public Object first() {
		return nth(offset);
	    }

	    public ISeq next() {
		if (offset < 3) {
		    return new UnrolledChunkedSeq(null, offset + 1);
		}
		return null;
	    }

	    public int count() {
		return 4 - offset;
	    }
	}

	public ISeq seq() {
	    return new UnrolledChunkedSeq(null, 0);
	}
    }

    public static final class T5 extends ATuple implements IObj,
	    IEditableCollection, IReduce {
	final Object e0;
	final Object e1;
	final Object e2;
	final Object e3;
	final Object e4;

	public T5(Object e0, Object e1, Object e2, Object e3, Object e4) {
	    this.e0 = e0;
	    this.e1 = e1;
	    this.e2 = e2;
	    this.e3 = e3;
	    this.e4 = e4;
	}

	public Object nth(int i) {
	    switch (i) {
	    case 0:
		return e0;
	    case 1:
		return e1;
	    case 2:
		return e2;
	    case 3:
		return e3;
	    case 4:
		return e4;
	    default:
		throw new IndexOutOfBoundsException();
	    }
	}

	public Object nth(int i, Object notFound) {
	    switch (i) {
	    case 0:
		return e0;
	    case 1:
		return e1;
	    case 2:
		return e2;
	    case 3:
		return e3;
	    case 4:
		return e4;
	    default:
		return notFound;
	    }
	}

	public int count() {
	    return 5;
	}

	public IPersistentVector empty() {
	    return EMPTY;
	}

	public IPersistentVector assocN(int i, Object val) {
	    switch (i) {
	    case 0:
		return new T5(val, e1, e2, e3, e4);
	    case 1:
		return new T5(e0, val, e2, e3, e4);
	    case 2:
		return new T5(e0, e1, val, e3, e4);
	    case 3:
		return new T5(e0, e1, e2, val, e4);
	    case 4:
		return new T5(e0, e1, e2, e3, val);
	    case 5:
		return cons(val);
	    default:
		throw new IndexOutOfBoundsException();
	    }
	}

	public IPersistentVector cons(Object val) {
	    return new T6(e0, e1, e2, e3, e4, val);
	}

	public ITransientCollection asTransient() {
	    return new Transient(e0, e1, e2, e3, e4);
	}

	public IPersistentVector pop() {
	    return new T4(e0, e1, e2, e3);
	}

	public Object kvreduce(IFn f, Object init) {
	    init = f.invoke(init, 0, e0);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    init = f.invoke(init, 1, e1);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    init = f.invoke(init, 2, e2);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    init = f.invoke(init, 3, e3);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    init = f.invoke(init, 4, e4);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    return init;
	}

	public Object reduce(IFn f) {
	    Object init = e0;
	    init = f.invoke(init, e1);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    init = f.invoke(init, e2);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    init = f.invoke(init, e3);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    init = f.invoke(init, e4);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    return init;
	}

	public Object reduce(IFn f, Object init) {
	    init = f.invoke(init, e0);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    init = f.invoke(init, e1);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    init = f.invoke(init, e2);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    init = f.invoke(init, e3);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    init = f.invoke(init, e4);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    return init;
	}

	public int hashCode() {
	    if (_hash == -1) {
		int hash = 1;
		hash = (31 * hash) + (e0 == null ? 0 : e0.hashCode());
		hash = (31 * hash) + (e1 == null ? 0 : e1.hashCode());
		hash = (31 * hash) + (e2 == null ? 0 : e2.hashCode());
		hash = (31 * hash) + (e3 == null ? 0 : e3.hashCode());
		hash = (31 * hash) + (e4 == null ? 0 : e4.hashCode());
		_hash = hash;
	    }
	    return _hash;
	}

	public int hasheq() {
	    if (_hasheq == -1) {
		int hash = 1;
		hash = (31 * hash) + Util.hasheq(e0);
		hash = (31 * hash) + Util.hasheq(e1);
		hash = (31 * hash) + Util.hasheq(e2);
		hash = (31 * hash) + Util.hasheq(e3);
		hash = (31 * hash) + Util.hasheq(e4);
		hash = Murmur3.mixCollHash(hash, 5);
		_hasheq = hash;
	    }
	    return _hasheq;
	}

	public boolean equals(Object o) {
	    if (o instanceof T5) {
		return Util.equals(e0, ((T5) o).e0)
			&& Util.equals(e1, ((T5) o).e1)
			&& Util.equals(e2, ((T5) o).e2)
			&& Util.equals(e3, ((T5) o).e3)
			&& Util.equals(e4, ((T5) o).e4);
	    } else {
		return super.equals(o);
	    }
	}

	public boolean equiv(Object o) {
	    if (o instanceof T5) {
		return Util.equiv(e0, ((T5) o).e0)
			&& Util.equiv(e1, ((T5) o).e1)
			&& Util.equiv(e2, ((T5) o).e2)
			&& Util.equiv(e3, ((T5) o).e3)
			&& Util.equiv(e4, ((T5) o).e4);
	    } else {
		return super.equiv(o);
	    }
	}

	public Object[] toArray() {
	    return new Object[] { e0, e1, e2, e3, e4 };
	}

	public Iterator iterator() {
	    return new Iterator() {
		int i = 0;

		public boolean hasNext() {
		    return i < 5;
		}

		public Object next() {
		    return nth(i++);
		}

		public void remove() {
		    throw new UnsupportedOperationException();
		}
	    };
	}

	class UnrolledChunkedSeq extends ASeq implements IChunkedSeq, Counted {
	    private final IPersistentMap meta;
	    private final int offset;

	    UnrolledChunkedSeq(IPersistentMap meta, int offset) {
		this.offset = offset;
		this.meta = meta;
	    }

	    public IChunk chunkedFirst() {
		return new ArrayChunk(toArray(), 0);
	    }

	    public ISeq chunkedNext() {
		return null;
	    }

	    public ISeq chunkedMore() {
		return PersistentList.EMPTY;
	    }

	    public UnrolledChunkedSeq withMeta(IPersistentMap meta) {
		return new UnrolledChunkedSeq(meta, offset);
	    }

	    public Object first() {
		return nth(offset);
	    }

	    public ISeq next() {
		if (offset < 4) {
		    return new UnrolledChunkedSeq(null, offset + 1);
		}
		return null;
	    }

	    public int count() {
		return 5 - offset;
	    }
	}

	public ISeq seq() {
	    return new UnrolledChunkedSeq(null, 0);
	}
    }

    public static final class T6 extends ATuple implements IObj,
	    IEditableCollection, IReduce {
	final Object e0;
	final Object e1;
	final Object e2;
	final Object e3;
	final Object e4;
	final Object e5;

	public T6(Object e0, Object e1, Object e2, Object e3, Object e4,
		Object e5) {
	    this.e0 = e0;
	    this.e1 = e1;
	    this.e2 = e2;
	    this.e3 = e3;
	    this.e4 = e4;
	    this.e5 = e5;
	}

	public Object nth(int i) {
	    switch (i) {
	    case 0:
		return e0;
	    case 1:
		return e1;
	    case 2:
		return e2;
	    case 3:
		return e3;
	    case 4:
		return e4;
	    case 5:
		return e5;
	    default:
		throw new IndexOutOfBoundsException();
	    }
	}

	public Object nth(int i, Object notFound) {
	    switch (i) {
	    case 0:
		return e0;
	    case 1:
		return e1;
	    case 2:
		return e2;
	    case 3:
		return e3;
	    case 4:
		return e4;
	    case 5:
		return e5;
	    default:
		return notFound;
	    }
	}

	public int count() {
	    return 6;
	}

	public IPersistentVector empty() {
	    return EMPTY;
	}

	public IPersistentVector assocN(int i, Object val) {
	    switch (i) {
	    case 0:
		return new T6(val, e1, e2, e3, e4, e5);
	    case 1:
		return new T6(e0, val, e2, e3, e4, e5);
	    case 2:
		return new T6(e0, e1, val, e3, e4, e5);
	    case 3:
		return new T6(e0, e1, e2, val, e4, e5);
	    case 4:
		return new T6(e0, e1, e2, e3, val, e5);
	    case 5:
		return new T6(e0, e1, e2, e3, e4, val);
	    case 6:
		return cons(val);
	    default:
		throw new IndexOutOfBoundsException();
	    }
	}

	public IPersistentVector cons(Object val) {
	    return new PersistentVector(null, 7, 5,
		    PersistentVector.EMPTY_NODE, new Object[] { e0, e1, e2, e3,
			    e4, e5, val });
	}

	public ITransientCollection asTransient() {
	    return new Transient(e0, e1, e2, e3, e4, e5);
	}

	public IPersistentVector pop() {
	    return new T5(e0, e1, e2, e3, e4);
	}

	public Object kvreduce(IFn f, Object init) {
	    init = f.invoke(init, 0, e0);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    init = f.invoke(init, 1, e1);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    init = f.invoke(init, 2, e2);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    init = f.invoke(init, 3, e3);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    init = f.invoke(init, 4, e4);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    init = f.invoke(init, 5, e5);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    return init;
	}

	public Object reduce(IFn f) {
	    Object init = e0;
	    init = f.invoke(init, e1);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    init = f.invoke(init, e2);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    init = f.invoke(init, e3);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    init = f.invoke(init, e4);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    init = f.invoke(init, e5);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    return init;
	}

	public Object reduce(IFn f, Object init) {
	    init = f.invoke(init, e0);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    init = f.invoke(init, e1);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    init = f.invoke(init, e2);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    init = f.invoke(init, e3);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    init = f.invoke(init, e4);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    init = f.invoke(init, e5);
	    if (RT.isReduced(init)) {
		return ((IDeref) init).deref();
	    }
	    return init;
	}

	public int hashCode() {
	    if (_hash == -1) {
		int hash = 1;
		hash = (31 * hash) + (e0 == null ? 0 : e0.hashCode());
		hash = (31 * hash) + (e1 == null ? 0 : e1.hashCode());
		hash = (31 * hash) + (e2 == null ? 0 : e2.hashCode());
		hash = (31 * hash) + (e3 == null ? 0 : e3.hashCode());
		hash = (31 * hash) + (e4 == null ? 0 : e4.hashCode());
		hash = (31 * hash) + (e5 == null ? 0 : e5.hashCode());
		_hash = hash;
	    }
	    return _hash;
	}

	public int hasheq() {
	    if (_hasheq == -1) {
		int hash = 1;
		hash = (31 * hash) + Util.hasheq(e0);
		hash = (31 * hash) + Util.hasheq(e1);
		hash = (31 * hash) + Util.hasheq(e2);
		hash = (31 * hash) + Util.hasheq(e3);
		hash = (31 * hash) + Util.hasheq(e4);
		hash = (31 * hash) + Util.hasheq(e5);
		hash = Murmur3.mixCollHash(hash, 6);
		_hasheq = hash;
	    }
	    return _hasheq;
	}

	public boolean equals(Object o) {
	    if (o instanceof T6) {
		return Util.equals(e0, ((T6) o).e0)
			&& Util.equals(e1, ((T6) o).e1)
			&& Util.equals(e2, ((T6) o).e2)
			&& Util.equals(e3, ((T6) o).e3)
			&& Util.equals(e4, ((T6) o).e4)
			&& Util.equals(e5, ((T6) o).e5);
	    } else {
		return super.equals(o);
	    }
	}

	public boolean equiv(Object o) {
	    if (o instanceof T6) {
		return Util.equiv(e0, ((T6) o).e0)
			&& Util.equiv(e1, ((T6) o).e1)
			&& Util.equiv(e2, ((T6) o).e2)
			&& Util.equiv(e3, ((T6) o).e3)
			&& Util.equiv(e4, ((T6) o).e4)
			&& Util.equiv(e5, ((T6) o).e5);
	    } else {
		return super.equiv(o);
	    }
	}

	public Object[] toArray() {
	    return new Object[] { e0, e1, e2, e3, e4, e5 };
	}

	public Iterator iterator() {
	    return new Iterator() {
		int i = 0;

		public boolean hasNext() {
		    return i < 6;
		}

		public Object next() {
		    return nth(i++);
		}

		public void remove() {
		    throw new UnsupportedOperationException();
		}
	    };
	}

	class UnrolledChunkedSeq extends ASeq implements IChunkedSeq, Counted {
	    private final IPersistentMap meta;
	    private final int offset;

	    UnrolledChunkedSeq(IPersistentMap meta, int offset) {
		this.offset = offset;
		this.meta = meta;
	    }

	    public IChunk chunkedFirst() {
		return new ArrayChunk(toArray(), 0);
	    }

	    public ISeq chunkedNext() {
		return null;
	    }

	    public ISeq chunkedMore() {
		return PersistentList.EMPTY;
	    }

	    public UnrolledChunkedSeq withMeta(IPersistentMap meta) {
		return new UnrolledChunkedSeq(meta, offset);
	    }

	    public Object first() {
		return nth(offset);
	    }

	    public ISeq next() {
		if (offset < 5) {
		    return new UnrolledChunkedSeq(null, offset + 1);
		}
		return null;
	    }

	    public int count() {
		return 6 - offset;
	    }
	}

	public ISeq seq() {
	    return new UnrolledChunkedSeq(null, 0);
	}
    }

    static class Transient extends AFn implements ITransientVector, Counted {
	Object e0;
	Object e1;
	Object e2;
	Object e3;
	Object e4;
	Object e5;
	private int count;
	private transient boolean edit = true;

	Transient() {
	    this.count = 0;
	}

	Transient(Object e0) {
	    this.count = 1;
	    this.e0 = e0;
	}

	Transient(Object e0, Object e1) {
	    this.count = 2;
	    this.e0 = e0;
	    this.e1 = e1;
	}

	Transient(Object e0, Object e1, Object e2) {
	    this.count = 3;
	    this.e0 = e0;
	    this.e1 = e1;
	    this.e2 = e2;
	}

	Transient(Object e0, Object e1, Object e2, Object e3) {
	    this.count = 4;
	    this.e0 = e0;
	    this.e1 = e1;
	    this.e2 = e2;
	    this.e3 = e3;
	}

	Transient(Object e0, Object e1, Object e2, Object e3, Object e4) {
	    this.count = 5;
	    this.e0 = e0;
	    this.e1 = e1;
	    this.e2 = e2;
	    this.e3 = e3;
	    this.e4 = e4;
	}

	Transient(Object e0, Object e1, Object e2, Object e3, Object e4,
		Object e5) {
	    this.count = 6;
	    this.e0 = e0;
	    this.e1 = e1;
	    this.e2 = e2;
	    this.e3 = e3;
	    this.e4 = e4;
	    this.e5 = e5;
	}

	private void ensureEditable() {
	    if (!edit) {
		throw new IllegalAccessError(
			"Transient used after persistent! call");
	    }
	}

	public int count() {
	    ensureEditable();
	    return count;
	}

	public ITransientVector conj(Object val) {
	    ensureEditable();
	    if (count == 6) {
		return new PersistentVector(7, 5, PersistentVector.EMPTY_NODE,
			new Object[] { e0, e1, e2, e3, e4, e5, val })
			.asTransient();
	    }
	    switch (++count) {
	    case 1:
		e0 = val;
		break;
	    case 2:
		e1 = val;
		break;
	    case 3:
		e2 = val;
		break;
	    case 4:
		e3 = val;
		break;
	    case 5:
		e4 = val;
		break;
	    case 6:
		e5 = val;
		break;
	    }
	    return this;
	}

	public Object valAt(Object key, Object notFound) {
	    if (Util.isInteger(key)) {
		return nth(((Number) key).intValue(), notFound);
	    }
	    return notFound;
	}

	public Object valAt(Object key) {
	    if (Util.isInteger(key)) {
		return nth(((Number) key).intValue());
	    }
	    throw new IllegalArgumentException("Key must be integer");
	}

	public Object invoke(Object key) {
	    return valAt(key);
	}

	public Object nth(int idx) {
	    if (idx >= 0 && idx < count) {
		switch (idx) {
		case 0:
		    return e0;
		case 1:
		    return e1;
		case 2:
		    return e2;
		case 3:
		    return e3;
		case 4:
		    return e4;
		case 5:
		    return e5;
		}
	    }
	    throw new IndexOutOfBoundsException();
	}

	public Object nth(int idx, Object notFound) {
	    if (idx >= 0 && idx < count) {
		return nth(idx);
	    }
	    return notFound;
	}

	public ITransientVector assoc(Object key, Object val) {
	    if (Util.isInteger(key)) {
		return assocN(((Number) key).intValue(), val);
	    }
	    throw new IllegalArgumentException("Key must be integer");
	}

	public ITransientVector assocN(int idx, Object val) {
	    ensureEditable();
	    if (idx >= 0 && idx < count) {
		switch (idx) {
		case 0:
		    e0 = val;
		    break;
		case 1:
		    e1 = val;
		    break;
		case 2:
		    e2 = val;
		    break;
		case 3:
		    e3 = val;
		    break;
		case 4:
		    e4 = val;
		    break;
		case 5:
		    e5 = val;
		    break;
		}
		return this;
	    } else if (idx == count) {
		return conj(val);
	    }
	    throw new IndexOutOfBoundsException();
	}

	public ITransientVector pop() {
	    ensureEditable();
	    if (count == 0) {
		throw new IllegalStateException("Can't pop empty vector");
	    } else {
		count--;
	    }
	    return this;
	}

	public IPersistentVector persistent() {
	    ensureEditable();
	    edit = false;
	    switch (count) {
	    case 0:
		return EMPTY;
	    case 1:
		return new T1(e0);
	    case 2:
		return new T2(e0, e1);
	    case 3:
		return new T3(e0, e1, e2);
	    case 4:
		return new T4(e0, e1, e2, e3);
	    case 5:
		return new T5(e0, e1, e2, e3, e4);
	    case 6:
		return new T6(e0, e1, e2, e3, e4, e5);
	    }
	    throw new IllegalStateException();
	}
    }
}