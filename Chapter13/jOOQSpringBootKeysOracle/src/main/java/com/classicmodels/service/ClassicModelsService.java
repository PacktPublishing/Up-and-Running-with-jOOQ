package com.classicmodels.service;

import com.classicmodels.repository.ClassicModelsRepository;
import org.springframework.stereotype.Service;

@Service
public class ClassicModelsService {

    private final ClassicModelsRepository classicModelsRepository;

    public ClassicModelsService(ClassicModelsRepository classicModelsRepository) {
        this.classicModelsRepository = classicModelsRepository;
    }

    public void callAll() {

        classicModelsRepository.suppressPrimaryKeyReturnOnUpdatableRecord();
        classicModelsRepository.updatePrimaryKeyOnUpdatableRecord();
        classicModelsRepository.insertAndReturnPrimaryKey();
        classicModelsRepository.compareComposedPrimaryKey();

        classicModelsRepository.getSequenceInfo();
        classicModelsRepository.currentSequenceVal();        
        classicModelsRepository.nextSequenceVal();
    }
}
