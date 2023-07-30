#include <unordered_set>
int maximumXor(vector<int> A)
{   
    int ans = 0;
    int mask = 0;
    int n = A.size();

    for (int i = 30; i >= 0; i--)
    {   
        unordered_set<int> s;
        mask = mask | (1 << i);
        for (int j = 0; j < n; j++)
        {   
            s.insert(A[j] & mask);
        }
        int temp = ans;
        temp = temp | (1 << i);
        for(auto it: s)
        {    
            if(s.count(it ^ temp))
            {   
                ans = temp;
                break;
            }
        }
    } 

    return ans; 
}
