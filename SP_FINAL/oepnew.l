%{\
#include<string.h>
char inden[20];
char *m;
char data[2][100];
char da[200];
int i,j;
%}

%%
#define[A-Z]*[a-z0-9A-Z ();=<>]*	{strcpy(da,yytext);for(i=8;da[i]<=91 && da[i]>=65;i++){data[0][i]=da[i];}for(j=i+1;da[j]!='\0';j++){data[1][j-(i+1)]=da[j];}for(i=0;data[0]!='\0';i++)printf("%c",data[0][i]);printf("\n");for(i=0;data[1]!='\0';i++)printf("%c",data[1][i]);}
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
