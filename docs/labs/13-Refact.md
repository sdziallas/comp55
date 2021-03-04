# Refactoring Lab

By this point you should have a feeling that there many different ways
for someone to write code, and one thing that we would like to do in
this class (and for you do in the future) is to make sure you write your
code in a way that can make it easy to change and be flexible.
**Software changes**. Most of the time we are worried about correctness
or speed, but we should also concentrate on readability. This is
especially true when we are coding with other people. If the code ends
up being difficult to read or overly complicated, it's less likely to be
tested and reviewed for errors. What we are going to do today is start
learning strategies we can use to do what's called **refactor code**,
which means to revise the code. Refactoring not only can increase
readability, but it can also reduce complexity, which will make your
code easier to test and debug.

## The biggest culprit (*if statements*)

In case you don't know, I'm not a big fan of ```if``` statements. If
statements are often overused, especially by budding programmers. The
most common issue I encounter with 55 students is their justification
for an if statement that subsequently mutates into many ```if``` statements,
when in fact if they re-thought their logic they most likely would need
only one or two. This becomes very egregious when the ```if``` statements
then lead to code that looks mostly the same in the different sections
of the if statement, resulting in the loss of many kittens from all the
copying and pasting that is being done. This lab will go over a set of
steps that you can perform so that you eliminate redundancy and
complexity from your code, which is a win for everyone. Today is about
teaching you some of the common steps you can take to refactor your
code. Let's go over some basics first. You'll see code in different
colors based on whether it needs to be refactored or not, with red being
problematic, yellow being somewhat troublesome and green often being a
good example to follow.

### Principles to follow

1)  **If you see a comparison to a boolean, take it out. If the boolean
    is false, simply use a negation**

Ie:

```if(isLow == true)``` =\> ```if(isLow)```

```if(isLow == false)``` =\> ```if(!isLow)```

2)  **Avoid using negations**

Negations can often be rewritten or restructured. For example, in the
step above, if ```isLow``` is only being used once and you are constantly
checking ```if(!isLow)```, then why not change the variable to make it
```isHigh```? There are usually ways for you to minimize the amount of
negations that you have, as negations just make things confusing. If you
don't believe me, then just think about what this statement means here
in English.

```java
if(x != 4 || x != 5)
```

While many of you look at it and think that the statement evaluates to
true for numbers that aren't equal for four or five. *It actually works
for all numbers.* You can use some boolean theory to extract out this
statement to its equivalent version, which is here

```java
if(!(x == 4 && x == 5))
```

Based on DeMorgan's laws, the two statements here are exactly the same,
yet one is more confusing to decipher.

3)  **If you have an if/else statement and all it's doing is returning
    true or false based on the condition, use a single return statement
    instead.**

Ie:

```java
if(isLow) {
    return true;
}else{
    return false;
}
```

All of this can be written as:

```java
return isLow;
```

4)  **If you see a lot of code that looks similar in each branch of an
    if/else statement, take the necessary steps so that it is not
    repeated.**

The easiest way to deal with this is when the code looks exactly the
same in both sections:

```java
if(x > 5) {
    x+=10;
    System.out.println("now pick the next number");
}else{
    x-=10;
    System.out.println("now pick the next number");
}
```

Most of the time you will have code at the beginning or the end of the
curly braces that is in both sets of statements. If it is the same at
the beginning, take it out of the ```if``` statement, and then place it
either before or after the if statement depending on where it's located.
In this instance, we can simply do this

```java
if(x > 5) {
    x+=10;
}else{
    x-=10;
}

System.out.println("now pick the next number");
```

While this example may seem highly trivial, slightly more complex
versions of this tend to happen in many places. Sometimes students will
see that one small change happens in the middle of six lines of code,
and for that reason end up repeating everything, when some should be
moved before the if statement and the other lines should be moved after.

5)  **If you do see if statements that look the same, but feel that it
    needs to be repeated, ask yourself – "Is there some way to
    standardize the operations by storing the different information in
    variables?"**

I get it, the last example was quite trivial, which we are doing for the
sake of having a short lab, but many COMP 55 students are guilty of
doing something slightly more extravagant, but I would call equally into
question. Let's elaborate on our previous example a little more.

```java
if(x > 5) {
    System.out.println("I'm going to add 7 here");
    x+=7;
    System.out.println("now pick the next number");
}else{
    System.out.println("I'm going to subtract 10 here");
    x-=10;
    System.out.println("now pick the next number");
}
```

You may have seen code that looks similar to this before, you have some
branches in your code that have some differences, and so you tend to
write them out. However, in both branches, you are printing out a
message, doing some addition/subtraction, and then printing out another
message.

