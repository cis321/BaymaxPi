package co.uniandes.serverBaymaxPi.api.representations;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ContentDTONew {

	private final List<ContentGenericNew> listBulleted;
	private final List<ContentImageGeneric> listImages;
	private final String preFooter;
	private final String footer;
	private final String sedeElectronicaVideo;

	@JsonCreator
	public ContentDTONew(@JsonProperty("listBulleted") List<ContentGenericNew> listBulleted,
			@JsonProperty("listImages") List<ContentImageGeneric> listImages,
			@JsonProperty("preFooter") String preFooter, @JsonProperty("footer") String footer,
			@JsonProperty("sedeElectronicaVideo") String sedeElectronicaVideo) {

		this.listBulleted = listBulleted;
		this.listImages = listImages;
		this.preFooter = preFooter;
		this.footer = footer;
		this.sedeElectronicaVideo = sedeElectronicaVideo;

	}

	public List<ContentGenericNew> getListBulleted() {
		return listBulleted;
	}

	public List<ContentImageGeneric> getListImages() {
		return listImages;
	}

	public String getPreFooter() {
		return preFooter;
	}

	public String getFooter() {
		return footer;
	}

	public String getSedeElectronicaVideo() {
		return sedeElectronicaVideo;
	}

}
