#include<bits/stdc++.h>

vector<int> kMaxSumCombination(vector<int> &a, vector<int> &b, int n, int k){

    
 unordered_map<int,int>mp;
 int mx=*max_element(a.begin(),a.end())+*max_element(b.begin(),b.end());
 int mn=*min_element(a.begin(),a.end())+*min_element(b.begin(),b.end());
 
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
            int sum=a[i]+b[j];
            mp[sum]++;
        }
    }
    vector<int>ans(k,0);
    int ind=0;
    for(int i=mx;i>=mn;i--)
    {
        if(mp.find(i)!=mp.end())
        {
            int t=mp[i];
            if(t>0)
            {
                while(t--)
                {
                    ans[ind++]=i;
                    k--;
                    if(k==0)break;
                }
                if(k==0)break; 
            }
        }
    }
   return ans;
}
