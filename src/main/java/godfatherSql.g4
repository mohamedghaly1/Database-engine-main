grammar godfatherSql;

pocket
  : (statement | ';')+ EOF
  ;

statement
    : createTable
    | insert
    | delete
    | select
    | createIndex
    | update
    ;

createIndex
    : CREATE INDEX indexName ON tableName columnNames
    ;

createTable
    : CREATE TABLE tableName columnDefinitions
    ;

insert
    : INSERT INTO tableName columnNames VALUES columnValues
    ;

delete
    : DELETE FROM tableName (WHERE booleanExpression)?
    ;

select
    : SELECT ASTERISK FROM tableName (WHERE booleanExpression)?
    ;

update
    : UPDATE tableName SET updateValueList WHERE IDENTIFIER EQUALS constant
    ;

columnNames
    : LEFT_PARENTHESIS columnName  (COMMA columnName)* RIGHT_PARENTHESIS
    ;

columnValues
    : LEFT_PARENTHESIS columnValue  (COMMA columnValue)* RIGHT_PARENTHESIS
    ;

columnDefinitions
    : LEFT_PARENTHESIS columnDefinition  (COMMA columnDefinition)* RIGHT_PARENTHESIS
    ;

columnName
    : IDENTIFIER
    ;

columnValue
    : constant
    ;

columnDefinition
    : columnName columnType CHECK LEFT_PARENTHESIS columnName GE constant AND columnName LE constant RIGHT_PARENTHESIS
    | PRIMARY KEY LEFT_PARENTHESIS columnName RIGHT_PARENTHESIS
    ;

updateValueList
    : LEFT_PARENTHESIS updateValue  (COMMA updateValue)* RIGHT_PARENTHESIS
    ;

updateValue
    : columnName EQUALS constant
    ;

columnType
    : 'INT'
    | 'DATE'
    | 'VARCHAR'
    | 'DOUBLE'
    | 'int'
    | 'date'
    | 'varchar'
    | 'double'
    ;


booleanExpression
    : IDENTIFIER compare constant
    | left=booleanExpression operator right=booleanExpression
    ;

operator
    : AND
    | OR
    | XOR
    ;

compare:
    EQUALS | GT | GE| LT| LE | NE;

constant
    : NULL
    | IDENTIFIER
    | (MINUS | PLUS)? INTEGER_VALUE
    | (MINUS | PLUS)? DECIMAL_VALUE
    | QUOTED_STRING+
    | DATE
    ;

indexName
    : IDENTIFIER
    ;

tableName
    : IDENTIFIER
    ;

CREATE : 'CREATE' | 'create';
SELECT: 'SELECT' | 'select';
FROM: 'FROM' | 'from';
TABLE: 'TABLE' | 'table';
INSERT : 'INSERT' | 'insert';
INTO : 'INTO' | 'into';
ROWS : 'ROWS' | 'rows';
UPDATE : 'UPDATE' | 'update';
SET : 'SET' | 'set';
WHERE : 'WHERE' | 'where';
DELETE : 'DELETE' | 'delete';
NULL : 'NULL' | 'null';
INDEX : 'INDEX' | 'index';
ON : 'ON' | 'on';
VALUES: 'VALUES' | 'values';
CHECK: 'CHECK' | 'check';
PRIMARY: 'PRIMARY' | 'primary';
KEY: 'KEY' | 'key';


DOT: '.';
COMMA: ',';
ASTERISK: '*';
LEFT_PARENTHESIS: '(';
RIGHT_PARENTHESIS: ')';
EQUALS: '=';
NOT : '!';
MINUS : '-';
PLUS: '+';
GT: '>';
GE: '>=';
LT: '<';
LE: '<=';
NE: '!=';


AND: 'AND' | 'and' | '&&';
OR: 'OR' | 'or' | '||';
XOR: 'XOR' | 'xor';


QUOTED_STRING
    : '\'' ( ~('\''|'\\') | ('\\' .) )* '\''
    | '"' ( ~('"'|'\\') | ('\\' .) )* '"'
    ;

INTEGER_VALUE
    : DIGIT+
    ;

DECIMAL_VALUE
    : DECIMAL_DIGITS
    ;

DATE
    : DIGIT DIGIT DIGIT DIGIT '/' DIGIT DIGIT '/' DIGIT DIGIT
    ;

IDENTIFIER
    : (LETTER | DIGIT | '_' )+
    ;



fragment DECIMAL_DIGITS
    : DIGIT+ '.' DIGIT*
    | '.' DIGIT+
    ;

fragment DIGIT
    : [0-9]
    ;

fragment LETTER
    : [a-zA-Z]
    ;

WS
    : [ \r\n\t]+ -> channel(HIDDEN)
    ;