package com.example.sprintboot_test.fish2;

import java.util.Arrays;

public class GenericArrayHelper {
	public static <K, V> Entry<K, V>[] newEntryArrayOfSize(int size) {
		Entry<K, V>[] result = new Entry[size];
		return result;
	}

	public static <T> T[] copyArrayWithIncreasedSize(T[] array,
			int newSize) {
		T[] ts = Arrays.copyOf(array, newSize);
		return Arrays.copyOf(array, newSize);
	}

	public static <T> T[] copyArray(T[] array) {
		return Arrays.copyOf(array, array.length);
	}
}
