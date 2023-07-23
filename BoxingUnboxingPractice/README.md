From a computer programming perspective, we can understand boxing as a wrapping operation to transform a primitive type into an object (wrapper datatype).

Boxing typically uses object pointers to store value on the heap. Once we box a datatype, we get an object. This object uses more memory and is relatively complex. After that, the system stores this object on the heap. Hence, we consume more memory and have increased lookup time.

Unboxing is the reverse transformation of boxing. So, we extract the primitive value of an object from its wrapper object.

More info on : https://www.baeldung.com/cs/boxing-unboxing#:~:text=Boxing%20is%20the%20process%20of,to%20the%20native%20primitive%20value.
