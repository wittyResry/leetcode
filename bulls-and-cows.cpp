int vis[10];
class Solution {
public:
    string getHint(string secret, string guess) {
        for (int i = 0; i < 10; ++i) {
            vis[i] = 0;
        }
        int cows = 0, bulls = 0;
        for (int i = 0; i < secret.size(); ++i) {
            if (secret[i] == guess[i]) {
                ++bulls;
            } else {
                ++vis[secret[i] - '0'];
            }
        }
        for (int i = 0; i < guess.size(); ++i) {
            if (secret[i] != guess[i]) {
                if (vis[guess[i] - '0'] > 0) {
                    ++cows;
                    --vis[guess[i] - '0'];
                }
            }
            
        }
        char tmp[100];  
        sprintf(tmp, "%dA%dB", bulls, cows);
        return tmp;
    }
};