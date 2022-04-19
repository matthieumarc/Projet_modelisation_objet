package project;

import org.junit.jupiter.api.Test;
import project.controller.MainController;

public class TestApp {

    @Test
    void TestMainApp(){
        //MainController main = new MainController();
        String[] agency = {"agency1","agency2"};
        App test_app = new App();
        test_app.main(agency);
    }
}
