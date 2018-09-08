#!/usr/bin/python
# -*- coding: utf-8 -*-
import os
import sys
def main():
    if (len(sys.argv) == 1):
        return
    print ''.join([string.capitalize() for string in sys.argv[1].split('-')])
if __name__ == '__main__':
    main()
