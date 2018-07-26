#include<iostream>
#include<fstream>
#include<stdlib.h>
#include<string.h>
#include<ctype.h>

using namespace std;

int isKeyword(char buffer[])
{
    char keywords[5][10] = {"char","double","float","int","long"};
    int i, flag = 0;

    for(i = 0; i < 5; ++i){
        if(strcmp(keywords[i], buffer) == 0){
            flag = 1;
            break;
        }
    }

    return flag;
}

int main()
{
    char ch, buffer[15],sym[10],symbol[20][20],data[20][20];
    ifstream fin("1.cpp");
    int j=0,o=0;

    if(!fin.is_open()){
        cout<<"error while opening the file\n";
        exit(0);
    }

    while(!fin.eof())
    {
           ch = fin.get();

        if(isalnum(ch))
        {
             buffer[j++] = ch;
        }

        else if((ch == ' ' || ch == '\n') && (j != 0))
        {
                   buffer[j] = '\0';
                   j = 0;

                   if(isKeyword(buffer) == 1)
                   {
						strcpy(symbol[o],buffer);
                        
                        //cout<<symbol[o]<<" is keyword\n";
                        
                        int p=0;
                        while( ch!=';')
                        {
							
                            ch=fin.get();
                           sym[p]=ch;
                           p++;
                           if(ch==',')
                           {
							   sym[--p]='\0';
							   strcpy(data[o],sym);
							   strcpy(symbol[o],buffer);
							   p=0;
							   o++;
						   }
                        
                        }
						
                        sym[--p]='\0';
                         strcpy(data[o],sym);
							   strcpy(symbol[o],buffer);
							   o++;
                        
                   }
        }

    }
for(int h=0;h<o;h++)
                        {
							cout<<symbol[h]<<"\t"<<data[h]<<"\n";
					}
    fin.close();
    return 0;
}

