package interfaces;

import model.Produce;

public interface IProductMethods {
  public  boolean uploadBabyProduct(Produce produce);
  public  boolean uploadBeautyProduct(Produce produce);
    public  boolean uploadHygieneProduct(Produce produce);
    public String deleteProduct(String produce, String confirm);
    public boolean viewProduct(String productName);
}
