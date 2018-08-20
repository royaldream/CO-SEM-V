#include<stdio.h>
#include<stdlib.h>
int i,j,k,a,b,u,v,n,ne=1;
int min,mcost=0,cost[9][9],p[9];
int loop(int,int);
int fi(int i)
{
    while(p[i]!=0)
    {
        i=p[i];
    }
    return i;
}

int main()
{

    printf("\nEnter no. of vertices:\n");
    scanf("%d",&n);
    for(i=1; i<=n; i++)
    {
        for(j=1; j<=n; j++)
        {
            cost[i][j]=999;
        }
    }
    cost[1][2]=25;
    cost[1][6]=10;
    cost[2][1]=25;
    cost[2][3]=14;
    cost[2][7]=12;
    cost[3][2]=14;
    cost[3][4]=11;
    cost[2][3]=14;
    cost[2][7]=12;
    cost[5][7]=22;
    cost[5][6]=23;
    cost[5][4]=20;
    cost[6][5]=23;
    cost[6][1]=10;
    cost[7][5]=22;
    cost[7][4]=17;
    cost[7][2]=12;
    while(ne < n)
    {
        for(i=1,min=999; i<=n; i++)
        {
            for(j=1; j<=n; j++)
            {
                if(cost[i][j] < min)
                {
                    min=cost[i][j];
                    a=u=i;
                    b=v=j;
                }
            }
        }
        printf("%d %d\n",a,b);
        u=fi(u);
        v=fi(v);
        if(loop(u,v))
        {
            printf("edge cost %d %d =%d\n",a,b,min);
            mcost +=min;
            ne++;
        }
        cost[a][b]=cost[b][a]=999;
        for(i=1; i<=n; i++)
        {
            printf("%d ",p[i]);
        }
        printf("\n");
    }
    printf("Minimum cost = %d\n",mcost);
    return 0;

}

int loop(int i,int j)
{
    if(i!=j)
    {
        p[j]=i;
        return 1;
    }
    return 0;
}
