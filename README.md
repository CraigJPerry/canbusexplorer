Canbus Explorer
===============

> Capture and understand the traffic on Canbus networks.

See the documentation site: https://CraigJPerry.github.io/canbusexplorer/

Deployment Overview
-------------------

    +-------------+     +--------------+     +--------+     +-------------+
    | OBD Vehicle |     | USB / WiFi / |     |   PC   |     | Web Browser |
    | Diagnostics | --> |   Bluetooth  | --> |   or   | --> | (PC or      |
    |    Port     |     |    Dongle    |     | Server |     |  Mobile)    |
    +-------------+     +--------------+     +--------+     +-------------+

You'll need a bluetooth, wifi or usb OBD dongle with the ELM327 (or ST1170)
chip.

This application needs Java installed on the host PC or Server. Supported
operating systems for the PC or Server include: Windows, MacOS, Linux,
FreeBSD and Solaris.

The front end is HTML5 based and can be accessed locally from the PC with the
OBD dongle or remotely. For example, from a phone or tablet connected to the
same wifi network as the host PC or Server.


Usage
-----

* Download `canbusexplorer.jar`
* From a command window run `java -jar canbusexplorer.jar`
* Visit the announced URL http://localhost:8080/
