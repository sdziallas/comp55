# comp55

Hi!  I've decided to make this repository to document changes that are made for COMP 55 over the years and to make the educational materials more collaborative.

More to come in the future about what's available and where

Special credit goes to Afsoon Yousefi-Zowj, Sebastian Dziallas, and all of the COMP 129 and COMP 55 students throughout the years that have either contributed or have used the repository.

These labs work best when setup as a github pages site so that way certain links do not have to be modified and it follows best practice.
Pages can be setup by visiting the settings part of your forked repo and enabling the settings provided below
![chnage branch and folder settings](https://user-images.githubusercontent.com/239024/208784665-eaf09153-6243-4abd-b1c6-745c679ba565.png)

I also [used pandoc](https://pandoc.org/getting-started.html) to switch files from word doc to github flavored markdown, the command that I used being:

```pandoc COMPLab1.docx -f docx -t gfm -s -o COMPLab1.md```
To extract the images embedded in the document, I like to have things in a flatter structure so you can skip everything after the ```&&```

```pandoc "COMPLab1.docx" --extract-media=defaultmedia && mv defaultmedia/media ./lab1media```
If defaultmedia does not exist, then it would create the folder, so you may have to remove it.

Thanks!

Osvaldo Jiménez

(ojimenez AT pacific DOT edu)

<a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png" /></a><br />This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/">Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License</a>.
