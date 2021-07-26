package hooks;

import cucumber.api.java.Before;
import net.serenitybdd.cucumber.suiteslicing.SerenityTags;

public class Hook {
	
	@Before
    public void before() {
        SerenityTags.create().tagScenarioWithBatchingInfo();
    }

}
