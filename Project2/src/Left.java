import java.util.function.Function;
import java.util.function.Supplier;

/**
 * This is a class to represent the "empty" in optional. This class will get
 * treated as an error and will be handled as such. Our .map function will ignore all the Left values.
 * @author km1473
 */
public class Left<T> extends Either<T>
{
	String noValue;
	
	public Left(String problem)
	{
		noValue = problem;
	}
	@Override
	public T get() throws EmptyValueException {
		if (object == null)
		{
			throw new EmptyValueException(noValue);
		}
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
	
	public String toString()
	{
		return "Either[" + noValue + "]";
	}
	
	@Override
	public <U> Either<U> map(Function<? super T, ? extends U> mapper) {
		return new Left<U>(noValue);
	}
	@Override
	public <U> Either<U> flatMap(Function<? super T, Either<U>> mapper) {
		return new Left<U>(noValue);
	}

}
