package org.traineProject.mockserver;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class WireMockServerRule implements BeforeAllCallback, AfterAllCallback {
    private static WireMockServer wireMockServer;

    @Override
    public void beforeAll(ExtensionContext context) {
        wireMockServer = new WireMockServer(WireMockConfiguration.wireMockConfig().port(8090));
        wireMockServer.start();
        WireMock.configureFor("localhost", 8090);
    }

    @Override
    public void afterAll(ExtensionContext context) {
        if (wireMockServer != null) {
            wireMockServer.stop();
        }
    }
}
