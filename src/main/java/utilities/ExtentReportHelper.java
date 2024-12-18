package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentReportHelper {
    public static ExtentReports reports;
    static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd_MM_yyyy_hh_mm_ss");
    public static ExtentReports getReportObject(){
        String reportPath = "./reports/"+dateTimeFormatter.format(LocalDateTime.now());
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setReportName("Automation Results");
        sparkReporter.config().setDocumentTitle("Execution results");
        sparkReporter.config().setTimeStampFormat("EEEE,MMMM,dd,yyyy,hh:mm a '('zzz')'");

        reports = new ExtentReports();
        reports.attachReporter(sparkReporter);
        reports.setSystemInfo("Tester is :","Debasis Silla");
        return reports;
    }
}
