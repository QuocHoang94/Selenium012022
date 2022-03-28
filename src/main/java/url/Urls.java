package url;

public interface Urls {
//    String BASE_URL = "http://demowebshop.tricentis.com";
    String BASE_URL = System.getProperty("baseUrl");
    String DYNAMIC_CONTROL_PAGE = "/dynamic_controls";
    String HOVERS = "/hovers";
    String DROPDOWN = "/dropdown";
    String IFRAME = "/iframe";
    String JAVASCRIPT_ALERTS = "/javascript_alerts";
    String LOGIN_PAGE = "/login";
    String HOME_PAGE = "/";
    String REGISTER_PAGE = "/register";
}
