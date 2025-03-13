package org.traineProject.utils.config;

public enum ConfigData {

    //region PRODUCT
    BASE_URL {
        public String getValue() {
            return ConfigReader.getConfigProperties("google.url");
        }
    },
    //endregion

    //region SELENIDE
    BROWSER {
        public String getValue() {
            return ConfigReader.getConfigProperties("selenide.browser");
        }
    },
    BROWSER_SIZE {
        public String getValue() {
            return ConfigReader.getConfigProperties("selenide.browser.size");
        }
    },
    BROWSER_HEADLESS {
        public String getValue() {
            return ConfigReader.getConfigProperties("selenide.browser.headless");
        }
    };
    //endregion


    public abstract String getValue();

    @Override
    public String toString() {
        return this.getValue();
    }
}
