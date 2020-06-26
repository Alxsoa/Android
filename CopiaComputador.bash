#!/bin/bash
clear

rsync -avzh MEGA/ asoares@192.168.15.12:/home/Work --checksum

