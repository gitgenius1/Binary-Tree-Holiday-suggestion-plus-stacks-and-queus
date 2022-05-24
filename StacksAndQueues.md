```
Stacks are LIFO

Cyan
Hello
Everyone
Blue
Green
Red
============================

- push = add to the top
- pop  = remove from the top
- peek = what's on the top?
- isEmpty = is there nothing in the stack?
```

# Start the example

```
============================
```

```java
stack.push("Red");
```

```
Red
============================
```

```java
stack.push("Green");
```

```
Green
Red
============================
```

```java
String latestColour = stack.pop();
```

```
Red
============================
```

```java
System.out.println(latestColour); // "Green"
```

```
// [4,8,9,3,1,0,0,0,0,0,0]
// [1,3,9,8,4,0,0,0,0,0,0]

/*
1
3
9
8
4
============================
*/

```

```java
while (!stack.isEmpty()) {
    list.append(stack.pop());
    // [1,3,9,8,4]
}
```


## Queues

Queues are FIFO.

` -> | b, d, e, h | ->`

- enqueue  = add value to the back of the queue
- dequeue  = remove value from the front of the queue
- isEmpty ...


` -> | b, d, e, h | ->`

```java
enqueue("a")
```

` -> | a, b, d, e, h | ->`

```java
dequeue() // returns h
```

` -> | a, b, d, e | ->`