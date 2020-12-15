# HashMap Lab

This lab is reading heavy, but not too long. In this lab you're going to
learn

  - *What a HashMap is*

  - *How it differs from a Hashtable*

  - *How to store and retrieve items from a HashMap*

  - *In which ways HashMaps are useful*

## Hash-what?

Similar to an ```ArrayList```, a ```HashMap``` stores a collection of items. A
```HashMap``` is a standard part of the Java Library, similar to what some
of you may remember with the **map** STL library in C++. In COMP 53, you
may have some faint recollection of what a hashtable is, which was a
data structure that would allow us to search and store items into a
collection in constant O(1) time, which means that no matter the size of
the hashtable, you would be able to count on the running time not
increasing (as long as the number of buckets is roughly equal to the
number of items and you have a full hash function yada yada)

## Why didn't they just call it a hashtable then?

By calling it a ```HashMap``` java wants to make clear that ```HashMaps``` are
meant to form a bond between two items, whereas a hashtable might just
be a mechanism for having something in a collection and giving you a way
to look into the collection to quickly see if it exists. ```HashMaps``` are
often thought of or referred to as **dictionaries**. Like a dictionary,
when you end up looking up a word in a dictionary, you get a definition
for that word. In a way it links or maps the word with the definition.
In computer science lingo, the word would end up being called the
**key**, while the definition would be called the **value**. In order to
make ```HashMaps``` truly work, ```HashMaps``` have a condition that a key can
only correspond to one value. So for example, going back to the
dictionary example the key *nomophobia* would be linked to a specific
value: in our case, the value will be "*the fear of losing mobile phone
service*". For a HashMap, what you would do is put the key and value
pairs into a map and then retrieve them in the future.

## Basic HashMap Usage

Like an ```ArrayList```, we need to first let java know that we want to use
one of these data structures. One syntactical difference is that Java
would like to know the type for both the key and the value in the angle
brackets. While I have only shown strings, the keys and values can be
any type of Object. In this particular case though since the type of
both the definition and word are both strings we'll declare them in this
manner.

```java
HashMap<String, String> phobias = new HashMap<String, String>();
```

Now to create a linkage in the ```HashMap```. One would use the put call to
place something into the ```HashMap```.

```java
phobias.put("nomophobia", "the fear of losing mobile phone service");
```

to put more definitions, you would simply keep using the put call to
create more mappings between two objects.

```java
phobias.put("pentheraphobia", "the fear of your mother-in-law")
phobias.put("ergophobia", "the abnormal fear of work")
```

Then to get back the definition in the future, you would simply look up
the word again by using the get feature.

```java
String def = phobias.get("ergophobia")
// def now has the value "the abnormal fear of work"
```

If you try to get a phobia that has not been introduced into this
particular phobias map like say this one

```java
String possibleDef = phobias.get("osvaldophobia")
```

The ```HashMap``` will return ```null``` for any key that has not been
explicitly put in.

## More advanced rules for HashMaps

So one thing to remember that is that each key corresponds to one and
only one value object. So how does this work when you have multiple
objects that you want with similar values. Let's try this first.

```java
phobias.put("ponophobia", "the abnormal fear of work")
```

If you have been reading this document closely you may notice that we
already have a name for the abnormal fear of work in ergophobia. So now
we have two different keys that use the same value. This is OK. This
does not violate anything from a HashMap standpoint, since both keys
still have just one value. The opposite is where things get dicey,
however, let's explore how java will introduce this.

```java
phobias.put("nomophobia", "the fear of losing mobile phone service or
your mobile phone device")
```

Since our ```phobias``` HashMap already has a linkage with *nomophobia*,
Java will **replace** that linkage with the one given here. Thus, no
longer would the shorter definition be linked to *nomophobia*, but
rather the longer definition would. Each key can only correspond to one
value

## You said this was like a dictionary though, what if there are multiple meanings to the same word?

In that case if you want to store multiple meanings, you'll have to
select an object or class that will allow you to store multiple
meanings. For example, you can have a word that has multiple meanings
sometimes even contradictory. Let's start up another ```HashMap```, this
time for contronyms which are words that often have opposite meanings.
For example, think about the word "dust". Usually it means to take off
something right? For example, when you want to *dust* the furniture.
However, dusting a pan, may mean that rather than you taking something
away you are adding something to the pan, like you want to *dust* a pan
with flour. In this case the word **dust** has two meanings. Let's say
we want to create a map that has both. How would this be done? In this
situation we could create some really long string, but what we can do is
simply create a different linkage, one in which we'll link a word, with
another storage mechanism that would allow us to store multiple
definitions. The easiest structure you have for that is to use an
```ArrayList```. So we are going to link a key which will be a ```String``` with
a value that will be an ```ArrayList``` of definitions. Let's create the
```ArrayList``` first.

```java
ArrayList<String> dustDefs = new ArrayList<String>();
dustDefs.add("To take away fine particles");
dustDefs.add("To add particles");
```

