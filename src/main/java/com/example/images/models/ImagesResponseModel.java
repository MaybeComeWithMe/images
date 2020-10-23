package com.example.images.models;

import com.example.images.entity.Picture;

import java.util.List;

public class ImagesResponseModel {
    private List<Picture> pictures;
    private int page;
    private int pageCount;
    private boolean hasMore;
    private String status;

    public ImagesResponseModel() {
    }

    public ImagesResponseModel(List<Picture> pictures, int page, int pageCount, boolean hasMore, String status) {
        this.pictures = pictures;
        this.page = page;
        this.pageCount = pageCount;
        this.hasMore = hasMore;
        this.status = status;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
