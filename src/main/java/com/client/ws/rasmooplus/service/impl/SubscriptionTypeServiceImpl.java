package com.client.ws.rasmooplus.service.impl;

import com.client.ws.rasmooplus.dto.SubscriptionTypeDto;
import com.client.ws.rasmooplus.exception.BadRequestException;
import com.client.ws.rasmooplus.exception.NotFoundException;
import com.client.ws.rasmooplus.model.SubscriptionType;
import com.client.ws.rasmooplus.repository.SubscriptionTypeRepository;
import com.client.ws.rasmooplus.service.SubscriptionTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SubscriptionTypeServiceImpl implements SubscriptionTypeService {

    private final SubscriptionTypeRepository subscriptionTypeRepository;

    public SubscriptionTypeServiceImpl(SubscriptionTypeRepository subscriptionTypeRepository) {
        this.subscriptionTypeRepository = subscriptionTypeRepository;
    }

    @Override
    public List<SubscriptionType> findAll() {
        return subscriptionTypeRepository.findAll();
    }

    @Override
    public SubscriptionType findById(Long id) {
        return subscriptionTypeRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Subscription type not found"));
    }

    @Override
    public SubscriptionType create(SubscriptionTypeDto dto) {
        if (Objects.nonNull(dto.getId())) {
            throw new BadRequestException("Id must be null");
        }

        return subscriptionTypeRepository.save(
                SubscriptionType.builder()
                    .name(dto.getName())
                    .accessMonth(dto.getAccessMonth())
                    .price(dto.getPrice())
                    .productKey(dto.getProductKey())
                    .build()
        );
    }

    @Override
    public SubscriptionType update(Long id, SubscriptionTypeDto dto) {
        if (!subscriptionTypeRepository.existsById(id)) {
            throw new NotFoundException("Subscription type not found");
        }

        return subscriptionTypeRepository.save(
                SubscriptionType.builder()
                        .id(id)
                        .name(dto.getName())
                        .accessMonth(dto.getAccessMonth())
                        .price(dto.getPrice())
                        .productKey(dto.getProductKey())
                        .build()
        );
    }

    @Override
    public void delete(Long id) {
        if (!subscriptionTypeRepository.existsById(id)) {
            throw new NotFoundException("Subscription type not found");
        }
        subscriptionTypeRepository.deleteById(id);
    }
}
