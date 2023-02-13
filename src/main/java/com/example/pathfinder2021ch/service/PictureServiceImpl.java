package com.example.pathfinder2021ch.service;

import com.example.pathfinder2021ch.repository.PictureRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepository;

    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @Override
    public List<String> findAllURLs() {
        return pictureRepository.findAllUrls();
    }
}
