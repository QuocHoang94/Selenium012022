package test;

import com.google.common.reflect.ClassPath;
import com.google.j2objc.annotations.ReflectionSupport;
import driver.BrowserType;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {

    @SuppressWarnings("UnstableApiUsage")
    public static void main(String[] args) throws IOException {
        // Get all classes that start with prefix "test."
        final ClassLoader loader = Thread.currentThread().getContextClassLoader();
        List<Class<?>> testsClasses = new ArrayList<>();

        for (ClassPath.ClassInfo info : ClassPath.from(loader).getTopLevelClasses()) {
            if(info.getName().startsWith("test.") && !info.getName().equalsIgnoreCase("test.BaseTest") && !info.getName().equalsIgnoreCase("test.Main")){
                testsClasses.add(info.load());
            }
        }

        // Get browser
        String browser = System.getProperty("browser");
        if(browser == null){
            throw new RuntimeException("Please provide browser via -Dbrowser");
        }
        try {
            BrowserType.valueOf(browser);
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("[ERR] " + browser + " is not supported, we covered for " + Arrays.toString(BrowserType.values()));
        }

        // We will parallel base on maximum parallel session
        final int MAX_PARALLEL_SESSION = 4;
        List<String> testGroupNames = new ArrayList<>();
        for (int index = 0; index < MAX_PARALLEL_SESSION; index++) {
            testGroupNames.add("Group " + (index + 1));
        }

        // Divide test classes into groups
        int testNumEachGroup = testsClasses.size() / testGroupNames.size();
        HashMap<String, List<Class<?>>> desiredCaps = new HashMap<>();
        for (int groupIndex = 0; groupIndex < testGroupNames.size(); groupIndex++) {
            int startIndex = groupIndex * testNumEachGroup;
            int endIndex = groupIndex == testGroupNames.size() - 1 ? testsClasses.size() : (startIndex + testNumEachGroup);
            List<Class<?>> subTestList = testsClasses.subList(startIndex, endIndex);
            desiredCaps.put(testGroupNames.get(groupIndex), subTestList);
        }

        // Building dynamic test suite
        TestNG testNG = new TestNG();
        XmlSuite suite = new XmlSuite();
        suite.setName("Regression");

        // Put all Test classes into groups
        List<XmlTest> allTests = new ArrayList<>();
        for (String groupName : desiredCaps.keySet()) {
            XmlTest test = new XmlTest(suite);
            test.setName(groupName);

            List<XmlClass> xmlClasses = new ArrayList<>();
            List<Class<?>> dedicatedClasses = desiredCaps.get(groupName);
            for (Class<?> dedicatedClass : dedicatedClasses) {
                xmlClasses.add(new XmlClass(dedicatedClass.getName()));
            }

            test.setXmlClasses(xmlClasses);
            test.addParameter("browser", browser);
            allTests.add(test);
        }

        // Add all tests into suite
        suite.setTests(allTests);
        suite.setParallel(XmlSuite.ParallelMode.TESTS);
        suite.setThreadCount(MAX_PARALLEL_SESSION);

        // Run a group of test
        if(browser.equals("safari")){
            suite.addIncludedGroup("smoke");
        } else {
            String targetGroup = args.length !=0 ? args[0] : null;
            if(targetGroup != null){
                suite.addIncludedGroup(targetGroup);
            }
        }

        System.out.println(suite.toXml());

        // Add the suite to the suite list
        List<XmlSuite> suites = new ArrayList<>();
        suites.add(suite);

        // Invoke run() method
        testNG.setXmlSuites(suites);
        testNG.run();
    }
}
