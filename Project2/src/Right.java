import java.util.function.Supplier;

/**
 * This is a class to represent the Optional<T> in the Optional class.
 * @author km1473
 */

public class Right<T> extends Either<T>
{

	public Right(T obj) {
		object = obj;
	}

	@Override
	public T get() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T orElse(T replacement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T orElseGet(Supplier<? extends T> replacement) {
		// TODO Auto-generated method stub
		return null;
	}

}
