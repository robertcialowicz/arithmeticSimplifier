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
   | func_
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

func_
   : funcname LPAREN expression (COMMA expression)* RPAREN
   ;

funcname
   : COS
   | TAN
   | SIN
   | SQRT
   ;

COS
   : 'cos'
   ;

SIN
   : 'sin'
   ;

TAN
   : 'tan'
   ;

SQRT
   : 'sqrt'
   ;

LPAREN
   : '('
   ;

RPAREN
   : ')'
   ;

PLUS
   : '+'
   ;

MINUS
   : '-'
   ;

TIMES
   : '*'
   ;

DIV
   : '/'
   ;

COMMA
   : ','
   ;

POINT
   : '.'
   ;

POW
   : '^'
   ;

VARIABLE
   : VALID_ID_START VALID_ID_CHAR*
   ;

fragment VALID_ID_START
   : ('a' .. 'z') | ('A' .. 'Z') | '_'
   ;

fragment VALID_ID_CHAR
   : VALID_ID_START | ('0' .. '9')
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
