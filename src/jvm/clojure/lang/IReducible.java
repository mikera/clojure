package clojure.lang;

public interface IReducible {
	Object reduce(IFn function, Object value);
}
