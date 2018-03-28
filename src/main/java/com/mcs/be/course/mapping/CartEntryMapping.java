package com.mcs.be.course.mapping;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.mcs.be.course.dto.CartEntryDto;
import com.mcs.be.course.model.CartEntry;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;

@Component
public class CartEntryMapping implements OrikaMapperFactoryConfigurer {
    @Override
    public void configure(MapperFactory orikaMapperFactory) {
        orikaMapperFactory.classMap(CartEntry.class, CartEntryDto.class)
        		.field("article.id", "articleId")
        		.byDefault()
        		.customize(new CustomMapper<CartEntry, CartEntryDto>() {
        			@Override
        			public void mapAtoB(CartEntry a, CartEntryDto b, MappingContext context) {
        				b.setTotalPrice(a.getUnitPrice().multiply(BigDecimal.valueOf(a.getQuantity())));
        				super.mapAtoB(a, b, context);
        			}
				})
                .mapNulls(false)
                .mapNullsInReverse(true)
                .register();
    }
}
