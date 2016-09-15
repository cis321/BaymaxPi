package co.uniandes.serverBaymaxPi.api.representations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ContentFooterDTO {

    private final ContentGeneric firstLink;
    private final ContentGeneric secondLink;
    private final ContentGeneric thirdLink;

    @JsonCreator
    public ContentFooterDTO(@JsonProperty("firstLink") ContentGeneric firstLink,
            @JsonProperty("secondLink") ContentGeneric secondLink,
            @JsonProperty("thirdLink") ContentGeneric thirdLink) {

        this.firstLink = firstLink;
        this.secondLink = secondLink;
        this.thirdLink = thirdLink;

    }

    public ContentGeneric getFirstLink() {
        return firstLink;
    }

    public ContentGeneric getSecondLink() {
        return secondLink;
    }

    public ContentGeneric getThirdLink() {
        return thirdLink;
    }

}
