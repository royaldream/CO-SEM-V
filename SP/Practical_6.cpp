/*
6.Write a program to implement the following Regular Expressions
    a.(b*)abb
    b.ba*
*/
#include<iostream>
#include<fstream>
#include<string.h>
#define SIZE 50
using namespace std;

int main()
{
    char input[SIZE];
    int flag=1,i=0;
    cout<<"Enter string which is valid or not :- ";
    cin>>input;
    int length=strlen(input);
    //cout<<length;
    int ch;
    cout<<"Menu \n1 : (b*)abb\n2 : ba*\n0 : Exit\n";
    cin>>ch;

    while(ch!=0)
    {
        if(ch==1)
        {
            if(input[length-1]=='b'&&input[length-2]=='b'&&input[length-3]=='a')
                {
                    for(i=0;i<length-3;i++)
                    {
                        if(input[i]!='b')
                            {
                                flag=0;
                                break;
                            }
                    }
                    if(flag==1)
                        cout<<"String is Valid"<<endl;
                    else
                        cout<<"String is not Valid"<<endl;
                }
                else
                    cout<<"String is not Valid"<<endl;
        }
        else
        if(ch==2)
        {
            if(input[0]=='b')
            {
                for(i=1;i<length;i++)
                {
                    if(input[i]!='a')
                        {
                                flag=0;
                                break;
                        }
                }
                if(flag==1)
                        cout<<"String is Valid"<<endl;
                    else
                        cout<<"String is not Valid"<<endl;
            }
            else{cout<<"String is not Valid"<<endl;}
        }
        else
        {
            cout<<"Wrong Choice\n";//wrong
        }
        cout<<"Enter string which is valid or not :- ";
        cin>>input;
        cout<<"Menu \n1 : (b*)abb\n2 : ba*\n0 : Exit\n";
        cin>>ch;

    }
    return 0;
}
