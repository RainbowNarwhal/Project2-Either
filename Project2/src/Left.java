import java.util.function.Supplier;

/**
 * This is a class to represent the "empty" in optional. This class will get
 * treated as an error and will be handled as such. Our .map function will ignore all the Left values.
 * @author km1473
 */
public class Left<T> extends Either<T>
{
	@Override
	public T get() throws EmptyValueException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T orElse(T replacement) {
		return replacement;
	}

	@Override
	public T orElseGet(Supplier<? extends T> replacement) {
		return replacement.get();
	}

}
