package com.piseth.java.school.phoneshopenight.mapper;

import com.piseth.java.school.phoneshopenight.dto.ModelDTO;
import com.piseth.java.school.phoneshopenight.entity.Brand;
import com.piseth.java.school.phoneshopenight.entity.Model;
import com.piseth.java.school.phoneshopenight.service.BrandService;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-01T19:12:15+0700",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.15 (Microsoft)"
)
@Component
public class ModelEntityMapperImpl implements ModelEntityMapper {

    @Autowired
    private BrandService brandService;

    @Override
    public Model toModel(ModelDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Model model = new Model();

        if ( dto.getBrandId() != null ) {
            model.setBrand( brandService.getById( dto.getBrandId().longValue() ) );
        }
        model.setName( dto.getName() );

        return model;
    }

    @Override
    public ModelDTO toModelDTO(Model model) {
        if ( model == null ) {
            return null;
        }

        ModelDTO modelDTO = new ModelDTO();

        Long id = modelBrandId( model );
        if ( id != null ) {
            modelDTO.setBrandId( id.intValue() );
        }
        modelDTO.setName( model.getName() );

        return modelDTO;
    }

    private Long modelBrandId(Model model) {
        if ( model == null ) {
            return null;
        }
        Brand brand = model.getBrand();
        if ( brand == null ) {
            return null;
        }
        Long id = brand.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
