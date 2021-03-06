package concerttours.facades.impl;

import concerttours.data.BandData;
import concerttours.facades.BandFacade;
import concerttours.model.BandModel;
import concerttours.service.BandService;
import de.hybris.platform.converters.Converters;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class DefaultBandFacade implements BandFacade {

    private BandService bandService;
    private Converter<BandModel, BandData> bandConverter;

    @Override
    public BandData getBand(String id) throws IllegalArgumentException {
        BandModel bandModel = bandService.getBandForCode(id);
        return bandConverter.convert(bandModel);
    }

    @Override
    public List<BandData> getBands() {
        return Converters.convertAll(bandService.getBands(), bandConverter);
    }

    @Required
    public void setBandService(BandService bandService) {
        this.bandService = bandService;
    }

    @Required
    public void setBandConverter(Converter<BandModel, BandData> bandConverter) {
        this.bandConverter = bandConverter;
    }

}
