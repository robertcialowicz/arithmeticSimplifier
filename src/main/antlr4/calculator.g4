grammar calculator;

expression
   : multiplyingExpression PLUS expression # Plus
   | multiplyingExpression MINUS expression # Minus
   | multiplyingExpression # toMultiplyingExpression
   ;

multiplyingExpression
   : powExpression TIMES multiplyingExpression # Times
   | powExpression DIV multiplyingExpression # Div
   | powExpression # toPowExpression
   ;

powExpression
   : signedAtom POW signedAtom # Pow
   | signedAtom # toSignedAtom
   ;

signedAtom
   : atom # PositiveAtom
   | MINUS atom # NegativeAtom
   ;

atom
   : FLOAT # Number
   | VARIABLE # Variable
   | LPAREN expression RPAREN # Parens
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
