#include<iostream>
#include<fstream>
#include<string.h>
#include<stdlib.h>
using namespace std;
int main()
{
    char s[1000],c,adds[10];
    char sym[1000];
    ifstream input;
    input.open("Practical_5.txt");
    input.getline((char *)&s,sizeof(s));
    int i=0,lenght,j=0,add;
    lenght=strlen(s);
    while(i!=lenght)
    {
        if(isdigit(s[i]))
        {
            adds[j]=s[i];
            j++;
        }
        i++;
    }
    adds[j]='\0';
    add=atoi(adds);
    cout<<"Starting Address from :- "<<add<<endl;
    cout<<"---------Symbol Table-----------\nSymbol\tAddress\tLenght\n";

    while(!input.eof())
    {
        input.getline((char *)&s,sizeof(s));
        add+=1;
        if(isalnum(s[0]))
        {
            int i=0;
            while(s[i]!='\t')
            {
                sym[i]=s[i];
                i++;
            }
            sym[i]='\0';
            cout<<sym<<"\t"<<add<<"\t"<<"1"<<endl;
        }
    }
    sym[0]='\0';
    input.close();
    cout<<"---------Literal Table-----------\nLiteral\tAddress\n";
    input.open("Practical_5.txt");
    while(!input.eof())
    {
        input.getline((char *)&s,sizeof(s));
        if(isalnum(s[0]))
        {
            int i=0;
            while(s[i]!='\t')
            {
                sym[i]=s[i];
                i++;
            }
            sym[i]='\0';
            cout<<sym<<"\t"<<add<<"\t"<<"1"<<endl;
        }
    }
}
