Declare a ```HashMap``` instance variable in ```SoundBoard```
that links a ```GLabel``` to a ```Playable``` and initializes it in the ```run``` method.
If it doesn't recognize HashMap,
make sure you ```import java.util.*;``` or do ***Ctrl-Shift-O***.
In this case, **a ```GLabel``` will be the key and the ```Playable``` will be the value**.
Are you not sure how to be able to declare and initialize a ```HashMap```? 
If you aren't sure,
then you'll want to go back and [look over the lab](12-Hash.html) more closely.
In this step,
you are only creating the ```HashMap``` (~2 lines of code),
you will link items in Step 6,
so there is no test per se,
just check you have added two lines of code and then move to the next step.

In ```SoundBoard```'s ```run```,
create ```GLabel```s for both the ```AHH_YEAH``` and the ```AIR_HORN```.
Use the constants around lines 18-25 to give you the x and y coordinates,
names,
and the font string to set each label's names,
coordinates and font.
Make sure you use the same string constant to
**create a ```SoundEffect``` object in run too**.
You should be making two ```GLabel```s,
and two ```SoundEffect```s using only constants as the parameters.
When you run this program,
you should get something that looks like the picture below,
but nothing will happen just yet.
(~8 lines of code)

![screenshot of two glabels in a java program](lab12media/media/step5result.png)

Near the end of ```run```,
use the ```Hashmap``` that you created to link the ```GLabel``` key with the ```Playable``` object.
Remember since ```SoundEffect``` is a ```Playable``` object,
you'll *link* the ```GLabel``` *with* a ```SoundEffect```.
Again,
if you are not sure how to do this,
[go back and look over the lab](12-Hash.html##basic-hashmap-usage)

In ```SoundBoard```,
finish implementing the ```mousePressed``` method,
which should leverage the ```elem``` from ```getElementAt```.
Inside the ```if``` statement where you are checking to make sure that ```elem``` is a ```GLabel```,
you can then get the ```SoundEffect``` from the ```HashMap``` and then just play it.
Test it to make sure it does in fact play the sound and voila!
You are now one step closer to err...something.
(~4 lines of code)

---

In class,
you'll notice that I showed an explosion where the label shakes up and down,
(if I haven't shown you this,
please ask me to!).
To implement this correctly,
think about making a new class called
```Explosion``` that inherits from ```SoundEffect```.
You should also create a class ```LabelShaker```
that has a ```GLabel``` as an instance variable
and that ```implements ActionListener```.
Then,
in the ```play``` implementation,
start the ```Timer```
to move the label up and down,
which uses the same mechanics from the dance simulator
for moving the label back and forth on each call to ```actionPerformed```.
