grammar calculator;

expression
   : multiplyingExpression ((PLUS | MINUS) multiplyingExpression)*
   ;

multiplyingExpression
   : powExpression ((TIMES | DIV) powExpression)*
   ;

powExpression
   : signedAtom (POW signedAtom)*
   ;

signedAtom
   : PLUS signedAtom
   | MINUS signedAtom
   | atom
   ;

atom
   : number
   | variable
   | LPAREN expression RPAREN
   ;

number
   : FLOAT
   ;

variable
   : VARIABLE
   ;

LPAREN : '(' ;
RPAREN : ')' ;
PLUS : '+' ;
MINUS : '-' ;
TIMES : '*' ;
DIV : '/' ;
COMMA : ',' ;
POINT : '.' ;
POW : '^' ;

VARIABLE
   : ('a' .. 'z') | ('A' .. 'Z')
   ;

FLOAT
   : ('0' .. '9') + ('.' ('0' .. '9') +)?
   ;

fragment SIGN
   : ('+' | '-')
   ;

WS
   : [ \r\n\t] + -> skip
   ;