Remember that subtraction can always be made to be addition, which means
that we can change our text slightly. And there are different ways to do
this, but here's a slightly better solution

```java
int amount = -10;
String action = "subtract";

if(x > 5) {
    amount = 5;
    action = "add";
}

System.out.println("I'm going to " + action +
Math.abs(amount) + "here");
x+=amount;
System.out.println("now pick the next number");
```

You may look at the above solution and think "*Lolz well that's the same
number of linezzz*" as the previous set of statements and believe that
therefore both snippets are the same, however, this is one simple
example of the type of scenario where that would happen, and what we are
doing is what the book said, which is trying to separate out only what
is different between the two cases. **The point is for you to think
about all the scenarios where code in different if sections is the same,
and then to figure out what does not have to be repeated over and over
again. Whatever both pieces share should seriously be considered for
rewriting.** Also, for those of you who are curious, the reason that we
have this as a single if statement is because of traditional languages
forcing you to declare variables in both the if and the else statements.
In our case, since we need the variables, we simply start by declaring
them and then having an if handle the alternate case to change their
values. Otherwise, if we were using other languages, we could do an if
else at the top if you really wanted to.

Again, while the previous code may not feel like much of an improvement,
I would argue that the following code does a better job as it is more
readable

```java
if(x > 5) {
    takeAction("add", 5);
}else{
    takeAction("subtract", -10);
}

// Meanwhile, in some other part of the code... (future snippets will use -------)

private void takeAction(String action, int amount) {
    System.out.println("I'm going to " + action +
    Math.abs(amount) + "here");
    x+=amount;
    System.out.println("now pick the next number");
}
```

Again, these are trivial examples, but it's important that you
understand that in most situations, having this latter version is going
to be better than the previous action that you created because we are
reducing the amount of duplicate code. Ultimately, depending on what we
were trying to do with the function, ```takeAction```, we could decide to go
further with that function by for example taking out the action to add
or subtract as something that is being passed in as a string. I only
provide that here to show how the refactoring would be done. If I were
to refactor this method again, I would most likely just include the
number and then inside of the function figure out if it's positive or
negative so that I can provide the correct label (add or subtract).
Another part of making functions is not just to refactor the code, but
to make the functions usable to people in the future and reduce the
amount of errors that you could get while making it easy for your
teammates to use.

```java
if(x > 5) {
    takeAction(5);
}else{
    takeAction(-10);
}

// ----------------------------------

private void takeAction(int amount) {
    String action = "add";

    if(amount < 0) {
        action = "subtract";
    }

    System.out.println("I'm going to " + action +
    Math.abs(amount) + "here");
    x+=amount;
    System.out.println("now pick the next number");
}
```

For those of you who would like to go further or don't want the extra
amount here, you could go with the ternary operator as well to eliminate
the extra lines of code

```java
private void takeAction(int amount) {
    System.out.println("I'm going to " + (amount > 0)? "add":"subtract" + Math.abs(amount) + "here");
    x+=amount;
    System.out.println("now pick the next number");
}
```

The ternary operator is not something that is used frequently however as
it makes the code dense. Again, like I mentioned up at the top, writing
code is expressive and there are different options or strategies that
you can take. *However, the biggest thing that I would like you to get
out of this class is to stop repeating and pasting so much code.* For
the purposes of this class, I'm going to be looking a lot at the code
that you are writing and making sure that there isn't much repetition in
it. **<u>The amount of repetition that you have in your code will impact
your final project grade.</u>**

6)  **Are you making a lot of variables? Consider using a list or other
    data structure to store them instead.**

I think for the purpose of this project, it's pretty easy to start
thinking of making instance variables for everything. Instance variables
are nice because they are visible in all methods of every method in a
class, which means you don't have to worry about passing information to
and from a function. 

However, the ability to pass information back and
forth between methods and understanding scope is an important tenet in
developing software. Otherwise, having so many instance variables is
akin to giving everyone in your dorm a key to your room. Sure it's
convenient to give everyone a key, but it's not secure, and more
importantly when you're trying to debug and figure out who borrowed your
Playstation, it makes it that much more difficult to find out who it was
and when it happened. Also, it could lead to situations where people
start using your room for other purposes that you wouldn't necessarily
want (feel free to let your imagine roam for a minute here if you want).

Like with your dorm room, there are situations in which your program and
all of your functions do not need to have access to every single one of
those instance variables, so consider using local variables when a
variable is only needed in one function. If you do need to have a
collection of variables, like say when you need to keep track of
multiple ```GObject```s on the screen, it may make more sense for you to
create all of the objects and store them in a list, or potentially a
```HashMap```. This also makes it nice because then you could possibly
create a loop and function that will create a series of these objects,
like for example buttons, where you extract out to the method all of the
common things needed for a button. 

