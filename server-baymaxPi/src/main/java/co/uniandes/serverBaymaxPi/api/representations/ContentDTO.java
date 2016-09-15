package co.uniandes.serverBaymaxPi.api.representations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ContentDTO {

    private final String _id;
    private final String helpContentUser;
    private final ContentGeneric contentRightPanelUp;
    private final ContentGeneric contentRightPanelMedium;
    private final ContentGeneric contentRightPanelBotton;
    private final ContentGeneric contentLowerRightPanel;
    private final String carouselTitle;
    private final ContentGeneric contentCarouselOne;
    private final ContentGeneric contentCarouselTwo;
    private final ContentGeneric contentCarouselThree;
    private final ContentGeneric contentCarouselFour;
    private final ContentGeneric contentCarouselFive;
    private final ContentFooterDTO contentFooterDTO;
    private final String termsAndConditions;
    private final String sedeElectronicaVideo;
    private final String portalFuncionarioVideo;

    @JsonCreator
    public ContentDTO(@JsonProperty("_id") String _id,
            @JsonProperty("helpContentUser") String helpContentUser,
            @JsonProperty("contentRightPanelUp") ContentGeneric contentRightPanelUp,
            @JsonProperty("contentRightPanelMedium") ContentGeneric contentRightPanelMedium,
            @JsonProperty("contentRightPanelBotton") ContentGeneric contentRightPanelBotton,
            @JsonProperty("contentLowerRightPanel") ContentGeneric contentLowerRightPanel,
            @JsonProperty("carouselTitle") String carouselTitle,
            @JsonProperty("contentCarouselOne") ContentGeneric contentCarouselOne,
            @JsonProperty("contentCarouselTwo") ContentGeneric contentCarouselTwo,
            @JsonProperty("contentCarouselThree") ContentGeneric contentCarouselThree,
            @JsonProperty("contentCarouselFour") ContentGeneric contentCarouselFour,
            @JsonProperty("contentCarouselFive") ContentGeneric contentCarouselFive,
            @JsonProperty("contentFooterDTO") ContentFooterDTO contentFooterDTO,
            @JsonProperty("termsAndConditions") String termsAndConditions,
            @JsonProperty("sedeElectronicaVideo") String sedeElectronicaVideo,
            @JsonProperty("portalFuncionarioVideo") String portalFuncionarioVideo) {
        this._id = _id;
        this.helpContentUser = helpContentUser;
        this.contentRightPanelUp = contentRightPanelUp;
        this.contentRightPanelMedium = contentRightPanelMedium;
        this.contentRightPanelBotton = contentRightPanelBotton;
        this.contentLowerRightPanel = contentLowerRightPanel;
        this.carouselTitle = carouselTitle;
        this.contentCarouselOne = contentCarouselOne;        
        this.contentCarouselTwo = contentCarouselTwo;
        this.contentCarouselThree = contentCarouselThree;
        this.contentCarouselFour = contentCarouselFour;
        this.contentCarouselFive = contentCarouselFive;
        this.contentFooterDTO = contentFooterDTO;
        this.termsAndConditions = termsAndConditions;
        this.sedeElectronicaVideo = sedeElectronicaVideo;
        this.portalFuncionarioVideo = portalFuncionarioVideo;
    }

    public String get_id() {
        return _id;
    }

    public String getHelpContentUser() {
        return helpContentUser;
    }

    public ContentGeneric getContentRightPanelUp() {
        return contentRightPanelUp;
    }

    public ContentGeneric getContentRightPanelMedium() {
        return contentRightPanelMedium;
    }

    public ContentGeneric getContentRightPanelBotton() {
        return contentRightPanelBotton;
    }

    public ContentGeneric getContentLowerRightPanel() {
        return contentLowerRightPanel;
    }
    
    public String getCarouselTitle() {
        return carouselTitle;
    }

    public ContentGeneric getContentCarouselOne() {
        return contentCarouselOne;
    }

    public ContentGeneric getContentCarouselTwo() {
        return contentCarouselTwo;
    }

    public ContentGeneric getContentCarouselThree() {
        return contentCarouselThree;
    }

    public ContentGeneric getContentCarouselFour() {
        return contentCarouselFour;
    }
    
    public ContentGeneric getContentCarouselFive() {
        return contentCarouselFive;
    }

    public ContentFooterDTO getContentFooterDTO() {
        return contentFooterDTO;
    }

    public String getTermsAndConditions() {
        return termsAndConditions;
    }
    
    public String getSedeElectronicaVideo() {
        return sedeElectronicaVideo;
    }
    
    public String getPortalFuncionarioVideo() {
        return portalFuncionarioVideo;
    }

}
