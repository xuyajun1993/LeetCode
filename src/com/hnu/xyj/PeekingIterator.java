package com.hnu.xyj;

import java.util.Iterator;

/**
 * Created by hzxuyajun on 2015/10/13.
 * Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().
 */
public class PeekingIterator implements Iterator<Integer>
{

	private Iterator<Integer> iterator;
	private Integer peek = null;

	public PeekingIterator(Iterator<Integer> iterator)
	{
		// initialize any member here.
		this.iterator = iterator;
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek()
	{
		if (peek != null)
			return peek;
		else
		{
			peek = iterator.next();
		}
		return peek;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next()
	{
		if (peek != null)
		{
			int temp = peek;
			peek = null;
			return temp;
		}
		return iterator.next();
	}

	@Override
	public void remove()
	{

	}

	@Override
	public boolean hasNext()
	{
		if (peek != null)
			return true;
		else
			return iterator.hasNext();
	}
}
