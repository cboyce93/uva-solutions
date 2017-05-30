// UVa 679 - Dropping Balls
// Cameron Boyce
// 05/30/17

#include <iostream>
#include <cmath>

using namespace std;

int K, D, I, MAX_DEPTH = 0;

// return stop position P
// I - stop position
int drop_ball(int ball_pos, int balls, int depth) {
    if (depth < D) {
        int left = ball_pos * 2;
        int right = left + 1;        
        if (balls % 2 == 0) drop_ball(right, balls/2, ++depth);
        else drop_ball(left, balls/2 + 1, ++depth);
    }
    else return ball_pos;
    
}

int main() {
    cin >> K;
    for(int i = 0; i < K; ++i) {
        cin >> D >> I;
        MAX_DEPTH = pow(2, D);
        cout << drop_ball(1, I, 1) << endl;    
    }
    
}
