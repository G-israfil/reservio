package reservio.common.mappers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component

@Configuration
public class ModelMapperHelper {

    @Autowired
    private final ModelMapper modelMapper;

    public ModelMapperHelper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public <S,D> D map(S sourceObject, Class<D> destinationClass){
        return this.modelMapper.map(sourceObject,destinationClass);
    }
    public <S,D> List<D> mapAll(Collection<S> sourceObjects, Class<D> destinationClass){
        return sourceObjects.stream().map(source -> modelMapper.map(source,destinationClass)).collect(Collectors.toList());
    }
}
