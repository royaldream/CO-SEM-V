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
double|int|else|long|char|for|void|if|float|printf|scanf	{strcpy(data,yytext);}
['][a-zA-Z][']	{}
[0-9#]+[a-zA-Z0-9]+	{}
[0-9]+	{}
[a-zA-Z_]+[a-zA-Z0-9]*	{if(strcmp(data,"int")==0)fprintf(yyout,"%s\t%s\tlength = 4\n",yytext,data);else if(strcmp(data,"float")==0)fprintf(yyout,"%s\t%s\tlength = 4\n",yytext,data);else if(strcmp(data,"char")==0)fprintf(yyout,"%s\t%s\tlength = 1\n",yytext,data);else if(strcmp(data,"void")==0)fprintf(yyout,"%s\t%s\tlength = 0\n",yytext,data);}
\n	{}
. {}
%%

/*call the yywrap function*/
int yywrap()								
{
return 1;
}

/*Auxiliary function*/
/*Driver function*/

int main(int argc,char *argv[])
{
	/*call the yylex function.*/
	yyin=fopen(argv[1],"r");
	yyout=fopen("symbols.txt","w");
	yylex();
	fclose(yyin);
	fclose(yyout);
	return 0;
					
}
