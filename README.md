## Prevent Obsidian Dispenser Crash ##

In minecraft 1.16.4 there is a crash possible by putting a flint and steel in a dispenser pointing downwards with two airblocks below it, with a piece of obsidian on the side.
Minecraft tries to do a light a portal check, but crashes during that process. This happens in single player as well as on servers.
As this is very annoying, this plugin cancels the dispenser when this specific scenario occurs, saving you a server crash.

Schema of the setup
```
# = dispenser with flint and steel
O = obsidian
. = air

[.][#][.]
[.][.][O]
[.][.][.]

 ``` 
