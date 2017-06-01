// UVa 11413 - Fill the Containers
// Cameron Boyce
// 06/01/17

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// n - # of vessels     m - # of containers
int n, m, i, sum, buff, low, mid, high, optimal, current_capacity = 0;
int current_no_of_containers = 1;
vector<int> vessel_capacities;
vector<int>::const_iterator vessel;

bool is_solution(int max_capacity) {
    current_capacity = 0;
    current_no_of_containers = 1;
    // iterate through each vessel
    for (vessel = vessel_capacities.begin(); 
         vessel != vessel_capacities.end(); ++vessel) {
        if (*vessel > max_capacity) return false;
        else if ((*vessel + current_capacity) > max_capacity) {
            ++current_no_of_containers;
            current_capacity = 0;   
            if (current_no_of_containers > m) return false;              
        }
        current_capacity += *vessel;
    }
    return true;
}

int main() {
    while (cin >> n) {
        cin >> m;
        for (i = 0; i < n; ++i) {
            cin >> buff;
            vessel_capacities.push_back(buff);
            sum += buff;
        }
        low = 1;
        high = sum;
        optimal = high;
        while (low <= high) {
            mid = (low + high)/2;
            if (is_solution(mid)) {
                optimal = mid;
                high = mid - 1;   
            }
            else {
                low = mid + 1;
            }
        }
        cout << optimal << endl;
        sum = 0;  // reset
        vessel_capacities.clear();
    }
}

