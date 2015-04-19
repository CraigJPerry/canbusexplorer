package com.craigjperry.canbusexplorer.feature.presentationformat;

import org.fluentlenium.core.FluentPage;

import static org.assertj.core.api.Assertions.assertThat;

public class CanbusExplorerSinglePageApplication extends FluentPage {

    @Override
    public String getUrl() {
        return "http://localhost:8080";
    }

    @Override
    public void isAt() {
        assertThat(title()).isEqualTo("Canbus Explorer");
        assertThat(pageSource()).contains("</html>");
    }

    public void isVisible(String panelName) {
        assertThat(find("#" + panelName)).hasSize(1);
    }

}
