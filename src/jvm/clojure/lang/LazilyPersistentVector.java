/**
 *   Copyright (c) Rich Hickey. All rights reserved.
 *   The use and distribution terms for this software are covered by the
 *   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
 *   which can be found in the file epl-v10.html at the root of this distribution.
 *   By using this software in any fashion, you are agreeing to be bound by
 * 	 the terms of this license.
 *   You must not remove this notice, or any other, from this software.
 **/

/* rich May 14, 2008 */

package clojure.lang;

import java.util.Collection;
import java.util.List;

public class LazilyPersistentVector{

// create an IPersistentVector from coll, handling special cases efficiently 
static public IPersistentVector create(Object coll) {
	if (coll==null) return PersistentVector.EMPTY;
	if (coll instanceof Collection) return create((Collection<?>)coll);
	return createOwning(RT.toArray(coll));
}

// create an IPersistentVector from an object array, MAY use object array as internal persistent vector storage
static public IPersistentVector createOwning(Object... items){
	int n=items.length;
	if (n == 0) return PersistentVector.EMPTY;
	if (n <= 32) return new PersistentVector(items.length, 5, PersistentVector.EMPTY_NODE,items);
	return PersistentVector.create(items);
}

static public IPersistentVector create(Collection<?> coll){
	if (coll instanceof IPersistentVector) return (IPersistentVector) coll;
	if (coll instanceof List) return PersistentVector.create((List<?>) coll);
	if (coll instanceof ISeq) return PersistentVector.create((ISeq) coll);
	return createOwning(coll.toArray());
}

}
