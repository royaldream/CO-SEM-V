%{\
#include<string.h>
char inden[20];
char *m;
int i;
char data[20];
int count=1;
%}

%%
#include	{fprintf(yyout,"%s\n",yytext);}
[<][a-z]*[.]*[a-z][>]	{fprintf(yyout,"%s\n",yytext);}
double|int|else|long|char|for|void|if|float|printf|scanf	{strcpy(data,yytext);fprintf(yyout,"%s\n",yytext);}
['][a-zA-Z][']	{fprintf(yyout,"%s\n",yytext);}
[0-9#]+[a-zA-Z0-9]+	{}
[0-9]+	{fprintf(yyout,"%s\n",yytext);}
[a-zA-Z_]+[a-zA-Z0-9]*	{if(strcmp(data,"int")==0)fprintf(yyout,"%s\n",yytext);else if(strcmp(data,"float")==0)fprintf(yyout,"%s\n",yytext);else if(strcmp(data,"char")==0)fprintf(yyout,"%s\n",yytext);else if(strcmp(data,"void")==0)fprintf(yyout,"%s\n",yytext);}
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
	yyout=fopen("output1.txt","w");
	yylex();
	fclose(yyin);
	fclose(yyout);
	return 0;
					
}
