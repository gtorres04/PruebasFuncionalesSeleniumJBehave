/**
 * 
 */
package com.qvision.prueba;

import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InstanceStepsFactory;

/**
 * @author gerlintorres
 *
 */
public class Login extends JUnitStory{
	/**
	 * Para mac "geckodriver-mac"; Para Windows "geckodriver-win"; Para linux
	 * "geckodriver-linux"
	 */
	public static final String NOMBRE_DRIVER_SISTEMA_OPERATIVO_FIREFOX = "geckodriver-mac";
	/**
	 * Para mac "chromedriver-mac"; Para Windows "chromedriver-win"; Para linux
	 * "chromedriver-linux"
	 */
	public static final String NOMBRE_DRIVER_SISTEMA_OPERATIVO_CHROME = "chromedriver-mac";
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
    public List candidateSteps() {
        InstanceStepsFactory stepsFactory = new InstanceStepsFactory(
        		configuration(), 
        		new LoginSteps("webdriver.gecko.driver", NOMBRE_DRIVER_SISTEMA_OPERATIVO_FIREFOX), 
        		new LoginSteps("webdriver.chrome.driver", NOMBRE_DRIVER_SISTEMA_OPERATIVO_CHROME));
        return stepsFactory.createCandidateSteps();
    }
	
	@Override
    public Configuration configuration() {
        Configuration result = super.configuration();
        result.useStoryReporterBuilder(getStoryReporterBuilder());
        return result;
    }

    private StoryReporterBuilder getStoryReporterBuilder() {
        StoryReporterBuilder result = new StoryReporterBuilder();
        result.withFormats(Format.CONSOLE, Format.HTML, Format.STATS);
        return result;
    }
}
