%{\
#include<string.h>
char inden[20];
char *m;
int i;
char data[20];
int count=1;
%}

%%
#include	{}
[<][a-z]*[.]*[a-z][>]	{}
double|int|else|long|char|for|void|if|float|printf|scanf	{}
['][a-zA-Z][']	{}
[0-9#]+[a-zA-Z0-9]+	{fprintf(yyout,"%s is invalid token at line %d\n",yytext,count);}
[0-9]+	{}
[a-zA-Z_]+[a-zA-Z0-9]*	{}
\n	count++;
. {}
%%

int yywrap()								
{
return 1;
}

int main(int argc,char *argv[])
{
	/*call the yylex function.*/
	yyin=fopen(argv[1],"r");
	yyout=fopen("error.txt","w");
	yylex();
	fclose(yyin);
	fclose(yyout);
	return 0;
					
}
