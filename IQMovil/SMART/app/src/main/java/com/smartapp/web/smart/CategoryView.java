package com.smartapp.web.smart;

/**
 * Created by klcho.o on 16/9/2017.
 */

public class CategoryView {

    private String Category;
    private int Image;

    public CategoryView(String pCategory, int pImage) {
        this.setImage(pImage);
        this.setCategory(pCategory);
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }
}
