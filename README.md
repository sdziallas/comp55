# comp55

Hi!  I've decided to make this repository to document changes that are made for COMP 55 over the years and to make the educational materials more collaborative.

More to come in the future about what's available and where

Special credit goes to Afsoon Yousefi-Zowj, Sebastian Dziallas, and all of the COMP 129 and COMP 55 students throughout the years that have either contributed or have used the repository.

This works best being setup as a pages site.  Pages can be setup to serve the pages from within the settings in the repo.

I also [used pandoc](https://pandoc.org/getting-started.html) to switch files from word doc to github flavored markdown, the command that I used being:

```pandoc COMPLab1.docx -f docx -t gfm -s -o COMPLab1.md```
To extract the images embedded in the document, I like to have things in a flatter structure so you can skip everything after the ```&&```

```pandoc "COMPLab1.docx" --extract-media=defaultmedia && mv defaultmedia/media ./lab1media```
If defaultmedia does not exist, then it would create the folder, so you may have to remove it.

Thanks!

Osvaldo Jiménez

(ojimenez AT pacific DOT edu)
