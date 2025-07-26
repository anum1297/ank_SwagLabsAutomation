package com.swaglabs.utilities;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;
import com.swaglabs.helpers.TestData_Reader;
import static com.swaglabs.driver.ListenerConfig.*; // Import test counters
import static com.swaglabs.utilities.ReportConstants.*; // For report path

public class EmailGeneration {

 public static void sendReportEmail() {
        TestData_Reader reader = new TestData_Reader();
        String from = reader.getProperty("mailFrom");
        String to = reader.getProperty("mailTo");
        String appPassword = reader.getProperty("appPassword");

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, appPassword);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("SwagLabs Automation - Test Execution Summary");

            int total = passedTests + failedTests + skippedTests;
            String statusText = (failedTests > 0) ? "❌ Failed" : "✔ Passed";
            String statusColor = (failedTests > 0) ? "red" : "green";

            String htmlContent = "<h3>SwagLabs Automation Test Summary</h3>" +
                    "<table border='1' cellpadding='8' cellspacing='0' style='border-collapse: collapse; font-family: Arial;'>" +
                    "<tr style='background-color: #f2f2f2;'>" +
                    "<th>Project</th><th>Suite</th><th>Total</th><th>Passed</th><th>Failed</th><th>Skipped</th><th>Status</th>" +
                    "</tr>" +
                    "<tr>" +
                    "<td>SwagLabs</td>" +
                    "<td>Regression Suite</td>" +
                    "<td>" + total + "</td>" +
                    "<td>" + passedTests + "</td>" +
                    "<td>" + failedTests + "</td>" +
                    "<td>" + skippedTests + "</td>" +
                    "<td style='color:" + statusColor + ";'><b>" + statusText + "</b></td>" +
                    "</tr>" +
                    "</table>" +
                    "<br><h4>✅ Passed Test Cases:</h4>" + buildHtmlList(passedTestNames) +
                    "<h4>❌ Failed Test Cases:</h4>" + buildHtmlList(failedTestNames) +
                    "<h4>⏭ Skipped Test Cases:</h4>" + buildHtmlList(skippedTestNames) +
                    "<p>See attached Extent Report for full execution details.</p>";

            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(htmlContent, "text/html");

            MimeBodyPart attachmentPart = new MimeBodyPart();
            File reportFile = new File(REPORT_PATH);
            if (!reportFile.exists()) {
                throw new FileNotFoundException("Report file not found at: " + REPORT_PATH);
            }
            attachmentPart.attachFile(reportFile);

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentPart);

            message.setContent(multipart);
            Transport.send(message);
            System.out.println("✅ Email sent successfully with summary and report.");

        } catch (Exception e) {
            System.err.println("❌ Failed to send email:");
            e.printStackTrace();
        }
    }

    private static String buildHtmlList(List<String> testNames) {
        if (testNames.isEmpty()) return "<i>None</i>";
        StringBuilder builder = new StringBuilder("<ul>");
        for (String name : testNames) {
            builder.append("<li>").append(name).append("</li>");
        }
        builder.append("</ul>");
        return builder.toString();
    }
}
