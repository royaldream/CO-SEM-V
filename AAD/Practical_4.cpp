#include<stdio.h>
#include<stdlib.h>
#include<math.h>
#include<sys/time.h>
#include<iostream>
using namespace std;
int recursive_factorial(int n)
{
    return n>=1 ? n * recursive_factorial(n-1) : 1;
}
int iter_factorial(int n)
{
    int f = 1;
    int i;
        for(i = 1; i <= n; i++)
        {
            f *= i;
        }
    return f;
}
int main()
{
    int n,ch;
    printf("Enter the Value of N\n");
    scanf("%d",&n);
    //n=20;
    //ch=2;
    long timedif,temp;
    struct timeval tpstart;
    struct timeval tpend;
    struct timeval now;
    int rc;
    now.tv_sec;
    now.tv_usec;
    cout<<"Enter Choice\n1 : Recursive Factorial\n2 : Iterative Factorial\n";
    cin>>ch;

    rc=settimeofday(&now,NULL);
    if(rc==0)
    {
        printf("settimeofday() failed.\n");
    }
    else
    {
        printf("\nsettimeofday() Succesful\n");
        printf("\nTime Set sec=%ld Msec=%ld\n",now.tv_sec,now.tv_usec);
    }
    switch(ch)
    {
        case 1:
            cout<<"Recursive Factorial for"<<n<<" : "<<recursive_factorial(n);
            break;
        case 2:
            cout<<"Iterative Factorial for"<<n<<" : "<<iter_factorial(n);
            break;
    }
    gettimeofday(&tpend, NULL);
    timedif = 1000000 * (tpend.tv_sec - tpstart.tv_sec) + tpend.tv_usec - tpstart.tv_usec;

}
