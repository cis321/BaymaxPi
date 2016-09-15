package co.uniandes.serverBaymaxPi.infrasctructure.factories;

import co.uniandes.serverBaymaxPi.api.representations.ContentDTO;
import co.uniandes.serverBaymaxPi.domain.entities.Content;

public class ContentFactory {

    public static Content createContent(ContentDTO contentDTO) {
        return new Content(contentDTO.get_id(), contentDTO.getHelpContentUser(),
                contentDTO.getContentRightPanelUp(), contentDTO.getContentRightPanelMedium(),
                contentDTO.getContentRightPanelBotton(), contentDTO.getContentLowerRightPanel(),
                contentDTO.getCarouselTitle(),
                contentDTO.getContentCarouselOne(), contentDTO.getContentCarouselTwo(),
                contentDTO.getContentCarouselThree(), contentDTO.getContentCarouselFour(),
                contentDTO.getContentCarouselFive(),
                contentDTO.getContentFooterDTO(), contentDTO.getTermsAndConditions(),
                contentDTO.getSedeElectronicaVideo(), contentDTO.getPortalFuncionarioVideo());
    }

    public static ContentDTO createContentDTO(Content content) {
        return new ContentDTO(content.get_id(), content.getHelpContentUser(), content.getContentRightPanelUp(),
                content.getContentRightPanelMedium(), content.getContentRightPanelBotton(),
                content.getContentLowerRightPanel(), content.getCarouselTitle(), 
                content.getContentCarouselOne(), content.getContentCarouselTwo(),
                content.getContentCarouselThree(), content.getContentCarouselFour(), content.getContentCarouselFive()
                , content.getContentFooterDTO(), content.getTermsAndConditions(),
                content.getSedeElectronicaVideo(), content.getPortalFuncionarioVideo());
    }
}