Now to add create this linkage in a map, we'll create a new HashMap that
links the word with this arraylist that we just created.

```java
HashMap<String, ArrayList<String>> contronyms = new HashMap<String, ArrayList<String>>();

contronyms.put("dust", dustDefs);
```

Then, whenever you call get, you will store the value that receive back
from the HashMap as an arraylist. For example:

```java
ArrayList<String> wordDefs = contronyms.get("dust");
```

## Ok, so how do we really use this?

The possibilities are endless here\! Remember how we had some difficulty
with like getting all the properties for Rick's guitar into the
application? We kept having to change our structure to because of all
the fields that he had. Well what if instead of defining the fields
explicitly for each instrument if it became so flexible why not just
have a ```HashMap``` that contains all of the fields for the spec? Then you
would have something like this:

![](lab12media/media/image1.png)

Image taken from Head First Object Oriented and Analysis Book for
educational purposes.

Look at the properties Map. Map is the overall idea of linking to
things, we say ```HashMap```, because we want to use hash functions to allow
us to build something that will do these retrievals in constant time.

Then inside of ```InstrumentSpe```c, our properties variable would be a
```HashMap```, where we could say something like

```java
String builderName = properties.get("builder")
```

and we would return back ```"Builder.Martin"```

Then in our ```matches``` function for searching for specs we would have
something like this instead

```java
for(String key:properties.keySet()) {
    if(!properties.get(key).equals(otherSpec.getProperty(key))) {
        return false;
    }
}
return true;
```

Isn't that beautiful? We do lose something here by doing this which is
some type safety, but we add so much flexibility by not having to bind
which properties are with which instrument. Each instrument spec can
flexibly declare its own set of linkages between keys and values for
each of the properties that it wants to hold.

Similarly, here's something else that I see often that I think you guys
can think of doing in a nicer way (which in a way follows the instrument
example above)

```java
if(state == "up") {
    upOval.move(0, -5);
    sendMessage("north");
}else if(state == "down") {
    downOval.move(0, 3):
    sendMessage("south");
}else if(state == "left") {
    leftOval.move(-7, 0);
    sendMessage("west");
}else if(state == "right") {
    rightOval.move(8, 0);
    sendMessage("east");
}
```

Now there are plenty of variations to this, but they are largely the
same issue, which is that people feel that they cannot make this type of
function better, since there are too many things going on here. You have
different objects with different variables and parameters for each one.
How could this be cleaner? Let's first say what if we had some type of
```Movement``` class?

```java
public class Movement {
    private String direction;
    private int dy;
    private int dx;
    private GOval;

    //getters and such

}
```

Now what you can do is create a ```HashMap``` between this state and this
movement class.

For example:

```java
HashMap<String, Movement> moveMap = new HashMap<String, Movement>();

moveMap.put("up", new Movement(upOval, 0, -5, "north"));
moveMap.put("down", new Movement(downOval, 0, 3, "south"));
moveMap.put("left", new Movement(leftOval, -7, 0, "west"));
moveMap.put("right", new Movement(rightOval, 8, 0, "east"));
```

Then when you get to actually having to do this code, then you can write
this.

```java
Movement moveData = moveMap.get(state);
if(moveData != null) {
    moveData.getOval().move(moveData.getDX(), moveData.getDY());
    sendMessage(moveData.getDirection());
}
```

Now some of you may rightfully say that this is more code, but think
about what this represents. We are putting all of the code that deals
with changes in one place. And what would happen if we move to 8
directions? And then we also forgot that we need to add two more lines
of code inside of our if statement that needs more movement data?
Hopefully you start to see that this would be a cleaner solution.

# How do I get credit for this lab?

Part of the credit for this lab, will be talking with your teammates
first. What I'd like you to do as a team is to answer the four questions
at the beginning of the document and submit on canvas. For the useful
part, you will come up with at least three different potential places
where you could use a ```HashMap``` in your project, and to provide code for
what that would look like in terms of helping you make the project
better. Remember that what I've shown you here has been using mostly
strings as keys, however, your key can be any object that you choose.
Thing about how you could implement or link a ```GObject``` with a class, or
vice-versa. HashMaps are pretty cool and can save us a lot of work. If
you are the first one to finish reading, then go ahead and follow the
next set of steps, which is how to get additional credit for the lab.

# After you read

