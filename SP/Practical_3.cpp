#include<iostream>
#include<fstream>
#include<string.h>

using namespace std;

int main()
{
    char input[1000];
    ifstream fin;
    fin.open("Practical_1.cpp");
    fin.read((char *)&input,sizeof(input));
    const char *del=" ;/.";
    char *token;
    token=strtok(input,del);

    while(token!=NULL)
    {
        cout<<token<<endl;
        token=strtok(NULL,del);
    }
}
