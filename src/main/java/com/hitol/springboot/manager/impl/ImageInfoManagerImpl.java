package com.hitol.springboot.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class ImageInfoManagerImpl implements ImageInfoManager {

    @Autowired
    private EntityManager em;

    @Autowired
    private ImageInfoRepository imageInfoRepository;


    @Override
    public int saveImageInfo(ImageInfo imageInfo) {
//        List<ImageInfo> list = em.createNativeQuery("select * from image_info where code =  " + imageInfo.getCode(),ImageInfo.class).getResultList();
//        if (CollectionUtils.isEmpty()) {
//        }
        imageInfoRepository.save(imageInfo);
        return 0;
    }

    @Override
    public List<ImageInfo> getImageInfosByPage(int page) {
        List<ImageInfo> list = em.createNativeQuery("select * from image_info where page = " + page,ImageInfo.class).getResultList();
        return list;
    }

    @Override
    public void updateImgDownloadSucc(ImageInfo imageInfo) {
        em.createNativeQuery("update image_info set is_download = 1 where id = " + imageInfo.getId());
    }
}