Go ahead and follow the link for <http://go.djosv.com/hashmap> and clone
the repository into eclipse, just like you've done before in the other
labs. What we are going to try to build today is an accessory that is a
very "essential" part of a DJ set (sarcastic voice here). What we are
going to do is create a very simple **Sampler**, or as I've called it a
**SoundBoard**, where we will create a couple of different ```GLabels``` and
when those different ```GLabels``` are clicked, we are going to play a
different sound effect. If this doesn't at all make sense, it will once
you start hearing the sound effects that we will be playing that you've
probably heard at some party. To start you off, you'll have two classes,
the ```SoundBoard```, which is a ```GraphicsProgram``` skeleton with a
```statusLabel``` and an ```AudioPlaye```r, which is a pretty nifty class that
you'll be able to use to play mp3's. All you'll need to do is to call
the AudioPlayer variable (in ```SoundBoard```, it's called ```player```) and
call the method ```playSound```. ```playSound``` takes in two arguments, a
*folder*, and an *mp3*. While you don't have to look too deeply in
```AudioPlayer```, if you do decide to open it up, you'll notice that
```AudioPlayer``` does in fact contain a ```HashMap``` that links a ```String``` in
this case a *filename*, to a ```MediaPlayer``` object.

The basic goal of extending the soundboard is to get add two ```GLabels```
and then when each of those ```GLabels``` is clicked, to play a particular
sound effect. While we could use a strategy of just creating the labels
and then having a gigantic if statement at the bottom that would try to
link a label to a sound, let's leverage using a ```HashMap``` instead. In
order to help us with this, let's first create an interface. **After
each step, please commit your changes with a short comment as to what
you did in the commit message.**

1)  Create an interface called **Playable** and insert the following two
    methods inside.

```java
public void play(AudioPlayer player, GLabel statusLabel);
public String getName();
```

Remember that interfaces allow us to create some objects that are much
more flexible. In this case we want to create an interface that allows
someone to just implement these two methods. One where we ask for a
string that gives us back a name, and the other which provides us with a
```AudioPlayer``` and a ```GLabel```, and we are asked to play a sound.

2)  Create a **SoundEffect** class that **implements Playable**

As part of this class, you'll need to have a constructor, as well as to
implement the two methods, play and ```getName```, which you should use
override for. Create a private String instance variable that you call
```name```. This will allow you to simply return that name for the ```getName```
method that ```Playable``` asks you to implement. To get this name, in the
constructor, just have a parameter that is a string that gets passed
into the constructor, so that you have something like this:

```java
public SoundEffect(String n) {
    name = n;
}
```

3)  In the play method for ```SoundEffect```, add a ```playSound``` method, by
    using the ```AudioPlayer```. If you use the same ```player``` variable, this
    would be as simple as adding this line into the ```play``` method.

```java
player.playSound("sounds", name + ".mp3");
```

You should also call ```setLabel``` on the label itself to update what it is
playing, which you can just say something like ```"playing: " + name``` as
the text inside the call to ```setLabel``` for the ```GLabel``` passed into
```play```. At this point your ```SoundEffect``` should not have any errors and
you should have three methods that have code implemented. A constructor,
a ```play``` method, and a ```getName```.

4)  Declare a ```HashMap``` instance variable in ```SoundBoard``` that links a
    ```GLabel``` to a ```Playable``` and initialize it in the ```run``` method. In
    this case your ```GLabel``` will be the key and the ```Playable``` will be
    the value. Are you not sure how to be able to declare a ```HashMap```?
    If you aren't, then you'll want to go back and look over the lab
    more closely. In this step, you are only creating the ```HashMap```, you
    will link items in Step 6.

5)  In ```SoundBoard```'s ```run```, create ```GLabel```s for both the ```"Ahh Yeah"```
    and the ```"Air Horn"```. Use the ```x``` and ```y``` constants, the ```name```
    constant, as well as the font string to set the label's font. You
    can use that named string constant to also create a ```SoundEffect```
    **object with that particular name in run too**. Because the project
    has "Ahh Yeah" and "Air Horn" mp3s, we'll rely on the named
    constants in the ```SoundBoard``` class to both create the ```GLabel``` and
    a ```SoundEffect``` that will play the files by the same name.

6)  Use the ```Hashmap``` that you created to link the ```GLabel``` key with the
    ```Playable``` object. Remember since ```SoundEffect``` is a ```Playable```
    object, you'll actually *link* the ```GLabel``` *with* a ```SoundEffect```.

7)  In ```SoundBoard```, finish implementing the ```mousePressed``` method,
    which should leverage the ```elem``` from ```getElementAt```. Inside the
    ```if``` statement where you are checking to make sure that ```elem``` is in
    fact a ```GLabel```, you can then get the ```SoundEffect``` from the
    ```HashMap``` and play it. Test it to make sure it does in fact play the
    sound and voila\! (You are done with the lab. If you'd like to be
    able to click the button to spam and restart the sound, you'll want
    to modify the ```SoundEffect``` class top the ```stop``` the sound before
    playing it.)

# Bonus

In class, you'll notice that I showed an explosion where the label
shakes up and down, (if I haven't shown you this, please ask me to\!).
To implement this correctly, think about making a new class called
```Explosion``` that inherits from ```SoundEffect```. You should also create a
class ```LabelShaker``` that has a ```GLabel``` as an instance variable and that
```implements ActionListener```. Then as part of the play start the ```Timer```
to move the label up and down, which uses the same mechanics from the
dance simulator for moving the label back and forth on each call to
```actionPerformed```.
