package test;

import pro.ddopson.ClassEnumerator;
import java.util.List;

public class TestClassEnumeration {
	public static void main(String[] args) {
		System.out.println("Test class package name: "+TestClassEnumeration.class.getPackage());
		List<Class<?>> classes = ClassEnumerator.getClassesForPackage(TestClassEnumeration.class.getPackage());
		Class<?>[] expected = new Class<?>[] {
			test.ClassIShouldFindOne.class,
			test.ClassIShouldFindTwo.class,
			test.subpkg.ClassIShouldFindThree.class,
			TestClassEnumeration.class,
			TestClassEnumerationFindAll.class
		};
		for (Class<?> clazz : expected) {
			if (!classes.contains(clazz)) {
				System.out.println("FAIL: expected to find class '" + clazz.getName() + "'");
				System.exit(-1);
			}
		}
		if(classes.size() != expected.length) {
			System.out.println("FAIL: expected to find " + expected.length + " classes, but actually found " + classes.size());
			System.exit(-1);
		}
	}
}
