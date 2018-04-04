import java.util.function.Function;
import java.util.function.Supplier;

public abstract class Either<T>
{
	T object;
	
	public static <T> Either<T> of(T obj)
	{
		if(obj != null)
			return new Right<T>(obj);
		else
			return new Left<T>("null_passed_to_of");
	}
	
	public abstract T get() throws EmptyValueException;
	
	public abstract T orElse(T replacement);
	
	public abstract T orElseGet(Supplier<? extends T> replacement);	
	
	public abstract <U> Either<U> map(Function<? super T, ? extends U> mapper);
	
	public abstract <U> Either<U> flatMap(Function<? super T,Either<U>> mapper);
	
}
