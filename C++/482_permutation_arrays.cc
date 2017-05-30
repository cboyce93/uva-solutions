// UVa 482 - Permutation Arrays 
// Cameron Boyce
// 05/30/17

#include <iostream>
#include <sstream>
#include <string>
#include <vector>

using namespace std;

int main() {
    int no_of_cases, i, j, buf = 0;
    cin >> no_of_cases;
    cin.ignore();
    for (i = 0; i < no_of_cases; ++i) {
        string line;
        cin.ignore();
        getline(cin, line);
        stringstream ss;
        ss << line;
        vector<int> order;
        while (ss >> buf)
            order.push_back(buf);
        vector<int>::size_type size = order.size();
        string arr[size];
        line = "";
        ss.clear();
        getline(cin, line);
        ss << line;
        string buff;
        ss >> buff;
        for (vector<int>::const_iterator iter = order.begin();
            iter != order.end(); ++iter, ss >> buff) {
            arr[*iter - 1] = buff;
        }
        for (j = 0; j < size; ++j)
            cout << arr[j] << endl;
        if (i < (no_of_cases - 1)) cout << endl;
    }
    return 0;
}
