package com.ut.utAttendance.helper;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class EncryPDF {

    public static void encryPDFNewVersion(String urlFiile,String urlStoreage, String Password, String user) throws IOException {
        // step 1. Loading the pdf file
        File f = new File(urlFiile);
        PDDocument pdd = PDDocument.load(f);

        // step 2.Creating instance of AccessPermission
        // class
        AccessPermission ap = new AccessPermission();

        // step 3. Creating instance of
        // StandardProtectionPolicy
        StandardProtectionPolicy stpp
                = new StandardProtectionPolicy(Password, user, ap);

        // step 4. Setting the length of Encryption key
        stpp.setEncryptionKeyLength(128);

        // step 5. Setting the permission
        stpp.setPermissions(ap);

        // step 6. Protecting the PDF file
        pdd.protect(stpp);

        // step 7. Saving and closing the the PDF Document
        pdd.save(urlStoreage);
        pdd.close();

        System.out.println("PDF Encrypted successfully...");
    }

    public static void encryPDF(String urlFiile,String urlStoreage, String Password, String user) throws IOException, DocumentException {
        PdfReader reader = new PdfReader(urlFiile);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(urlStoreage));
        stamper.setEncryption(Password.getBytes(), "owner_password".getBytes(),PdfWriter.ALLOW_COPY, PdfWriter.ENCRYPTION_AES_256);
        stamper.close();
        reader.close();
        System.out.println("Successfully Done");
    }

    public static void encryPDFVersion3(String urlFiile,String urlStoreage, String Password, String user) throws IOException, DocumentException {
        try {
            String userPassword = "user123";
            String ownerPassword = "owner123";

            //Create Document instance.
            Document document = new Document();

            //Create OutputStream instance.
            OutputStream outputStream =
                    new FileOutputStream(new File("D:\\quotation.pdf"));

            //Create PDFWriter instance.
            PdfWriter pdfWriter =
                    PdfWriter.getInstance(document, outputStream);

            //Add password protection.
            pdfWriter.setEncryption(userPassword.getBytes(),
                    ownerPassword.getBytes(),
                    PdfWriter.ALLOW_PRINTING,
                    PdfWriter.ENCRYPTION_AES_256);

            //Open the document.
            document.open();

            //Add content to the document.
            document.add(new Paragraph("Hello world, this is a " +
                    "test pdf file with password protection."));

            //Close document and outputStream.
            document.close();
            outputStream.close();

            System.out.println("Pdf created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
