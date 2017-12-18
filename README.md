# mediator
mediator is a modeling language that helps develop formal model through both

- automata-based, precise and formal semantics
- easy-to-use compositional diagrams

Currently, this project is still on its very early stage. This repo provides a CLI of the tool. Hopefully we will keep adding more features in this CLI. And after some time we will also release an electron-based, cross-platform IDE.

## build guide

Under `scripts` folder, we have a `release.sh` that helps you build this project.

The project is written in Java, and use Maven to manage the dependencies. So we assume that you already have JDK (1.8 at least) and Maven (latest distribution) installed.
Currently the building script only supports Mac OS (has been tested under high sierra) and Linux (tested under Ubuntu 17.04).

To use the script, simply type

    ./scripts/release.sh package
    
and it will use Maven to compile, then move all required files to the `release` folder. After that it will automatically copy the launcher scripts (`mediator.sh` and `mediator.bat`) to this folder.

A zip archive of the folder `release` will also be created at the same time.

## usage

Run `mediator.sh` or `mediator.bat` to use mediator. The program provides a built-in help command. More documents will come soon.

## supported platforms

- The building scripts currently supports both Linux and Mac OS.
- Released program works on popular operating systems including Linux (tested under Ubuntu 16.04), Darwin (tested under Mac OS high sierra) and Windows (tested under Windows 10 x64). Till now all codes are written in Java, which means support of all OS where Jre supports.
