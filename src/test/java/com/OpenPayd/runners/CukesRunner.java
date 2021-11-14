package com.OpenPayd.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //I put for html reporting
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports"},
        //I put for location of features file
        features = "src/test/resources/features",
        //I put for location of step definitions
        glue = "com/OpenPayd/step_definitions",
        //if I do it tru I get undefined step definitions
        dryRun = false,
        //I put for execute specific scenerio
        tags = "@user_story1"

)
public class CukesRunner {
}
