package utilityClasses;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	private static ExtentReports extent;
	
	public static ExtentReports getInstance()
	
	{
		if (extent==null)	
		{
		      String reportPath=System.getProperty("user.dir")+"/reports/TestReport.html";
		      
		      ExtentSparkReporter reporter=new ExtentSparkReporter(reportPath);
		      
		      reporter.config().setDocumentTitle("Automation Report");
		      reporter.config().setReportName("Functional Testing Report");
		      reporter.config().setTheme(Theme.STANDARD);
		      
		      
		      extent=new ExtentReports();
		      extent.attachReporter(reporter);
		        extent.setSystemInfo("Project", "OrangeHRM");
		        extent.setSystemInfo("Tester", "Sharad Chaudhari");
		        extent.setSystemInfo("Environment", "QA");
		      
		}
		return extent;
	}
 
}