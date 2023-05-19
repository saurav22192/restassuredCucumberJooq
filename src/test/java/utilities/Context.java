package utilities;

public class Context  {
    private DriverManager webDriverManager;
    private POMManager pageObjectManager;
    private ScenarioContext scenarioContext;
    private RestAssuredManager restAssuredManager;
    public Context()
    {
       webDriverManager = new DriverManager();
//       System.out.println("i am here");
//       pageObjectManager = new POMManager(webDriverManager.getDriver());
       scenarioContext = new ScenarioContext();
       restAssuredManager = new RestAssuredManager();
    }

        public DriverManager getWebDriverManager() {
        return webDriverManager;
    }

        public POMManager getPageObjectManager() {
        return pageObjectManager;
    }

    public void setPageObjectManager(POMManager pm){
        this.pageObjectManager=pm;
    }

        public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }

    public RestAssuredManager getRestAssuredManager() {
        return restAssuredManager;
    }

}