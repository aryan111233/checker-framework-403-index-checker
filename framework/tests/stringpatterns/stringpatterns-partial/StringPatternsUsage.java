        import tests.util.*;

public class StringPatternsUsage {

  void requiresA(@PatternA String arg) { }
  void requiresB(@PatternB String arg) { }
  void requiresC(@PatternC String arg) { }
  void requiresAB(@PatternAB String arg) { }
  void requiresBC(@PatternBC String arg) { }
  void requiresAC(@PatternAC String arg) { }
  void requiresAny(String arg) { }

  void m() {

    String a = "A";
    String b = "B";
    String c = "C";
    String d = "D";
    String e = "";

    // This should produce the following diagnostic:
    // :-1: other: error: Bug in @ImplicitFor(stringpatterns=...) in type hierarchy definition: inferred type for "A" is [@tests.util.PatternBottomPartial] which is a subtype of [@tests.util.PatternBC] but its pattern does not match the string.  matches = [[@tests.util.PatternAC], [@tests.util.PatternAB]]; nonMatches = [[@tests.util.PatternBC]]

    requiresA(a);

  }

}
