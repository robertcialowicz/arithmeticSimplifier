// Generated from calculator.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class calculatorLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COS=1, SIN=2, TAN=3, ACOS=4, ASIN=5, ATAN=6, LN=7, LOG=8, SQRT=9, LPAREN=10, 
		RPAREN=11, PLUS=12, MINUS=13, TIMES=14, DIV=15, COMMA=16, POINT=17, POW=18, 
		PI=19, EULER=20, I=21, VARIABLE=22, SCIENTIFIC_NUMBER=23, WS=24;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"COS", "SIN", "TAN", "ACOS", "ASIN", "ATAN", "LN", "LOG", "SQRT", "LPAREN", 
			"RPAREN", "PLUS", "MINUS", "TIMES", "DIV", "COMMA", "POINT", "POW", "PI", 
			"EULER", "I", "VARIABLE", "VALID_ID_START", "VALID_ID_CHAR", "SCIENTIFIC_NUMBER", 
			"NUMBER", "E1", "E2", "SIGN", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'cos'", "'sin'", "'tan'", "'acos'", "'asin'", "'atan'", "'ln'", 
			"'log'", "'sqrt'", "'('", "')'", "'+'", "'-'", "'*'", "'/'", "','", "'.'", 
			"'^'", "'pi'", null, "'i'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COS", "SIN", "TAN", "ACOS", "ASIN", "ATAN", "LN", "LOG", "SQRT", 
			"LPAREN", "RPAREN", "PLUS", "MINUS", "TIMES", "DIV", "COMMA", "POINT", 
			"POW", "PI", "EULER", "I", "VARIABLE", "SCIENTIFIC_NUMBER", "WS"
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


	public calculatorLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "calculator.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\32\u00b3\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2"+
		"\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3"+
		"\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n"+
		"\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3"+
		"\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3"+
		"\27\7\27\u0082\n\27\f\27\16\27\u0085\13\27\3\30\5\30\u0088\n\30\3\31\3"+
		"\31\5\31\u008c\n\31\3\32\3\32\3\32\5\32\u0091\n\32\3\32\5\32\u0094\n\32"+
		"\3\32\3\32\5\32\u0098\n\32\3\33\6\33\u009b\n\33\r\33\16\33\u009c\3\33"+
		"\3\33\6\33\u00a1\n\33\r\33\16\33\u00a2\5\33\u00a5\n\33\3\34\3\34\3\35"+
		"\3\35\3\36\3\36\3\37\6\37\u00ae\n\37\r\37\16\37\u00af\3\37\3\37\2\2 \3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\23%\24\'\25)\26+\27-\30/\2\61\2\63\31\65\2\67\29\2;\2=\32\3\2"+
		"\5\5\2C\\aac|\4\2--//\5\2\13\f\17\17\"\"\2\u00b5\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2\63\3\2\2\2\2=\3\2\2\2\3?\3\2"+
		"\2\2\5C\3\2\2\2\7G\3\2\2\2\tK\3\2\2\2\13P\3\2\2\2\rU\3\2\2\2\17Z\3\2\2"+
		"\2\21]\3\2\2\2\23a\3\2\2\2\25f\3\2\2\2\27h\3\2\2\2\31j\3\2\2\2\33l\3\2"+
		"\2\2\35n\3\2\2\2\37p\3\2\2\2!r\3\2\2\2#t\3\2\2\2%v\3\2\2\2\'x\3\2\2\2"+
		"){\3\2\2\2+}\3\2\2\2-\177\3\2\2\2/\u0087\3\2\2\2\61\u008b\3\2\2\2\63\u008d"+
		"\3\2\2\2\65\u009a\3\2\2\2\67\u00a6\3\2\2\29\u00a8\3\2\2\2;\u00aa\3\2\2"+
		"\2=\u00ad\3\2\2\2?@\7e\2\2@A\7q\2\2AB\7u\2\2B\4\3\2\2\2CD\7u\2\2DE\7k"+
		"\2\2EF\7p\2\2F\6\3\2\2\2GH\7v\2\2HI\7c\2\2IJ\7p\2\2J\b\3\2\2\2KL\7c\2"+
		"\2LM\7e\2\2MN\7q\2\2NO\7u\2\2O\n\3\2\2\2PQ\7c\2\2QR\7u\2\2RS\7k\2\2ST"+
		"\7p\2\2T\f\3\2\2\2UV\7c\2\2VW\7v\2\2WX\7c\2\2XY\7p\2\2Y\16\3\2\2\2Z[\7"+
		"n\2\2[\\\7p\2\2\\\20\3\2\2\2]^\7n\2\2^_\7q\2\2_`\7i\2\2`\22\3\2\2\2ab"+
		"\7u\2\2bc\7s\2\2cd\7t\2\2de\7v\2\2e\24\3\2\2\2fg\7*\2\2g\26\3\2\2\2hi"+
		"\7+\2\2i\30\3\2\2\2jk\7-\2\2k\32\3\2\2\2lm\7/\2\2m\34\3\2\2\2no\7,\2\2"+
		"o\36\3\2\2\2pq\7\61\2\2q \3\2\2\2rs\7.\2\2s\"\3\2\2\2tu\7\60\2\2u$\3\2"+
		"\2\2vw\7`\2\2w&\3\2\2\2xy\7r\2\2yz\7k\2\2z(\3\2\2\2{|\59\35\2|*\3\2\2"+
		"\2}~\7k\2\2~,\3\2\2\2\177\u0083\5/\30\2\u0080\u0082\5\61\31\2\u0081\u0080"+
		"\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084"+
		".\3\2\2\2\u0085\u0083\3\2\2\2\u0086\u0088\t\2\2\2\u0087\u0086\3\2\2\2"+
		"\u0088\60\3\2\2\2\u0089\u008c\5/\30\2\u008a\u008c\4\62;\2\u008b\u0089"+
		"\3\2\2\2\u008b\u008a\3\2\2\2\u008c\62\3\2\2\2\u008d\u0097\5\65\33\2\u008e"+
		"\u0091\5\67\34\2\u008f\u0091\59\35\2\u0090\u008e\3\2\2\2\u0090\u008f\3"+
		"\2\2\2\u0091\u0093\3\2\2\2\u0092\u0094\5;\36\2\u0093\u0092\3\2\2\2\u0093"+
		"\u0094\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096\5\65\33\2\u0096\u0098\3"+
		"\2\2\2\u0097\u0090\3\2\2\2\u0097\u0098\3\2\2\2\u0098\64\3\2\2\2\u0099"+
		"\u009b\4\62;\2\u009a\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009a\3\2"+
		"\2\2\u009c\u009d\3\2\2\2\u009d\u00a4\3\2\2\2\u009e\u00a0\7\60\2\2\u009f"+
		"\u00a1\4\62;\2\u00a0\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a0\3\2"+
		"\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a5\3\2\2\2\u00a4\u009e\3\2\2\2\u00a4"+
		"\u00a5\3\2\2\2\u00a5\66\3\2\2\2\u00a6\u00a7\7G\2\2\u00a78\3\2\2\2\u00a8"+
		"\u00a9\7g\2\2\u00a9:\3\2\2\2\u00aa\u00ab\t\3\2\2\u00ab<\3\2\2\2\u00ac"+
		"\u00ae\t\4\2\2\u00ad\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00ad\3\2"+
		"\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\b\37\2\2\u00b2"+
		">\3\2\2\2\r\2\u0083\u0087\u008b\u0090\u0093\u0097\u009c\u00a2\u00a4\u00af"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}