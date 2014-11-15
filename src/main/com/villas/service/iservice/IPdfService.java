package main.com.villas.service.iservice;

import org.apache.pdfbox.exceptions.COSVisitorException;

import java.io.IOException;

/**
 * Created by aboyarintsev on 11/15/2014.
 */
public interface IPdfService {

    byte[] drawInvoice() throws IOException, COSVisitorException;
}
