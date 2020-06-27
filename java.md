## PECS

**P**roducer **E**xtends **C**osumer **S**uper

**1. Covariance**
```java 
? extends MyClass
```
MyClass est la plus haute dans la hierachie des héritages

>_"I can get it from the wildcard type **?**"_

>>_"I can get values out of a structure."_

**2. ContraVariance** 
```java 
? super MyClass
```
MyClass est la plus basse type dans la hierarchie des heritages.

>_"I can give it to the wildcard type **?**"_

>>_"I can put values into a structure."_

**3. NonVariance/Variance**
```java
MyClass
```

## Exemples

```java
abstract A {}

class B extends A {}

class C extends B {}


public class Pecs{

	public void testCovariance(List<? extends B> elements){
		B b = new B();
		C c = new C();
		A a = elements.get(0); // PASS: On connait le type d'élément produit, qui est forcément un sous type de B
		
		elements.add(b); // Exception : ambiguité sur le type de l'élément à fournir à la structure, b inclus
		elements.add(c); // Exception
	}


	public void testContraVariance(List<? super B> elements){
		B b = new B();
		C c = new C();
		elements.add(b); // PASS : On connait le super type d'élément à introduire qui est forcément au moins B (minimum)
		elements.add(c); // PASS
		
		A a = elements.get(0); // Exception : ambuiguité sur le type de l'element produit
		Object a = elements.get(0);
	}

}
```

### Application
Nous pourrons maintenant illustrer le principe via une fonction prenant une entrée et une sortie. 
On pourra ainsi introduire la notion de **SUPPLIER** et **PRODUCER**
```java
public interface Function<? super I, ? extends O>{
	public O apply(I input);
}
```

### Subtype and wildcards
super : data in
extends : data out

### Reflection and Rawtypes
Generic information can't reflet because it get's erased at compile time
Rawtypes represent a type without a parameter `MaClass.class`

### Lambdas and Intersection types
- Lambda: look at the target type, have their types inferred, use funtionnal interface
- Intersection types : <T extends A & B> powerful
	`T extends Object & Comparable<? super T>`
