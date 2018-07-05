#include<iostream>
#include<fstream>
using namespace std;

int main()
{
    char input;
    ifstream fin;
    fin.open("Practical_1.txt");
    
    int ch=0,line=0,word=0;
    while(!fin.eof())
    {

        fin.get(input);
    
        if(input=='\n')
            {line++;word++;}
        else if(input==' ')
            word++;
        else
            ch++;
    }
    
    cout<<"Number Of Char :- "<<ch<<endl;
        cout<<"Number Of Word :- "<<word-1<<endl;
            cout<<"Number Of Lines :- "<<line-1<<endl;
}

