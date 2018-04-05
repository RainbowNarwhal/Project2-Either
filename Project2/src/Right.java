import java.util.function.Function;
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
	
	public String toString()
	{
		return "Either[" + object + "]";
	}

	@Override
	public <U> Either<U> map(Function<? super T, ? extends U> mapper) {
		U newObject = mapper.apply(object);
//		System.out.println(mapper.apply(object));
		String message = this.object.getClass().toString();
		
		return Either.ofInternal(newObject, "Empty:NoValueFromInside" + message);
	}

	@Override
	public <U> Either<U> flatMap(Function<? super T, Either<U>> mapper) {
		// TODO Auto-generated method stub
		return null;
	}

}
