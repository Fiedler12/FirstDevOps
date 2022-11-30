package config;

public class Config {

    // ------ Path names -------
    public static final String CAMPUSNET_LOGIN_PATH = "api/campusnet/login";
    public static final String CAMPUSNET_REDIRECT_PATH = "api/campusnet/redirect";


    public static final String DEFAULT_CAMPUSNET_REDIRECT_URL = "http://localhost:8080/" + CAMPUSNET_REDIRECT_PATH;
    public static final String DEFAULT_FRONTEND_URL = "http://localhost:3000/";

    public static final String FRONTEND_URL = System.getenv("FRONTEND_URL") != null ? System.getenv("FRONTEND_URL") : DEFAULT_FRONTEND_URL;
    public static final String CN_REDIRECT_URL = System.getenv("CAMPUSNET_REDIRECT_URL") != null ? System.getenv("CAMPUSNET_REDIRECT_URL") + CAMPUSNET_REDIRECT_PATH : DEFAULT_CAMPUSNET_REDIRECT_URL;
}
