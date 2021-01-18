# Interface Lab

The purpose of this lab is to introduce you to interfaces, which is a
neat way to be able to use some of the benefits of polymorphism without
having the headaches of inheritance. While inheritance has its uses, one
of its biggest disadvantages comes when you want to borrow multiple
abilities from different classes. Java only supports inheriting from a
single class, while other languages that support multiple inheritance
often have some clunky constructs to help determine what to inherit from
which object. For example, if you wanted to create a ```ToyGuitar``` Class
that inherited from both ```Toy``` and ```Guitar``` and they both have a
variable called ```timesPlayed``` (where for toys it's the \# of times the
toy is switched on and off and for the guitar it's the \# of times
"Stairway to Heaven" has been performed), which ```timesPlayed``` should
```ToyGuitar``` inherit or modify when you reference ```ToyGuitar```? This can
become messy and quite buggy. However, one thing that that Java has
realized is that you should be able to "inherit" multiple sets of
behaviors. This is where interfaces come in. **Interfaces** are special
java files that allow us to declare methods, but provide no
functionality for those methods. Java allows classes to implement as
many interfaces as they like, which will become useful when you want to
tie two classes together in a more flexible way.

Let's start by downloading the **InterfacesLab.zip** file, which you can do
from canvas or [directly from here](http://go.djosv.com/interface)

Import that zip file [like you normally would](lab2media/media/image2.gif).

Let's do a quick representation of how the project works, you can scan
through the files if you like, but this is what we would like to have.

  - Once user opens the application, all entities are in a calm state.

  - Many different entities can be displayed on the screen (via editing
    code)

  - When the user clicks on the screen, the entities change their
    emotional state

  - The emotional states go from one to the next in a cyclical order.

For our program we are going to cycle through the three states common to
programming. Calm before programming, then a happiness as we are writing
code and excited with what we want, followed by Anger based off of the
frustration of having to spend more time than we anticipated looking for
bugs. Once we fix all of those bugs, then we will return back to being
calm, which lets us write more code.

All entities will share the same state.

Step 1: Make the ```Emotional``` Interface with ```beCalm()```, ```beHappy()```, and
```beAngry()```

Step 2: Have ```EmotionalOval``` implement this interface

Step 3: Make an ```EmotionalRect``` (can be a copy of ```EmotionalOval```)

Step 4: Change ```ExpressionManager``` to pass in ```Emotional```

Step 5: Make an ```EmotionalCharacte```r

You have to figure out what the goal is going to be of the interface lab
and how to improve it. What am I going to ask them to do? Make a new
class that they can then implement so that they create their own emotional state. 
