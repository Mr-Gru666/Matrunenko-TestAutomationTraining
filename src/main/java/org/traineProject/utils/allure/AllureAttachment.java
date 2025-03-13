package org.traineProject.utils.allure;

import io.qameta.allure.Allure;

public class AllureAttachment {

    public static void attachObject(String attachName, Object object) {
        Allure.addAttachment(
                attachName,
                "text/json",
                object.toString()
        );
    }
}
