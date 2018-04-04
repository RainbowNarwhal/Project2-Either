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
	public T get() throws EmptyValueException {
		// TODO Auto-generated method stub
		return object;
	}

	@Override
	public T orElse(T replacement) {
		return object;
	}

	@Override
	public T orElseGet(Supplier<? extends T> replacement) {
		return object;
	}

}
