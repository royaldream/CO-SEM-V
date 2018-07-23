#include<iostream>
#define SIZE 10
using namespace std;
class Stack
{
    public :
    int a[SIZE][SIZE];
    int top,r,f;
    int visited[SIZE];
    int stack[SIZE];
    Stack()
    {
        for(int i=0;i<SIZE;i++)
            for(int j=0;j<SIZE;j++)
                a[i][j]=999;
    }
    Stack(int n)
    {
        top=-1;
        r=f=-1;
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                a[i][j]=0;
        for(int i=0;i<n;i++)
            {visited[i]=0;}
    }
    void addEdge(int sn,int dn)
    {
        a[sn][dn]=1;
        a[dn][sn]=1;
    }
    void showGraph(int n)
    {
        cout<<endl;
        for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                    cout<<a[i][j]<<"\t";
                    cout<<endl;
            }
    }

    void push(int num)
    {
        top++;
        stack[top]=num;
    }
    int pop()
    {
        int temp;
        temp=stack[top];
        top--;
        return temp;
    }
    void pushqueue(int num)
    {
        r++;
        stack[r]=num;
    }
    int popqueue()
    {
        int temp;
        f++;
        temp=stack[f];
        return temp;
    }
    void DFS(int source,int n)
    {
        if(visited[source]==0)
        {
            push(source);
            visited[source]=1;
        }
        for(int i=0;i<n;i++)
        {
            if(a[source][i]==1 && visited[i]==0)
                {
                    push(i);
                    visited[i]=1;
                    DFS(i,n);
                }
        }
    }
    void BFS(int source,int n)
    {
            if(r==(n-1)||f==(n-2))
            return;
        int x;
        visited[source]=1;
        for(int i=0;i<n;i++)
        {
            if(a[source][i]==1 && visited[i]==0)
                {
                    pushqueue(i);
                    visited[i]=1;
                }
        }
        x=popqueue();
        cout<<x<<endl;
        BFS(x,n);
    }
};

int main()
{
    Stack graph;
    int n,ch=1;
    cout<<"Enter Number Of Total Nodes :- ";
    cin>>n;
    //n=4;
    graph=Stack(n);
    int sn,dn;
    /*graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 2);
    graph.addEdge(2, 0);
    graph.addEdge(2, 3);
    graph.addEdge(3, 3);*/
    while(1)
    {
        if(ch==1)
            {   cout<<"Enter Edges Node :- ";
                cin>>sn;
                cin>>dn;
                graph.addEdges(sn,dn);
                cout<<"If add Edge (select 1) else (select 0): ";
                cin>>ch;
            }
        else if(ch==0)
            break;
    }
    graph.showGraph(n);
    int ch,source;
    cout<<"Enter Source Node :- ";
    cin>>source;
    cout<<"Enter Your Choice \n1 : DFS\n2 : BFS 0 : Exit\n";
    cin>>ch;
    //graph.DFS(0,n);
    while(ch!=0)
    {
        if(ch==1)
            graph.DFS(source,n);
        else
        if(ch==2)
            {
                cout<<source<<"\n";
                graph.BFS(source,n);
            }
        cout<<"Enter Your Choice \n1 : DFS\n2 : BFS 0 : Exit\n";
        cin>>ch;
    }
    return 0;
}

/*

visited[v]=1;
k=1;
while(k<n)
{
for(j=1;j<=n;j++)
    if(cost[v][j]!=0 && visited[j]!=1 && visit[j]!=1)
    {
    visit[j]=1;
    qu[rare++]=j;
    }

v=qu[front++];
cout<<v << " ";
k++;
visit[v]=0; visited[v]=1;
}




*/
