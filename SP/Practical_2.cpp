#include<iostream>
#include<fstream>
using namespace std;

int main()
{
    ifstream fin;
    fin.open("Practical_1.cpp");
    ofstream fout;
    fout.open("RemoveCommentPractical_1.cpp");
    char ch1,ch2;
    int i=0;
    while(!fin.eof())
    {
        fin.get(ch1);
        if(ch1=='/')
        {
            fin.get(ch1);
            if(ch1=='/')
                while(ch1!='\n')
                    fin.get(ch1);
           else if(ch1=='*')
            {
                do
                {
                    fin.get(ch1);
                    fin.get(ch2);
                    if(ch1!='*'&& ch2!='/')
                        fin.seekg(-1,ios::cur);
                }while(ch1!='*'&& ch2!='/');
                if(ch1=='/' ||ch1=='*')
                    fin.get(ch1);
            }
        }
        fout.put(ch1);
    }
    fin.close();
    fout.close();
    cout<<"Successfully Run !!!!......\n";

 return 0;
}