Here is a pseudo code as an example:

```
void makeButton(String label, double x, double y, double width, double height, Color col) {
       ....
       List <GButton> listOfButtons = new ArrayList <GRect>();
       for (int i = 0; i < 5 < i++) {
          GButton knob = new GButton (label, x, y, width, height, color);
          listOfButtons.add(knob);
        }
        ...
}
```

If you are creating 5 buttons,
wouldn't it be nice to have a function that was like makeButton(30, 30,
100, 100, "OK", Color.BLUE) and then know it that it will just show up?

7)  **Does the code look confusing? Consider making methods to help you
    make parts more readable.**

If there are sections of code that look crazy, or feel dense, it's best
to go back through and look into making those methods into classes,
since that will make the code more readable, and if you come up with
methods that have return values based on parameters, will make them
easier to generate test methods for as well, since you'll be able to
say, *when I expect this, I should get back this*, which is the basis of
unit testing that we went over in the previous lab.

To be honest, I think a lot of the issues that I see with student code
in COMP 55 is the lack of methods/functions that they tend to create for
a variety of reasons. I understand that making them takes time, but
again, remember that eclipse does offer the *Alt-Shift-M* keyboard
shortcut to help you make or extract a method out of a piece of code, so
I would encourage you to use that to make things more readable and more
testable. Having more methods easily outweighs any insignificant (if any
at all) performance hit you'd get from having them.

8)  **Do you see a number over and over and over again? That should be a
    constant. If a formula is repeated that either needs to be in a
    variable or in a function**

If a number is specified in your code and it isn't a 0, 1, or 2, then I
generally have a rule of declaring it as a constant. If you have a
number say 30, or 300 or 50 that is used more than once, it should
definitely be defined as a constant. Let's take this example:

```java
body = new GOval(200, 400, 100, 100);
head = new GOval(225, 350, 50, 50);
```

While this situation is slightly more complex, the numbers are much more
likely to be repeated.

In this case, let's first take the number 100, which seems to be the
size of the body. You could simply decide to make that a constant that
you could change up top.

```java
public static final int SIZE = 100;

// ----------------------------------

body = new GOval(200, 400, SIZE, SIZE);
head = new GOval(225, 350, 50, 50);
```

But why stop there? Use formulas to establish the relationships between
all of these numbers, since they really are in this case referencing
each other.

```java
public static final int SIZE = 100;
public static final int BODY_X = 200;
public static final int BODY_Y = 400;

// ----------------------------------

body = new GOval(BODY_X, BODY_Y, SIZE, SIZE);
head = new GOval(BODY_X+SIZE/4, BODY_Y-SIZE/2, SIZE/2, SIZE/2);
```

Here, we are establishing, other norms for your program that help you
think of how the numbers relate to each other. Now we make it easier for
you to increase the size as well as move the ovals and not have to do
any of the calculations yourselves. Now, how you work this, you may
decide that the two 100's here are merely a coincidence. If that's the
case, then you could create two variables instead. Declaring constants
makes your code more readable and more readily changeable. While the
previous example is on the extreme end, there are many situations where
code tends to have the same number egregiously littered everywhere.
Convert that number to a constant, since if you change it one place, it
should change in the others as well. This makes a lot of sense to do as
well with filenames, to make them string constants or even to
concatenate strings. For example, here was my traffic jam way of reading
files from the project. Which were *images/car.png,
images/car\_vert.png, images/truck.png, images/truck\_vert.png*, etc.

```java
public static final String IMG_EXTENSION = ".png";
public static final String V_IMG_ENDING = "_vert";
public static final String IMG_PATH = "images/";

// ----------------------------------

private void drawCar(Vehicle v) {

    String suffix = IMG_EXTENSION;
    if(v.isVertical()) {
        suffix = V_IMG_ENDING + suffix;
    }

    GImage g = new GImage(IMG_PATH + v.getVehicleType() + suffix, …)
```

Your goal is for the rest of class to take these rules and to look over
the project that I've given you, and by the deadline come up with a
refactored solution that still works. **Don't spend your time playing
and exploring the game**, but rather reading the code and making
changes. This isn't as much about testing and looking for bugs or
critiquing as much as practicing the refactoring principles I've given
you here. Credit will be given on how much more readable, flexible and
possibly simple the code is in relation to the original. **You can work
on this project in pairs, but should not break up or attempt to break up
the work. Rather you should work on it together, propose ideas to each
other about how to refactor and what should be refactored.** This is not
group work but team work. If you're unsure where to start, I would start
by looking at any of the classes that have a *Pane* in the name of the
java file. You should commit changes everytime you have a factor that
you'd like to propose…change it and then commit and push. Good luck\!
