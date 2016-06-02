solve1:
awk '{if(NR==10) print $0}' file.txt
solve2:
sed -n '10,10p' file.txt