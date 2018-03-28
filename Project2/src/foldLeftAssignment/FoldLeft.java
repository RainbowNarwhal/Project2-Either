package foldLeftAssignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FoldLeft
{

	public static void main(String[] args)
	{
		List<List<Integer>> lli = Arrays.asList(Arrays.asList(1,2,3), Arrays.asList(4,5,6), Arrays.asList(7,8,9));
		System.out.println(lli);
		Stream<Stream<Integer>> ssi = lli.stream().map(List::stream);
		
		Stream<Integer> si = ssi.flatMap(x -> x);
		//Stream<Integer> si = ssi.flatMap(Function.identity());
		List<Integer> test = Arrays.asList(0);
		
		List<Integer> li = si.collect(Collectors.toList());
		int total = sum(li);
		int count = count(li);
		//List<Integer> filter = foldLeft2(li, 0, (a,b) -> a);
		
		System.out.println(total);
		System.out.println(count);
		//System.out.println(filter);
		System.out.println(li);
	}
	static Integer sum(List<Integer> li)
	{
		return foldLeft(li, 0, (a,b) -> a+b);
	}
	
	static <A> Integer count(List<A> li)
	{
		return foldLeft(li, 0, (a,b) -> {
			int count = b;
			count++;
			return count;
		});
	}
	
	static <A> List<A> filter(List<A> li, Predicate<A> p)
	{
		
		return null;
	}
	
	static <A,B> List<B> map(List<A> li, Function<A,B> f)
	{
		return null;
	}
	
	static <A,B> B foldLeft(List<A> lst, B identity, BiFunction<A,B,B> f)
	{
		B accumulator = identity;
		for(A listItem : lst)
		{
			accumulator = f.apply(listItem, accumulator);
		}
		return accumulator;
	}
	
	/*static <A,B,T> B foldLeft2(List<A> lst, B identity, BiFunction<A,B,B> f /*,Predicate<T> p)
	{
		B accumulator = f.apply(lst.get(0), accumulator);
		
		return accumulator;
	}*/
}

// static int sum(int listItem, int total)
// static int count(int listItem, int total)

// static int filter(int listItem, List<Integer>)
// static int map(int listItem, List<Integer>)
