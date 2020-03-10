package com.examen.utils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;

import com.examen.dto.SelectDTO;
import com.examen.model.Canton;
import com.examen.model.Distrito;
import com.examen.model.Provincia;

public class ObjectMapperUtils {

	private static ModelMapper modelMapper = new ModelMapper();

	/**
	 * Model mapper property setting are specified in the following block. Default
	 * property matching strategy is set to Strict see {@link MatchingStrategies}
	 * Custom mappings are added using {@link ModelMapper#addMappings(PropertyMap)}
	 */
	static {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		modelMapper.addMappings(new PropertyMap<Provincia, SelectDTO>() {
			protected void configure() {
				map().setId(source.getCodigo());
				map().setText(source.getNombre());

			}
		});
		
		modelMapper.addMappings(new PropertyMap<Canton, SelectDTO>() {
			protected void configure() {
				map().setId(source.getPk().getCodigo());
				map().setText(source.getNombre());
			}
		});
		
		modelMapper.addMappings(new PropertyMap<Distrito, SelectDTO>() {
			protected void configure() {
				map().setId(source.getPk().getCodigo());
				map().setText(source.getNombre());
			}
		});
		
		
//
//		modelMapper.createTypeMap(Canton.class, SelectDTO.class).addMappings(mapper -> {
//			mapper.map(src -> src.getPk().getCodigoProvincia() + src.getPk().getCodigo(), SelectDTO::setId);
//			mapper.map(src -> src.getNombre(), SelectDTO::setText);
//		});
//
//		modelMapper.createTypeMap(Distrito.class, SelectDTO.class).addMappings(mapper -> {
//			mapper.map(src -> src.getPk().getCodigoProvincia(), SelectDTO::setId);
//			mapper.map(src -> src.getNombre(), SelectDTO::setText);
//		});
	}

	/**
	 * Hide from public usage.
	 */
	private ObjectMapperUtils() {
	}

	/**
	 * <p>
	 * Note: outClass object must have default constructor with no arguments
	 * </p>
	 *
	 * @param <D>      type of result object.
	 * @param <T>      type of source object to map from.
	 * @param entity   entity that needs to be mapped.
	 * @param outClass class of result object.
	 * @return new object of <code>outClass</code> type.
	 */
	public static <D, T> D map(final T entity, Class<D> outClass) {
		return modelMapper.map(entity, outClass);
	}

	/**
	 * <p>
	 * Note: outClass object must have default constructor with no arguments
	 * </p>
	 *
	 * @param entityList list of entities that needs to be mapped
	 * @param outCLass   class of result list element
	 * @param <D>        type of objects in result list
	 * @param <T>        type of entity in <code>entityList</code>
	 * @return list of mapped object with <code><D></code> type.
	 */
	public static <D, T> List<D> mapAll(final Collection<T> entityList, Class<D> outCLass) {
		return entityList.stream().map(entity -> map(entity, outCLass)).collect(Collectors.toList());
	}

	/**
	 * Maps {@code source} to {@code destination}.
	 *
	 * @param source      object to map from
	 * @param destination object to map to
	 */
	public static <S, D> D map(final S source, D destination) {
		modelMapper.map(source, destination);
		return destination;
	}
}
