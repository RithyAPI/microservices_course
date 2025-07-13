package com.ut.utAttendance.helper;


public class UnicodeRenderKhmer {
    private final int _xx = 0;
    private final int CC_COENG = 7;
    private final int CC_CONSONANT = 1;
    private final int CC_CONSONANT_SHIFTER = 5;
    private final int CC_CONSONANT2 = 2;
    private final int CC_CONSONANT3 = 3;
    private final int CC_DEPENDENT_VOWEL = 8;
    private final int CC_ROBAT = 6;
    private final int CC_SIGN_ABOVE = 9;
    private final int CC_SIGN_AFTER = 10;
    private final int CF_ABOVE_VOWEL = 536870912;
    private final int CF_CLASS_MASK = 65535;
    private final int CF_COENG = 134217728;
    private final int CF_CONSONANT = 16777216;
    private final int CF_DOTTED_CIRCLE = 67108864;
    private final int CF_POS_ABOVE = 131072;
    private final int CF_POS_AFTER = 65536;
    private final int CF_POS_BEFORE = 524288;
    private final int CF_POS_BELOW = 262144;
    private final int CF_SHIFTER = 268435456;
    private final int CF_SPLIT_VOWEL = 33554432;
    private final int _c1 = 16777217;
    private final int _c2 = 16777218;
    private final int _c3 = 16777219;
    private final int _co = 201326599;
    private final int _cs = 335544325;
    private final int _da = 604110856;
    private final int _db = 67371016;
    private final int _dl = 67633160;
    private final int _dr = 67174408;
    private final int _rb = 67239942;
    private final int _sa = 67239945;
    private final int _sp = 67174410;
    private final int _va = 637665288;
    private final int _vr = 100728840;
    private char BA = UnicodeUtil.unicodeChar("0x1794");
    private char COENG = UnicodeUtil.unicodeChar("0x17D2");
    private String CONYO = Character.toString(UnicodeUtil.unicodeChar("0x17D2")).concat(Character.toString(UnicodeUtil.unicodeChar("0x1789")));
    private String CORO = Character.toString(UnicodeUtil.unicodeChar("0x17D2")).concat(Character.toString(UnicodeUtil.unicodeChar("0x179A")));
    private int[] khmerCharClasses = new int[]{16777217, 16777217, 16777217, 16777219, 16777217, 16777217, 16777217, 16777217, 16777219, 16777217, 16777217, 16777217, 16777217, 16777219, 16777217, 16777217, 16777217, 16777217, 16777217, 16777217, 16777219, 16777217, 16777217, 16777217, 16777217, 16777219, 16777218, 16777217, 16777217, 16777217, 16777219, 16777219, 16777217, 16777219, 16777217, 16777217, 16777217, 16777217, 16777217, 16777217, 16777217, 16777217, 16777217, 16777217, 16777217, 16777217, 16777217, 16777217, 16777217, 16777217, 16777217, 16777217, 67174408, 67174408, 67174408, 604110856, 604110856, 604110856, 604110856, 67371016, 67371016, 67371016, 637665288, 100728840, 100728840, 67633160, 67633160, 67633160, 100728840, 100728840, 67239945, 67174410, 67174410, 335544325, 335544325, 67239945, 67239942, 67239945, 67239945, 67239945, 67239945, 67239945, 201326599, 67239945, 0, 0, 0, 0, 0, 0, 0, 0, 0, 67239945, 0, 0};
    private short[][] khmerStateTable = new short[][]{{1, 2, 2, 2, 1, 1, 1, 6, 1, 1, 1, 2}, {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, 3, 4, 5, 6, 16, 17, 1, -1}, {-1, -1, -1, -1, -1, 4, -1, -1, 16, -1, -1, -1}, {-1, -1, -1, -1, 15, -1, -1, 6, 16, 17, 1, 14}, {-1, -1, -1, -1, -1, -1, -1, -1, 20, -1, 1, -1}, {-1, 7, 8, 9, -1, -1, -1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, 12, 13, -1, 10, 16, 17, 1, 14}, {-1, -1, -1, -1, 12, 13, -1, -1, 16, 17, 1, 14}, {-1, -1, -1, -1, 12, 13, -1, 10, 16, 17, 1, 14}, {-1, 11, 11, 11, -1, -1, -1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, 15, -1, -1, -1, 16, 17, 1, 14}, {-1, -1, -1, -1, -1, 13, -1, -1, 16, -1, -1, -1}, {-1, -1, -1, -1, 15, -1, -1, -1, 16, 17, 1, 14}, {-1, -1, -1, -1, -1, -1, -1, -1, 16, -1, -1, -1}, {-1, -1, -1, -1, -1, -1, -1, -1, 16, -1, -1, -1}, {-1, -1, -1, -1, -1, -1, -1, -1, -1, 17, 1, 18}, {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, 18}, {-1, -1, -1, -1, -1, -1, -1, 19, -1, -1, -1, -1}, {-1, 1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1}};
    private char MARK = UnicodeUtil.unicodeChar("0x17EA");
    private char NYO = UnicodeUtil.unicodeChar("0x1789");
    private char SA = UnicodeUtil.unicodeChar("0x179F");
    private char SRAAA = UnicodeUtil.unicodeChar("0x17B6");
    private char SRAAU = UnicodeUtil.unicodeChar("0x17C5");
    private char SRAE = UnicodeUtil.unicodeChar("0x17C1");
    private char SRAIE = UnicodeUtil.unicodeChar("0x17C0");
    private char SRAII = UnicodeUtil.unicodeChar("0x17B8");
    private char SRAOE = UnicodeUtil.unicodeChar("0x17BE");
    private char SRAOO = UnicodeUtil.unicodeChar("0x17C4");
    private char SRAU = UnicodeUtil.unicodeChar("0x17BB");
    private char SRAYA = UnicodeUtil.unicodeChar("0x17BF");
    private char TRIISAP = UnicodeUtil.unicodeChar("0x17CA");
    private char YO = UnicodeUtil.unicodeChar("0x1799");

