#include <iostream>
#include <cstdio>
#include <cstring>
#include <algorithm>
using namespace std;
int N, m;
struct node{
	char s[5];
	int lx, ly, rx, ry;
	node(int _lx = 0, int _ly = 0, int _rx = 0, int _ry = 0):lx(_lx), ly(_ly), rx(_rx), ry(_ry){}	
}st[50005];
int tree[1005<<2][1005<<2];
int read(int x, int y){
	int sum = 0, nx = x, ny = y;
	for(nx = x; nx > 0; nx -= nx&(-nx)){
		for(ny = y; ny > 0; ny -= ny&(-ny)){
			sum += tree[nx][ny];	
		}	
	}
	return sum;
}
void update(int x, int y, int val){
	int nx = x, ny = y;
	for(nx = x; nx <= N; nx += nx&(-nx)){
		for(ny = y; ny <= N; ny += ny&(-ny)){
			tree[nx][ny] += val;
		}	
	}
}
void solve(){
	memset(tree,  0, sizeof(tree));	
	/*N = 100;
	update(1, 2, -100);
	update(1,3, 10);
	printf("%d\n", read(15,3));
	return;*/
	//printf("N = %d\n", N);
	for(int i = 0; i < m; i++){
		if(st[i].s[0] == 'C'){
			#define Lx st[i].lx
			#define Ly st[i].ly
			#define Rx st[i].rx
			#define Ry st[i].ry
			//printf("%s %d %d %d %d\n", st[i].s, Lx, Ly, Rx, Ry);
			update(Lx,Ly,1),update(Lx,Ry+1, -1), update(Rx+1,Ly,-1),update(Rx+1,Ry+1,1);
		} else if(st[i].s[0] == 'Q'){
			/*#define A read(Lx,Ly)
			#define B read(Lx-1,Ly)
			#define CC read(Lx, Ly-1)
			#define D read(Lx-1, Ly-1)
			printf("#A = %d, B = %d, CC = %d, D = %d#", A, B, CC, D);
			int res = read(Lx,Ly)-read(Lx-1,Ly)-read(Lx,Ly-1)+read(Lx-1,Ly-1);
			printf("%s %d %d:read(%d,%d) = %d ", st[i].s, Lx, Ly, Lx, Ly, read(Lx, Ly));
			if(read(Lx, Ly)%2 == 0) printf("res = %d\n", res);
			else printf("res = %d\n", res);*/
			printf("%d\n", read(Lx, Ly)%2 == 1);
		}
	}
}
void input(){
	scanf("%d%d", &N, &m);
	for(int i = 0; i < m; i++){
		char s[5];
		scanf("%s", &s);
		if(s[0] == 'C'){
			int lx, ly, rx, ry;
			scanf("%d%d%d%d", &lx, &ly, &rx, &ry);
			st[i] = node(lx, ly, rx, ry);	
		} else if(s[0] = 'Q'){
			int x, y;
			scanf("%d%d", &x, &y);
			st[i] = node(x, y);	
		}
		strcpy(st[i].s, s);
	}	
	/*for(int i = 0; i < m; i++){
		#define S st[i]
		if(S.s[0] == 'C'){
			printf("%s %d %d %d %d\n", S.s, S.lx, S.ly, S.rx, S.ry);
		} else if(S.s[0] == 'Q'){
			printf("%s %d %d\n", S.s, S.lx, S.ly);
		}
	}*/
}
int main(){
	freopen("test.in", "r", stdin);
	freopen("test.out", "w", stdout);
	int C;
	scanf("%d", &C);
	for(int i=1; i <= C; i++){
		input();
		solve();	
		printf("\n");
	}	
}