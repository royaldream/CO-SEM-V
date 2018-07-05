#include<iostream>
#include<fstream>
#include<string.h>
#define SIZE 50
using namespace std;

int isOperatorornot(char op)
{
    char operat[8]="+-*/%=,",brakets[7]="{}[]()";
    int flag=0;
        for(int i=0;i<7;i++)
            if(op==operat[i])
                {flag=1;break;}
        for(int i=0;i<6;i++)
            if(op==brakets[i])
                {flag=1;break;}
        return flag;
}

int iskeywordornot(char word[])
{   char keyword[SIZE][SIZE]={"auto","break","case","char","const","continue","default",
                            "do","double","else","enum","float","for","goto",
                            "if","int","long","return","short","signed",
                            "sizeof","static","struct","switch","typedef","union",
                            "unsigned","void","volatile","while","main","include","cout","cin","endl","class"};
    for(int i=0;i<35;i++)
        if(strcmp(keyword[i],word)==0)
            return 1;
    return 0;
}
int main()
{
    char input[1000],c,operat[7]="+-*/%=",brakets[7]="{}[]()",variable[15];
    int k=0;
    ifstream fin;
    fin.open("Practical_3.txt");
    if(fin.good())
    {
        while(!fin.eof())
        {
            c=fin.get();
            for(int i=0;i<6;i++)
                if(c==operat[i])
                    cout<<c<<" is Operator\n";
            for(int i=0;i<6;i++)
                if(c==brakets[i])
                    cout<<c<<" is Brackets\n";
            if(c==';')
                cout<<c<<" is Semicolon\n";
            if(isalnum(c))
                variable[k++]=c;
            else if((c==' ' || c=='\n' || isOperatorornot(c) )&&k!=0)
            {
                variable[k]='\0';
                if(iskeywordornot(variable)==1)
                {
                    cout<<variable<<" is KeyWord\n";
                }else
                {
                    cout<<variable<<" is Identifier\n";
                }
                k=0;
            }
        }
    }
}
