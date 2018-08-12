#!/usr/bin/python
# -*- coding: utf-8 -*-
import os
import sys
def main():
    for root, dirs, files in os.walk('./'):
        print files
        for f in files:
            opt1 = 'sed -i "" "s/Solve.py/' + ''.join([string.capitalize() for string in f.split('-')]).replace('.java', '') + '/g" ' + f 
            print opt1
            os.system(opt1)
            opt2 = 'mv ' + f + ' ' + ''.join([string.capitalize() for string in f.split('-')])
            print opt2
            os.system(opt2)
if __name__ == '__main__':
    main()
