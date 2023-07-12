# This is a fork of Apoli
This project aims to get a buildable version of apoli 2.1.0 working of Minecraft 1.17.1. There's not really any reason why this is a good idea, other than for letting mods on 1.17 have this as a dependency and not have their builds fail (fallflyinglib was causing build errors, so I removed it).

So far this fork has jitpack building the project properly (I checked...<sup>it better still be working</sup>), most of the 2.1.0 features working (excluding a few mixins), and dependencies as up to date as they are probably ever going to be.

I guess it goes without saying, but you should reconsider not using this if you are not running into build errors on the upstream 1.17 build.

# Apoli

[![JitPack](https://img.shields.io/jitpack/v/github/apace100/apoli?style=for-the-badge)](https://jitpack.io/#Apace100/apoli) [![Discord](https://img.shields.io/discord/734127708488859831?style=for-the-badge)](https://discord.gg/CnCBaRgwJD) ![GitHub issues](https://img.shields.io/github/issues/apace100/apoli?style=for-the-badge) ![GitHub pull requests](https://img.shields.io/github/issues-pr/apace100/apoli?style=for-the-badge) ![GitHub](https://img.shields.io/github/license/apace100/apoli?style=for-the-badge)

Apoli is a data-driven entity power provider. It allows you to attach powers to entities via datapacks.

## Maven
```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    modImplementation "com.github.apace100:apoli:[VERSION]"
}
```

## Documentation

Unfortunately Apoli doesn't have its own documentation yet, however you can reference the [documentation for Origins](https://origins.readthedocs.io/en/latest/) to see documentation from a consumer perspective. 

For additional support please use the [#addon-dev channel in the Origins discord](https://discord.gg/CnCBaRgwJD)