    public UnicodeRenderKhmer() {
    }

    private char strEcombining(char chrInput) {
        char retChar = ' ';
        if (chrInput == this.SRAOE) {
            retChar = this.SRAII;
        } else if (chrInput == this.SRAYA) {
            retChar = this.SRAYA;
        } else if (chrInput == this.SRAIE) {
            retChar = this.SRAIE;
        } else if (chrInput == this.SRAOO) {
            retChar = this.SRAAA;
        } else if (chrInput == this.SRAAU) {
            retChar = this.SRAAU;
        }

        return retChar;
    }

    private int getCharClass(char uniChar) {
        int retValue = 0;
        if (uniChar > 255 && uniChar >= UnicodeUtil.unicodeChar("0x1780")) {
            int ch = uniChar - UnicodeUtil.unicodeChar("0x1780");
            if (ch < this.khmerCharClasses.length) {
                retValue = this.khmerCharClasses[ch];
            }
        }

        return retValue;
    }

    public String render(String strInput) {
        int cursor = 0;
        short state = 0;
        int charCount = strInput.length();

        StringBuilder result;
        for(result = new StringBuilder(); cursor < charCount; state = 0) {
            String _reserved = "";
            String _signAbove = "";
            String _signAfter = "";
            String _base = "";
            String _robat = "";
            String _shifter = "";
            String _vowelBefore = "";
            String _vowelBelow = "";
            String _vowelAbove = "";
            String _vowelAfter = "";
            boolean _coeng = false;
            String _coeng1 = "";
            String _coeng2 = "";

            boolean _shifterAfterCoeng;
            for(_shifterAfterCoeng = false; cursor < charCount; ++cursor) {
                char curChar = strInput.charAt(cursor);
                int kChar = this.getCharClass(curChar);
                int charClass = kChar & '\uffff';

                try {
                    state = this.khmerStateTable[state][charClass];
                } catch (Exception var28) {
                    state = -1;
                }

                if (state < 0) {
                    break;
                }

                if (kChar == 0) {
                    _reserved = Character.toString(curChar);
                } else if (kChar == 67239945) {
                    _signAbove = Character.toString(curChar);
                } else if (kChar == 67174410) {
                    _signAfter = Character.toString(curChar);
                } else if (kChar != 16777217 && kChar != 16777218 && kChar != 16777219) {
                    if (kChar == 67239942) {
                        _robat = Character.toString(curChar);
                    } else if (kChar == 335544325) {
                        if (!"".equalsIgnoreCase(_coeng1)) {
                            _shifterAfterCoeng = true;
                        }

                        _shifter = Character.toString(curChar);
                    } else if (kChar == 67633160) {
                        _vowelBefore = Character.toString(curChar);
                    } else if (kChar == 67371016) {
                        _vowelBelow = Character.toString(curChar);
                    } else if (kChar == 604110856) {
                        _vowelAbove = Character.toString(curChar);
                    } else if (kChar == 67174408) {
                        _vowelAfter = Character.toString(curChar);
                    } else if (kChar == 201326599) {
                        _coeng = true;
                    } else if (kChar == 637665288) {
                        _vowelBefore = Character.toString(this.SRAE);
                        _vowelAbove = Character.toString(this.strEcombining(curChar));
                    } else if (kChar == 100728840) {
                        _vowelBefore = Character.toString(this.SRAE);
                        _vowelAfter = Character.toString(this.strEcombining(curChar));
                    }
                } else if (_coeng) {
                    if ("".equalsIgnoreCase(_coeng1)) {
                        _coeng1 = Character.toString(this.COENG).concat(Character.toString(curChar));
                    } else {
                        _coeng2 = Character.toString(this.COENG).concat(Character.toString(curChar));
                    }

                    _coeng = false;
                } else {
                    _base = Character.toString(curChar);
                }
            }

            String _coengBefore = "";
            if (this.CORO.equalsIgnoreCase(_coeng1)) {
                _coengBefore = _coeng1;
                _coeng1 = "";
            } else if (this.CORO.equalsIgnoreCase(_coeng2)) {
                _coengBefore = _coeng2;
                _coeng2 = "";
            }

            if ((!"".equalsIgnoreCase(_coeng1) || !"".equalsIgnoreCase(_coeng2)) && Character.toString(this.NYO).equalsIgnoreCase(_base)) {
                _base = Character.toString(UnicodeUtil.unicodeChar("0xF0AE"));
                if (_coeng1.equalsIgnoreCase(this.CONYO)) {
                    _coeng1 = Character.toString(UnicodeUtil.unicodeChar("0xF0CB"));
                }
            }

            if (!"".equalsIgnoreCase(_base) && !"".equalsIgnoreCase(_shifter)) {
                if (!"".equalsIgnoreCase(_vowelAbove) && Character.toString(this.BA).equalsIgnoreCase(_base) && Character.toString(this.TRIISAP).equalsIgnoreCase(_shifter)) {
                    _vowelAbove = UnicodeUtil.getVowelAbove(_vowelAbove);
                } else if (!"".equalsIgnoreCase(_vowelAbove)) {
                    _shifter = "";
                    _vowelBelow = Character.toString(this.SRAU);
                }
            }

            if (_coeng && "".equalsIgnoreCase(_coeng1)) {
                _coeng1 = Character.toString(this.COENG);
            } else if (_coeng && "".equalsIgnoreCase(_coeng2)) {
                _coeng2 = Character.toString(this.MARK).concat(Character.toString(this.COENG));
            }

            if ("".equalsIgnoreCase(_base) && !"".equalsIgnoreCase(_vowelBefore) && !"".equalsIgnoreCase(_coengBefore) && "".equalsIgnoreCase(_robat) && "".equalsIgnoreCase(_shifter) && "".equalsIgnoreCase(_coeng1) && "".equalsIgnoreCase(_coeng2) && "".equalsIgnoreCase(_vowelAfter) && "".equalsIgnoreCase(_vowelBelow) && "".equalsIgnoreCase(_vowelAbove) && "".equalsIgnoreCase(_signAbove) && !"".equalsIgnoreCase(_signAfter)) {
            }

            String _shifter1 = "";
            String _shifter2 = "";
            _shifter = UnicodeUtil.getConsonantShifter(_shifter);
            if (_shifterAfterCoeng) {
                _shifter2 = _shifter;
            } else {
                _shifter1 = _shifter;
            }

            boolean _specialCaseBA = false;
            String strMARK_SRAAA = Character.toString(this.MARK).concat(Character.toString(this.SRAAA));
            String strMARK_SRAAU = Character.toString(this.MARK).concat(Character.toString(this.SRAAU));
            if (Character.toString(this.BA).equalsIgnoreCase(_base) && (Character.toString(this.SRAAA).equalsIgnoreCase(_vowelAfter) || Character.toString(this.SRAAU).equalsIgnoreCase(_vowelAfter) || strMARK_SRAAA.equalsIgnoreCase(_vowelAfter) || strMARK_SRAAU.equalsIgnoreCase(_vowelAfter))) {
                _base = Character.toString(UnicodeUtil.unicodeChar("0xF0AF"));
                _specialCaseBA = true;
                if (!"".equalsIgnoreCase(_coeng1)) {
                    String _coeng1Complete = _coeng1.substring(0, _coeng1.length() - 1);
                    if (Character.toString(this.BA).equalsIgnoreCase(_coeng1Complete) || Character.toString(this.YO).equalsIgnoreCase(_coeng1Complete) || Character.toString(this.SA).equalsIgnoreCase(_coeng1Complete)) {
                        _specialCaseBA = false;
                    }
                }
            }

            _coengBefore = UnicodeUtil.getSubConsonant(_coengBefore);
            _coeng1 = UnicodeUtil.getSubConsonant(_coeng1);
            _coeng2 = UnicodeUtil.getSubConsonant(_coeng2);
            _vowelAfter = UnicodeUtil.change(_vowelAfter);
            _signAbove = UnicodeUtil.change(_signAbove);
            if (!_robat.equalsIgnoreCase("")) {
                _vowelAbove = UnicodeUtil.getVowelAbove(_vowelAbove);
            } else {
                _vowelAbove = UnicodeUtil.change(_vowelAbove);
            }

            if (_coeng1.equalsIgnoreCase("") && _coeng2.equalsIgnoreCase("")) {
                _vowelBelow = UnicodeUtil.change(_vowelBelow);
            } else {
                _vowelBelow = UnicodeUtil.getVowelBelow(_vowelBelow);
            }

            String _cluster;
            if (_specialCaseBA) {
                _cluster = _vowelBefore + _coengBefore + _base + _vowelAfter + _robat + _shifter1 + _coeng1 + _coeng2 + _shifter2 + _vowelBelow + _vowelAbove + _signAbove + _signAfter;
            } else {
                _cluster = _vowelBefore + _coengBefore + _base + _robat + _shifter1 + _coeng1 + _coeng2 + _shifter2 + _vowelBelow + _vowelAbove + _vowelAfter + _signAbove + _signAfter;
            }

            result.append(_cluster + _reserved);
        }

        return result.toString();
    }
}