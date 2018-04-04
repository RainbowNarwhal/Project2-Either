import java.util.function.Supplier;

public abstract class Either<T>
{
	T object;
	
	public Either<T> of(T obj)
	{
		if(obj != null)
			return new Right(obj);
		else
			return new Left();
	}
	
	public abstract T get() throws Exception;
	
	public abstract T orElse(T replacement);
	
	public abstract T orElseGet(Supplier<? extends T> replacement);	
	
}
