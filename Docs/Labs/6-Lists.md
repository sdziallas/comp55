# ArrayLists

**```**ArrayList``` is a special Java collection that makes keeping track of
multiple items (what we normally use Arrays for) much much easier.
```ArrayList```s are similar to ```Vector``` in C++ in that they:

  - Don't have some absolute size limit like arrays, they just keep
    growing as you add more items.

  - Can tack items to the end of an array by simply calling add along
    with the item to be added.

  - Can insert items into the middle of the list without worrying about
    whether or not you shifted all the elements over.

  - Can remove items from the list by calling remove on the list in a
    variety of ways either searching for the object to remove or
    removing at a particular position. The list will automatically
    shrink.

  - Can cycle through the ```ArrayList``` in a very shorthand and awesome
    way.

```ArrayList```s do have an array under the hood, and so we can still access
them like arrays, except instead of using the bracket notation we use
*get* and *set* methods. In order to use array lists, you'll need to
```import java.util.*;``` which is the package that has the ArrayList code.

What's the con? Well one con is the additional syntax. You have seen
this syntax before in C++, which is specifying the type of ArrayLists by
using Angle brackets ```<>```. So to make an ```ArrayList``` of type ```String```,
you would do ```ArrayList<String> ids = new ArrayList<String>();``` This
would create an empty list called ```ids```. If you wanted that list to hold
```GOval```s instead, you would have to change the type inside the angle
brackets to be a ```GOval``` on both ends.

The other con is that they don't work directly with primitives like
```int``` and ```double```. To use primitives as lists it is a little bit more
cumbersome. To create an ```ArrayList``` of ```int```s, we have to use an object
type called ```Integer```. After doing so, Java will then take the integers
and magically box them into ```Integer``` objects that simply contain the
number. These are not really needed for the assignment though, so if
you'd like to learn more, you can go off and learn about them on your
own. You may also need them for the bonus section.

Here's some code to show you how awesome ```ArrayList```s are. This presents
most of the functionality that you will need for the project. This will
do what you expect, including the printing of the names. If you want
more information on the different methods that you can call on an
```ArrayList```, you can visit java docs by googling **"java arraylist
api"** which should take you to a site like this

<https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html>

Here is some sample ArrayList code.

```java
void foo() {
    ArrayList<String> names = new ArrayList<String>();
    names.add("Osvaldo");
    names.add("David");
    printList(names);
    names.remove("Osvaldo");
    printList(names);
}

void printList(ArrayList<String> list) {
    for(String s:list) {
        System.out.println(s);
    }
}
```

## **Completing this mini-lab**

To complete this lab, you are going to copy your **Ball.java** file from
the Interactivity lab and paste it in that same project (*Make sure to
cover the Ball portion of the Interactivity Lab before attempting this
lab*). You can rename the file **Balls.java**, since your end goal will
be to have multiple balls bouncing off the screen. You'll also have the
program change a single ball's color when that particular ball is
picked. Let's start by introducing a constant in your file ```NUM_BALLS```
that will store 2.

Go ahead and place this value as a constant before your instance
variable declarations

```java
public static final int NUM_BALLS = 2;
```

Then declare an instance variable that will store an **ArrayList** of
**GOvals**, and call that variable **balls**. Next at the beginning of
**run()**, create the **ArrayList** object by saying

**balls = new ArrayList\<GOval\>();**

Then, you will change the code where you created your original ```GOval```
ball, and surround those four lines (*including the* ```add(ball)```) in a
```for``` loop that repeats ```NUM_BALLS``` times. In addition to adding the
ball to the screen, you'll need to add the ball to the list. *This means
that after* ```add(ball)``` *you should write* ```balls.add(ball);``` which will
add the ```ball``` to your list of ```balls```.

Go ahead and *run the code* right now, and notice how it looks the same
initially. However, as you let the program run, you'll notice what looks
to be one ball that is still and another that is moving. Because we have
an ArrayList, we looped through to create the balls, but we did not loop
through to create the balls in different places, as each time through
the loop we are giving the ovals the same coordinates to start at, which
simply puts them on top of each other. An easy way to solve this is that
rather than having the x in the new ```GOval``` always be ```WINDOW_WIDTH/2 –
BALL_SIZE/2``` , we can make the oval be ```(i*(WINDOW_WIDTH/3)) –
BALL_SIZE/2```, then have the for loop start at 1 and go to three. By
doing this, it would place the first ball at 1/3 of the width of the
window and the second ball and 2/3 of the width of the window. Run the
program again and the two balls should now be at different positions,
and one ball will be the only one moving.

## **Making all balls move**

Just like you did in creating multiple GOvals, the trick with making all
the balls move is to go through the list and call move on each one. You
can do this **by surrounding the code that moves the ball and changes
the direction inside of a for loop**. Because it's very common to
iterate through a list, Java has provided an alternate loop syntax for
cycling through a list.

```java
for(Elem e:list) {
    // Do something with e here
```

Where ```Elem``` is the **type**, ```e``` is the name of the variable for that
type and ```list``` is the variable name of the list.

In our case, you would write

```for(GOval ball:balls)```, which would now allow you to reference each
oval in that list and call it ```ball``` **while inside the** ```for```
**loop**.

To be sure you understand what is happening, the above for loop is
equivalent to writing this:

```java
for(int i = 0; i < balls.size(); i++) {
    GOval ball = balls.get(i);
    // Do something with ball here
```

You can also surround your ```mousePressed``` code with the same type of for
loop, so that you change the color of the ball that you clicked on. One
thing to know about the simplified version of the for loop is that you
**cannot use remove elements from the list while iterating through it.**
Doing so would raise an exception, so if you are at all confused, you
can always go back to using the standard for loop syntax shown above to
iterate through a list instead.

When you run the program, you'll notice that the balls are all moving in
the same direction and don't work independently. That is all you need
for this mini-lab. When that is done, you can submit the text of the
java file online via canvas. Just copy and paste the code into the
editor into the canvas submission page for Ball.java.

## **Bonus: What? The balls don't move independently\! I gotta make them all bounce around the screen.**

Well that's outside of the scope of learning about Arraylists for this
lab. But to get each one to bounce around the screen, that means that
each ball will need its own ```xVelocity``` and ```yVelocity```. One way to
ensure that is to create a ```Ball``` class so that each ball can store its
own ```x``` and ```y``` velocity as well as a ```GOval```, but for this lab, you
could just make a parallel ```ArrayList``` for ```xVelocities``` and another
parallel ```ArrayList``` for ```yVelocities```. Doing so would probably mean
that you would want to use the more generalized version of the ```for```
loop that uses an ```i``` variable, so that you can use the same index (```i```)
to link a particular ```GOval``` with an ```xVelocity``` and ```yVelocity``` if
you'd want. If you do this while passing in a ```Goval``` into
```outOfBounds``` called ```ball```, then you should be good to go. You can also
have them move in random locations by using a ```RandomGenerator``` like you
had in Roulette and then use ```nextInt``` to generate a low and high, which
could be used for the x and y velocity for each ball. Let me know if you
have any questions.

Good luck\!
