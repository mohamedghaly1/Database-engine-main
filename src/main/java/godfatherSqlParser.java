// Generated from /Users/mshereef/Desktop/Uni/Sem6/Databases 2/database-engine/src/main/java/godfatherSql.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class godfatherSqlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		CREATE=10, SELECT=11, FROM=12, TABLE=13, INSERT=14, INTO=15, ROWS=16, 
		UPDATE=17, SET=18, WHERE=19, DELETE=20, NULL=21, INDEX=22, ON=23, VALUES=24, 
		CHECK=25, PRIMARY=26, KEY=27, DOT=28, COMMA=29, ASTERISK=30, LEFT_PARENTHESIS=31, 
		RIGHT_PARENTHESIS=32, EQUALS=33, NOT=34, MINUS=35, PLUS=36, GT=37, GE=38, 
		LT=39, LE=40, NE=41, AND=42, OR=43, XOR=44, QUOTED_STRING=45, INTEGER_VALUE=46, 
		DECIMAL_VALUE=47, DATE=48, IDENTIFIER=49, WS=50;
	public static final int
		RULE_pocket = 0, RULE_statement = 1, RULE_createIndex = 2, RULE_createTable = 3, 
		RULE_insert = 4, RULE_delete = 5, RULE_select = 6, RULE_update = 7, RULE_columnNames = 8, 
		RULE_columnValues = 9, RULE_columnDefinitions = 10, RULE_columnName = 11, 
		RULE_columnValue = 12, RULE_columnDefinition = 13, RULE_updateValueList = 14, 
		RULE_updateValue = 15, RULE_columnType = 16, RULE_booleanExpression = 17, 
		RULE_operator = 18, RULE_compare = 19, RULE_constant = 20, RULE_indexName = 21, 
		RULE_tableName = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"pocket", "statement", "createIndex", "createTable", "insert", "delete", 
			"select", "update", "columnNames", "columnValues", "columnDefinitions", 
			"columnName", "columnValue", "columnDefinition", "updateValueList", "updateValue", 
			"columnType", "booleanExpression", "operator", "compare", "constant", 
			"indexName", "tableName"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'INT'", "'DATE'", "'VARCHAR'", "'DOUBLE'", "'int'", "'date'", 
			"'varchar'", "'double'", null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "'.'", "','", 
			"'*'", "'('", "')'", "'='", "'!'", "'-'", "'+'", "'>'", "'>='", "'<'", 
			"'<='", "'!='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "CREATE", 
			"SELECT", "FROM", "TABLE", "INSERT", "INTO", "ROWS", "UPDATE", "SET", 
			"WHERE", "DELETE", "NULL", "INDEX", "ON", "VALUES", "CHECK", "PRIMARY", 
			"KEY", "DOT", "COMMA", "ASTERISK", "LEFT_PARENTHESIS", "RIGHT_PARENTHESIS", 
			"EQUALS", "NOT", "MINUS", "PLUS", "GT", "GE", "LT", "LE", "NE", "AND", 
			"OR", "XOR", "QUOTED_STRING", "INTEGER_VALUE", "DECIMAL_VALUE", "DATE", 
			"IDENTIFIER", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "godfatherSql.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public godfatherSqlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PocketContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(godfatherSqlParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public PocketContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pocket; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof godfatherSqlVisitor ) return ((godfatherSqlVisitor<? extends T>)visitor).visitPocket(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PocketContext pocket() throws RecognitionException {
		PocketContext _localctx = new PocketContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_pocket);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(48);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CREATE:
				case SELECT:
				case INSERT:
				case UPDATE:
				case DELETE:
					{
					setState(46);
					statement();
					}
					break;
				case T__0:
					{
					setState(47);
					match(T__0);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(50); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1199106L) != 0) );
			setState(52);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public CreateTableContext createTable() {
			return getRuleContext(CreateTableContext.class,0);
		}
		public InsertContext insert() {
			return getRuleContext(InsertContext.class,0);
		}
		public DeleteContext delete() {
			return getRuleContext(DeleteContext.class,0);
		}
		public SelectContext select() {
			return getRuleContext(SelectContext.class,0);
		}
		public CreateIndexContext createIndex() {
			return getRuleContext(CreateIndexContext.class,0);
		}
		public UpdateContext update() {
			return getRuleContext(UpdateContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof godfatherSqlVisitor ) return ((godfatherSqlVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(60);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				createTable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				insert();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(56);
				delete();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(57);
				select();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(58);
				createIndex();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(59);
				update();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CreateIndexContext extends ParserRuleContext {
		public TerminalNode CREATE() { return getToken(godfatherSqlParser.CREATE, 0); }
		public TerminalNode INDEX() { return getToken(godfatherSqlParser.INDEX, 0); }
		public IndexNameContext indexName() {
			return getRuleContext(IndexNameContext.class,0);
		}
		public TerminalNode ON() { return getToken(godfatherSqlParser.ON, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public ColumnNamesContext columnNames() {
			return getRuleContext(ColumnNamesContext.class,0);
		}
		public CreateIndexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createIndex; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof godfatherSqlVisitor ) return ((godfatherSqlVisitor<? extends T>)visitor).visitCreateIndex(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreateIndexContext createIndex() throws RecognitionException {
		CreateIndexContext _localctx = new CreateIndexContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_createIndex);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(CREATE);
			setState(63);
			match(INDEX);
			setState(64);
			indexName();
			setState(65);
			match(ON);
			setState(66);
			tableName();
			setState(67);
			columnNames();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CreateTableContext extends ParserRuleContext {
		public TerminalNode CREATE() { return getToken(godfatherSqlParser.CREATE, 0); }
		public TerminalNode TABLE() { return getToken(godfatherSqlParser.TABLE, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public ColumnDefinitionsContext columnDefinitions() {
			return getRuleContext(ColumnDefinitionsContext.class,0);
		}
		public CreateTableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createTable; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof godfatherSqlVisitor ) return ((godfatherSqlVisitor<? extends T>)visitor).visitCreateTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreateTableContext createTable() throws RecognitionException {
		CreateTableContext _localctx = new CreateTableContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_createTable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(CREATE);
			setState(70);
			match(TABLE);
			setState(71);
			tableName();
			setState(72);
			columnDefinitions();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InsertContext extends ParserRuleContext {
		public TerminalNode INSERT() { return getToken(godfatherSqlParser.INSERT, 0); }
		public TerminalNode INTO() { return getToken(godfatherSqlParser.INTO, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public ColumnNamesContext columnNames() {
			return getRuleContext(ColumnNamesContext.class,0);
		}
		public TerminalNode VALUES() { return getToken(godfatherSqlParser.VALUES, 0); }
		public ColumnValuesContext columnValues() {
			return getRuleContext(ColumnValuesContext.class,0);
		}
		public InsertContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insert; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof godfatherSqlVisitor ) return ((godfatherSqlVisitor<? extends T>)visitor).visitInsert(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InsertContext insert() throws RecognitionException {
		InsertContext _localctx = new InsertContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_insert);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(INSERT);
			setState(75);
			match(INTO);
			setState(76);
			tableName();
			setState(77);
			columnNames();
			setState(78);
			match(VALUES);
			setState(79);
			columnValues();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeleteContext extends ParserRuleContext {
		public TerminalNode DELETE() { return getToken(godfatherSqlParser.DELETE, 0); }
		public TerminalNode FROM() { return getToken(godfatherSqlParser.FROM, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(godfatherSqlParser.WHERE, 0); }
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public DeleteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delete; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof godfatherSqlVisitor ) return ((godfatherSqlVisitor<? extends T>)visitor).visitDelete(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeleteContext delete() throws RecognitionException {
		DeleteContext _localctx = new DeleteContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_delete);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(DELETE);
			setState(82);
			match(FROM);
			setState(83);
			tableName();
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(84);
				match(WHERE);
				setState(85);
				booleanExpression(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SelectContext extends ParserRuleContext {
		public TerminalNode SELECT() { return getToken(godfatherSqlParser.SELECT, 0); }
		public TerminalNode ASTERISK() { return getToken(godfatherSqlParser.ASTERISK, 0); }
		public TerminalNode FROM() { return getToken(godfatherSqlParser.FROM, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(godfatherSqlParser.WHERE, 0); }
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public SelectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof godfatherSqlVisitor ) return ((godfatherSqlVisitor<? extends T>)visitor).visitSelect(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectContext select() throws RecognitionException {
		SelectContext _localctx = new SelectContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_select);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(SELECT);
			setState(89);
			match(ASTERISK);
			setState(90);
			match(FROM);
			setState(91);
			tableName();
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(92);
				match(WHERE);
				setState(93);
				booleanExpression(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UpdateContext extends ParserRuleContext {
		public TerminalNode UPDATE() { return getToken(godfatherSqlParser.UPDATE, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public TerminalNode SET() { return getToken(godfatherSqlParser.SET, 0); }
		public UpdateValueListContext updateValueList() {
			return getRuleContext(UpdateValueListContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(godfatherSqlParser.WHERE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(godfatherSqlParser.IDENTIFIER, 0); }
		public TerminalNode EQUALS() { return getToken(godfatherSqlParser.EQUALS, 0); }
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public UpdateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_update; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof godfatherSqlVisitor ) return ((godfatherSqlVisitor<? extends T>)visitor).visitUpdate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UpdateContext update() throws RecognitionException {
		UpdateContext _localctx = new UpdateContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_update);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(UPDATE);
			setState(97);
			tableName();
			setState(98);
			match(SET);
			setState(99);
			updateValueList();
			setState(100);
			match(WHERE);
			setState(101);
			match(IDENTIFIER);
			setState(102);
			match(EQUALS);
			setState(103);
			constant();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ColumnNamesContext extends ParserRuleContext {
		public TerminalNode LEFT_PARENTHESIS() { return getToken(godfatherSqlParser.LEFT_PARENTHESIS, 0); }
		public List<ColumnNameContext> columnName() {
			return getRuleContexts(ColumnNameContext.class);
		}
		public ColumnNameContext columnName(int i) {
			return getRuleContext(ColumnNameContext.class,i);
		}
		public TerminalNode RIGHT_PARENTHESIS() { return getToken(godfatherSqlParser.RIGHT_PARENTHESIS, 0); }
		public List<TerminalNode> COMMA() { return getTokens(godfatherSqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(godfatherSqlParser.COMMA, i);
		}
		public ColumnNamesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnNames; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof godfatherSqlVisitor ) return ((godfatherSqlVisitor<? extends T>)visitor).visitColumnNames(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnNamesContext columnNames() throws RecognitionException {
		ColumnNamesContext _localctx = new ColumnNamesContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_columnNames);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(LEFT_PARENTHESIS);
			setState(106);
			columnName();
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(107);
				match(COMMA);
				setState(108);
				columnName();
				}
				}
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(114);
			match(RIGHT_PARENTHESIS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ColumnValuesContext extends ParserRuleContext {
		public TerminalNode LEFT_PARENTHESIS() { return getToken(godfatherSqlParser.LEFT_PARENTHESIS, 0); }
		public List<ColumnValueContext> columnValue() {
			return getRuleContexts(ColumnValueContext.class);
		}
		public ColumnValueContext columnValue(int i) {
			return getRuleContext(ColumnValueContext.class,i);
		}
		public TerminalNode RIGHT_PARENTHESIS() { return getToken(godfatherSqlParser.RIGHT_PARENTHESIS, 0); }
		public List<TerminalNode> COMMA() { return getTokens(godfatherSqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(godfatherSqlParser.COMMA, i);
		}
		public ColumnValuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnValues; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof godfatherSqlVisitor ) return ((godfatherSqlVisitor<? extends T>)visitor).visitColumnValues(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnValuesContext columnValues() throws RecognitionException {
		ColumnValuesContext _localctx = new ColumnValuesContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_columnValues);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(LEFT_PARENTHESIS);
			setState(117);
			columnValue();
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(118);
				match(COMMA);
				setState(119);
				columnValue();
				}
				}
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(125);
			match(RIGHT_PARENTHESIS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ColumnDefinitionsContext extends ParserRuleContext {
		public TerminalNode LEFT_PARENTHESIS() { return getToken(godfatherSqlParser.LEFT_PARENTHESIS, 0); }
		public List<ColumnDefinitionContext> columnDefinition() {
			return getRuleContexts(ColumnDefinitionContext.class);
		}
		public ColumnDefinitionContext columnDefinition(int i) {
			return getRuleContext(ColumnDefinitionContext.class,i);
		}
		public TerminalNode RIGHT_PARENTHESIS() { return getToken(godfatherSqlParser.RIGHT_PARENTHESIS, 0); }
		public List<TerminalNode> COMMA() { return getTokens(godfatherSqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(godfatherSqlParser.COMMA, i);
		}
		public ColumnDefinitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnDefinitions; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof godfatherSqlVisitor ) return ((godfatherSqlVisitor<? extends T>)visitor).visitColumnDefinitions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnDefinitionsContext columnDefinitions() throws RecognitionException {
		ColumnDefinitionsContext _localctx = new ColumnDefinitionsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_columnDefinitions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(LEFT_PARENTHESIS);
			setState(128);
			columnDefinition();
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(129);
				match(COMMA);
				setState(130);
				columnDefinition();
				}
				}
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(136);
			match(RIGHT_PARENTHESIS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ColumnNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(godfatherSqlParser.IDENTIFIER, 0); }
		public ColumnNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof godfatherSqlVisitor ) return ((godfatherSqlVisitor<? extends T>)visitor).visitColumnName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnNameContext columnName() throws RecognitionException {
		ColumnNameContext _localctx = new ColumnNameContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_columnName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ColumnValueContext extends ParserRuleContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public ColumnValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnValue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof godfatherSqlVisitor ) return ((godfatherSqlVisitor<? extends T>)visitor).visitColumnValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnValueContext columnValue() throws RecognitionException {
		ColumnValueContext _localctx = new ColumnValueContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_columnValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			constant();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ColumnDefinitionContext extends ParserRuleContext {
		public List<ColumnNameContext> columnName() {
			return getRuleContexts(ColumnNameContext.class);
		}
		public ColumnNameContext columnName(int i) {
			return getRuleContext(ColumnNameContext.class,i);
		}
		public ColumnTypeContext columnType() {
			return getRuleContext(ColumnTypeContext.class,0);
		}
		public TerminalNode CHECK() { return getToken(godfatherSqlParser.CHECK, 0); }
		public TerminalNode LEFT_PARENTHESIS() { return getToken(godfatherSqlParser.LEFT_PARENTHESIS, 0); }
		public TerminalNode GE() { return getToken(godfatherSqlParser.GE, 0); }
		public List<ConstantContext> constant() {
			return getRuleContexts(ConstantContext.class);
		}
		public ConstantContext constant(int i) {
			return getRuleContext(ConstantContext.class,i);
		}
		public TerminalNode AND() { return getToken(godfatherSqlParser.AND, 0); }
		public TerminalNode LE() { return getToken(godfatherSqlParser.LE, 0); }
		public TerminalNode RIGHT_PARENTHESIS() { return getToken(godfatherSqlParser.RIGHT_PARENTHESIS, 0); }
		public TerminalNode PRIMARY() { return getToken(godfatherSqlParser.PRIMARY, 0); }
		public TerminalNode KEY() { return getToken(godfatherSqlParser.KEY, 0); }
		public ColumnDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof godfatherSqlVisitor ) return ((godfatherSqlVisitor<? extends T>)visitor).visitColumnDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnDefinitionContext columnDefinition() throws RecognitionException {
		ColumnDefinitionContext _localctx = new ColumnDefinitionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_columnDefinition);
		try {
			setState(161);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(142);
				columnName();
				setState(143);
				columnType();
				setState(144);
				match(CHECK);
				setState(145);
				match(LEFT_PARENTHESIS);
				setState(146);
				columnName();
				setState(147);
				match(GE);
				setState(148);
				constant();
				setState(149);
				match(AND);
				setState(150);
				columnName();
				setState(151);
				match(LE);
				setState(152);
				constant();
				setState(153);
				match(RIGHT_PARENTHESIS);
				}
				break;
			case PRIMARY:
				enterOuterAlt(_localctx, 2);
				{
				setState(155);
				match(PRIMARY);
				setState(156);
				match(KEY);
				setState(157);
				match(LEFT_PARENTHESIS);
				setState(158);
				columnName();
				setState(159);
				match(RIGHT_PARENTHESIS);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UpdateValueListContext extends ParserRuleContext {
		public TerminalNode LEFT_PARENTHESIS() { return getToken(godfatherSqlParser.LEFT_PARENTHESIS, 0); }
		public List<UpdateValueContext> updateValue() {
			return getRuleContexts(UpdateValueContext.class);
		}
		public UpdateValueContext updateValue(int i) {
			return getRuleContext(UpdateValueContext.class,i);
		}
		public TerminalNode RIGHT_PARENTHESIS() { return getToken(godfatherSqlParser.RIGHT_PARENTHESIS, 0); }
		public List<TerminalNode> COMMA() { return getTokens(godfatherSqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(godfatherSqlParser.COMMA, i);
		}
		public UpdateValueListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_updateValueList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof godfatherSqlVisitor ) return ((godfatherSqlVisitor<? extends T>)visitor).visitUpdateValueList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UpdateValueListContext updateValueList() throws RecognitionException {
		UpdateValueListContext _localctx = new UpdateValueListContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_updateValueList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(LEFT_PARENTHESIS);
			setState(164);
			updateValue();
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(165);
				match(COMMA);
				setState(166);
				updateValue();
				}
				}
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(172);
			match(RIGHT_PARENTHESIS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UpdateValueContext extends ParserRuleContext {
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(godfatherSqlParser.EQUALS, 0); }
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public UpdateValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_updateValue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof godfatherSqlVisitor ) return ((godfatherSqlVisitor<? extends T>)visitor).visitUpdateValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UpdateValueContext updateValue() throws RecognitionException {
		UpdateValueContext _localctx = new UpdateValueContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_updateValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			columnName();
			setState(175);
			match(EQUALS);
			setState(176);
			constant();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ColumnTypeContext extends ParserRuleContext {
		public ColumnTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof godfatherSqlVisitor ) return ((godfatherSqlVisitor<? extends T>)visitor).visitColumnType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnTypeContext columnType() throws RecognitionException {
		ColumnTypeContext _localctx = new ColumnTypeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_columnType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1020L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BooleanExpressionContext extends ParserRuleContext {
		public BooleanExpressionContext left;
		public BooleanExpressionContext right;
		public TerminalNode IDENTIFIER() { return getToken(godfatherSqlParser.IDENTIFIER, 0); }
		public CompareContext compare() {
			return getRuleContext(CompareContext.class,0);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public List<BooleanExpressionContext> booleanExpression() {
			return getRuleContexts(BooleanExpressionContext.class);
		}
		public BooleanExpressionContext booleanExpression(int i) {
			return getRuleContext(BooleanExpressionContext.class,i);
		}
		public BooleanExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof godfatherSqlVisitor ) return ((godfatherSqlVisitor<? extends T>)visitor).visitBooleanExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanExpressionContext booleanExpression() throws RecognitionException {
		return booleanExpression(0);
	}

	private BooleanExpressionContext booleanExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BooleanExpressionContext _localctx = new BooleanExpressionContext(_ctx, _parentState);
		BooleanExpressionContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_booleanExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(181);
			match(IDENTIFIER);
			setState(182);
			compare();
			setState(183);
			constant();
			}
			_ctx.stop = _input.LT(-1);
			setState(191);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BooleanExpressionContext(_parentctx, _parentState);
					_localctx.left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_booleanExpression);
					setState(185);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(186);
					operator();
					setState(187);
					((BooleanExpressionContext)_localctx).right = booleanExpression(2);
					}
					} 
				}
				setState(193);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OperatorContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(godfatherSqlParser.AND, 0); }
		public TerminalNode OR() { return getToken(godfatherSqlParser.OR, 0); }
		public TerminalNode XOR() { return getToken(godfatherSqlParser.XOR, 0); }
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof godfatherSqlVisitor ) return ((godfatherSqlVisitor<? extends T>)visitor).visitOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 30786325577728L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CompareContext extends ParserRuleContext {
		public TerminalNode EQUALS() { return getToken(godfatherSqlParser.EQUALS, 0); }
		public TerminalNode GT() { return getToken(godfatherSqlParser.GT, 0); }
		public TerminalNode GE() { return getToken(godfatherSqlParser.GE, 0); }
		public TerminalNode LT() { return getToken(godfatherSqlParser.LT, 0); }
		public TerminalNode LE() { return getToken(godfatherSqlParser.LE, 0); }
		public TerminalNode NE() { return getToken(godfatherSqlParser.NE, 0); }
		public CompareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compare; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof godfatherSqlVisitor ) return ((godfatherSqlVisitor<? extends T>)visitor).visitCompare(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompareContext compare() throws RecognitionException {
		CompareContext _localctx = new CompareContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_compare);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4269197492224L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode NULL() { return getToken(godfatherSqlParser.NULL, 0); }
		public TerminalNode IDENTIFIER() { return getToken(godfatherSqlParser.IDENTIFIER, 0); }
		public TerminalNode INTEGER_VALUE() { return getToken(godfatherSqlParser.INTEGER_VALUE, 0); }
		public TerminalNode MINUS() { return getToken(godfatherSqlParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(godfatherSqlParser.PLUS, 0); }
		public TerminalNode DECIMAL_VALUE() { return getToken(godfatherSqlParser.DECIMAL_VALUE, 0); }
		public List<TerminalNode> QUOTED_STRING() { return getTokens(godfatherSqlParser.QUOTED_STRING); }
		public TerminalNode QUOTED_STRING(int i) {
			return getToken(godfatherSqlParser.QUOTED_STRING, i);
		}
		public TerminalNode DATE() { return getToken(godfatherSqlParser.DATE, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof godfatherSqlVisitor ) return ((godfatherSqlVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_constant);
		int _la;
		try {
			int _alt;
			setState(214);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(198);
				match(NULL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(199);
				match(IDENTIFIER);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(201);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS || _la==PLUS) {
					{
					setState(200);
					_la = _input.LA(1);
					if ( !(_la==MINUS || _la==PLUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(203);
				match(INTEGER_VALUE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(205);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS || _la==PLUS) {
					{
					setState(204);
					_la = _input.LA(1);
					if ( !(_la==MINUS || _la==PLUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(207);
				match(DECIMAL_VALUE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(209); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(208);
						match(QUOTED_STRING);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(211); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(213);
				match(DATE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IndexNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(godfatherSqlParser.IDENTIFIER, 0); }
		public IndexNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof godfatherSqlVisitor ) return ((godfatherSqlVisitor<? extends T>)visitor).visitIndexName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IndexNameContext indexName() throws RecognitionException {
		IndexNameContext _localctx = new IndexNameContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_indexName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TableNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(godfatherSqlParser.IDENTIFIER, 0); }
		public TableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof godfatherSqlVisitor ) return ((godfatherSqlVisitor<? extends T>)visitor).visitTableName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableNameContext tableName() throws RecognitionException {
		TableNameContext _localctx = new TableNameContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_tableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 17:
			return booleanExpression_sempred((BooleanExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean booleanExpression_sempred(BooleanExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00012\u00dd\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0001\u0000\u0001\u0000\u0004\u00001\b\u0000"+
		"\u000b\u0000\f\u00002\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001=\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0003\u0005W\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006_\b\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0005\bn\b\b\n\b\f\bq\t\b"+
		"\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0005\ty\b\t\n\t\f\t"+
		"|\t\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u0084\b"+
		"\n\n\n\f\n\u0087\t\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0003\r\u00a2\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0005\u000e\u00a8\b\u000e\n\u000e\f\u000e\u00ab\t\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u00be\b\u0011"+
		"\n\u0011\f\u0011\u00c1\t\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001"+
		"\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u00ca\b\u0014\u0001"+
		"\u0014\u0001\u0014\u0003\u0014\u00ce\b\u0014\u0001\u0014\u0001\u0014\u0004"+
		"\u0014\u00d2\b\u0014\u000b\u0014\f\u0014\u00d3\u0001\u0014\u0003\u0014"+
		"\u00d7\b\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0000\u0001\"\u0017\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u001e \"$&(*,\u0000\u0004\u0001\u0000\u0002\t"+
		"\u0001\u0000*,\u0002\u0000!!%)\u0001\u0000#$\u00dc\u00000\u0001\u0000"+
		"\u0000\u0000\u0002<\u0001\u0000\u0000\u0000\u0004>\u0001\u0000\u0000\u0000"+
		"\u0006E\u0001\u0000\u0000\u0000\bJ\u0001\u0000\u0000\u0000\nQ\u0001\u0000"+
		"\u0000\u0000\fX\u0001\u0000\u0000\u0000\u000e`\u0001\u0000\u0000\u0000"+
		"\u0010i\u0001\u0000\u0000\u0000\u0012t\u0001\u0000\u0000\u0000\u0014\u007f"+
		"\u0001\u0000\u0000\u0000\u0016\u008a\u0001\u0000\u0000\u0000\u0018\u008c"+
		"\u0001\u0000\u0000\u0000\u001a\u00a1\u0001\u0000\u0000\u0000\u001c\u00a3"+
		"\u0001\u0000\u0000\u0000\u001e\u00ae\u0001\u0000\u0000\u0000 \u00b2\u0001"+
		"\u0000\u0000\u0000\"\u00b4\u0001\u0000\u0000\u0000$\u00c2\u0001\u0000"+
		"\u0000\u0000&\u00c4\u0001\u0000\u0000\u0000(\u00d6\u0001\u0000\u0000\u0000"+
		"*\u00d8\u0001\u0000\u0000\u0000,\u00da\u0001\u0000\u0000\u0000.1\u0003"+
		"\u0002\u0001\u0000/1\u0005\u0001\u0000\u00000.\u0001\u0000\u0000\u0000"+
		"0/\u0001\u0000\u0000\u000012\u0001\u0000\u0000\u000020\u0001\u0000\u0000"+
		"\u000023\u0001\u0000\u0000\u000034\u0001\u0000\u0000\u000045\u0005\u0000"+
		"\u0000\u00015\u0001\u0001\u0000\u0000\u00006=\u0003\u0006\u0003\u0000"+
		"7=\u0003\b\u0004\u00008=\u0003\n\u0005\u00009=\u0003\f\u0006\u0000:=\u0003"+
		"\u0004\u0002\u0000;=\u0003\u000e\u0007\u0000<6\u0001\u0000\u0000\u0000"+
		"<7\u0001\u0000\u0000\u0000<8\u0001\u0000\u0000\u0000<9\u0001\u0000\u0000"+
		"\u0000<:\u0001\u0000\u0000\u0000<;\u0001\u0000\u0000\u0000=\u0003\u0001"+
		"\u0000\u0000\u0000>?\u0005\n\u0000\u0000?@\u0005\u0016\u0000\u0000@A\u0003"+
		"*\u0015\u0000AB\u0005\u0017\u0000\u0000BC\u0003,\u0016\u0000CD\u0003\u0010"+
		"\b\u0000D\u0005\u0001\u0000\u0000\u0000EF\u0005\n\u0000\u0000FG\u0005"+
		"\r\u0000\u0000GH\u0003,\u0016\u0000HI\u0003\u0014\n\u0000I\u0007\u0001"+
		"\u0000\u0000\u0000JK\u0005\u000e\u0000\u0000KL\u0005\u000f\u0000\u0000"+
		"LM\u0003,\u0016\u0000MN\u0003\u0010\b\u0000NO\u0005\u0018\u0000\u0000"+
		"OP\u0003\u0012\t\u0000P\t\u0001\u0000\u0000\u0000QR\u0005\u0014\u0000"+
		"\u0000RS\u0005\f\u0000\u0000SV\u0003,\u0016\u0000TU\u0005\u0013\u0000"+
		"\u0000UW\u0003\"\u0011\u0000VT\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000"+
		"\u0000W\u000b\u0001\u0000\u0000\u0000XY\u0005\u000b\u0000\u0000YZ\u0005"+
		"\u001e\u0000\u0000Z[\u0005\f\u0000\u0000[^\u0003,\u0016\u0000\\]\u0005"+
		"\u0013\u0000\u0000]_\u0003\"\u0011\u0000^\\\u0001\u0000\u0000\u0000^_"+
		"\u0001\u0000\u0000\u0000_\r\u0001\u0000\u0000\u0000`a\u0005\u0011\u0000"+
		"\u0000ab\u0003,\u0016\u0000bc\u0005\u0012\u0000\u0000cd\u0003\u001c\u000e"+
		"\u0000de\u0005\u0013\u0000\u0000ef\u00051\u0000\u0000fg\u0005!\u0000\u0000"+
		"gh\u0003(\u0014\u0000h\u000f\u0001\u0000\u0000\u0000ij\u0005\u001f\u0000"+
		"\u0000jo\u0003\u0016\u000b\u0000kl\u0005\u001d\u0000\u0000ln\u0003\u0016"+
		"\u000b\u0000mk\u0001\u0000\u0000\u0000nq\u0001\u0000\u0000\u0000om\u0001"+
		"\u0000\u0000\u0000op\u0001\u0000\u0000\u0000pr\u0001\u0000\u0000\u0000"+
		"qo\u0001\u0000\u0000\u0000rs\u0005 \u0000\u0000s\u0011\u0001\u0000\u0000"+
		"\u0000tu\u0005\u001f\u0000\u0000uz\u0003\u0018\f\u0000vw\u0005\u001d\u0000"+
		"\u0000wy\u0003\u0018\f\u0000xv\u0001\u0000\u0000\u0000y|\u0001\u0000\u0000"+
		"\u0000zx\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{}\u0001\u0000"+
		"\u0000\u0000|z\u0001\u0000\u0000\u0000}~\u0005 \u0000\u0000~\u0013\u0001"+
		"\u0000\u0000\u0000\u007f\u0080\u0005\u001f\u0000\u0000\u0080\u0085\u0003"+
		"\u001a\r\u0000\u0081\u0082\u0005\u001d\u0000\u0000\u0082\u0084\u0003\u001a"+
		"\r\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0084\u0087\u0001\u0000\u0000"+
		"\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000"+
		"\u0000\u0086\u0088\u0001\u0000\u0000\u0000\u0087\u0085\u0001\u0000\u0000"+
		"\u0000\u0088\u0089\u0005 \u0000\u0000\u0089\u0015\u0001\u0000\u0000\u0000"+
		"\u008a\u008b\u00051\u0000\u0000\u008b\u0017\u0001\u0000\u0000\u0000\u008c"+
		"\u008d\u0003(\u0014\u0000\u008d\u0019\u0001\u0000\u0000\u0000\u008e\u008f"+
		"\u0003\u0016\u000b\u0000\u008f\u0090\u0003 \u0010\u0000\u0090\u0091\u0005"+
		"\u0019\u0000\u0000\u0091\u0092\u0005\u001f\u0000\u0000\u0092\u0093\u0003"+
		"\u0016\u000b\u0000\u0093\u0094\u0005&\u0000\u0000\u0094\u0095\u0003(\u0014"+
		"\u0000\u0095\u0096\u0005*\u0000\u0000\u0096\u0097\u0003\u0016\u000b\u0000"+
		"\u0097\u0098\u0005(\u0000\u0000\u0098\u0099\u0003(\u0014\u0000\u0099\u009a"+
		"\u0005 \u0000\u0000\u009a\u00a2\u0001\u0000\u0000\u0000\u009b\u009c\u0005"+
		"\u001a\u0000\u0000\u009c\u009d\u0005\u001b\u0000\u0000\u009d\u009e\u0005"+
		"\u001f\u0000\u0000\u009e\u009f\u0003\u0016\u000b\u0000\u009f\u00a0\u0005"+
		" \u0000\u0000\u00a0\u00a2\u0001\u0000\u0000\u0000\u00a1\u008e\u0001\u0000"+
		"\u0000\u0000\u00a1\u009b\u0001\u0000\u0000\u0000\u00a2\u001b\u0001\u0000"+
		"\u0000\u0000\u00a3\u00a4\u0005\u001f\u0000\u0000\u00a4\u00a9\u0003\u001e"+
		"\u000f\u0000\u00a5\u00a6\u0005\u001d\u0000\u0000\u00a6\u00a8\u0003\u001e"+
		"\u000f\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a8\u00ab\u0001\u0000"+
		"\u0000\u0000\u00a9\u00a7\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000"+
		"\u0000\u0000\u00aa\u00ac\u0001\u0000\u0000\u0000\u00ab\u00a9\u0001\u0000"+
		"\u0000\u0000\u00ac\u00ad\u0005 \u0000\u0000\u00ad\u001d\u0001\u0000\u0000"+
		"\u0000\u00ae\u00af\u0003\u0016\u000b\u0000\u00af\u00b0\u0005!\u0000\u0000"+
		"\u00b0\u00b1\u0003(\u0014\u0000\u00b1\u001f\u0001\u0000\u0000\u0000\u00b2"+
		"\u00b3\u0007\u0000\u0000\u0000\u00b3!\u0001\u0000\u0000\u0000\u00b4\u00b5"+
		"\u0006\u0011\uffff\uffff\u0000\u00b5\u00b6\u00051\u0000\u0000\u00b6\u00b7"+
		"\u0003&\u0013\u0000\u00b7\u00b8\u0003(\u0014\u0000\u00b8\u00bf\u0001\u0000"+
		"\u0000\u0000\u00b9\u00ba\n\u0001\u0000\u0000\u00ba\u00bb\u0003$\u0012"+
		"\u0000\u00bb\u00bc\u0003\"\u0011\u0002\u00bc\u00be\u0001\u0000\u0000\u0000"+
		"\u00bd\u00b9\u0001\u0000\u0000\u0000\u00be\u00c1\u0001\u0000\u0000\u0000"+
		"\u00bf\u00bd\u0001\u0000\u0000\u0000\u00bf\u00c0\u0001\u0000\u0000\u0000"+
		"\u00c0#\u0001\u0000\u0000\u0000\u00c1\u00bf\u0001\u0000\u0000\u0000\u00c2"+
		"\u00c3\u0007\u0001\u0000\u0000\u00c3%\u0001\u0000\u0000\u0000\u00c4\u00c5"+
		"\u0007\u0002\u0000\u0000\u00c5\'\u0001\u0000\u0000\u0000\u00c6\u00d7\u0005"+
		"\u0015\u0000\u0000\u00c7\u00d7\u00051\u0000\u0000\u00c8\u00ca\u0007\u0003"+
		"\u0000\u0000\u00c9\u00c8\u0001\u0000\u0000\u0000\u00c9\u00ca\u0001\u0000"+
		"\u0000\u0000\u00ca\u00cb\u0001\u0000\u0000\u0000\u00cb\u00d7\u0005.\u0000"+
		"\u0000\u00cc\u00ce\u0007\u0003\u0000\u0000\u00cd\u00cc\u0001\u0000\u0000"+
		"\u0000\u00cd\u00ce\u0001\u0000\u0000\u0000\u00ce\u00cf\u0001\u0000\u0000"+
		"\u0000\u00cf\u00d7\u0005/\u0000\u0000\u00d0\u00d2\u0005-\u0000\u0000\u00d1"+
		"\u00d0\u0001\u0000\u0000\u0000\u00d2\u00d3\u0001\u0000\u0000\u0000\u00d3"+
		"\u00d1\u0001\u0000\u0000\u0000\u00d3\u00d4\u0001\u0000\u0000\u0000\u00d4"+
		"\u00d7\u0001\u0000\u0000\u0000\u00d5\u00d7\u00050\u0000\u0000\u00d6\u00c6"+
		"\u0001\u0000\u0000\u0000\u00d6\u00c7\u0001\u0000\u0000\u0000\u00d6\u00c9"+
		"\u0001\u0000\u0000\u0000\u00d6\u00cd\u0001\u0000\u0000\u0000\u00d6\u00d1"+
		"\u0001\u0000\u0000\u0000\u00d6\u00d5\u0001\u0000\u0000\u0000\u00d7)\u0001"+
		"\u0000\u0000\u0000\u00d8\u00d9\u00051\u0000\u0000\u00d9+\u0001\u0000\u0000"+
		"\u0000\u00da\u00db\u00051\u0000\u0000\u00db-\u0001\u0000\u0000\u0000\u000f"+
		"02<V^oz\u0085\u00a1\u00a9\u00bf\u00c9\u00cd\u00d3\u00d6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}