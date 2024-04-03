package com.example.akangfood.RecyclerView;

public class FnBModel {
    private String nameText;
    private String calText;
    private String rasaText;
    private String hargaText;
    private int fnbImg;
    private boolean isFav;

    public FnBModel (String nameText, String calText, String rasaText, String hargaText, int fnbImg, boolean isFav) {
        this.nameText = nameText;
        this.calText = calText;
        this.rasaText = rasaText;
        this.hargaText = hargaText;
        this.fnbImg = fnbImg;
        this.isFav = isFav();
    }

    public String getNameText() {
        return nameText;
    }

    public void setNameText(String nameText) {
        this.nameText = nameText;
    }

    public String getCalText() {
        return calText;
    }

    public void setCalText(String calText) {
        this.calText = calText;
    }

    public String getRasaText() {
        return rasaText;
    }

    public void setRasaText(String rasaText) {
        this.rasaText = rasaText;
    }

    public String getHargaText() {
        return hargaText;
    }

    public void setHargaText(String hargaText) {
        this.hargaText = hargaText;
    }

    public int getFnbImg() {
        return fnbImg;
    }

    public void setFnbImg(int fnbImg) {
        this.fnbImg = fnbImg;
    }

    public boolean isFav() {
        return isFav;
    }

    public void setFav(boolean fav) {
        isFav = fav;
    }
}
