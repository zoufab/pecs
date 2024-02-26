## PECS

**P**roducer **E**xtends **C**osumer **S**uper

**1. Covariance**
```java 
? extends MyClass
```
MyClass is the highest in hierarchy of inheritance

>_"I can get it from the wildcard type **?**"_

>_"I can get values out of a structure."_

**2. ContraVariance** 
```java 
? super MyClass
```
MyClass is the lowest in the hierarchy of inheritance.

>_"I can give it to the wildcard type **?**"_

>_"I can put values into a structure."_

**3. NonVariance/Variance**
```java
MyClass
```

## Examples

```java
abstract A {}

class B extends A {}

class C extends B {}


public class Pecs{

	public void testCovariance(List<? extends B> elements){
		B b = new B();
		C c = new C();
		A a = elements.get(0); // PASS: We know th return type, necessarily a subtype of B
		
		elements.add(b); // Exception : ambiguous type given to the structure, include b
		elements.add(c); // Exception
	}


	public void testContraVariance(List<? super B> elements){
		B b = new B();
		C c = new C();
		elements.add(b); // PASS : We know the super of the element's type given to structure, necessarily B at least
		elements.add(c); // PASS
		
		A a = elements.get(0); // Exception : ambiguous type out of structure
		Object a = elements.get(0);
	}

}
```

### Subtype and wildcards
**super** : data in

**extends** : data out

### Reflection and Raw types
Generic information can't reflect because it gets erased at compile time
Raw types represent a type without a parameter `MaClass.class`

### Lambdas and Intersection types
- Lambda: look at the target type, have their types inferred, use funtionnal interface
- Intersection types : <T extends A & B> is a powerful system
	`T extends Object & Comparable<? super T>`
