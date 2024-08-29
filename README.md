# SloppySpoof
A Forge mod to hide mods from servers, by removing them from the Forge modlist in the FML handshake. Built for Minecraft version 1.20.1, on Forge version 47.3.7.

### Usage:
Upon running, SloppySpoof will generate a config file, _config/sloppyspoof-common.toml_. Enter the mod ID of any mod you wish to hide under _bannedMods_ within this file. By default, SloppySpoof will hide itself and any mod with the mod ID "xray". 

### Method:
SloppySpoof uses a mixin to hook into the bottom of the C2SModListReply constructor, where it removes any mods named in _bannedMods_ from the list of mods C2SModListReply generates.

Here is an example of the modlist sent with SloppySpoof installed, versus the modlist sent without SloppySpoof.

<img src="https://images2.imgbox.com/7d/e8/1k0xBW23_o.png">

### Notes:
SloppySpoof was inspired by [modspoof](https://github.com/Debuggingss/modspoof) by [Debuggingss](https://github.com/Debuggingss), though none of Debuggingss' code was used (since modspoof targets Minecraft 1.8.9, and because I do not know anything about Kotlin).

This mod is not made to counter any form of anti-cheat beyond simple analysis of the modlist sent during the FML handshake. While I have tested the mod and found it to work, I do not take responsibility for any bans that may arise from its potential failure or misuse. Also note that this is my first Minecraft mod, and that this is the first time I've touched Java in about 9 years.
