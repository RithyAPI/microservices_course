package com.ut.utAttendance.helper;


import com.itextpdf.text.pdf.BidiLine;

public class KhmerLigaturizer {

    public static String process(String s) {
        UnicodeRenderKhmer khmerRender = new UnicodeRenderKhmer();
        return BidiLine.processLTR(khmerRender.render(s), 2, 0);
    }
}
