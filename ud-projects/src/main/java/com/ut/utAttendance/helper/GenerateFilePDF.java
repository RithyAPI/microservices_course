//package com.ut.vendingMachineCC.helper;
//
//import com.itextpdf.text.*;
//import com.itextpdf.text.pdf.ColumnText;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;
//import com.ut.vendingMachineCC.model.FileSendPayslip;
//import com.ut.vendingMachineCC.service.FileSendPayslipService;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.servlet.http.HttpServletRequest;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.net.UnknownHostException;
//import java.util.UUID;
//
//public class GenerateFilePDF {
//
//    @Autowired
//    public FileSendPayslipService fileSendPayslipService;
//
//    private static final String ROOT;
//    private static final String PROJECT_NAME;
//    private static final String FOLDER_UPLOAD;
//
//    static {
//        ROOT = System.getProperty("catalina.base");
//        PROJECT_NAME = "logs/SmartVMCCAPi";
//        FOLDER_UPLOAD = "upload";
//    }
//
//    public String PDFPayslip(HttpServletRequest httpServletRequest) throws UnknownHostException {
//
//        FileSendPayslip fileSendPayslip = new FileSendPayslip();
//        // Generate File PDF
//        Document document = new Document();
//        String aliasFilename = UUID.randomUUID().toString();
//        File path = new File(ROOT + File.separator + PROJECT_NAME + File.separator + FOLDER_UPLOAD+"/"+aliasFilename+".pdf");
//        fileSendPayslip.setUrl("/"+FOLDER_UPLOAD+"/"+aliasFilename+".pdf");
//        try {
//            File file = new File(String.valueOf(path));
//            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
//            document.open();
//
//            int[] columnWidths = new int[] { 2, 1, 1};
//            PdfPTable datatable = new PdfPTable(columnWidths.length);
//            datatable.setHorizontalAlignment(Element.ALIGN_CENTER);
//            datatable.setWidthPercentage(100);
//            datatable.setWidths(columnWidths);
//            //TODO: Image
//            Image image1 = Image.getInstance("https://ci3.googleusercontent.com/proxy/-_vMPCltSn7IAU9vKRo0U2XgnOAsK9E2-B7knhKkaIbCb1Ap_CPfUk3adOzeLTbVqDelw3xbxR2aG3hwHeKs82TC7NHZhf7L42i6FcCoriI5CVPFnAt9pMa6bto3UcC-o9f9evWp3W4z1Tuu=s0-d-e1-ft#https://qacltom.udaya-tech.com/SmartVMCCAPi/upload/028dfa09-ed77-4bf2-8b37-2e4ce51ba5ec.png");
//            image1.scaleAbsolute(50,50);
//            image1.setAlignment(Element.ALIGN_CENTER);
//
//            Paragraph report2 = new Paragraph("Compensation Statement for February/2022");
//            report2.setAlignment(Element.ALIGN_CENTER);
//
//            Paragraph report3 = new Paragraph("Private & Confidential");
//            report3.setAlignment(Element.ALIGN_CENTER);
//
//            document.add(image1);
//            document.add(report2);
//            document.add(report3);
//            document.add(new Paragraph("-"));
//            document.add(new Paragraph("Employee ID: 55895"));
//            document.add(new Paragraph("Employee Name: HIM RINA"));
//            document.add(new Paragraph("Phnom Penh, Cambodia"));
//            document.add(new Paragraph("DTC & EVENT ACTIVATION MANAGER"));
//            document.add(new Paragraph("February/2022"));
//            document.add(new Paragraph("-"));
//
//            datatable.addCell(new Paragraph("Payroll Type", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD)));
//            datatable.addCell(new Paragraph("Monthly (USD)", new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD)));
//            datatable.addCell(new Paragraph("Year to Date (USD)", new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD)));
//
//            datatable.addCell(new Paragraph("Base salary"));
//            datatable.addCell(new Paragraph("baseSalaryInMonth"+"$"));
//            datatable.addCell(new Paragraph("10$"));
//
//            System.out.println("baseSalaryInMonth"+"baseSalaryInMonth");
//
//            datatable.addCell(new Paragraph("Position Allowance"));
//            datatable.addCell(new Paragraph("10$"));
//            datatable.addCell(new Paragraph("10$"));
//
//            datatable.addCell(new Paragraph("Mobile Allowance"));
//            datatable.addCell(new Paragraph("10$"));
//            datatable.addCell(new Paragraph("10$"));
//
//            datatable.addCell(new Paragraph("Car Allowance"));
//            datatable.addCell(new Paragraph("10$"));
//            datatable.addCell(new Paragraph("10$"));
//
//            datatable.addCell(new Paragraph("Maintenance Allowance"));
//            datatable.addCell(new Paragraph("10$"));
//            datatable.addCell(new Paragraph("10$"));
//
//            datatable.addCell(new Paragraph("Housing Allowance (net pay)"));
//            datatable.addCell(new Paragraph("10$"));
//            datatable.addCell(new Paragraph("10$"));
//
//            datatable.addCell(new Paragraph("Transportation Allowance (net pay)"));
//            datatable.addCell(new Paragraph("10$"));
//            datatable.addCell(new Paragraph("10$"));
//
//            datatable.addCell(new Paragraph("Field Support Allowance (net pay)"));
//            datatable.addCell(new Paragraph("10$"));
//            datatable.addCell(new Paragraph("10$"));
//
//            datatable.addCell(new Paragraph("Relocation Allowance (net pay)"));
//            datatable.addCell(new Paragraph("10$"));
//            datatable.addCell(new Paragraph("10$"));
//
//            datatable.addCell(new Paragraph("Long Service Award (net pay)"));
//            datatable.addCell(new Paragraph("10$"));
//            datatable.addCell(new Paragraph("10$"));
//
//            datatable.addCell(new Paragraph("Overtime"));
//            datatable.addCell(new Paragraph("10$"));
//            datatable.addCell(new Paragraph("10$"));
//
//            datatable.addCell(new Paragraph("Sales Incentives"));
//            datatable.addCell(new Paragraph("10$"));
//            datatable.addCell(new Paragraph("10$"));
//
//            datatable.addCell(new Paragraph("Safety Incentive"));
//            datatable.addCell(new Paragraph("10$"));
//            datatable.addCell(new Paragraph("10$"));
//
//            datatable.addCell(new Paragraph("Quarterly Sales Incentive"));
//            datatable.addCell(new Paragraph("10$"));
//            datatable.addCell(new Paragraph("10$"));
//
//            datatable.addCell(new Paragraph("Quarterly Recognition Award"));
//            datatable.addCell(new Paragraph("10$"));
//            datatable.addCell(new Paragraph("10$"));
//
//            datatable.addCell(new Paragraph("Program Incentive Mevius (net pay)"));
//            datatable.addCell(new Paragraph("10$"));
//            datatable.addCell(new Paragraph("10$"));
//
//            datatable.addCell(new Paragraph("Program Incentive Winston (net pay)"));
//            datatable.addCell(new Paragraph("10$"));
//            datatable.addCell(new Paragraph("10$"));
//
//            datatable.addCell(new Paragraph("Gift of Joy (net pay)"));
//            datatable.addCell(new Paragraph("10$"));
//            datatable.addCell(new Paragraph("10$"));
//
//            datatable.addCell(new Paragraph("Dental Claim (net pay)"));
//            datatable.addCell(new Paragraph("10$"));
//            datatable.addCell(new Paragraph("10$"));
//
//            datatable.addCell(new Paragraph("Subtotal", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD)));
//            datatable.addCell(new Paragraph("100$", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD)));
//            datatable.addCell(new Paragraph("10$", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD)));
//
//            datatable.addCell(new Paragraph("Dental Claim (net pay)"));
//            datatable.addCell(new Paragraph("10$"));
//            datatable.addCell(new Paragraph("10$"));
//
//            datatable.addCell(new Paragraph("Employee Pension Contribution"));
//            datatable.addCell(new Paragraph("10$"));
//            datatable.addCell(new Paragraph("10$"));
//
//            datatable.addCell(new Paragraph("Loan Deduction"));
//            datatable.addCell(new Paragraph("10$"));
//            datatable.addCell(new Paragraph("10$"));
//
//            datatable.addCell(new Paragraph("1st Payrun"));
//            datatable.addCell(new Paragraph("10$"));
//            datatable.addCell(new Paragraph("10$"));
//
//            datatable.addCell(new Paragraph("Subtotal", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD)));
//            datatable.addCell(new Paragraph("1000$", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD)));
//            datatable.addCell(new Paragraph("1000$", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD)));
//
//            datatable.addCell(new Paragraph("Net Compensation", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD)));
//            datatable.addCell(new Paragraph("10$", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD)));
//            datatable.addCell(new Paragraph("10$", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD)));
//
//            datatable.addCell(new Paragraph("Pension Contribution – For Information Only", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD)));
//            datatable.addCell(new Paragraph("10$", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD)));
//            datatable.addCell(new Paragraph("10$", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD)));
//
//            document.add(datatable);
//
//            ColumnText columnText = new ColumnText(writer.getDirectContent());
//            columnText.setRunDirection(PdfWriter.RUN_DIRECTION_LTR);
//            fileSendPayslip.setEmployeeId(1l);
//            fileSendPayslipService.insert(fileSendPayslip, null, httpServletRequest);
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
//        document.close();
//        return "";
//    }
//}
