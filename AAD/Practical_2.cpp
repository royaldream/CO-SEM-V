#include<stdio.h>
#include<stdlib.h>
#include<math.h>
#include<sys/time.h>
#include<algorithm>
#include<iostream>
using namespace std;

int linearSearch(long a[],int n,long temp)
{
    for(int i=0;i<n;i++)
    {
        //cout<<a[i]<<endl;
        if(a[i]==temp)
            return i;
    }
    return -1;
}

int binarySearch(long arr[], int l, int r, long x)
{
   if (r >= l)
   {
        int mid = l + (r - l)/2;
        if (arr[mid] == x)
            return mid;
        if (arr[mid] > x)
            return binarySearch(arr, l, mid-1, x);
        return binarySearch(arr, mid+1, r, x);
   }


   return -1;
}
int main()
{   int n;
    printf("Enter the Value of N\n");
    //scanf("%d",&n);
    n=100000;
    long i,timedif,a[n];
    struct timeval tpstart;
    struct timeval tpend;
    struct timeval now;
    int rc,j;
    now.tv_sec;
    now.tv_usec;
    rc=settimeofday(&now,NULL);

    for(i=0;i<n;i++)
    {
        a[i]=rand()%n;
        //printf("%ld\n",a[i]);
    }
    int position;
    int ch;
    ch=2;
    long temp;
    cout<<"Enter Nuber Which is Find Out Of Array :- ";
    //cin>>temp;
    temp=-1;
    switch(ch)
    {
        case 1:position=linearSearch(a,n,temp);
                if(position==-1)
                    cout<<"There is Not Any Equals Element.\n";
                else
                    cout<<"Equals with Position is "<<position<<endl;
                break;
        case 2:position=binarySearch(a,0,n,temp);
                if(position==-1)
                    cout<<"There is Not Any Equals Element.\n";
                else
                    cout<<"Equals with Position is "<<position<<endl;
                    break;
    }



}
