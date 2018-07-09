#include<stdio.h>
#include<stdlib.h>
#include<math.h>
#include<sys/time.h>
#include<iostream>
using namespace std;
void bubblesort(long a[],int n)
{
    int i=0,j=0,temp=0;
    for(i=0;i<n-1;i++)
        {
            for(j=0;j<n-i-1;j++)
            {
                if(a[j]>a[j+1])
                {
                    temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
}

void selectionSort(long a[], int n)
{
    int i=0,j=0,temp=0;
    for(i=0;i<n;i++)
    {
        for(j=i+1;j<n;j++)
        {
            if(a[j]<a[i])
            {
                temp=a[j];
                a[j]=a[i];
                a[i]=temp;
            }
        }
    }
}

void insertionSort(long a[], int n)
{
   int i, key, j;
   for (i = 1; i < n; i++)
   {
       key = a[i];
       j = i-1;

       while (j >= 0 && a[j] > key)
       {
           a[j+1] = a[j];
           j = j-1;
       }
       a[j+1] = key;
   }
}
int main()
{
    int n;
    printf("Enter the Value of N\n");
    scanf("%d",&n);
    //n=10;
    long i,timedif,a[n],temp;
    struct timeval tpstart;
    struct timeval tpend;
    struct timeval now;
    int rc,j;
    now.tv_sec;
    now.tv_usec;
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

    for(i=0;i<n;i++)
    {
        a[i]=rand()%n;
        //printf("%ld\n",a[i]);
    }
    int ch;
    cout<<"Enter Choice\n1 : Bubble Sort\n2 : Selection Sort\n3 : Insertion Sort\n";
    cin>>ch;
    //ch=1;
    switch(ch)
    {
        case 1:
                gettimeofday(&tpstart, NULL);
                bubblesort(a,n);
                break;
        case 2:
                gettimeofday(&tpstart, NULL);
                selectionSort(a,n);
                break;
        case 3:
                gettimeofday(&tpstart, NULL);
                insertionSort(a,n);
                break;
    }
    gettimeofday(&tpend, NULL);
    timedif = 1000000 * (tpend.tv_sec - tpstart.tv_sec) + tpend.tv_usec - tpstart.tv_usec;

    printf("\nTime difference is : %ld\n",timedif);
}



