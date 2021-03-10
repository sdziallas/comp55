# Part 2 of the HashMap lab

If you didn't read part 1 of the HashMaps lab, realize there are some puntos involved with that lab, so [go back to that lab](12-Hash.html) before continuing.

[**Click here to start this part of the lab**](http://go.djosv.com/hashmap) and clone
the repository into eclipse, [just like you've done](lab8media/media/importrepo.gif) before in [the other
labs](lab8media/media/importfromgit.gif). 

What we are going to build today is an accessory that is a
very 🙃 *essential* 😏 part of a DJ set 🙄. We are
going create a very simple **Sampler**, aka a
**SoundBoard**, where we will create a couple of different ```GLabel```s and
we are going to play sound effects when each of those different
 ```GLabel```s are clicked. If this doesn't at all make sense, it will once
you start hearing the sounds, as they will make you reminisce about those days at a party ✨🎉✨. To start you off, you'll have two classes,
1. ```SoundBoard```, which is a ```GraphicsProgram``` skeleton with a
```statusLabel```
2. ```AudioPlayer```, which is a pretty nifty class that
you'll be able to use to play mp3's. All you'll need to do is to call
the AudioPlayer variable (in ```SoundBoard```, it's called ```player```) and
call the method ```playSound```. ```playSound``` takes in two arguments, a
*folder*, and an *mp3*. While you don't have to look too deeply in
```AudioPlayer```, if you do decide to open it up, you'll notice that
```AudioPlayer``` does in fact contain a ```HashMap``` that links a ```String``` in
this case a *filename*, to a ```MediaPlayer``` object.

The basic goal of extending the soundboard is to add two ```GLabel```s
and then when each of those ```GLabel```s is clicked, to play a particular
sound effect. While we could create the labels
and then have a gigantic ```if``` statement at the bottom that would try to
link a label to a sound, let's leverage using a ```HashMap``` instead. In
order to help us with this, let's first create an interface. **After
each step, please commit your changes with a short comment as to what
you did in the commit message.**

1. Create an interface called **Playable** and insert the following two
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

2. Create a **SoundEffect** class that **implements Playable**

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

3. In the play method for ```SoundEffect```, add a ```playSound``` method, by
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

4. Declare a ```HashMap``` instance variable in ```SoundBoard``` that links a
    ```GLabel``` to a ```Playable``` and initialize it in the ```run``` method. In
    this case your ```GLabel``` will be the key and the ```Playable``` will be
    the value. Are you not sure how to be able to declare a ```HashMap```?
    If you aren't, then you'll want to go back and look over the lab
    more closely. In this step, you are only creating the ```HashMap```, you
    will link items in Step 6.

5. In ```SoundBoard```'s ```run```, create ```GLabel```s for both the ```"Ahh Yeah"```
    and the ```"Air Horn"```. Use the ```x``` and ```y``` constants, the ```name```
    constant, as well as the font string to set the label's font. You
    can use that named string constant to also create a ```SoundEffect```
    **object with that particular name in run too**. Because the project
    has "Ahh Yeah" and "Air Horn" mp3s, we'll rely on the named
    constants in the ```SoundBoard``` class to both create the ```GLabel``` and
    a ```SoundEffect``` that will play the files by the same name.

6. Use the ```Hashmap``` that you created to link the ```GLabel``` key with the
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
```implements ActionListener```. Then, in the ```play``` implementation,  start the ```Timer```
to move the label up and down, which uses the same mechanics from the
dance simulator for moving the label back and forth on each call to
```actionPerformed```.
