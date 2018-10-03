echo `clear`
lex oep1.l
gcc lex.yy.c && ./a.out oep1.l
echo -e '\n'
lex oep2.l
gcc lex.yy.c && ./a.out oep2.l
echo -e '\n'
