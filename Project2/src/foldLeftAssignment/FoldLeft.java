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
		System.out.println("pre-collect: " + lli);
		Stream<Stream<Integer>> ssi = lli.stream().map(List::stream);
		
		Stream<Integer> si = ssi.flatMap(x -> x);
		List<Integer> test = Arrays.asList(0);
		
		List<Integer> li = si.collect(Collectors.toList());
		int total = sum(li);
		int count = count(li);
		List<Integer> filter = filter(li, a -> a % 2 != 0);
		List<Integer> mapp = map(li, a -> a*2);
		
		System.out.println("list: " + li);
		System.out.println("total: " + total);
		System.out.println("count: " + count);
		System.out.println("filter: " + filter);
		System.out.println("map: " + mapp);
		
		List<String> ls = Arrays.asList("Mike", "Andrew", "Alex", "Matt", "Samson", "Mark");
		
		System.out.println("\nList: " + ls);
		List<String> flsOne = filter(ls, a -> a.charAt(0) == 'M');
		System.out.println("filter: " + flsOne);
		List<String> ammendedls = map(ls, a -> a+" Wright");
		System.out.println("map: " + ammendedls);
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
	
	static <A,B> List<B> filter(List<A> li, Predicate<A> p)
	{
		List<B> lst = new ArrayList<B>();
		List<A> temp = new ArrayList<A>();
		B value = null;
		
		for(A listItem : li)
		{
			temp.add(listItem);
			value = foldLeft(temp, value, (a,b) -> {
				if(p.test(a))
				{
					return (B) a;
				}
				else
				{
					return null;
				}
			});
			if(value != null)
			{
				lst.add(value);
			}
		}
		return lst;
	}
	
	static <A,B> List<B> map(List<A> li, Function<A,B> f)
	{
		List<B> lst = new ArrayList<B>();
		List<A> temp = new ArrayList<A>();
		B value = null;
		
		for(A listItem : li)
		{
			temp.add(listItem);
			value = foldLeft(temp, value, (a,b) -> f.apply(a));
			lst.add(value);
			temp.clear();
		}
		return lst;
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
}
