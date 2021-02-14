package sbrest.pdf;

import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

public class LoadDoc {
	public static void main(String args[]) throws IOException {

		try {

			File file = new File(
					"C:/Users/Rawad/Downloads/Enrollment_forms/ISD Downey Data Center Registration LA County Employees.pdf");
			PDDocument document = PDDocument.load(file);

			PDDocumentCatalog docCatalog = document.getDocumentCatalog();
			PDAcroForm acroForm = docCatalog.getAcroForm();
			PDField field1 = (PDField) acroForm.getField("1");
			PDField field2 = (PDField) acroForm.getField("2");
			PDField field4 = (PDField) acroForm.getField("4");
			PDField field5 = (PDField) acroForm.getField("5");

			field1.setValue("10/1/2020");
			field2.setValue("On");
			field4.setValue("Smith John ");
			field5.setValue("johnSmith@gmail.com");

			// Saving the document
			document.save(
					"C:/Users/Rawad/Downloads/Enrollment_forms/ISD Downey Data Center Registration LA County Employees.pdf");

			// Closing the document
			document.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		{
			try {

				File file = new File(
						"C:/Users/Rawad/Downloads/Enrollment_forms/ISD  Active Directory Hosted Registration Forms Permanent Employees.pdf");
				PDDocument document = PDDocument.load(file);

				PDDocumentCatalog docCatalog = document.getDocumentCatalog();
				PDAcroForm acroForm = docCatalog.getAcroForm();
				PDField field1 = (PDField) acroForm.getField("new");
				PDField field2 = (PDField) acroForm.getField("1");
				PDField field3 = (PDField) acroForm.getField("2");
				PDField field4 = (PDField) acroForm.getField("3");
				PDField field5 = (PDField) acroForm.getField("4");
				PDField field6 = (PDField) acroForm.getField("5");
				PDField field7 = (PDField) acroForm.getField("6");
				PDField field8 = (PDField) acroForm.getField("7");
				PDField field9 = (PDField) acroForm.getField("8");
				PDField field10 = (PDField) acroForm.getField("9");
				PDField field11 = (PDField) acroForm.getField("10");
				PDField field12 = (PDField) acroForm.getField("11");
				PDField field13 = (PDField) acroForm.getField("12");
				PDField field14 = (PDField) acroForm.getField("13");

				field1.setValue("1");
				field2.setValue("Smith");
				field3.setValue("Smith ");
				field4.setValue("B");
				field5.setValue("3431131");
				field6.setValue("352323AADD533");
				field7.setValue("johnSmith@gmail.com");
				field8.setValue("Department");
				field9.setValue("103322");
				field10.setValue("123street");
				field11.setValue("Los Angeles");
				field12.setValue("90032");
				field13.setValue("(323) 123-4567");
				field14.setValue("1");

				// Saving the document
				document.save(
						"C:/Users/Rawad/Downloads/Enrollment_forms/ISD  Active Directory Hosted Registration Forms Permanent Employees.pdf");

				// Closing the document
				document.close();
			} catch (IOException er) {
				er.printStackTrace();

			}
		}
	}
}
