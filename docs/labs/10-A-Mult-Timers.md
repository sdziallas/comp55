# Multiple Timers

If you haven't read the [previous lab on timers](10-Timer.html),
then please go back
and take a look at that.

As you continue working with timers,
you may eventually want to utilize multiple timers within the same class
for different purposes.

*Note: There are two categories that you must distinguish when considering the idea of "multiple timers":*

1. You have different tasks affecting the *same resources*,
with timing being an important deciding factor.
(aka. **shared resources**)

2. You have different tasks affecting their *own resources*,
with timing being trivial. (aka. **unique resources**)

For *shared resources*,
you do **not** actually need more than one ```Timer```.
As a matter of fact,
introducing
more than one timer variable can create concurrency issues as the timers are not guaranteed to affect the
shared resources in a specific order every time the program executes.
To handle different timer tasks that
use the same resources,
follow one of the following two approaches depending on timing:

## Simulating multiple tasks on shared resources at different times with a single timer

Imagine that we want to create a program where we have two tasks that happen at different times but affect the same resource (ex: *Task A should occur every 3 sec,
Task B should occur every 4 sec*)

To do this,
follow,
these steps:

### 1. Create and initialize a variable that keeps track of the number of times the timer is called

```java
int timesCalled = 0;
```

### 2. Ensure that the timer runs every second through its delay value (1000)

```java
Timer myTimer = new Timer(1000,
objectToUseTimer);
```

### 3. Handle the different tasks in ```actionPerformed```

First increment the value of ```timesCalled```.
Then make use of the modulo operator (```%```) and if-statements to differentiate the tasks:

```java
timesCalled++;
if (timesCalled % 3 == 0) {
    //Task A
}
if (timesCalled % 4 == 0) {
    //Task B
}
```

This type of implementation will always work,
the only small caveat is that it may affect performance if what is implemented in ```actionPerformed``` is in fact long.
But for 95% of you,
if you understand this approach,
I am OK with you using this.
In fact in previous classes this is what I would recommend students to do.

## Implementing multiple timers for tasks that work on unique resources

For instances where each task will work on its own unique resource,
multiple timers are acceptable and will not cause concurrency issues because as long as either of the timers do not change shared resources.

You can have multiple timers that each have a different listening object.
This would allow you to separate the ```actionPerformed```.

```java
Timer myFirstTimer = new Timer(1000, objectToNotifyOfTimer);
Timer mySecondTimer = new Timer(1000, otherClassToNotifyOfTimer);
```

In this situation,
both classes can will receive the action performed method that corresponds to their own timer.
This would be the preferred way of implementing this.
However,
for many of you,
you may want to have the same object listen to both timers.
In that situation,
you would setup the timers like this:

```java
Timer myFirstTimer = new Timer(1000, objectToUseTimer);
Timer mySecondTimer = new Timer(1000, objectToUseTimer);
```

```java
public void actionPerformed(ActionEvent e) {
    //...
}
```

With the way ```actionPerformed``` is currently set up,
there is no way to differentiate between tasks that
should be completed for each timer.
To properly handle this,
you want to use the ```getSource```
function and compare its return value to the timers you created:

```java
public void actionPerformed(ActionEvent e) {
    Object source = e.getSource();
    if (source == myFirstTimer) {
        //Tasks for the first timer which affect item X
    }
    else if (source == mySecondTimer) {
        //Tasks for the second timer which affect item Y
    }
}
```

Now you should have a better understanding of how to deal with multiple timer-related tasks!
