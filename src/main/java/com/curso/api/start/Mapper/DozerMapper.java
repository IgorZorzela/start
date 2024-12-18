package com.curso.api.start.Mapper;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class DozerMapper {

    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <O, D> D parseObject(O origem, Class<D> destination) {
        return mapper.map(origem, destination);

    }

    public static <O, D> List <D> parseListObjects(List<O> origem, Class<D> destination) {
        List<D> destinationsObjects = new ArrayList<D>();
        for (O o : origem) {
            destinationsObjects.add(mapper.map(o, destination));
        }
        return destinationsObjects;
    }
}