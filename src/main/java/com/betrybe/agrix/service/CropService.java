package com.betrybe.agrix.service;


import com.betrybe.agrix.entity.Crop;
import com.betrybe.agrix.repository.CropRepository;
import com.betrybe.agrix.service.exception.CropNotFoundException;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Crop service.
 */
@Service
public class CropService {

  private final CropRepository cropRepository;

  private final LocalDate today = LocalDate.now();

  /**
   * Instantiates a new Crop service.
   *
   * @param cropRepository the crop repository
   */
  @Autowired
  public CropService(CropRepository cropRepository) {
    this.cropRepository = cropRepository;
  }

  /**
   * Find all list.
   *
   * @return the list
   */
  public List<Crop> findAll() {
    return cropRepository.findAll();
  }

  public Crop findById(Long cropId) throws CropNotFoundException {
    return cropRepository.findById(cropId)
        .orElseThrow(CropNotFoundException::new);
  }

  public List<Crop> findExpiresAtProducts(LocalDate start, LocalDate end) {

    return cropRepository.findByHarvestDateBetween(start, end);
  }
}