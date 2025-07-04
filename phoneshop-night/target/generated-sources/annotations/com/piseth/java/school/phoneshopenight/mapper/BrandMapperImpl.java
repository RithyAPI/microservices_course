package com.piseth.java.school.phoneshopenight.mapper;

import com.piseth.java.school.phoneshopenight.dto.BrandDTO;
import com.piseth.java.school.phoneshopenight.entity.Brand;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-04T20:10:15+0700",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.15 (Microsoft)"
)
public class BrandMapperImpl implements BrandMapper {

    @Override
    public Brand toBrand(BrandDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Brand brand = new Brand();

        brand.setName( dto.getName() );

        return brand;
    }

    @Override
    public BrandDTO toBrandDTO(Brand entity) {
        if ( entity == null ) {
            return null;
        }

        BrandDTO brandDTO = new BrandDTO();

        brandDTO.setName( entity.getName() );

        return brandDTO;
    }
}
