package com.example.zelda.engine;

import java.util.Comparator;

/**
 *
 * @author maartenhus
 */
public class GObjectComparator implements Comparator<Object> {
	public int compare(Object obj1, Object obj2) {
		var gobj1 = (GObject) obj1;
		var gobj2 = (GObject) obj2;

		return Integer.compare(gobj1.getZ(), gobj2.getZ());
	}
}
