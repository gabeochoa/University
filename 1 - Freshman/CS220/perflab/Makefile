# Student's Makefile for the CS:APP Performance Lab
TEAM = bovik
VERSION = 1
HANDINDIR = 

# T. Stachecki, 11/25/12 -- force students to consider optimizations.
# Some of these options are likely redundant and are for clarification.

# -fno-inline-small-functions  -fno-loop-block -fno-loop-strip-mine
EXTRA_CFLAGS = -ftree-vectorize -msse2 -fno-inline-functions \
  -fno-reorder-blocks 

CC = gcc
CFLAGS = -Wall -O2 -m32 $(EXTRA_CFLAGS)
LIBS = -lm

OBJS = driver.o kernels.o fcyc.o clock.o

all: driver

driver: $(OBJS) fcyc.h clock.h defs.h config.h
	$(CC) $(CFLAGS) $(OBJS) $(LIBS) -o driver

handin:
	cp kernels.c $(HANDINDIR)/$(TEAM)-$(VERSION)-kernels.c

clean: 
	-rm -f $(OBJS) driver core *~ *.o


